/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.IRouteDao;
import com.primosoft.astman.core.db.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "routeService")
public class RouteServiceImpl implements IRouteService {
	private final IRouteDao routeDao;

	@Autowired
	public RouteServiceImpl(IRouteDao routeDao) {
		this.routeDao = routeDao;
	}
}
