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
class FailResponseAction extends AbstractSuccessFailedResponseAction implements FailedResponseAction, ResponseAction {

	@Autowired
	FailResponseAction(@Qualifier("socketLogger") Logger logger) {
		super(logger);
	}

	@Override
	boolean invokeAction() throws Exception {
		return false;
	}
}
