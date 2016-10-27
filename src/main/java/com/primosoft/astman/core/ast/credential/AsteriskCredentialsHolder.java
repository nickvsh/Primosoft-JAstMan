/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.credential;

/**
 * Created on 21.06.16.
 * Asterisk credentials holder implementation.
 *
 * @author atelizhenko
 */
class AsteriskCredentialsHolder extends AbstractAsteriskCredentials implements AsteriskCredentials {
	/**
	 * Constructor
	 *
	 * @param asteriskCredential asterisk credentials
	 */
	AsteriskCredentialsHolder(AsteriskCredential asteriskCredential) {
		super(asteriskCredential);
	}
}
