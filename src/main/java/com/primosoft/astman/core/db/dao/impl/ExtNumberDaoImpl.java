/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IExtNumberDao;
import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.entity.ats.ExtNumber;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "extNumberDao")
@Transactional(readOnly = true)
public class ExtNumberDaoImpl extends GenericDao<BigInteger, ExtNumber> implements IExtNumberDao, IGenericDao<BigInteger, ExtNumber> {
	private static final long serialVersionUID = -4670223552802190984L;
}
