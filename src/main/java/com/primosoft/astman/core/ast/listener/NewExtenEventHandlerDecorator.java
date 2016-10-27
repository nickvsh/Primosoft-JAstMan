/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.NewExtenEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 23.08.16.
 *
 * @author atelizhenko
 */
class NewExtenEventHandlerDecorator implements AsteriskEventHandler {
	private final AsteriskEventListener asteriskEventListener;
	private final Logger logger;
	private NewExtenEvent newExtenEvent;

	@Autowired
	NewExtenEventHandlerDecorator(AsteriskEventListener asteriskEventListener, @Qualifier("asteriskLogger") Logger logger) {
		this.asteriskEventListener = asteriskEventListener;
		this.logger = logger;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		newExtenEvent = (NewExtenEvent) event;
	}

	@Override
	public void onEvent() {
		logger.trace(getClass().getSimpleName() + " handled event " + newExtenEvent.getUniqueId());
		
		final String channelName = newExtenEvent.getChannel();
		final AsteriskChannel asteriskChannel = asteriskEventListener.getChannelByName(channelName);
		logger.debug("NewExtenEvent has channel " + asteriskChannel);
	}
}
