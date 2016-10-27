/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao;

import com.primosoft.astman.core.db.entity.ats.SipUser;

import java.math.BigInteger;
import java.util.List;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
public interface ISipUserDao extends IGenericDao<BigInteger, SipUser> {
	List<SipUser> getActiveSipUserList();

	SipUser getByDn(String dn);

	void executeFinishCitlSc(int sipUserId);

	void executeHangupCitlMc(int sipUserId);

	void executeBeginCitlSc(int sipUserId);
}
