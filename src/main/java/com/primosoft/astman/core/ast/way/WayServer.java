/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.way;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created on 19.08.16.
 *
 * @author atelizhenko
 */
final class WayServer {
	private final String wayServer;
	private final List<WayPrefix> wayPrefixList;

	WayServer(String server, Map<String, Map<String, Integer>> map) {
		this.wayServer = server;
		this.wayPrefixList = new ArrayList<>(map.size());

		for (final Map.Entry<String, Map<String, Integer>> stringMapEntry : map.entrySet()) {
			final String key = stringMapEntry.getKey();
			final Map<String, Integer> value = stringMapEntry.getValue();

			wayPrefixList.add(new WayPrefix(key, value));
		}
	}

	public final List<WayPrefix> getWayPrefixList() {
		return wayPrefixList;
	}
}
