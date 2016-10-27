/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.dao.IRelWauWagDao;
import com.primosoft.astman.core.db.entity.ats.RelWauWag;
import com.primosoft.astman.core.db.entity.ats.pk.RelWauWagPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
@Repository(value = "relWauWagDao")
@Transactional(readOnly = true)
public class RelWauWagDaoImpl extends GenericDao<RelWauWagPK, RelWauWag> implements IRelWauWagDao, IGenericDao<RelWauWagPK, RelWauWag> {
	private static final long serialVersionUID = -1564891720935316968L;
}
