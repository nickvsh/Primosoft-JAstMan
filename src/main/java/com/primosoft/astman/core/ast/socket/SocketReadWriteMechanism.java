package com.primosoft.astman.core.ast.socket;

import com.primosoft.astman.core.ast.socket.context.action.BlockActionContext;
import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.BlockHelper;
import com.primosoft.astman.core.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * Created on 09.09.16.
 *
 * @author atelizhenko
 */
class SocketReadWriteMechanism implements Runnable {
	private final Logger socketLogger;
	private final Logger errorLogger;
	private final PropertiesUtil propertiesUtil;
	private final BlockActionContext blockActionContext;
	private SelectionKey key;

	@Autowired
	SocketReadWriteMechanism(Logger socketLogger, Logger errorLogger,
							 PropertiesUtil propertiesUtil, BlockActionContext blockActionContext) {
		this.socketLogger = socketLogger;
		this.errorLogger = errorLogger;
		this.propertiesUtil = propertiesUtil;
		this.blockActionContext = blockActionContext;
	}

	void setKey(SelectionKey key) {
		this.key = key;
	}

	@Override
	public void run() {
		if (key == null) {
			errorLogger.error("Selection key in " + getClass().getSimpleName() + " is not defined");
			return;
		}
		read(key);
	}

	private void read(SelectionKey key) {
		try {
			final SocketChannel channel = (SocketChannel) key.channel();
			final ByteBuffer buffer =
					ByteBuffer.allocate(Integer.parseInt(propertiesUtil.getProperty("socket.buffer.size")));
			final int numRead = channel.read(buffer);

			if (numRead == -1) {
				final Socket socket = channel.socket();
				final SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
				socketLogger.trace("Connection closed by client: " + remoteSocketAddress);
				channel.close();
				key.cancel();
				return;
			}

			byte[] data = new byte[numRead];
			System.arraycopy(buffer.array(), 0, data, 0, numRead);

			write(channel, new String(data));
		} catch (IOException e) {
			errorLogger.error(e.getMessage(), e);
		}
	}

	private void write(final SocketChannel channel, final String block) throws IOException {
		socketLogger.trace("Got incoming block: " + block);

		blockActionContext.setBlockHelper(new BlockHelper(block));
		blockActionContext.setRemoteSocketAddress(channel.socket().getRemoteSocketAddress());

		final String response = blockActionContext.discoverActionStrategy();
		final ByteBuffer writeBuffer = ByteBuffer.wrap(response.getBytes());
		channel.write(writeBuffer);
		writeBuffer.clear();
	}
}
