/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket.context.action;

import com.primosoft.astman.core.log.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 17.08.16.
 *
 * @author atelizhenko
 */
class LogoffResponseAction extends AbstractSuccessFailedResponseAction implements SuccessResponseAction, FailedResponseAction {

	@Autowired
	LogoffResponseAction(@Qualifier("socketLogger") Logger logger) {
		super(logger);
	}

	@Override
	boolean invokeAction() throws Exception {
		return true;
	}

	@Override
	public ResponsePair[] onSuccess() {
		return new ResponsePair[]{new ResponsePair("Request", "Logoff")};
	}
}
