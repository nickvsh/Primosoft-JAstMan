/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.dao.IWorkAppGroupDao;
import com.primosoft.astman.core.db.entity.ats.WorkAppGroup;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "workAppGroupDao")
public class WorkAppGroupDaoImpl extends GenericDao<BigInteger, WorkAppGroup> implements IWorkAppGroupDao, IGenericDao<BigInteger, WorkAppGroup> {
	private static final long serialVersionUID = 6615593483474869585L;
}
