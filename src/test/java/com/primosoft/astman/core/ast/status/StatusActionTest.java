/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.status;

import com.primosoft.astman.core.ast.listener.AsteriskEventListener;
import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.manager.action.StatusAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created on 25.08.16.
 *
 * @author atelizhenko
 */
@ActiveProfiles("test")
@ContextConfiguration("classpath:config/spring-all.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StatusActionTest {
	@Qualifier("asteriskLogger")
	@Autowired
	private Logger logger;
	@Autowired
	private AsteriskEventListener asteriskEventListener;

	@Test
	public void testStatusAction() throws InterruptedException, IOException {
		asteriskEventListener.startListening();
		asteriskEventListener.sendAction(new StatusAction(), response -> logger.warn(response));
		Thread.sleep(TimeUnit.SECONDS.toMillis(5));
	}
}
