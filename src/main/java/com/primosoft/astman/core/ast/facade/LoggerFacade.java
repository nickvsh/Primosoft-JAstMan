/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.facade;

import com.primosoft.astman.core.log.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
public final class LoggerFacade {
	private final ApplicationContext context;

	LoggerFacade(AbstractApplicationContext context) {
		this.context = context;
	}

	public Logger getMemoryLogger() {
		return (MemoryLogger) context.getBean("memoryLogger");
	}

	public Logger getInfoLogger() {
		return (InfoLogger) context.getBean("infoLogger");
	}

	public Logger getDebugLogger() {
		return (DebugLogger) context.getBean("debugLogger");
	}

	public Logger getSocketLogger() {
		return (SocketLogger) context.getBean("socketLogger");
	}

	public Logger getSqlLogger() {
		return (SqlLogger) context.getBean("sqlLogger");
	}

	public Logger getAsteriskLogger() {
		return (AsteriskLogger) context.getBean("asteriskLogger");
	}

	public Logger getErrorLogger() {
		return (ErrorLogger) context.getBean("errorLogger");
	}
}
