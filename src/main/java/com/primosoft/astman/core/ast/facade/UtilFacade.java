/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.facade;

import com.primosoft.astman.core.util.PropertiesUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
public final class UtilFacade {
	private final ApplicationContext context;

	UtilFacade(AbstractApplicationContext context) {
		this.context = context;
	}

	public PropertiesUtil getPropertiesUtil() {
		return (PropertiesUtil) context.getBean("propertiesUtil");
	}
}
