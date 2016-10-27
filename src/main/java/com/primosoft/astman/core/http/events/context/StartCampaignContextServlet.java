/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.http.events.context;

import com.primosoft.astman.core.log.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 02.09.16.
 *
 * @author atelizhenko
 */
public class StartCampaignContextServlet extends HttpServlet {
	private static final long serialVersionUID = 4015837907791936746L;
	private final Logger logger;
	private final String startCampaignPath;

	@Autowired
	StartCampaignContextServlet(@Qualifier("httpLogger") Logger logger,
								@Qualifier("startCampaignCommandPath") String startCampaignPath) {
		this.logger = logger;
		this.startCampaignPath = startCampaignPath;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered in " + startCampaignPath + ". Congratulations!");
	}

	public String getStartCampaignPath() {
		return startCampaignPath;
	}
}
