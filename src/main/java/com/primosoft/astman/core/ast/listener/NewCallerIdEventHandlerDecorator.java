/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.live.CallerId;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.NewCallerIdEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 23.08.16.
 *
 * @author atelizhenko
 */
class NewCallerIdEventHandlerDecorator implements AsteriskEventHandler {
	private final AsteriskEventListener asteriskEventListener;
	private final Logger logger;
	private NewCallerIdEvent newCallerIdEvent;

	@Autowired
	NewCallerIdEventHandlerDecorator(AsteriskEventListener asteriskEventListener, @Qualifier("asteriskLogger") Logger logger) {
		this.asteriskEventListener = asteriskEventListener;
		this.logger = logger;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		newCallerIdEvent = (NewCallerIdEvent) event;
	}

	@Override
	public void onEvent() {
		logger.trace(getClass().getSimpleName() + " handled event " + newCallerIdEvent.getUniqueId());
		final String channelName = newCallerIdEvent.getChannel();
		final AsteriskChannel asteriskChannel = asteriskEventListener.getChannelByName(channelName);
		final CallerId callerId = asteriskChannel.getCallerId();

		logger.debug("NewCallerIdEvent with callerId " + callerId);
	}
}
