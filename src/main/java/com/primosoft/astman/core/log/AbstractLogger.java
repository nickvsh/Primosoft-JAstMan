/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.or.ObjectRenderer;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
abstract class AbstractLogger implements com.primosoft.astman.core.log.Logger {
	private Logger logger;
	private String name;

	public void setName(String name) {
		this.name = name;
		logger = Logger.getLogger(name);
		logger.setLevel(getLevel());
	}

	protected abstract Level getLevel();

	public void trace(Object message) {
		logger.trace(message);
	}

	public void trace(Object message, Throwable t) {
		logger.trace(message, t);
	}

	public void debug(Object message) {
		logger.debug(message);
	}

	public void debug(Object message, Throwable t) {
		logger.debug(message, t);
	}

	public void error(Object message) {
		logger.error(message);
	}

	public void error(Object message, Throwable t) {
		logger.error(message, t);
	}

	public void fatal(Object message) {
		logger.fatal(message);
	}

	public void fatal(Object message, Throwable t) {
		logger.fatal(message, t);
	}

	public void info(Object message) {
		logger.info(message);
	}

	public void info(Object message, Throwable t) {
		logger.info(message, t);
	}

	public void log(Priority priority, Object message, Throwable t) {
		logger.log(priority, message, t);
	}

	public void log(Priority priority, Object message) {
		logger.log(priority, message);
	}

	public void log(String callerFQCN, Priority level, Object message, Throwable t) {
		logger.log(callerFQCN, level, message, t);
	}

	public void warn(Object message) {
		logger.warn(message);
	}

	public void warn(Object message, Throwable t) {
		logger.warn(message, t);
	}
}
