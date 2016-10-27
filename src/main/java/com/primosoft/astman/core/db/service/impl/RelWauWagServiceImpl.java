/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.IRelWauWagDao;
import com.primosoft.astman.core.db.service.IRelWauWagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "relWauWagService")
public class RelWauWagServiceImpl implements IRelWauWagService {
	private final IRelWauWagDao relWauWagDao;

	@Autowired
	public RelWauWagServiceImpl(IRelWauWagDao relWauWagDao) {
		this.relWauWagDao = relWauWagDao;
	}
}
