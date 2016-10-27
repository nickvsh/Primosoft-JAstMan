/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket.context.action;

import com.primosoft.astman.core.ast.listener.AsteriskEventListener;
import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.BlockHelper;
import com.primosoft.astman.core.util.BlockKey;
import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 18.08.16.
 *
 * @author atelizhenko
 */
class DialResponseAction extends AbstractSuccessFailedResponseAction implements SuccessResponseAction, FailedResponseAction {
	private final AsteriskEventListener asteriskEventListener;
	private String answerChannel;
	private String result = "-1";

	@Autowired
	DialResponseAction(@Qualifier("socketLogger") Logger logger, AsteriskEventListener asteriskEventListener) {
		super(logger);
		this.asteriskEventListener = asteriskEventListener;
	}

	@Override
	boolean invokeAction() throws Exception {
		final long now = System.currentTimeMillis();

		final BlockHelper blockHelper = getBlockHelper();
		final String channel = blockHelper.getValue(BlockKey.CHANNEL);
		final String variable = blockHelper.getValue(BlockKey.VARIABLE);

		blockHelper.addValue(BlockKey.MAN_CALL_ID, String.valueOf(now));

//		origParams['Action'] = 'Originate'
//		origParams['Channel'] = self.channel
//		origParams['CallerID'] = self.callerId
//		origParams['Context'] = self.context
//		origParams['Exten'] = self.exten
//		origParams['Priority'] = self.priority
//		origParams['Timeout'] = self.timeout
//		origParams['Variable'] = self.variable
//		origParams['Async'] = self.async

//		final OriginateAction originateAction = new OriginateAction();
//		originateAction.setChannel(channel);
//		asteriskEventListener.sendAction(originateAction, 0);
//		getLogger().debug("DialResponseAction was originated (" + originateAction + ") and has channel " + originateAsteriskChannel);

//		answerChannel = originateAsteriskChannel.getName();

		return true;
	}

	@Override
	public ResponsePair[] onSuccess() {
		return new ResponsePair[]{
				new DefaultSuccessResponsePair(),
				new ResponsePair("AnswChan", answerChannel),
				new ResponsePair("Result", result)
		};
	}

	@Override
	public ResponsePair[] onFailed() {
		return new ResponsePair[]{new DefaultFailedResponsePair(), new ResponsePair("Reason", "UNKNOWN")};
	}
}
