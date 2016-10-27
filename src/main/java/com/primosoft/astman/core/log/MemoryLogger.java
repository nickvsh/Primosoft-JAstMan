/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.log;

import org.apache.log4j.Level;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
public class MemoryLogger extends AbstractLogger implements Logger {
	MemoryLogger() {
	}

	@Override
	protected Level getLevel() {
		return Level.WARN;
	}
}
