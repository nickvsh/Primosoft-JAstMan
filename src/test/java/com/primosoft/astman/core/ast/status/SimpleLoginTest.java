/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.status;

import org.asteriskjava.live.AsteriskServer;
import org.asteriskjava.live.internal.AsteriskServerImpl;
import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.StatusAction;
import org.junit.Test;

import java.io.IOException;

/**
 * Created on 29.08.16.
 *
 * @author atelizhenko
 */
public class SimpleLoginTest {
	@Test
	public void testAsteriskLogin() throws IOException, TimeoutException, InterruptedException, AuthenticationFailedException {
		ManagerConnectionFactory managerConnectionFactory = new ManagerConnectionFactory("10.0.1.109", "comrade", "comrade");
		final AsteriskServer asteriskServer = new AsteriskServerImpl(managerConnectionFactory.createManagerConnection());
		asteriskServer.getManagerConnection().login();
		asteriskServer.getManagerConnection().sendAction(new StatusAction(), System.out::println);
		Thread.sleep(5000);
		asteriskServer.shutdown();
	}
}
