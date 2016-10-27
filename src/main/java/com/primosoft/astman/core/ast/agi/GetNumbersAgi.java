/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.agi;

import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.BaseAgiScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 31.08.16.
 *
 * @author atelizhenko
 */
class GetNumbersAgi extends BaseAgiScript {
	private final Logger logger;

	@Autowired
	GetNumbersAgi(@Qualifier("agiLogger") Logger logger) {
		this.logger = logger;
	}

	/**
	 * The service method is called by the AsteriskServer whenever this
	 * AgiScript should handle an incoming AgiRequest.
	 *
	 * @param request the initial data received from Asterisk when requesting
	 *                this script.
	 * @param channel a handle to communicate with Asterisk such as sending
	 *                commands to the channel sending the request.
	 * @throws AgiException any exception thrown by your script will be logged.
	 */
	@Override
	public void service(AgiRequest request, AgiChannel channel) throws AgiException {
		logger.debug("Invoked " + getClass().getSimpleName() + "\t" + request + "\t" + channel);
	}
}
