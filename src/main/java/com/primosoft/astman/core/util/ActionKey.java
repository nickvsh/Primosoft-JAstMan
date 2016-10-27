/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.util;

/**
 * Created on 17.08.16.
 *
 * @author atelizhenko
 */
public enum ActionKey {
	NOTHING("Nothing"),

	LOGIN("login"),
	LOGOFF("logoff"),
	PING("ping"),
	GET_CALL_WAYS_LOADS("GetCallWaysLoads"),
	DIAL("Dial"),
	CALL_BACK("CallBack"),
	GET_USERS_OF_GROUP("GetUsersOfGroup"),
	GET_FREE_USERS_OF_GROUP("GetFreeUsersOfGroup"),
	ASTERISK_RX("AsteriskRX"),
	EVENT_CONTACT_CREATED("EventContactCreated"),
	REFR_SMYK_USER_ID("RefrSmykUserId"),
	GET_WAY_LOADS("GetWayLoads"),
	NEW_MAIN_APP_USER_STATUS("NewMainAppUserStatus"),
	MAKE_OUTGOING_CALL("MakeOutgoingCall"),
	SET_WORK_APP_USER_STATE("SetWorkAppUserState"),
	GET_USER_STATE("GUS");


	private final String key;

	ActionKey(String key) {
		this.key = key;
	}

	public static ActionKey getActionKey(String key) {
		for (ActionKey actionKey : values()) {
			if (actionKey.getKey().equalsIgnoreCase(key))
				return actionKey;
		}
		return NOTHING;
	}

	public final String getKey() {
		return key;
	}
}
