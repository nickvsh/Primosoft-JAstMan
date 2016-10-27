/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.ICallBackDao;
import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.entity.ats.CallBack;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "callBackDao")
@Transactional(readOnly = true)
public class CallBackDaoImpl extends GenericDao<BigInteger, CallBack> implements ICallBackDao, IGenericDao<BigInteger, CallBack> {
	private static final long serialVersionUID = -2277184120615103966L;
}
