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
public class SocketLogger extends AbstractLogger implements Logger {
	SocketLogger() {
	}

	@Override
	protected Level getLevel() {
		return Level.ALL;
	}
}
