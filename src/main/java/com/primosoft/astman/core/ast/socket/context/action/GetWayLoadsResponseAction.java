/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket.context.action;

import com.primosoft.astman.core.log.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 18.08.16.
 *
 * @author atelizhenko
 */
class GetWayLoadsResponseAction extends AbstractSuccessFailedResponseAction implements SuccessResponseAction, FailedResponseAction {
	private String loads;

	@Autowired
	GetWayLoadsResponseAction(@Qualifier("socketLogger") Logger logger) {
		super(logger);
	}

	@Override
	boolean invokeAction() throws Exception {
		return false;
	}

	@Override
	public ResponsePair[] onSuccess() {
		return new ResponsePair[]{new DefaultSuccessResponsePair(), new ResponsePair("Load", loads)};
	}
}
