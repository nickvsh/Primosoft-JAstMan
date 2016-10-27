/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.ast.state.BridgedChannel;
import com.primosoft.astman.core.ast.state.ChannelHolder;
import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.ChannelUtil;
import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.live.CallerId;
import org.asteriskjava.manager.event.BridgeEvent;
import org.asteriskjava.manager.event.ManagerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 23.08.16.
 *
 * @author atelizhenko
 */
class BridgeEventHandlerDecorator implements AsteriskEventHandler {    //also unlink event
	private final AsteriskEventListener asteriskEventListener;
	private final ChannelHolder channelHolder;
	private final Logger logger;
	private BridgeEvent bridgeEvent;

	@Autowired
	BridgeEventHandlerDecorator(AsteriskEventListener asteriskEventListener, ChannelHolder channelHolder,
								@Qualifier("asteriskLogger") Logger logger) {
		this.asteriskEventListener = asteriskEventListener;
		this.channelHolder = channelHolder;
		this.logger = logger;
	}

	@Override
	public void setAsteriskManagerEvent(ManagerEvent event) {
		bridgeEvent = (BridgeEvent) event;
	}

	@Override
	public void onEvent() {
		logger.trace(getClass().getSimpleName() + " handled event "
				+ bridgeEvent.getUniqueId1() + "\\/" + bridgeEvent.getUniqueId2());

		final String ast = "ast";
		final String channel1 = bridgeEvent.getChannel1();
		final String channel2 = bridgeEvent.getChannel2();

		final AsteriskChannel asteriskChannel1 = asteriskEventListener.getChannelByName(channel1);
		final AsteriskChannel asteriskChannel2 = asteriskEventListener.getChannelByName(channel2);

		channelHolder.addBridgedChannel(new BridgedChannel(asteriskChannel1, asteriskChannel2));

		final String userName1 = ChannelUtil.getChannelBean(channel1).getDn();
		final String userName2 = ChannelUtil.getChannelBean(channel2).getDn();

		final CallerId callerId1 = asteriskChannel1.getCallerId();
		final CallerId callerId2 = asteriskChannel2.getCallerId();

		logger.debug("Bridged event callerId #1 " + callerId1 + " has channel " + asteriskChannel1);
		logger.debug("Bridged event callerId #2 " + callerId2 + " has channel " + asteriskChannel2);

		// TODO: 07.09.16 WTF block?
		if (userName1.contains(ast) && !userName2.contains(ast)) {

		} else if (!userName1.contains(ast) && userName2.contains(ast)) {

		}

		final boolean unlink = bridgeEvent.isUnlink();
		logger.debug("Bridge two channels have been unlinked " + unlink);
	}
}
