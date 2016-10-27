/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.ICallRouteDao;
import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.entity.ats.CallRoute;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "callRouteDao")
@Transactional(readOnly = true)
public class CallRouteDaoImpl extends GenericDao<BigInteger, CallRoute> implements ICallRouteDao, IGenericDao<BigInteger, CallRoute> {
	private static final long serialVersionUID = -4971972416097675639L;
}
