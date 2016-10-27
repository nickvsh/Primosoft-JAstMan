/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.fastagi.AgiScript;
import org.asteriskjava.fastagi.AgiServer;
import org.asteriskjava.fastagi.AgiServerThread;
import org.asteriskjava.fastagi.DefaultAgiServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;

/**
 * Created on 31.08.16.
 *
 * @author atelizhenko
 */
class AgiListener implements AgiServer {
	private final Logger logger;
	private final AgiServerThread agiServerThread;

	@Autowired
	AgiListener(@Qualifier("agiLogger") Logger logger) {
		this.logger = logger;
		this.agiServerThread = new AgiServerThread(new DefaultAgiServer());
	}

	/**
	 * Starts this AgiServer.<p>
	 * After calling startup() this AgiServer is ready to receive requests from
	 * Asterisk servers and process them.<p>
	 * Note that this method will not return until the AgiServer has been shut down.
	 * If you want to run the AgiServer in the background use wrap it with an
	 * {@link AgiServerThread}.
	 *
	 * @throws IOException           if the server socket cannot be bound.
	 * @throws IllegalStateException if this AgiServer is already running.
	 */
	@Override
	public void startup() throws IOException, IllegalStateException {
		agiServerThread.startup();
		logger.info("Started AGI server");
	}

	/**
	 * Stops this AgiServer.<p>
	 * The server socket is closed, new connections are refused and resources
	 * are freed. Any running {@link AgiScript}s are finish before shutdown
	 * completes.
	 *
	 * @throws IllegalStateException if this AgiServer is already shut down or
	 *                               has not yet been started.
	 */
	@Override
	public void shutdown() throws IllegalStateException {
		agiServerThread.shutdown();
		logger.info("Stopped AGI server");
	}
}
