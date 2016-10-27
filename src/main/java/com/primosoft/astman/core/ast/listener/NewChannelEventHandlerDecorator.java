/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.ast.state.UsersHolder;
import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.NewChannelEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 25.08.16.
 *
 * @author atelizhenko
 */
class NewChannelEventHandlerDecorator implements AsteriskEventHandler {
	private final AsteriskEventListener asteriskEventListener;
	private final Logger logger;
	private final UsersHolder usersHolder;
	private NewChannelEvent newChannelEvent;

	@Autowired
	NewChannelEventHandlerDecorator(@Qualifier("asteriskLogger") Logger logger,
									AsteriskEventListener asteriskEventListener, UsersHolder usersHolder) {
		this.logger = logger;
		this.asteriskEventListener = asteriskEventListener;
		this.usersHolder = usersHolder;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		newChannelEvent = (NewChannelEvent) event;
	}

	@Override
	public void onEvent() {
		logger.trace(getClass().getSimpleName() + " handled event " + newChannelEvent.getUniqueId());

		final AsteriskChannel channel = asteriskEventListener.getChannelByName(newChannelEvent.getChannel());
		logger.debug("Added new channel: " + channel);
		logger.info("Added new channel: " + channel.getName());

		usersHolder.addUser(channel.getName());
	}
}
