/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.ICallBackStatusDao;
import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.entity.ats.CallBackStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "callBackStatusDao")
@Transactional(readOnly = true)
public class CallBackStatusDaoImpl extends GenericDao<BigInteger, CallBackStatus> implements ICallBackStatusDao, IGenericDao<BigInteger, CallBackStatus> {
	private static final long serialVersionUID = 6315581099454446410L;
}
