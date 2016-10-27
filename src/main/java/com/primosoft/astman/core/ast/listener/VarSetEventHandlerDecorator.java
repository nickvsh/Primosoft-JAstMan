/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.VarSetEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 23.08.16.
 *
 * @author atelizhenko
 */
class VarSetEventHandlerDecorator implements AsteriskEventHandler {
	private final AsteriskEventListener asteriskEventListener;
	private final Logger logger;
	private VarSetEvent varSetEvent;

	@Autowired
	VarSetEventHandlerDecorator(AsteriskEventListener asteriskEventListener, @Qualifier("asteriskLogger") Logger logger) {
		this.asteriskEventListener = asteriskEventListener;
		this.logger = logger;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		varSetEvent = (VarSetEvent) event;
	}

	@Override
	public void onEvent() {
		logger.trace(getClass().getSimpleName() + " handled event " + varSetEvent.getUniqueId());

		final String channelName = varSetEvent.getChannel();
		final AsteriskChannel asteriskChannel = asteriskEventListener.getChannelByName(channelName);
		final String variableVariable = asteriskChannel.getVariable("Variable");
		final String variableValue = asteriskChannel.getVariable("Value");

		logger.info("VarSetEvent has channel " + channelName);
		logger.debug("VarSetEvent has channel " + asteriskChannel);

		if ("OutgoingSpoolFailed".equalsIgnoreCase(channelName)) {
			if ("manUNIQUEID".equalsIgnoreCase(variableVariable)) {
				final String uid = asteriskChannel.getVariable("Uniqueid");
				final AsteriskChannel channelById = asteriskEventListener.getChannelById(uid);
				// TODO: 06.09.16 reindexing for channels WTF???
			} else {

			}
		} else {
			if ("manUNIQUEID".equalsIgnoreCase(variableVariable)) {

			} else {

			}
		}

		// TODO: 05.09.16 other manipulation with variables WTF???
		// TODO: 06.09.16 pseudo addChanToCall from zman code
	}
}
