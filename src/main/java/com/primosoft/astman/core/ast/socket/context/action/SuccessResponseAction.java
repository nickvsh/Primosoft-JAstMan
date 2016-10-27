/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket.context.action;

/**
 * Created on 17.08.16.
 *
 * @author atelizhenko
 */
interface SuccessResponseAction extends ResponseAction {
	ResponsePair[] onSuccess();
}
