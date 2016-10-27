/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.state;

import org.jetbrains.annotations.Nullable;

/**
 * Created on 07.06.16.
 * Client state for connect to db
 *
 * @author atelizhenko
 */
public enum ClientState {
	UA("Ukraine"),
	RU("Russia"),
	PL("Poland");

	/**
	 * State for country
	 */
	private final String state;

	/**
	 * Invisible constructor for country
	 *
	 * @param state state for country
	 */
	ClientState(final String state) {
		this.state = state;
	}

	/**
	 * Getting client state by string
	 *
	 * @param state input string state
	 * @return client state
	 */
	@Nullable
	public static ClientState getState(String state) {
		for (ClientState clientState : values()) {
			if (clientState.getState().equalsIgnoreCase(state))
				return clientState;
		}
		return null;
	}

	/**
	 * Getter
	 *
	 * @return statefor country
	 */
	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return name();
	}
}
