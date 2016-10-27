/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.ast.state.UsersHolder;
import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.live.HangupCause;
import org.asteriskjava.manager.event.HangupEvent;
import org.asteriskjava.manager.event.ManagerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 23.08.16.
 *
 * @author atelizhenko
 */
class HangupEventHandlerDecorator implements AsteriskEventHandler {
	private final AsteriskEventListener asteriskEventListener;
	private final UsersHolder usersHolder;
	private final Logger logger;
	private HangupEvent hangupEvent;

	@Autowired
	HangupEventHandlerDecorator(AsteriskEventListener asteriskEventListener, UsersHolder usersHolder,
								@Qualifier("asteriskLogger") Logger logger) {
		this.asteriskEventListener = asteriskEventListener;
		this.usersHolder = usersHolder;
		this.logger = logger;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		hangupEvent = (HangupEvent) event;
	}

	@Override
	public void onEvent() {
		logger.trace(getClass().getSimpleName() + " handled event " + hangupEvent.getUniqueId());
		final String channelName = hangupEvent.getChannel();
		final AsteriskChannel hangupChannel = asteriskEventListener.getChannelByName(channelName);
		final HangupCause hangupCause = hangupChannel.getHangupCause();
		if (HangupCause.AST_CAUSE_NO_ROUTE_TRANSIT_NET.equals(hangupCause)
				|| HangupCause.AST_CAUSE_CHANNEL_UNACCEPTABLE.equals(hangupCause)) {
			usersHolder.citlFSC(channelName);
		} else {
			usersHolder.citlHMC(channelName);
		}
		// TODO: 05.09.16 other actions for hangup
		logger.debug("HangupCause " + hangupCause + " - " + hangupEvent.getUniqueId());
		logger.debug("Hangup channel " + hangupChannel + " - " + hangupEvent.getUniqueId());
	}
}
