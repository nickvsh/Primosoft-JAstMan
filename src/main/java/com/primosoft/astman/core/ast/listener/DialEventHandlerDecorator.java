/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.ast.state.ChannelBean;
import com.primosoft.astman.core.ast.state.UsersHolder;
import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.ChannelUtil;
import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.manager.event.DialEvent;
import org.asteriskjava.manager.event.ManagerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 23.08.16.
 *
 * @author atelizhenko
 */
class DialEventHandlerDecorator implements AsteriskEventHandler {
	private final AsteriskEventListener asteriskEventListener;
	private final Logger logger;
	private final UsersHolder usersHolder;
	private DialEvent dialEvent;

	@Autowired
	DialEventHandlerDecorator(AsteriskEventListener asteriskEventListener, @Qualifier("asteriskLogger") Logger logger,
							  UsersHolder usersHolder) {
		this.asteriskEventListener = asteriskEventListener;
		this.logger = logger;
		this.usersHolder = usersHolder;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		dialEvent = (DialEvent) event;
	}

	@Override
	public void onEvent() {
		logger.trace(getClass().getSimpleName() + " handled event " + dialEvent.getUniqueId());
		final String channelName = dialEvent.getChannel();
		final AsteriskChannel asteriskChannel = asteriskEventListener.getChannelByName(channelName);

		// TODO: 07.09.16 need clrQTYPE be in 2 or 6
		final ChannelBean channelBean = ChannelUtil.getChannelBean(channelName);
		usersHolder.citlBSC(channelBean.getDn());

		logger.debug("DialEvent has status " + dialEvent.getDialStatus() + " and channel " + asteriskChannel);
	}
}
