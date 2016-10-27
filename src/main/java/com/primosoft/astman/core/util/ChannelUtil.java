/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.util;

import com.primosoft.astman.core.ast.state.ChannelBean;

/**
 * Created on 02.09.16.
 *
 * @author atelizhenko
 */
public final class ChannelUtil {
	private ChannelUtil() {

	}

	public static ChannelBean getChannelBean(String channelName) {
		final ChannelBean channelBean = new ChannelBean();

		if (channelName != null && !channelName.isEmpty()) {
			final String[] peerArray = channelName.split("/");
			if (peerArray.length == 2) {
				channelBean.setPeer(peerArray[0]);
				channelBean.setDn(peerArray[1]);
			}
		}

		return channelBean;
	}
}
