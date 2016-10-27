/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.IRouteContentDao;
import com.primosoft.astman.core.db.service.IRouteContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "routeContentService")
public class RouteContentServiceImpl implements IRouteContentService {
	private final IRouteContentDao routeContentDao;

	@Autowired
	public RouteContentServiceImpl(IRouteContentDao routeContentDao) {
		this.routeContentDao = routeContentDao;
	}
}
