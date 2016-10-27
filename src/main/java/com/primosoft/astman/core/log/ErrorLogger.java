/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.log;

import org.apache.log4j.Level;

/**
 * Created on 17.08.16.
 *
 * @author atelizhenko
 */
public class ErrorLogger extends AbstractLogger implements Logger {
	ErrorLogger() {
	}

	@Override
	protected Level getLevel() {
		return Level.ERROR;
	}
}
