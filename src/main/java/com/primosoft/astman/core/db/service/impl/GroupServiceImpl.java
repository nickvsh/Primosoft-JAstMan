/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.IGroupDao;
import com.primosoft.astman.core.db.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "groupService")
public class GroupServiceImpl implements IGroupService {
	private final IGroupDao groupDao;

	@Autowired
	public GroupServiceImpl(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}
}
