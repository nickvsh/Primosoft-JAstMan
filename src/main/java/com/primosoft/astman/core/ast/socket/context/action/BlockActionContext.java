/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket.context.action;

import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.ActionKey;
import com.primosoft.astman.core.util.BlockHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.SocketAddress;

/**
 * Created on 17.08.16.
 *
 * @author atelizhenko
 */
public class BlockActionContext {
	private final ResponseAction loginResponseAction;
	private final ResponseAction logoffResponseAction;
	private final ResponseAction pingResponseAction;
	private final ResponseAction getCallWaysLoadsResponseAction;
	private final ResponseAction dialResponseAction;
	private final ResponseAction callBackResponseAction;
	private final ResponseAction getUsersOfGroupResponseAction;
	private final ResponseAction getFreeUsersOfGroupResponseAction;
	private final ResponseAction asteriskRXResponseAction;
	private final ResponseAction eventContactCreatedResponseAction;
	private final ResponseAction refrSmykUserIdResponseAction;
	private final ResponseAction getWayLoadsResponseAction;
	private final ResponseAction newMainAppUserStatusResponseAction;
	private final ResponseAction makeOutgoingCallResponseAction;
	private final ResponseAction setWorkAppUserStateResponseAction;
	private final ResponseAction gusResponseAction;
	private final ResponseAction failResponseAction;
	private final Logger socketLogger;
	private BlockHelper blockHelper;
	private SocketAddress remoteSocketAddress;
	private ResponseAction responseAction;

	@Autowired
	public BlockActionContext(ResponseAction loginResponseAction, ResponseAction logoffResponseAction,
							  ResponseAction pingResponseAction, ResponseAction getCallWaysLoadsResponseAction,
							  ResponseAction dialResponseAction, ResponseAction callBackResponseAction,
							  ResponseAction getUsersOfGroupResponseAction, ResponseAction getFreeUsersOfGroupResponseAction,
							  ResponseAction asteriskRXResponseAction, ResponseAction eventContactCreatedResponseAction,
							  ResponseAction refrSmykUserIdResponseAction, ResponseAction getWayLoadsResponseAction,
							  ResponseAction newMainAppUserStatusResponseAction, ResponseAction makeOutgoingCallResponseAction,
							  ResponseAction setWorkAppUserStateResponseAction, ResponseAction gusResponseAction,
							  ResponseAction failResponseAction, Logger socketLogger) {
		this.loginResponseAction = loginResponseAction;
		this.logoffResponseAction = logoffResponseAction;
		this.pingResponseAction = pingResponseAction;
		this.getCallWaysLoadsResponseAction = getCallWaysLoadsResponseAction;
		this.dialResponseAction = dialResponseAction;
		this.callBackResponseAction = callBackResponseAction;
		this.getUsersOfGroupResponseAction = getUsersOfGroupResponseAction;
		this.getFreeUsersOfGroupResponseAction = getFreeUsersOfGroupResponseAction;
		this.asteriskRXResponseAction = asteriskRXResponseAction;
		this.eventContactCreatedResponseAction = eventContactCreatedResponseAction;
		this.refrSmykUserIdResponseAction = refrSmykUserIdResponseAction;
		this.getWayLoadsResponseAction = getWayLoadsResponseAction;
		this.newMainAppUserStatusResponseAction = newMainAppUserStatusResponseAction;
		this.makeOutgoingCallResponseAction = makeOutgoingCallResponseAction;
		this.setWorkAppUserStateResponseAction = setWorkAppUserStateResponseAction;
		this.gusResponseAction = gusResponseAction;
		this.failResponseAction = failResponseAction;
		this.socketLogger = socketLogger;
	}


	public final void setRemoteSocketAddress(SocketAddress remoteSocketAddress) {
		this.remoteSocketAddress = remoteSocketAddress;
		socketLogger.debug("Settled remote socket address " + this.remoteSocketAddress);
	}

	public final void setBlockHelper(BlockHelper blockHelper) {
		this.blockHelper = blockHelper;
		socketLogger.debug("Settled block helper " + this.blockHelper);
	}

	public final String discoverActionStrategy() {
		socketLogger.debug("Discovering strategy for separate action");

		try {
			final ActionKey actionKey = blockHelper.getActionKey();
			socketLogger.debug("ActionKey after generating block is " + actionKey);
			responseAction = generateResponse(actionKey);
			socketLogger.debug("Generated response " + responseAction.getClass().getSimpleName() + " by ActionKey " + actionKey);
			responseAction.setBlockHelper(new BlockHelper(blockHelper));
			responseAction.setSocketAddress(remoteSocketAddress);
			return responseAction.invoke();
		} finally {
			blockHelper.clear();
			blockHelper = null;
		}
	}

	private ResponseAction generateResponse(final ActionKey actionKey) {
		switch (actionKey) {
			case LOGIN:
				return loginResponseAction;
			case LOGOFF:
				return logoffResponseAction;
			case PING:
				return pingResponseAction;
			case GET_CALL_WAYS_LOADS:
				return getCallWaysLoadsResponseAction;
			case DIAL:
				return dialResponseAction;
			case CALL_BACK:
				return callBackResponseAction;
			case GET_USERS_OF_GROUP:
				return getUsersOfGroupResponseAction;
			case GET_FREE_USERS_OF_GROUP:
				return getFreeUsersOfGroupResponseAction;
			case ASTERISK_RX:
				return asteriskRXResponseAction;
			case EVENT_CONTACT_CREATED:
				return eventContactCreatedResponseAction;
			case REFR_SMYK_USER_ID:
				return refrSmykUserIdResponseAction;
			case GET_WAY_LOADS:
				return getWayLoadsResponseAction;
			case NEW_MAIN_APP_USER_STATUS:
				return newMainAppUserStatusResponseAction;
			case MAKE_OUTGOING_CALL:
				return makeOutgoingCallResponseAction;
			case SET_WORK_APP_USER_STATE:
				return setWorkAppUserStateResponseAction;
			case GET_USER_STATE:
				return gusResponseAction;
		}
		return failResponseAction;
	}

	public final boolean verifyCloseConnection() {
		final boolean verifyToCloseConnection = responseAction != null && !responseAction.stayConnection();
		socketLogger.debug("Need to close connection " + remoteSocketAddress + " has value " + verifyToCloseConnection);
		return verifyToCloseConnection;
	}
}
