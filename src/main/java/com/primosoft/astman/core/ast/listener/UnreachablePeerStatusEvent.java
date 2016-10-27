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
class UnreachablePeerStatusEvent implements AsteriskEventHandler {
	private final Logger logger;
	private PeerStatusEvent peerStatusEvent;

	@Autowired
	UnreachablePeerStatusEvent(@Qualifier("asteriskLogger") Logger logger) {
		this.logger = logger;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		peerStatusEvent = (PeerStatusEvent) event;
	}

	@Override
	public void onEvent() {
		logger.trace(getClass().getSimpleName() + " handled event " + peerStatusEvent.getPeer());
	}
}
