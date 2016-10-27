/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket;

import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.PropertiesUtil;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
final class ServerSocket implements Runnable {
	final static int READ_MESSAGE_WAIT_TIME = 15;
	//	final static int MESSAGE_INPUT_SIZE = 128;
	private final InetSocketAddress listenAddress;
	private final Logger socketLogger;
	private final Logger errorLogger;
	private final ExecutorService selectorSocketExecutorService;
	private final PropertiesUtil propertiesUtil;
	private final AsyncSocketReadWriteMechanism asyncSocketReadWriteMechanism;
	private AsynchronousChannelGroup asyncChannelGroup;
	private AsynchronousServerSocketChannel asyncServerSocketChannel;

	@Autowired
	ServerSocket(Logger socketLogger, Logger errorLogger, PropertiesUtil propertiesUtil,
				 AsyncSocketReadWriteMechanism asyncSocketReadWriteMechanism) {
		this.socketLogger = socketLogger;
		this.errorLogger = errorLogger;
		this.propertiesUtil = propertiesUtil;

		this.listenAddress = new InetSocketAddress(
				propertiesUtil.getProperty("astman.local.domain"),
				Integer.parseInt(propertiesUtil.getProperty("astman.local.port"))
		);

		this.selectorSocketExecutorService = Executors.newCachedThreadPool(
				new BasicThreadFactory.Builder()
						.namingPattern("ServerSelectorSocketMechanism %d")
						.daemon(true)
						.priority(Thread.MAX_PRIORITY)
						.build()
		);
		this.asyncSocketReadWriteMechanism = asyncSocketReadWriteMechanism;
	}

	@Override
	public void run() {
		try {
			startAsynchronousServer();
		} catch (IOException e) {
			errorLogger.error(e.getMessage(), e);
		}
	}

	private void startAsynchronousServer() throws IOException {
		createAsyncChannelGroup();
		openAsyncChannel(listenAddress);
		listenAsyncChannel();
	}

	private void createAsyncChannelGroup() throws IOException {
		asyncChannelGroup = AsynchronousChannelGroup.withThreadPool(selectorSocketExecutorService);
	}

	private void openAsyncChannel(InetSocketAddress serverAddress) throws IOException {
		socketLogger.debug("Opening Async ServerSocket channel at " + serverAddress);
		asyncServerSocketChannel = AsynchronousServerSocketChannel.open(asyncChannelGroup).bind(serverAddress);
		asyncServerSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF,
				Integer.parseInt(propertiesUtil.getProperty("socket.buffer.size")));
		asyncServerSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
	}

	private void listenAsyncChannel() {
		if (asyncServerSocketChannel.isOpen()) {
			asyncServerSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
				@Override
				public void completed(final AsynchronousSocketChannel asyncSocketChannel, Object attachment) {
					if (asyncServerSocketChannel.isOpen()) {
						asyncServerSocketChannel.accept(null, this);
					}
					handleAcceptConnection(asyncSocketChannel);
				}

				@Override
				public void failed(Throwable exc, Object attachment) {
					socketLogger.error("Handled failed mechanism in ", exc);
					if (asyncServerSocketChannel.isOpen()) {
						asyncServerSocketChannel.accept(null, this);
					}
				}
			});
			socketLogger.trace("Socket server is ready to accepting connections");
		}
	}

	private void handleAcceptConnection(AsynchronousSocketChannel asyncSocketChannel) {
		asyncSocketReadWriteMechanism.setAsyncSocketChannel(asyncSocketChannel);
		asyncSocketReadWriteMechanism.run();
	}
}
