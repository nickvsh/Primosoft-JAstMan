
/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.dao.IOperatorDao;
import com.primosoft.astman.core.db.dao.ISipUserDao;
import com.primosoft.astman.core.db.entity.ats.SipUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "sipUserDao")
@Transactional(readOnly = true)
public class SipUserDaoImpl extends GenericDao<BigInteger, SipUser> implements ISipUserDao, IGenericDao<BigInteger, SipUser> {
	private static final long serialVersionUID = -2522773073849869214L;

	private final IOperatorDao operatorDao;

	@Autowired
	public SipUserDaoImpl(IOperatorDao operatorDao) {
		this.operatorDao = operatorDao;
	}

	@Override
	public List<SipUser> getActiveSipUserList() {
		return operatorDao.getLoginedSipUsers();
	}

	@Override
	public SipUser getByDn(String dn) {
		return getEntityManager()
				.createQuery("SELECT s FROM SipUser s WHERE s.username = :dn", SipUser.class)
				.setParameter("dn", dn)
				.getSingleResult();
	}

	@Override
	@Transactional
	public void executeFinishCitlSc(int sipUserId) {
		executeFunction(
				createCallFunction(ATS_SCHEMA, FINISH_CITL_SC, 1),
				Collections.singletonList(new FunctionParameter(sipUserId))
		);
	}

	@Override
	@Transactional
	public void executeHangupCitlMc(int sipUserId) {
		executeFunction(
				createCallFunction(ATS_SCHEMA, HANGUP_CITL_MC, 1),
				Collections.singletonList(new FunctionParameter(sipUserId))
		);
	}

	@Override
	@Transactional
	public void executeBeginCitlSc(int sipUserId) {
		executeFunction(
				createCallFunction(ATS_SCHEMA, BEGIN_CITL_SC, 1),
				Collections.singletonList(new FunctionParameter(sipUserId))
		);

	}
}
