/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.ICbCallDao;
import com.primosoft.astman.core.db.service.ICbCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "cbCallService")
public class CbCallServiceImpl implements ICbCallService {
	private final ICbCallDao cbCallDao;

	@Autowired
	public CbCallServiceImpl(ICbCallDao cbCallDao) {
		this.cbCallDao = cbCallDao;
	}
}
