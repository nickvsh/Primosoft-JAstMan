package com.primosoft.astman.core.log;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * Created on 12.09.16.
 *
 * @author atelizhenko
 */
public final class Log4jChangeWatcherService implements Runnable {
	private final Logger errorLogger;
	private final Logger infoLogger;
	private String fullFilePath;
	private String configFileName;
	private String dirPath;
	private WatchService watchService;

	@Autowired
	public Log4jChangeWatcherService(Logger errorLogger, Logger infoLogger) {
		this.errorLogger = errorLogger;
		this.infoLogger = infoLogger;
	}

	final void setFullFilePath(String fullFilePath) {
		this.fullFilePath = fullFilePath;
		this.configFileName = initConfigFileName(fullFilePath);
	}

	private String initConfigFileName(String fullFilePath) {
		final int lastIndex = fullFilePath.lastIndexOf(File.separator);
		this.dirPath = fullFilePath.substring(0, lastIndex + 1);
		return fullFilePath.substring(lastIndex + 1, fullFilePath.length());
	}

	@Override
	public void run() {
		if (fullFilePath == null || fullFilePath.isEmpty()) {
			errorLogger.error("Log4j file path in watcher service configured improperly!");
			return;
		}
		try {
			register();
		} catch (IOException e) {
			errorLogger.error(e.getMessage(), e);
		}
	}

	private void register() throws IOException {
		configurationChanged(this.fullFilePath);
		startWatcher(this.dirPath, this.configFileName);
	}

	private void configurationChanged(String configFileName) {
		infoLogger.warn("Log4j configuration file changed. Reloading logging levels");
		DOMConfigurator.configure(configFileName);
	}

	private void startWatcher(String dirPath, String configFileName) throws IOException {
		watchService = FileSystems.getDefault().newWatchService();

		final Path path = Paths.get(dirPath);
		path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

		while (true) {
			try {
				final WatchKey key = watchService.take();
				key.pollEvents()
						.stream()
						.filter(event -> event.context().toString().equals(this.configFileName))
						.forEach(event -> configurationChanged(dirPath + configFileName));
				final boolean reset = key.reset();
				if (!reset) {
					errorLogger.error("Could not reset the watch key.");
					break;
				}
			} catch (Exception e) {
				errorLogger.error(e.getMessage(), e);
			}
		}
	}

	final void shutdown() {
		if (watchService != null) {
			try {
				watchService.close();
			} catch (IOException e) {
				errorLogger.error(e.getMessage(), e);
			}
		}
	}
}
