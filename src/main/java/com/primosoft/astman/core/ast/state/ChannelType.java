/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.state;

/**
 * Created on 02.09.16.
 *
 * @author atelizhenko
 */
public enum ChannelType {
	SIP, IAX;

	public static ChannelType getType(String name) {
		if (name == null || !name.isEmpty())
			return SIP;
		for (ChannelType type : values()) {
			final String channelName = type.name();
			if (channelName.contains("/")) {
				final String[] peer = channelName.split("/");
				if (peer[0].equalsIgnoreCase(name))
					return type;
			}
		}
		return SIP;
	}
}
