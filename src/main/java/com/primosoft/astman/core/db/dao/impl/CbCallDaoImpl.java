/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.ICbCallDao;
import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.entity.ats.CbCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "cbCallDao")
@Transactional(readOnly = true)
public class CbCallDaoImpl extends GenericDao<BigInteger, CbCall> implements ICbCallDao, IGenericDao<BigInteger, CbCall> {
	private static final long serialVersionUID = -7010921156888955344L;
}
