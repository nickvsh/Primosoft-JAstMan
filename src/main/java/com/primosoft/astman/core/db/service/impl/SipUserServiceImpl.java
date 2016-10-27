/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.ISipUserDao;
import com.primosoft.astman.core.db.dao.ex.NoOperatorFound;
import com.primosoft.astman.core.db.entity.ats.Operator;
import com.primosoft.astman.core.db.entity.ats.SipUser;
import com.primosoft.astman.core.db.service.IOperatorService;
import com.primosoft.astman.core.db.service.ISipUserService;
import com.primosoft.astman.core.log.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Service(value = "sipUserService")
@Transactional(readOnly = true)
public class SipUserServiceImpl implements ISipUserService {
	private final ISipUserDao sipUserDao;
	private final IOperatorService operatorService;
	private final Logger logger;

	@Autowired
	public SipUserServiceImpl(ISipUserDao sipUserDao, IOperatorService operatorService,
							  @Qualifier("serviceLogger") Logger logger) {
		this.sipUserDao = sipUserDao;
		this.operatorService = operatorService;
		this.logger = logger;
	}

	@Override
	public List<SipUser> getAllActiveSipUsers() {
		return sipUserDao.getActiveSipUserList();
	}

	@Override
	public SipUser findByUserName(String dn) {
		return sipUserDao.getByDn(dn);
	}

	@Override
	@Transactional
	public void invokeFinishCitlSc(SipUser sipUser) {
		try {
			final Operator operator = operatorService.getBySipUser(sipUser);
			sipUserDao.executeFinishCitlSc(operator.getWorkAppUser().getId().intValue());
		} catch (NoOperatorFound ignored) {
		}
	}

	@Override
	@Transactional
	public void invokeHangupCitlMc(SipUser sipUser) {
		try {
			final Operator operator = operatorService.getBySipUser(sipUser);
			sipUserDao.executeHangupCitlMc(operator.getWorkAppUser().getId().intValue());
		} catch (NoOperatorFound ignored) {
		}
	}

	@Override
	@Transactional
	public void invokeBeginCitlSc(SipUser sipUser) {
		try {
			final Operator operator = operatorService.getBySipUser(sipUser);
			sipUserDao.executeBeginCitlSc(operator.getWorkAppUser().getId().intValue());
		} catch (NoOperatorFound ignored) {
		}
	}
}
