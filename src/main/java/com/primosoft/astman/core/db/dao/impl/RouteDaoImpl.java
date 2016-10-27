/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.dao.IRouteDao;
import com.primosoft.astman.core.db.entity.ats.Route;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "routeDao")
@Transactional(readOnly = true)
public class RouteDaoImpl extends GenericDao<BigInteger, Route> implements IRouteDao, IGenericDao<BigInteger, Route> {
	private static final long serialVersionUID = 2302313443690022270L;
}
