/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.credential;

import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 25.08.16.
 *
 * @author atelizhenko
 */
public final class DefaultCredential {
	private final PropertiesUtil propertiesUtil;
	private final Logger logger;

	@Autowired
	private DefaultCredential(PropertiesUtil propertiesUtil, @Qualifier("infoLogger") Logger logger) {
		this.propertiesUtil = propertiesUtil;
		this.logger = logger;
	}

	public AsteriskCredential getConfiguredAsteriskCredential() {
		final AsteriskCredential asteriskCredential = new AsteriskCredential.Builder()
				.domain(propertiesUtil.getProperty("astman.domain"))
				.port(Integer.parseInt(propertiesUtil.getProperty("astman.port")))
				.login(propertiesUtil.getProperty("astman.local.login"))
				.password(propertiesUtil.getProperty("astman.local.password"))
				.secured(false)
				.build();
		logger.trace("Instantiated configuring asterisk credentials");
		logger.debug(asteriskCredential);
		return asteriskCredential;
	}
}
