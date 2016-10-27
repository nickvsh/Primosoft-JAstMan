/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.dao.IRouteContentDao;
import com.primosoft.astman.core.db.entity.ats.RouteContent;
import com.primosoft.astman.core.db.entity.ats.pk.RouteContentPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "routeContentDao")
@Transactional(readOnly = true)
public class RouteContentDaoImpl extends GenericDao<RouteContentPK, RouteContent> implements IRouteContentDao, IGenericDao<RouteContentPK, RouteContent> {
	private static final long serialVersionUID = -7612870341954138793L;
}
