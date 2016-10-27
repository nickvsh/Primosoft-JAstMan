/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.dao.IRelOpGrDao;
import com.primosoft.astman.core.db.entity.ats.RelOpGr;
import com.primosoft.astman.core.db.entity.ats.pk.RelOpGrPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "relOpGrDao")
@Transactional(readOnly = true)
public class RelOpGrDaoImpl extends GenericDao<RelOpGrPK, RelOpGr> implements IRelOpGrDao, IGenericDao<RelOpGrPK, RelOpGr> {
	private static final long serialVersionUID = 2823645188421451196L;
}
