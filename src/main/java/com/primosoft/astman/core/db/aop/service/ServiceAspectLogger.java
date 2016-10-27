/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.aop.service;

import com.primosoft.astman.core.log.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.concurrent.TimeUnit;

/**
 * Created on 30.08.16.
 *
 * @author atelizhenko
 */
@Aspect
public class ServiceAspectLogger {
	private final Logger serviceLogger;
	private final Logger errorLogger;

	@Autowired
	public ServiceAspectLogger(@Qualifier("serviceLogger") Logger serviceLogger, @Qualifier("errorLogger") Logger errorLogger) {
		this.serviceLogger = serviceLogger;
		this.errorLogger = errorLogger;
	}

	@Around("execution(* com.primosoft.astman.core.db.service.impl.*.*(..)) && !execution(* com.primosoft.astman.core.db.service.impl.*.set*(..))")
	public Object logAroundServices(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		final long now = System.nanoTime();
		try {
			return proceedingJoinPoint.proceed();
		} catch (Exception e) {
			errorLogger.error(e.getMessage(), e);
			throw e;
		} finally {
			final long after = System.nanoTime();
			final long timeLeftNs = after - now;
			final long timeLeft = TimeUnit.NANOSECONDS.toMillis(timeLeftNs);

			final String timeResult = timeLeft == 0 ? TimeUnit.NANOSECONDS.toMicros(timeLeftNs) + "mcs." : timeLeft + "ms.";

			final String message = "Time elapsed:\t" + timeResult + "\tInvoked method\t" + proceedingJoinPoint.toString();

			if (TimeUnit.MILLISECONDS.toSeconds(timeLeft) > 5)    //warn message instead of info
				serviceLogger.warn(message);
			else
				serviceLogger.info(message);
		}
	}
}