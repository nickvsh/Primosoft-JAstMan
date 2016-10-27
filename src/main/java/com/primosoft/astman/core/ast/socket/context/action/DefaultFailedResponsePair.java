/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket.context.action;

/**
 * Created on 18.08.16.
 *
 * @author atelizhenko
 */
class DefaultFailedResponsePair extends ResponsePair {
	private static final long serialVersionUID = -7662396309354453637L;

	/**
	 * Creates a new pair with failedd response
	 */
	DefaultFailedResponsePair() {
		super("Response", "Failed");
	}
}
