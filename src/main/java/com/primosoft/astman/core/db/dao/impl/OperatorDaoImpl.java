/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.dao.IOperatorDao;
import com.primosoft.astman.core.db.dao.ex.NoOperatorFound;
import com.primosoft.astman.core.db.entity.ats.Operator;
import com.primosoft.astman.core.db.entity.ats.SipUser;
import com.primosoft.astman.core.db.entity.ats.WorkAppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "operatorDao")
@Transactional(readOnly = true)
public class OperatorDaoImpl extends GenericDao<BigInteger, Operator> implements IOperatorDao, IGenericDao<BigInteger, Operator> {
	private static final long serialVersionUID = 4116182027595714391L;

	@Override
	public List<Operator> getLoginedOperators() {
		return getEntityManager().createQuery("SELECT o FROM Operator o where o.logined = true", Operator.class).getResultList();
	}

	@Override
	public List<SipUser> getLoginedSipUsers() {
		return getEntityManager().createQuery("SELECT o.sipUser FROM Operator o where o.logined = true", SipUser.class).getResultList();
	}

	@Override
	@Transactional
	public void updateOperatorStatus(BigInteger operatorStatusId, String dn) {
		getEntityManager()
				.createQuery("UPDATE Operator o SET operatorStatus.id = :operatorStatusId WHERE login = :dn")
				.setParameter("operatorStatusId", operatorStatusId)
				.setParameter("dn", dn)
				.executeUpdate();
	}

	@Override
	public Operator getBySipUser(SipUser sipUser) throws NoOperatorFound {
		try {
			return getEntityManager().createQuery("SELECT o FROM Operator o WHERE o.sipUser = :sipUser", Operator.class)
					.setParameter("sipUser", sipUser)
					.getSingleResult();
		} catch (NoResultException e) {
			throw new NoOperatorFound(e);
		}
	}

	@Override
	public Operator getBySipUserId(BigInteger sipUserId) throws NoOperatorFound {
		try {
			return getEntityManager().createQuery("SELECT o FROM Operator o WHERE o.sipUser.id = :sipUserId", Operator.class)
					.setParameter("sipUserId", sipUserId)
					.getSingleResult();
		} catch (NoResultException e) {
			throw new NoOperatorFound(e);
		}

	}

	@Override
	public List<Operator> getAllOfGroupList(String groupName) {
		return getEntityManager().createNamedQuery("RelOpGr.findAllOfGroup", Operator.class)
				.setParameter("groupName", groupName).getResultList();
	}

	@Override
	public List<Operator> getLoginedOfGroupList(String groupName) {
		return getEntityManager().createNamedQuery("RelWauWag.findLoginedOfGroup", Operator.class)
				.setParameter("groupName", groupName).getResultList();
	}

	@Override
	public List<Operator> getFreeOfGroupList(String groupName) {
		return getEntityManager().createNamedQuery("RelWauWag.findFreeOfGroup", Operator.class)
				.setParameter("groupName", groupName).getResultList();
	}

	@Override
	public List<Operator> getDontSpeakOfGroupList(String groupName) {
		return getEntityManager().createNamedQuery("RelWauWag.findDontSpeakOfGroup", Operator.class)
				.setParameter("groupName", groupName).getResultList();
	}

	@Override
	@Transactional
	public List<Operator> getOldestFreeOfGroupList(String groupName) {
		final List<WorkAppUser> workAppUsers = executeFunction(
				createCallFunction(ATS_SCHEMA, GET_OPER_OLDEST_FREE, 1),
				Collections.singletonList(new FunctionParameter(groupName)),
				resultSet -> new WorkAppUser(BigInteger.valueOf(resultSet.getLong(2)))
		);
		return getEntityManager().createNamedQuery("Operators.findByUserIdList", Operator.class)
				.setParameter(
						"userIdList",
						workAppUsers.stream()
								.map(WorkAppUser::getId)
								.collect(Collectors.toList())
				).getResultList();
	}
}
