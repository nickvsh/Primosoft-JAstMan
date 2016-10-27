/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.ICallRouteDao;
import com.primosoft.astman.core.db.service.ICallRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "callRouteService")
public class CallRouteServiceImpl implements ICallRouteService {
	private final ICallRouteDao callRouteDao;

	@Autowired
	public CallRouteServiceImpl(ICallRouteDao callRouteDao) {
		this.callRouteDao = callRouteDao;
	}
}
