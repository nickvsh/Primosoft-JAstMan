/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.manager.AbstractManagerEventListener;
import org.asteriskjava.manager.event.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

/**
 * Created on 05.09.16.
 *
 * @author atelizhenko
 */
class AsteriskManagerEventListener extends AbstractManagerEventListener implements ApplicationListener<AsteriskManagerCustomEvent> {
	private final AsteriskEventHandler bridgeEventHandlerDecorator;
	private final AsteriskEventHandler dialEventHandlerDecorator;
	private final AsteriskEventHandler hangupEventHandlerDecorator;
	private final AsteriskEventHandler newCallerIdEventHandlerDecorator;
	private final AsteriskEventHandler newChannelEventHandlerDecorator;
	private final AsteriskEventHandler newExtenEventHandlerDecorator;
	private final AsteriskEventHandler newStateEventHandlerDecorator;
	private final AsteriskEventHandler originateResponseEventHandlerDecorator;
	private final AsteriskEventHandler peerStatusEventHandlerDecorator;
	private final AsteriskEventHandler statusCompleteEventHandlerDecorator;
	private final AsteriskEventHandler varSetEventHandlerDecorator;
	private final Logger infoLogger;
	private final Logger asteriskLogger;


	@Autowired
	AsteriskManagerEventListener(AsteriskEventHandler bridgeEventHandlerDecorator,
								 AsteriskEventHandler dialEventHandlerDecorator,
								 AsteriskEventHandler hangupEventHandlerDecorator,
								 AsteriskEventHandler newCallerIdEventHandlerDecorator,
								 AsteriskEventHandler newChannelEventHandlerDecorator,
								 AsteriskEventHandler newExtenEventHandlerDecorator,
								 AsteriskEventHandler newStateEventHandlerDecorator,
								 AsteriskEventHandler originateResponseEventHandlerDecorator,
								 AsteriskEventHandler peerStatusEventHandlerDecorator,
								 AsteriskEventHandler statusCompleteEventHandlerDecorator,
								 AsteriskEventHandler varSetEventHandlerDecorator, Logger infoLogger, Logger asteriskLogger) {
		this.bridgeEventHandlerDecorator = bridgeEventHandlerDecorator;
		this.dialEventHandlerDecorator = dialEventHandlerDecorator;
		this.hangupEventHandlerDecorator = hangupEventHandlerDecorator;
		this.newCallerIdEventHandlerDecorator = newCallerIdEventHandlerDecorator;
		this.newChannelEventHandlerDecorator = newChannelEventHandlerDecorator;
		this.newExtenEventHandlerDecorator = newExtenEventHandlerDecorator;
		this.newStateEventHandlerDecorator = newStateEventHandlerDecorator;
		this.originateResponseEventHandlerDecorator = originateResponseEventHandlerDecorator;
		this.peerStatusEventHandlerDecorator = peerStatusEventHandlerDecorator;
		this.statusCompleteEventHandlerDecorator = statusCompleteEventHandlerDecorator;
		this.varSetEventHandlerDecorator = varSetEventHandlerDecorator;
		this.infoLogger = infoLogger;
		this.asteriskLogger = asteriskLogger;
	}


	/**
	 * Handle an application event.
	 *
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(AsteriskManagerCustomEvent event) {
		infoLogger.debug("Handled local asterisk event from publisher " + event);
		asteriskLogger.debug("Handled local asterisk event from publisher " + event);
		final ManagerEvent managerEvent = event.getManagerEvent();
		onManagerEvent(managerEvent);
	}

	protected void handleEvent(VarSetEvent event) {
		infoLogger.debug("Handling VarSetEvent " + event.getUniqueId());
		invokeDecoratorEvent(varSetEventHandlerDecorator, event);
	}

	private void invokeDecoratorEvent(final AsteriskEventHandler asteriskEventHandler, ManagerEvent event) {
		asteriskEventHandler.setAsteriskManagerEvent(event);
		asteriskEventHandler.onEvent();
	}

	@Override
	protected void handleEvent(DialEvent event) {
		infoLogger.debug("Handling DialEvent " + event.getUniqueId());
		invokeDecoratorEvent(dialEventHandlerDecorator, event);
	}

	@Override
	protected void handleEvent(NewExtenEvent event) {
		infoLogger.debug("Handling NewExtenEvent " + event.getUniqueId());
		invokeDecoratorEvent(newExtenEventHandlerDecorator, event);
	}

	@Override
	protected void handleEvent(PeerStatusEvent event) {
		infoLogger.debug("Handling PeerStatusEvent " + event.getPeer());
		invokeDecoratorEvent(peerStatusEventHandlerDecorator, event);
	}

	@Override
	protected void handleEvent(NewCallerIdEvent event) {
		infoLogger.debug("Handling NewCallerIdEvent " + event.getUniqueId());
		invokeDecoratorEvent(newCallerIdEventHandlerDecorator, event);
	}

	@Override
	protected void handleEvent(HangupEvent event) {
		infoLogger.debug("Handling HangupEvent " + event.getUniqueId());
		invokeDecoratorEvent(hangupEventHandlerDecorator, event);
	}

	@Override
	protected void handleEvent(NewChannelEvent event) {
		infoLogger.debug("Handling NewChannelEvent " + event.getUniqueId());
		invokeDecoratorEvent(newChannelEventHandlerDecorator, event);
	}

	@Override
	protected void handleEvent(NewStateEvent event) {
		infoLogger.debug("Handling NewStateEvent " + event.getUniqueId());
		invokeDecoratorEvent(newStateEventHandlerDecorator, event);
	}

	@Override
	protected void handleEvent(BridgeEvent event) {
		infoLogger.debug("Handling BridgeEvent " + event.getUniqueId1() + "; " + event.getUniqueId2());
		invokeDecoratorEvent(bridgeEventHandlerDecorator, event);
	}

	@Override
	protected void handleEvent(OriginateResponseEvent event) {
		infoLogger.debug("Handling OriginateResponseEvent " + event.getUniqueId());
		invokeDecoratorEvent(originateResponseEventHandlerDecorator, event);
	}

	@Override
	protected void handleEvent(StatusCompleteEvent event) {
		infoLogger.debug("Handling StatusCompleteEvent " + event.getDateReceived());
		invokeDecoratorEvent(statusCompleteEventHandlerDecorator, event);
	}

	/**
	 * Dispatches to the appropriate handleEvent(...) method.
	 *
	 * @param event the event to handle
	 */
	@Override
	public void onManagerEvent(ManagerEvent event) {
		super.onManagerEvent(event);
		if (event instanceof VarSetEvent) {
			handleEvent((VarSetEvent) event);
		}
	}
}
