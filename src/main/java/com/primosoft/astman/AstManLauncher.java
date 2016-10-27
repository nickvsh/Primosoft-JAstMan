/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman;

import com.primosoft.astman.core.ast.facade.SpringFacade;
import com.primosoft.astman.core.ast.listener.AsteriskEventListener;
import com.primosoft.astman.core.ast.socket.SocketMechanismFactory;
import com.primosoft.astman.core.http.LocalHttpServer;
import com.primosoft.astman.core.log.Log4jConfigurator;
import com.primosoft.astman.core.log.Logger;

/**
 * Created on 17.08.16.
 *
 * @author atelizhenko
 */
final class AstManLauncher {
	private String mode;

	AstManLauncher() {

	}

	void run() {
		initJAstMan();
		final Logger infoLogger = SpringFacade.getInstance().getLoggerFacade().getInfoLogger();
		final Logger errorLogger = SpringFacade.getInstance().getLoggerFacade().getErrorLogger();

		infoLogger.info("Starting with \"" + this.mode.toUpperCase() + "\" mode!");

		while (true) {    //forever...
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					errorLogger.error(e.getMessage(), e);
				}
			}
		}
	}

	private void initJAstMan() {
		initSpringProfile();
		initSpringContext();
		initLog4jConfiguratorService();
		initAmiListener();
		initServerSocket();
		initLocalHttpServer();
	}

	private void initSpringProfile() {
		final ProfileMode profileMode = ProfileMode.guestProfile(System.getProperty("jastman.profile.mode"));
		System.setProperty("spring.profiles.active", profileMode.getName());
	}

	private void initSpringContext() {
		SpringFacade.getInstance();
	}

	private void initLog4jConfiguratorService() {
		final Log4jConfigurator log4jConfigurator = SpringFacade.getInstance().getBeansFacade().getLog4jConfigurator();
		log4jConfigurator.initialize();
	}

	private void initAmiListener() {
		final AsteriskEventListener eventListener = SpringFacade.getInstance().getServiceFacade().getAsteriskEventListener();
		eventListener.startListening();
	}

	private void initServerSocket() {
		final SocketMechanismFactory socketMechanismFactory =
				SpringFacade.getInstance().getBeansFacade().getSocketMechanismFactory();
		socketMechanismFactory.runServerSocketMechanism();
	}

	private void initLocalHttpServer() {
		final LocalHttpServer localHttpServer = SpringFacade.getInstance().getBeansFacade().getLocalHttpServer();
		localHttpServer.startup();
	}

	private enum ProfileMode {
		TEST("TEST", 0),
		PRODUCTION("PRODUCTION", 1);

		private final String name;
		private final int mode;

		ProfileMode(String name, int mode) {
			this.name = name;
			this.mode = mode;
		}

		private static ProfileMode guestProfile(String profile) {
			if (profile == null || profile.isEmpty())
				throw new IllegalArgumentException("You should to specify profile mode!");

			for (ProfileMode profileMode : values()) {
				if (profile.equalsIgnoreCase(profileMode.getName())
						|| profile.equalsIgnoreCase(String.valueOf(profileMode.getMode())))
					return profileMode;
			}

			throw new IllegalArgumentException("You are set profile mode as \""
					+ profile
					+ "\", but it has no specification. Please, specify profile mode properly!");
		}

		private String getName() {
			return name;
		}

		private int getMode() {
			return mode;
		}
	}
}
