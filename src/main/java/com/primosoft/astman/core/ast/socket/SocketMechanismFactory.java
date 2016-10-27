/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket;

import com.primosoft.astman.core.log.Logger;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 17.08.16.
 *
 * @author atelizhenko
 */
public final class SocketMechanismFactory {
	private final Logger socketLogger;
	private final ServerSocket serverSocket;
	private final ClientSocket clientSocket;
	private final ExecutorService serverSocketExecutorService;
	private final ExecutorService clientSocketExecutorService;

	@Autowired
	public SocketMechanismFactory(Logger socketLogger, ServerSocket serverSocket, ClientSocket clientSocket) {
		this.socketLogger = socketLogger;
		this.serverSocket = serverSocket;
		this.clientSocket = clientSocket;

		this.serverSocketExecutorService = Executors.newSingleThreadExecutor(
				new BasicThreadFactory.Builder()
						.namingPattern("ServerSocketMechanism %d")
						.daemon(true)
						.priority(Thread.MAX_PRIORITY)
						.build()
		);
		this.clientSocketExecutorService = Executors.newCachedThreadPool(
				new BasicThreadFactory.Builder()
						.namingPattern("ClientSocketMechanism %d")
						.daemon(true)
						.priority(Thread.MAX_PRIORITY)
						.build()
		);
	}

	public void runServerSocketMechanism() {
		socketLogger.info("Initialize server socket factory mechanism");
		serverSocketExecutorService.submit(serverSocket);
	}

	public void runClientSocketMechanism(final String url) {
		socketLogger.info("Initialize client socket mechanism which connects to " + url);
		clientSocket.setUrl(url);
		clientSocketExecutorService.submit(clientSocket);
	}
}
