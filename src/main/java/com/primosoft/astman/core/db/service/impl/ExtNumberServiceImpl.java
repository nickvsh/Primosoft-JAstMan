/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.IExtNumberDao;
import com.primosoft.astman.core.db.service.IExtNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "extNumberService")
public class ExtNumberServiceImpl implements IExtNumberService {
	private final IExtNumberDao extNumberDao;

	@Autowired
	public ExtNumberServiceImpl(IExtNumberDao extNumberDao) {
		this.extNumberDao = extNumberDao;
	}
}
