/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket.context.action;

import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.BlockHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.net.SocketAddress;

/**
 * Created on 17.08.16.
 *
 * @author atelizhenko
 */
abstract class AbstractSuccessFailedResponseAction implements SuccessResponseAction, FailedResponseAction, ResponseAction {
	private final Logger logger;
	private BlockHelper blockHelper;
	private SocketAddress remoteSocketAddress;

	@Autowired
	public AbstractSuccessFailedResponseAction(@Qualifier("socketLogger") Logger logger) {
		this.logger = logger;
	}

	final Logger getLogger() {
		return logger;
	}

	BlockHelper getBlockHelper() {
		return blockHelper;
	}

	@Override
	public void setBlockHelper(BlockHelper blockHelper) {
		this.blockHelper = blockHelper;
	}

	@Override
	public void setSocketAddress(SocketAddress socketAddress) {
		this.remoteSocketAddress = socketAddress;
	}

	@Override
	public boolean stayConnection() {
		return false;
	}

	SocketAddress getRemoteSocketAddress() {
		return remoteSocketAddress;
	}

	@Override
	public String invoke() {
		logger.trace("Start to generate response");

		final ResponsePairMechanism responsePairMechanism = new ResponsePairMechanism();
		try {
			responsePairMechanism.addPairs(invokeAction() ? onSuccess() : onFailed());
			final String response = responsePairMechanism.convertResponse();

			logger.debug("Converted generated response is " + response);
			return response;
		} catch (Exception e) {
			responsePairMechanism.addPairs(onFailed());
			final String failResponse = responsePairMechanism.convertResponse();
			logger.debug("Converted generated failed response is " + failResponse);
			return failResponse;
		} finally {
			responsePairMechanism.clear();
		}
	}

	abstract boolean invokeAction() throws Exception;

	@Override
	public ResponsePair[] onSuccess() {
		return new ResponsePair[]{new DefaultSuccessResponsePair()};
	}

	@Override
	public ResponsePair[] onFailed() {
		return new ResponsePair[]{new DefaultFailedResponsePair()};
	}
}
