package com.primosoft.astman.core.log;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 12.09.16.
 *
 * @author atelizhenko
 */
public final class Log4jConfigurator {
	private final Log4jChangeWatcherService log4jChangeWatcherService;
	private final Logger errorLogger;
	private final Logger infoLogger;

	@Autowired
	public Log4jConfigurator(Log4jChangeWatcherService log4jChangeWatcherService, Logger errorLogger, Logger infoLogger) {
		this.log4jChangeWatcherService = log4jChangeWatcherService;
		this.errorLogger = errorLogger;
		this.infoLogger = infoLogger;
	}

	public final void initialize() {
		final String log4jFile = System.getProperty("log4j.configuration");

		if (log4jFile != null && !log4jFile.isEmpty()) {
			infoLogger.info("Initializing log4j configurator to handle changes from " + log4jFile);

			final String empty = "";
			final String needCutString = "file:";
			final String localLog4jFile;
			if (log4jFile.startsWith(needCutString)) {
				localLog4jFile = log4jFile.replace(needCutString, empty);
			} else
				localLog4jFile = log4jFile;
			log4jChangeWatcherService.setFullFilePath(localLog4jFile);

			new Thread(log4jChangeWatcherService).start();
		} else {
			errorLogger.error("No file configured for external log4j. Beginning use classpath configuration file");
		}
	}

	public final void shutdown() {
		log4jChangeWatcherService.shutdown();
	}
}
