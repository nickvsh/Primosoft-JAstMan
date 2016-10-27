/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.IOperatorStatusDao;
import com.primosoft.astman.core.db.service.IOperatorStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "operatorStatusService")
public class OperatorStatusServiceImpl implements IOperatorStatusService {
	private final IOperatorStatusDao operatorStatusDao;

	@Autowired
	public OperatorStatusServiceImpl(IOperatorStatusDao operatorStatusDao) {
		this.operatorStatusDao = operatorStatusDao;
	}
}
