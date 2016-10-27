package com.primosoft.astman.core.ast.socket;

import com.primosoft.astman.core.ast.socket.context.action.BlockActionContext;
import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.BlockDiscover;
import com.primosoft.astman.core.util.BlockHelper;
import com.primosoft.astman.core.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.List;
import java.util.concurrent.*;

import static com.primosoft.astman.core.ast.socket.ServerSocket.READ_MESSAGE_WAIT_TIME;

/**
 * Created on 09.09.16.
 *
 * @author atelizhenko
 */
final class AsyncSocketReadWriteMechanism {
	private final Logger errorLogger;
	private final Logger socketLogger;
	private final BlockActionContext blockActionContext;
	private final PropertiesUtil propertiesUtil;
	private AsynchronousSocketChannel asyncSocketChannel;

	@Autowired
	AsyncSocketReadWriteMechanism(Logger errorLogger, Logger socketLogger, BlockActionContext blockActionContext, PropertiesUtil propertiesUtil) {
		this.errorLogger = errorLogger;
		this.socketLogger = socketLogger;
		this.blockActionContext = blockActionContext;
		this.propertiesUtil = propertiesUtil;
	}

	void setAsyncSocketChannel(AsynchronousSocketChannel asyncSocketChannel) {
		this.asyncSocketChannel = asyncSocketChannel;
	}

	void run() {
		if (asyncSocketChannel == null)
			errorLogger.error("AsynchronousSocketChannel is not defined for correct IO work!");

		handleAcceptConnection(asyncSocketChannel);
	}

	private void handleAcceptConnection(AsynchronousSocketChannel asyncSocketChannel) {
		socketLogger.debug("Handled asyncSocketChannel " + asyncSocketChannel);
		final ByteBuffer messageByteBuffer =
				ByteBuffer.allocate(Integer.parseInt(propertiesUtil.getProperty("socket.buffer.size")));
		boolean[] closeConnectionHandler = new boolean[0];
		try {
			final Future<Integer> futureReadResult = asyncSocketChannel.read(messageByteBuffer);
			final Integer integer = futureReadResult.get(READ_MESSAGE_WAIT_TIME, TimeUnit.SECONDS);
			if (integer != null && integer == -1) {
				socketLogger.debug("No bytes could be read because the channel "
						+ asyncSocketChannel
						+ " has reached end-of-stream.");
			}

			final String clientMessage = new String(messageByteBuffer.array());
			socketLogger.trace("Got incoming message block: " + clientMessage);

			messageByteBuffer.clear();
			messageByteBuffer.flip();

			socketLogger.trace("Discovering separate blocks");
			final List<BlockHelper> blockHelperList = BlockDiscover.discoverBlocks(clientMessage);
			final int blockHelperListSize = blockHelperList.size();
			socketLogger.debug("Discovered blocks are " + blockHelperList);

			if (blockHelperListSize > 0) {
				closeConnectionHandler = new boolean[blockHelperListSize];

				final SocketAddress remoteAddress = asyncSocketChannel.getRemoteAddress();
				blockActionContext.setRemoteSocketAddress(remoteAddress);

				for (int i = 0; i < blockHelperListSize; i++) {
					blockActionContext.setBlockHelper(new BlockHelper(blockHelperList.get(i)));

					final String response = blockActionContext.discoverActionStrategy();

					final ByteBuffer writeMessageByteBuffer = ByteBuffer.wrap(response.getBytes());
					socketLogger.debug("Writing to " + remoteAddress + " an answer " + response);
					final Future<Integer> futureWriteResult = asyncSocketChannel.write(writeMessageByteBuffer);
					final Integer numberBytesSends = futureWriteResult.get(READ_MESSAGE_WAIT_TIME, TimeUnit.SECONDS);
					if (numberBytesSends != null) {
						socketLogger.debug("Was written " + numberBytesSends + " bytes");
					}
					if (writeMessageByteBuffer.hasRemaining()) {
						writeMessageByteBuffer.compact();
					} else {
						writeMessageByteBuffer.clear();
					}

					closeConnectionHandler[i] = blockActionContext.verifyCloseConnection();
				}
			}

		} catch (InterruptedException | ExecutionException | TimeoutException | CancellationException | IOException e) {
			errorLogger.error(e.getMessage(), e);
			socketLogger.error(e.getMessage(), e);
		} finally {
			if (guessToCloseConnection(closeConnectionHandler))
				try {
					socketLogger.trace("Trying to close channel " + asyncSocketChannel);
					asyncSocketChannel.close();
				} catch (IOException e) {
					errorLogger.error(e.getMessage(), e);
					socketLogger.error(e.getMessage(), e);
				}
		}
	}

	private boolean guessToCloseConnection(boolean[] closeConnectionHandler) {
		for (boolean closeConnection : closeConnectionHandler) {
			if (closeConnection)
				return true;
		}
		return false;
	}

}
