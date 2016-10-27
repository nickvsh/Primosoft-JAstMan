/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.ICallDao;
import com.primosoft.astman.core.db.service.ICallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "callService")
public class CallServiceImpl implements ICallService {
	private final ICallDao callDao;

	@Autowired
	public CallServiceImpl(ICallDao callDao) {
		this.callDao = callDao;
	}
}
