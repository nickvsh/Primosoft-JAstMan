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
public final class WayTechnology {
	private final String technology;
	private final List<WayServer> wayServerList;


	WayTechnology(String technology, List<Map<String, Map<String, Map<String, Integer>>>> wayList) {
		this.technology = technology;
		this.wayServerList = new ArrayList<>(wayList.size());

		for (final Map<String, Map<String, Map<String, Integer>>> map : wayList) {
			for (Map.Entry<String, Map<String, Map<String, Integer>>> stringMapEntry : map.entrySet()) {
				final String key = stringMapEntry.getKey();
				final Map<String, Map<String, Integer>> value = stringMapEntry.getValue();

				wayServerList.add(new WayServer(key, value));
			}
		}
	}

	public final List<WayServer> getWayServerList() {
		return wayServerList;
	}
}
