/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service;

import com.primosoft.astman.core.db.entity.ats.WorkAppUser;

import java.util.List;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
public interface IWorkAppUserService {
	List<WorkAppUser> getAllUsers();
}
