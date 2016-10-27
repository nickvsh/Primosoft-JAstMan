/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.IRelOpGrDao;
import com.primosoft.astman.core.db.service.IRelOpGrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "relOprGrService")
public class RelOpGrServiceImpl implements IRelOpGrService {
	private final IRelOpGrDao relOpGrDao;

	@Autowired
	public RelOpGrServiceImpl(IRelOpGrDao relOpGrDao) {
		this.relOpGrDao = relOpGrDao;
	}
}
