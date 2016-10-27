/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.actions;

import com.primosoft.astman.core.ast.socket.context.action.BlockActionContext;
import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.BlockHelper;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created on 17.08.16.
 *
 * @author atelizhenko
 */
@ActiveProfiles("test")
@ContextConfiguration("classpath:config/spring-all.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ActionTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Qualifier("socketLogger")
	@Autowired
	private Logger logger;
	@Autowired
	private BlockActionContext blockActionContext;

	@Test
	public void actionTest() {
		final String appUserState = "Action: SetWorkAppUserState"
				+ "\nHOST: 192.168.110.88"
				+ "\nAPP_USER_ID: 284"
				+ "\nSTATE: 10\n\n";

		logger.info("Incoming action: " + appUserState);

		blockActionContext.setBlockHelper(new BlockHelper(appUserState));
		final String response = blockActionContext.discoverActionStrategy();

		Assert.assertNotNull("Attention! Response is failure", response);

		logger.info("Response after incoming action is: " + response);
	}
}
