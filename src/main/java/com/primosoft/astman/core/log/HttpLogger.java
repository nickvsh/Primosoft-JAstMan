/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.log;

import org.apache.log4j.Level;

/**
 * Created on 02.09.16.
 *
 * @author atelizhenko
 */
public class HttpLogger extends AbstractLogger implements Logger {
	HttpLogger() {
	}

	@Override
	protected Level getLevel() {
		return Level.INFO;
	}
}
