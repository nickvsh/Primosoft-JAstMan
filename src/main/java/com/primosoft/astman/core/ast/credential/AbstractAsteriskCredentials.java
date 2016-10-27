/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.credential;

import org.asteriskjava.live.AsteriskServer;
import org.asteriskjava.live.DefaultAsteriskServer;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;

/**
 * Created on 21.06.16.
 * Base abstract asterisk credentials holder.
 *
 * @author atelizhenko
 */
abstract class AbstractAsteriskCredentials implements AsteriskCredentials {
	/**
	 * Asterisk credentials
	 */
	private final AsteriskCredential asteriskCredential;
	/**
	 * Manager connection to asterisk server
	 */
	private final ManagerConnection managerConnection;

	/**
	 * Constructor
	 *
	 * @param asteriskCredential asterisk credentials
	 */
	AbstractAsteriskCredentials(final AsteriskCredential asteriskCredential) {
		this.asteriskCredential = asteriskCredential;

		final ManagerConnectionFactory managerConnectionFactory = new ManagerConnectionFactory(
				asteriskCredential.getDomain(),
				asteriskCredential.getPort(),
				asteriskCredential.getLogin(),
				asteriskCredential.getPassword()
		);

		this.managerConnection = asteriskCredential.isSecured() ?
				managerConnectionFactory.createSecureManagerConnection() : managerConnectionFactory.createManagerConnection();
	}

	/**
	 * Gets asterisk credential.
	 *
	 * @return the asterisk credential
	 */
	final AsteriskCredential getAsteriskCredential() {
		return asteriskCredential;
	}

	/**
	 * Gets manager connection.
	 *
	 * @return the manager connection
	 */
	final ManagerConnection getManagerConnection() {
		return managerConnection;
	}

	/**
	 * Create asterisk server connection instance
	 *
	 * @return {@link AsteriskServer} connection instance
	 */
	@Override
	public AsteriskServer createConnection() {
		return new DefaultAsteriskServer(this.managerConnection);
	}
}
