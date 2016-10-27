/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket;

import com.primosoft.astman.core.ast.facade.SpringFacade;
import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
final class ClientSocket implements Runnable {
	private final Logger socketLogger;
	private final Logger errorLogger;
	private String url;

	@Autowired
	ClientSocket(@Qualifier("socketLogger") Logger socketLogger, @Qualifier("errorLogger") Logger errorLogger) {
		this.socketLogger = socketLogger;
		this.errorLogger = errorLogger;
	}

	void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		try {
			startClient();
		} catch (IOException | InterruptedException e) {
			errorLogger.error(e.getMessage(), e);
		}
	}

	private void startClient() throws IOException, InterruptedException {
		socketLogger.trace("Starting client socket connection!");
		if (url != null) {
			final PropertiesUtil propertiesUtil = SpringFacade.getInstance().getUtilFacade().getPropertiesUtil();
			final InetSocketAddress hostAddress =
					new InetSocketAddress(url, Integer.parseInt(propertiesUtil.getProperty("client.local.port")));
			final SocketChannel client = SocketChannel.open(hostAddress);

			socketLogger.debug("Client socket connected to " + url);

			for (final String message1 : new String[]{"test"}) {
				byte[] message = message1.getBytes();
				ByteBuffer buffer = ByteBuffer.wrap(message);
				client.write(buffer);
				System.out.println(message1);

				buffer.clear();
			}
			client.close();
		} else
			errorLogger.error("URL is null in client socket connection!");
	}
}
