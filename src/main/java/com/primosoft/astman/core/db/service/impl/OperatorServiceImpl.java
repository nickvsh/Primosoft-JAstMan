/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.IOperatorDao;
import com.primosoft.astman.core.db.dao.ex.NoOperatorFound;
import com.primosoft.astman.core.db.entity.ats.Operator;
import com.primosoft.astman.core.db.entity.ats.SipUser;
import com.primosoft.astman.core.db.service.IOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "operatorService")
public class OperatorServiceImpl implements IOperatorService {
	private final IOperatorDao operatorDao;

	@Autowired
	public OperatorServiceImpl(IOperatorDao operatorDao) {
		this.operatorDao = operatorDao;
	}

	@Transactional
	@Override
	public void refreshOperatorStatus(int state, String dn) {
		operatorDao.updateOperatorStatus(BigInteger.valueOf(state), dn);
	}

	@Override
	public Operator getBySipUser(SipUser sipUser) throws NoOperatorFound {
		return operatorDao.getBySipUser(sipUser);
	}
}
