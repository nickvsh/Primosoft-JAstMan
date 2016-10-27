/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.dao.IOperatorStatusDao;
import com.primosoft.astman.core.db.entity.ats.OperatorStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "operatorStatusDao")
@Transactional(readOnly = true)
public class OperatorStatusDaoImpl extends GenericDao<BigInteger, OperatorStatus> implements IOperatorStatusDao, IGenericDao<BigInteger, OperatorStatus> {
	private static final long serialVersionUID = -5381356282267612798L;
}
