/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket.context.action;

import com.primosoft.astman.core.ast.state.UsersHolder;
import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.BlockHelper;
import com.primosoft.astman.core.util.BlockKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 18.08.16.
 *
 * @author atelizhenko
 */
class SetWorkAppUserStateResponseAction extends AbstractSuccessFailedResponseAction implements SuccessResponseAction, FailedResponseAction {
	private final String absentId = "Absent user id";
	private final String absentHost = "Absent user host";
	private final UsersHolder usersHolder;
	private String absentSipUser;
	private boolean absentIdModified;
	private boolean absentSipModified;
	private String caseId;
	private String personTypeId;
	private String AtmospheraId;
	private String Ptp;

	@Autowired
	SetWorkAppUserStateResponseAction(UsersHolder usersHolder, @Qualifier("socketLogger") Logger logger) {
		super(logger);
		this.usersHolder = usersHolder;
	}

	@Override
	boolean invokeAction() throws Exception {
		final BlockHelper blockHelper = getBlockHelper();

		final String appUserIdValue = blockHelper.getValue(BlockKey.APP_USER_ID);
		final String userHostValue = blockHelper.getValue(BlockKey.HOST);
		final String userStateValue = blockHelper.getValue(BlockKey.STATE);

		if (appUserIdValue == null || appUserIdValue.isEmpty())
			return false;


		return false;
	}

	@Override
	public ResponsePair[] onFailed() {
		final String absent = absentSipModified ? absentSipUser : absentIdModified ? absentId : absentHost;
		return new ResponsePair[]{new DefaultFailedResponsePair(), new ResponsePair("Reason", absent)};
	}
}
