/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.credential;

import org.asteriskjava.live.AsteriskServer;

/**
 * Created on 21.06.16.
 * Asterisk credentials and parameters to connect
 *
 * @author atelizhenko
 */
public interface AsteriskCredentials {
	/**
	 * Create asterisk server connection instance
	 *
	 * @return {@link AsteriskServer} connection instance
	 */
	AsteriskServer createConnection();
}
