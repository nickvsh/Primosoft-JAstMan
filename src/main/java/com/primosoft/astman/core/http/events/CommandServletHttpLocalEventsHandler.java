/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.http.events;

import com.primosoft.astman.core.http.events.context.StartCampaignContextServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 02.09.16.
 *
 * @author atelizhenko
 */
public class CommandServletHttpLocalEventsHandler extends ServletContextHandler {
	private final Integer options;
	private final String contextPath;
	private final StartCampaignContextServlet campaignServlet;


	@Autowired
	CommandServletHttpLocalEventsHandler(@Qualifier("servletContextHandlerOption") Integer options,
										 @Qualifier("commandResourcePath") String contextPath,
										 StartCampaignContextServlet campaignServlet) {
		super(options);
		setContextPath(contextPath);

		this.options = options;
		this.contextPath = contextPath;
		this.campaignServlet = campaignServlet;

		addServlet(new ServletHolder(campaignServlet), campaignServlet.getStartCampaignPath());
	}
}
