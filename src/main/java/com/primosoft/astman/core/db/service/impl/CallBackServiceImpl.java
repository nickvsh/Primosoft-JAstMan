/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.ICallBackDao;
import com.primosoft.astman.core.db.service.ICallBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "callBackService")
public class CallBackServiceImpl implements ICallBackService {
	private final ICallBackDao callBackDao;

	@Autowired
	public CallBackServiceImpl(ICallBackDao callBackDao) {
		this.callBackDao = callBackDao;
	}
}
