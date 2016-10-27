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
public class InfoLogger extends AbstractLogger implements Logger {
	InfoLogger() {
	}

	@Override
	protected Level getLevel() {
		return Level.ALL;
	}
}
