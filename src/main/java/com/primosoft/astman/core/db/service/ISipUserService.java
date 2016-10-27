/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service;

import com.primosoft.astman.core.db.entity.ats.SipUser;

import java.util.List;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
public interface ISipUserService {
	List<SipUser> getAllActiveSipUsers();

	SipUser findByUserName(String dn);

	void invokeFinishCitlSc(SipUser sipUser);

	void invokeHangupCitlMc(SipUser sipUser);

	void invokeBeginCitlSc(SipUser sipUser);
}
