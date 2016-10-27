/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.facade;

import com.primosoft.astman.core.ast.socket.SocketMechanismFactory;
import com.primosoft.astman.core.ast.state.ChannelHolder;
import com.primosoft.astman.core.ast.state.UsersHolder;
import com.primosoft.astman.core.ast.way.CallWay;
import com.primosoft.astman.core.http.LocalHttpServer;
import com.primosoft.astman.core.log.Log4jConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
public final class BeansFacade {
	private final ApplicationContext context;

	BeansFacade(AbstractApplicationContext context) {
		this.context = context;
	}

	public UsersHolder getUsersHolder() {
		return (UsersHolder) context.getBean("usersHolder");
	}

	public ChannelHolder getChannelHolder() {
		return (ChannelHolder) context.getBean("channelHolder");
	}

	public CallWay getCallWay() {
		return (CallWay) context.getBean("callWay");
	}

	public SocketMechanismFactory getSocketMechanismFactory() {
		return (SocketMechanismFactory) context.getBean("socketMechanismFactory");
	}

	public LocalHttpServer getLocalHttpServer() {
		return (LocalHttpServer) context.getBean("jettyLocalHttpServer");
	}

	public Log4jConfigurator getLog4jConfigurator() {
		return (Log4jConfigurator) context.getBean("log4jConfigurator");
	}
}
