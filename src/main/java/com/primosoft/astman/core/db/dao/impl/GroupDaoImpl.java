/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.dao.IGroupDao;
import com.primosoft.astman.core.db.entity.ats.Group;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "groupDao")
@Transactional(readOnly = true)
public class GroupDaoImpl extends GenericDao<BigInteger, Group> implements IGroupDao, IGenericDao<BigInteger, Group> {
	private static final long serialVersionUID = 4179313461330505462L;
}
