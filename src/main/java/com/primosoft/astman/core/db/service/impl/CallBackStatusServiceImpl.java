/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.ICallBackStatusDao;
import com.primosoft.astman.core.db.service.ICallBackStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "callBackStatusService")
public class CallBackStatusServiceImpl implements ICallBackStatusService {
	private final ICallBackStatusDao callBackStatusDao;

	@Autowired
	public CallBackStatusServiceImpl(ICallBackStatusDao callBackStatusDao) {
		this.callBackStatusDao = callBackStatusDao;
	}
}
