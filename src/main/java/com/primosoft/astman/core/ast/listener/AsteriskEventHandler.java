/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import org.asteriskjava.manager.event.ManagerEvent;

/**
 * Created on 06.09.16.
 *
 * @author atelizhenko
 */
interface AsteriskEventHandler {
	void setAsteriskManagerEvent(ManagerEvent event);

	void onEvent();
}
