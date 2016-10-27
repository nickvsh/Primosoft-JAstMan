/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.service;

import com.primosoft.astman.core.db.entity.ats.SipUser;
import com.primosoft.astman.core.log.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created on 05.09.16.
 *
 * @author atelizhenko
 */
@ActiveProfiles("test")
@ContextConfiguration("classpath:config/spring-all.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SipUserServiceTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Inject
	private ISipUserService sipUserService;
	@Qualifier("infoLogger")
	@Autowired
	private Logger logger;

	@Test
	public void testFunctionCitlsSc() {
		final SipUser sipUser = sipUserService.findByUserName("3105");
		sipUserService.invokeBeginCitlSc(sipUser);
		sipUserService.invokeFinishCitlSc(sipUser);
		sipUserService.invokeHangupCitlMc(sipUser);
	}
}
