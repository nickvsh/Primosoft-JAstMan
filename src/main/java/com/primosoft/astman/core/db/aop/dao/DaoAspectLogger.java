/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.aop.dao;

import com.primosoft.astman.core.log.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;

import javax.persistence.PersistenceException;
import java.sql.SQLException;

/**
 * Created on 05.09.16.
 *
 * @author atelizhenko
 */
@Aspect
public class DaoAspectLogger {
	private final Logger sqlLogger;

	@Autowired
	public DaoAspectLogger(@Qualifier("sqlLogger") Logger sqlLogger) {
		this.sqlLogger = sqlLogger;
	}

	@Around("execution(* com.primosoft.astman.core.db.dao.*.*(..))")
	public Object logAroundDao(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		try {
			return proceedingJoinPoint.proceed();
		} catch (PersistenceException | DataAccessException | SQLException e) {
			sqlLogger.error(e.getMessage(), e);
			throw e;
		}
	}
}
