/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.dao.IWorkAppUserDao;
import com.primosoft.astman.core.db.entity.ats.WorkAppUser;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "workAppUserDao")
public class WorkAppUserDaoImpl extends GenericDao<BigInteger, WorkAppUser> implements IWorkAppUserDao, IGenericDao<BigInteger, WorkAppUser> {
	private static final long serialVersionUID = -5398104661144126774L;
}
