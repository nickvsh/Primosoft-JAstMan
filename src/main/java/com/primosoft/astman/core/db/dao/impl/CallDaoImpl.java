/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.ICallDao;
import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.entity.ats.Call;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "callDao")
@Transactional(readOnly = true)
public class CallDaoImpl extends GenericDao<BigInteger, Call> implements ICallDao, IGenericDao<BigInteger, Call> {
	private static final long serialVersionUID = -674957501842561237L;
}
