/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.http.events;

import com.primosoft.astman.core.log.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 02.09.16.
 *
 * @author atelizhenko
 */
public class HttpLocalEventsHandler extends ContextHandlerCollection {
	private final Logger logger;
	private final Handler handler;

	@Autowired
	HttpLocalEventsHandler(@Qualifier("httpLogger") Logger logger,
						   @Qualifier("commandServletHttpLocalEventsHandler") Handler handler) {
		this.logger = logger;
		this.handler = handler;

		setHandlers(new Handler[] {handler});
	}
}
