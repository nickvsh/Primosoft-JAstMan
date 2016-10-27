/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.PeerStatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.asteriskjava.manager.event.PeerStatusEvent.*;

/**
 * Created on 22.08.16.
 *
 * @author atelizhenko
 */
class PeerStatusEventHandlerDecorator implements AsteriskEventHandler {
	private final AsteriskEventHandler registeredStatusEventHandler;
	private final AsteriskEventHandler unregisteredStatusEventHandler;
	private final AsteriskEventHandler reachebleStatusEventHandler;
	private final AsteriskEventHandler laggedStatusEventHandler;
	private final AsteriskEventHandler unreachebleStatusEventHandler;
	private final AsteriskEventHandler rejectedStatusEventHandler;
	private final AsteriskEventHandler emptyStatusEventHandler;
	private PeerStatusEvent peerStatusEvent;

	@Autowired
	PeerStatusEventHandlerDecorator(@Qualifier("registeredPeerStatusEvent") AsteriskEventHandler registeredStatusEventHandler,
									@Qualifier("unregisteredPeerStatusEvent") AsteriskEventHandler unregisteredStatusEventHandler,
									@Qualifier("reachablePeerStatusEvent") AsteriskEventHandler reachebleStatusEventHandler,
									@Qualifier("laggedPeerStatusEvent") AsteriskEventHandler laggedStatusEventHandler,
									@Qualifier("unreachablePeerStatusEvent") AsteriskEventHandler unreachebleStatusEventHandler,
									@Qualifier("rejectedPeerStatusEvent") AsteriskEventHandler rejectedStatusEventHandler,
									@Qualifier("emptyPeerStatusEvent") AsteriskEventHandler emptyStatusEventHandler) {
		this.registeredStatusEventHandler = registeredStatusEventHandler;
		this.unregisteredStatusEventHandler = unregisteredStatusEventHandler;
		this.reachebleStatusEventHandler = reachebleStatusEventHandler;
		this.laggedStatusEventHandler = laggedStatusEventHandler;
		this.unreachebleStatusEventHandler = unreachebleStatusEventHandler;
		this.rejectedStatusEventHandler = rejectedStatusEventHandler;
		this.emptyStatusEventHandler = emptyStatusEventHandler;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		peerStatusEvent = (PeerStatusEvent) event;
	}

	@Override
	public void onEvent() {
		final AsteriskEventHandler statusEvent = createSeparatePeerStatusEvent();
		statusEvent.setAsteriskManagerEvent(peerStatusEvent);
		statusEvent.onEvent();
	}

	private AsteriskEventHandler createSeparatePeerStatusEvent() {
		switch (peerStatusEvent.getPeerStatus()) {
			case STATUS_REGISTERED:
				return registeredStatusEventHandler;
			case STATUS_UNREGISTERED:
				return unregisteredStatusEventHandler;
			case STATUS_REACHABLE:
				return reachebleStatusEventHandler;
			case STATUS_LAGGED:
				return laggedStatusEventHandler;
			case STATUS_UNREACHABLE:
				return unreachebleStatusEventHandler;
			case STATUS_REJECTED:
				return rejectedStatusEventHandler;
			default:
				return emptyStatusEventHandler;
		}
	}
}
