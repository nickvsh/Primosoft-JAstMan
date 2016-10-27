/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.facade;

import com.primosoft.astman.core.ast.listener.AsteriskEventListener;
import com.primosoft.astman.core.http.LocalHttpServer;
import com.primosoft.astman.core.log.Log4jConfigurator;
import com.primosoft.astman.core.log.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
public final class SpringFacade {
	private final DaoRepositoryFacade daoRepositoryFacade;
	private final ServiceFacade serviceFacade;
	private final BeansFacade beansFacade;
	private final UtilFacade utilFacade;
	private final LoggerFacade loggerFacade;

	private SpringFacade() {
		final AbstractApplicationContext context = new FileSystemXmlApplicationContext("config/spring-all.xml");
		this.daoRepositoryFacade = new DaoRepositoryFacade(context);
		this.serviceFacade = new ServiceFacade(context);
		this.beansFacade = new BeansFacade(context);
		this.utilFacade = new UtilFacade(context);
		this.loggerFacade = new LoggerFacade(context);

		context.registerShutdownHook();

		Runtime.getRuntime().addShutdownHook(
				new ShutdownThread(
						context,
						loggerFacade.getInfoLogger(),
						serviceFacade.getAsteriskEventListener(),
						beansFacade.getLocalHttpServer(),
						beansFacade.getLog4jConfigurator()
				)
		);
	}

	public static SpringFacade getInstance() {
		return LocalFacadeHolder.LOCAL_FACADE;
	}

	public final DaoRepositoryFacade getDaoRepositoryFacade() {
		return daoRepositoryFacade;
	}

	public final ServiceFacade getServiceFacade() {
		return serviceFacade;
	}

	public final BeansFacade getBeansFacade() {
		return beansFacade;
	}

	public final UtilFacade getUtilFacade() {
		return utilFacade;
	}

	public final LoggerFacade getLoggerFacade() {
		return loggerFacade;
	}

	private static final class LocalFacadeHolder {
		private static final SpringFacade LOCAL_FACADE = new SpringFacade();
	}

	private static final class ShutdownThread extends Thread {
		private final AbstractApplicationContext context;
		private final Logger logger;
		private final AsteriskEventListener asteriskEventListener;
		private final LocalHttpServer localHttpServer;
		private final Log4jConfigurator log4jConfigurator;

		private ShutdownThread(AbstractApplicationContext context, Logger logger,
							   AsteriskEventListener asteriskEventListener,
							   LocalHttpServer localHttpServer, Log4jConfigurator log4jConfigurator) {
			super();

			this.context = context;
			this.logger = logger;
			this.asteriskEventListener = asteriskEventListener;
			this.localHttpServer = localHttpServer;
			this.log4jConfigurator = log4jConfigurator;
		}

		@Override
		public void run() {
			asteriskEventListener.shutdown();
			localHttpServer.shutdown();
			log4jConfigurator.shutdown();
			logger.info("Invoked properly shutdown hook!");

			context.close();
		}
	}
}
