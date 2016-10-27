/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.PeerStatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 30.08.16.
 *
 * @author atelizhenko
 */
class RejectedPeerStatusEvent implements AsteriskEventHandler {
	private final Logger logger;
	private PeerStatusEvent peerStatusEvent;

	@Autowired
	RejectedPeerStatusEvent(@Qualifier("asteriskLogger") Logger logger) {
		this.logger = logger;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		peerStatusEvent = (PeerStatusEvent) event;
	}

	@Override
	public void onEvent() {
		logger.trace("Registered " + peerStatusEvent.getPeerStatus() + " peer event " + peerStatusEvent.getPeer() + "!");

	}
}
