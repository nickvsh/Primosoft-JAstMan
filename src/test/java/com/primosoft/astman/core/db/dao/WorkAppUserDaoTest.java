/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao;

import com.primosoft.astman.core.db.entity.ats.WorkAppUser;
import com.primosoft.astman.core.log.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigInteger;

@ActiveProfiles("test")
@ContextConfiguration("classpath:config/spring-all.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkAppUserDaoTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Inject
	private IWorkAppUserDao workAppUserDao;
	@Named("infoLogger")
	@Inject
	private Logger logger;

	@Test
	public void testGetAppUser() {
		final WorkAppUser workAppUser = workAppUserDao.getById(BigInteger.valueOf(284));
		Assert.assertNotNull("App user is null", workAppUser);
		logger.info("WorkAppUser is: " + workAppUser);
	}
}
