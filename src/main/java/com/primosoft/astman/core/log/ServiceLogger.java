/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.log;

import org.apache.log4j.Level;

/**
 * Created on 30.08.16.
 *
 * @author atelizhenko
 */
public class ServiceLogger extends AbstractLogger implements Logger {
	ServiceLogger() {
	}

	@Override
	protected Level getLevel() {
		return Level.INFO;
	}
}
