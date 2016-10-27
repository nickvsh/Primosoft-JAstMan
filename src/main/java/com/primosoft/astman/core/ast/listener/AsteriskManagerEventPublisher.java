/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.manager.event.ManagerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created on 05.09.16.
 *
 * @author atelizhenko
 */
class AsteriskManagerEventPublisher implements ApplicationEventPublisherAware {
	private final Logger logger;
	private ApplicationEventPublisher publisher;

	@Autowired
	AsteriskManagerEventPublisher(@Qualifier("infoLogger") Logger logger) {
		this.logger = logger;
	}

	/**
	 * Set the ApplicationEventPublisher that this object runs in.
	 * <p>Invoked after population of normal bean properties but before an init
	 * callback like InitializingBean's afterPropertiesSet or a custom init-method.
	 * Invoked before ApplicationContextAware's setApplicationContext.
	 *
	 * @param applicationEventPublisher event publisher to be used by this object
	 */
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}

	void publishManagerEvent(ManagerEvent managerEvent) {
		logger.debug("Publish to local asterisk event listener " + managerEvent);
		publisher.publishEvent(new AsteriskManagerCustomEvent(this, managerEvent));
	}
}
