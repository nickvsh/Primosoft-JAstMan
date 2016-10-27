/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service;

import com.primosoft.astman.core.db.dao.ex.NoOperatorFound;
import com.primosoft.astman.core.db.entity.ats.Operator;
import com.primosoft.astman.core.db.entity.ats.SipUser;

import java.util.List;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
public interface IOperatorService {
	void refreshOperatorStatus(int state, String dn);

	Operator getBySipUser(SipUser sipUser) throws NoOperatorFound;
}
