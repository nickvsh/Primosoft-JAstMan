/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.OriginateResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 23.08.16.
 *
 * @author atelizhenko
 */
class OriginateResponseEventHandlerDecorator implements AsteriskEventHandler {
	private final AsteriskEventListener asteriskEventListener;
	private final Logger logger;
	private OriginateResponseEvent originateResponseEvent;

	@Autowired
	public OriginateResponseEventHandlerDecorator(AsteriskEventListener asteriskEventListener,
												  @Qualifier("asteriskLogger") Logger logger) {
		this.asteriskEventListener = asteriskEventListener;
		this.logger = logger;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		originateResponseEvent = (OriginateResponseEvent) event;
	}

	@Override
	public void onEvent() {
		logger.trace(getClass().getSimpleName() + " handled event " + originateResponseEvent.getUniqueId());

		final String response = originateResponseEvent.getResponse();    //"Success" or "Failure"
		final String channelName = originateResponseEvent.getChannel();
		final AsteriskChannel asteriskChannel = asteriskEventListener.getChannelByName(channelName);
		final Integer reason = originateResponseEvent.getReason();
		
		logger.trace("OriginateResponse " + response + " with reason " + reason);
		logger.debug("OriginateResponseEvent has channel " + asteriskChannel);
	}
}
