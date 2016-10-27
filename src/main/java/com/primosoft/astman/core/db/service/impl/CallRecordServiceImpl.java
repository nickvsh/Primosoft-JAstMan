/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.ICallRecordDao;
import com.primosoft.astman.core.db.service.ICallRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "callRecordService")
public class CallRecordServiceImpl implements ICallRecordService {
	private final ICallRecordDao callRecordDao;

	@Autowired
	public CallRecordServiceImpl(ICallRecordDao callRecordDao) {
		this.callRecordDao = callRecordDao;
	}
}
