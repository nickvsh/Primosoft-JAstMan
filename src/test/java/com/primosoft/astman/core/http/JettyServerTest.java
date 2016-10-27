/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.http;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created on 02.09.16.
 *
 * @author atelizhenko
 */
@ActiveProfiles("test")
@ContextConfiguration("classpath:config/spring-all.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JettyServerTest {
	@Autowired
	private LocalHttpServer localHttpServer;

	@Test
	public void testJettyServer() throws InterruptedException {
		localHttpServer.startup();
		Thread.sleep(TimeUnit.SECONDS.toMillis(5));
		localHttpServer.shutdown();
	}
}
