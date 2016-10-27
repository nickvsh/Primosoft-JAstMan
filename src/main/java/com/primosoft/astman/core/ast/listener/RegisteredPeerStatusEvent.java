/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.ast.state.ChannelBean;
import com.primosoft.astman.core.ast.state.UsersHolder;
import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.ChannelUtil;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.PeerStatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 30.08.16.
 *
 * @author atelizhenko
 */
class RegisteredPeerStatusEvent implements AsteriskEventHandler {
	private final Logger logger;
	private final UsersHolder usersHolder;
	private PeerStatusEvent peerStatusEvent;

	@Autowired
	RegisteredPeerStatusEvent(@Qualifier("asteriskLogger") Logger logger, UsersHolder usersHolder) {
		this.logger = logger;
		this.usersHolder = usersHolder;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		peerStatusEvent = (PeerStatusEvent) event;
	}

	@Override
	public void onEvent() {
		logger.trace("Registered " + peerStatusEvent.getPeerStatus() + " peer event " + peerStatusEvent.getPeer() + "!");
		logger.debug("Registered " + peerStatusEvent.getPeerStatus() + " peer event " + peerStatusEvent.getPeer() + "!");

		final ChannelBean channelBean = ChannelUtil.getChannelBean(peerStatusEvent.getPeer());

		usersHolder.addUser(channelBean.getDn(), 10);

	}
}
