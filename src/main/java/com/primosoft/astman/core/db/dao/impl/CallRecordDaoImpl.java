/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.ICallRecordDao;
import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.entity.ats.CallRecord;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "callRecordDao")
@Transactional(readOnly = true)
public class CallRecordDaoImpl extends GenericDao<BigInteger, CallRecord> implements ICallRecordDao, IGenericDao<BigInteger, CallRecord> {
	private static final long serialVersionUID = -592670629209771595L;
}
