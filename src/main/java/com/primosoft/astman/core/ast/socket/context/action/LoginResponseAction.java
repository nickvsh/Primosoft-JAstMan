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
class LoginResponseAction extends AbstractSuccessFailedResponseAction implements SuccessResponseAction, FailedResponseAction {

	@Autowired
	LoginResponseAction(@Qualifier("socketLogger") Logger logger) {
		super(logger);
	}

	@Override
	public boolean stayConnection() {
		return true;
	}

	@Override
	boolean invokeAction() throws Exception {
		return true;
	}

	@Override
	public ResponsePair[] onSuccess() {
		return new ResponsePair[]{new ResponsePair("Autentification", "Accepted")};
	}

	@Override
	public ResponsePair[] onFailed() {
		return new ResponsePair[]{new ResponsePair("Autentification", "Rejected")};
	}
}
