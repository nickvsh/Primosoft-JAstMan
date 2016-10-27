/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.IWorkAppUserDao;
import com.primosoft.astman.core.db.entity.ats.WorkAppUser;
import com.primosoft.astman.core.db.service.IWorkAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "workAppUserService")
public class WorkAppUserServiceImpl implements IWorkAppUserService {
	private final IWorkAppUserDao workAppUserDao;

	@Autowired
	public WorkAppUserServiceImpl(IWorkAppUserDao workAppUserDao) {
		this.workAppUserDao = workAppUserDao;
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<WorkAppUser> getAllUsers() {
		return workAppUserDao.getAll();
	}
}
