/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.log;

import org.apache.log4j.Priority;

/**
 * Created on 02.09.16.
 *
 * @author atelizhenko
 */
public interface Logger {
	void trace(Object message);

	void trace(Object message, Throwable t);

	void debug(Object message);

	void debug(Object message, Throwable t);

	void error(Object message);

	void error(Object message, Throwable t);

	void fatal(Object message);

	void fatal(Object message, Throwable t);

	void info(Object message);

	void info(Object message, Throwable t);

	void log(Priority priority, Object message, Throwable t);

	void log(Priority priority, Object message);

	void log(String callerFQCN, Priority level, Object message, Throwable t);

	void warn(Object message);

	void warn(Object message, Throwable t);
}
