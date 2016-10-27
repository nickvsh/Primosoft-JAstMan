/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import org.asteriskjava.manager.event.ManagerEvent;
import org.springframework.context.ApplicationEvent;

/**
 * Created on 05.09.16.
 *
 * @author atelizhenko
 */
class AsteriskManagerCustomEvent extends ApplicationEvent {
	private static final long serialVersionUID = 6106083955749280842L;
	private final ManagerEvent managerEvent;

	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source       the object on which the event initially occurred (never {@code null})
	 * @param managerEvent asterisk manager event
	 */
	AsteriskManagerCustomEvent(Object source, ManagerEvent managerEvent) {
		super(source);
		this.managerEvent = managerEvent;
	}

	ManagerEvent getManagerEvent() {
		return managerEvent;
	}
}
