/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.IWorkAppGroupDao;
import com.primosoft.astman.core.db.service.IWorkAppGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "workAppGroupService")
public class WorkAppGroupServiceImpl implements IWorkAppGroupService {
	private final IWorkAppGroupDao workAppGroupDao;

	@Autowired
	public WorkAppGroupServiceImpl(IWorkAppGroupDao workAppGroupDao) {
		this.workAppGroupDao = workAppGroupDao;
	}
}
