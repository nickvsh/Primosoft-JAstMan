package com.primosoft.astman.core.ast.socket;

import com.primosoft.astman.core.log.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created on 09.09.16.
 *
 * @author atelizhenko
 */
class SocketAcceptMechanism implements Runnable {
	private final Logger socketLogger;
	private final Logger errorLogger;
	private SelectionKey key;
	private Selector selector;

	@Autowired
	public SocketAcceptMechanism(Logger socketLogger, Logger errorLogger) {
		this.socketLogger = socketLogger;
		this.errorLogger = errorLogger;
	}

	void setKey(SelectionKey key) {
		this.key = key;
	}

	void setSelector(Selector selector) {
		this.selector = selector;
	}

	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		if (key == null) {
			errorLogger.error("Selection key in " + getClass().getSimpleName() + " is not defined");
			return;
		} else if (selector == null) {
			errorLogger.error("Selector in " + getClass().getSimpleName() + " is not defined");
			return;
		}

		accept(key);
	}

	private void accept(SelectionKey key) {
		try {
			final ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
			final SocketChannel channel = serverChannel.accept();
			channel.configureBlocking(false);
			final Socket socket = channel.socket();
			final SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
			socketLogger.trace("Connected to: " + remoteSocketAddress);

			channel.register(this.selector, SelectionKey.OP_READ);
		} catch (IOException e) {
			errorLogger.error(e.getMessage(), e);
		}
	}
}
