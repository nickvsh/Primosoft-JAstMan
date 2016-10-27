/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.log;

import org.apache.log4j.Level;

/**
 * Created on 31.08.16.
 *
 * @author atelizhenko
 */
public class AgiLogger extends AbstractLogger implements Logger {
	AgiLogger() {
	}

	@Override
	protected Level getLevel() {
		return Level.INFO;
	}
}
