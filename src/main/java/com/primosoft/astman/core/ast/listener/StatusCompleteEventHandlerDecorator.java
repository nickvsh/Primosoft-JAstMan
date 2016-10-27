/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.StatusCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 25.08.16.
 *
 * @author atelizhenko
 */
class StatusCompleteEventHandlerDecorator implements AsteriskEventHandler {
	private final Logger logger;
	private StatusCompleteEvent statusCompleteEvent;

	@Autowired
	public StatusCompleteEventHandlerDecorator(@Qualifier("asteriskLogger") Logger logger) {
		this.logger = logger;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		statusCompleteEvent = (StatusCompleteEvent) event;
	}

	@Override
	public void onEvent() {
		logger.trace(getClass().getSimpleName() + " handled event");
	}
}
