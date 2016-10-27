/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao;

import com.primosoft.astman.core.db.dao.ex.NoOperatorFound;
import com.primosoft.astman.core.db.entity.ats.Operator;
import com.primosoft.astman.core.db.entity.ats.SipUser;

import java.math.BigInteger;
import java.util.List;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
public interface IOperatorDao extends IGenericDao<BigInteger, Operator> {
	List<Operator> getLoginedOperators();

	List<SipUser> getLoginedSipUsers();

	void updateOperatorStatus(BigInteger operatorStatusId, String dn);

	Operator getBySipUser(SipUser sipUser) throws NoOperatorFound;

	Operator getBySipUserId(BigInteger sipUserId) throws NoOperatorFound;

	List<Operator> getAllOfGroupList(String groupName);

	List<Operator> getLoginedOfGroupList(String groupName);

	List<Operator> getFreeOfGroupList(String groupName);

	List<Operator> getDontSpeakOfGroupList(String groupName);

	List<Operator> getOldestFreeOfGroupList(String groupName);
}
