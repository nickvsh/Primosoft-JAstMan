/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.http;

import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.PropertiesUtil;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 02.09.16.
 *
 * @author atelizhenko
 */
final class JettyLocalHttpServer implements LocalHttpServer {
	private final Logger logger;
	private final Server server;
	private final Logger errorLogger;
	private final Handler handler;
	private final PropertiesUtil propertiesUtil;

	@Autowired
	JettyLocalHttpServer(@Qualifier("httpLogger") Logger logger,
						 @Qualifier("errorLogger") Logger errorLogger,
						 @Qualifier("httpLocalEventsHandler") Handler handler, PropertiesUtil propertiesUtil) {
		this.logger = logger;
		this.propertiesUtil = propertiesUtil;
		this.errorLogger = errorLogger;
		this.handler = handler;

		this.server = new Server(Integer.parseInt(propertiesUtil.getProperty("http.local.port")));
		this.server.setHandler(handler);
	}

	@Override
	public void startup() {
		try {
			server.start();
			logger.info("Started local http server");
		} catch (Exception e) {
			errorLogger.error(e.getMessage(), e);
		}
	}

	@Override
	public void shutdown() {
		try {
			server.stop();
			logger.info("Stopped local http server");
		} catch (Exception e) {
			errorLogger.error(e.getMessage(), e);
		}
	}
}
