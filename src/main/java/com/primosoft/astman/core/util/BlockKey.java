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
public enum BlockKey {
	NOTHING("Nothing"),
	ACTION("Action"),
	HOST("HOST"),
	APP_USER_ID("APP_USER_ID"),
	STATE("STATE"),
	CASE_ID("CaseId"),
	CLIENT_ID("ClientId"),
	PHONE_ID("PhoneId"),
	PERSON_TYPE_ID("PersonTypeId"),
	ATMOSPHERA_ID("AtmospheraId"),
	PTP("Ptp"),
	GET_USER_STATE("GUS"),
	CHANNEL("Channel"),
	VARIABLE("Variable"),
	MAN_CALL_ID("manCALLID");


	private final String key;

	BlockKey(String key) {
		this.key = key;
	}

	public static BlockKey getBlockKey(String key) {
		for (final BlockKey blockKey : values()) {
			if (blockKey.getKey().equalsIgnoreCase(key))
				return blockKey;
		}
		return NOTHING;
	}

	public final String getKey() {
		return key;
	}
}
