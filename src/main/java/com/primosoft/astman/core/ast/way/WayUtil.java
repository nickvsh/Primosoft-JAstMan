/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.way;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 23.08.16.
 *
 * @author atelizhenko
 */
final class WayUtil {

	private WayUtil() {

	}

	static Map<String, Map<String, Map<String, Integer>>> getServerWay(String[] ways, String[] prefixes, int[] prefixValues) {
		final Map<String, Map<String, Map<String, Integer>>> map = new HashMap<>();

		for (String way : ways) {
			map.put(way, getWayPrefixMap(prefixes, prefixValues));
		}

		return map;
	}

	static Map<String, Map<String, Integer>> getWayPrefixMap(String[] prefixes, int[] prefixValues) {
		final Map<String, Map<String, Integer>> map = new HashMap<>();

		for (int i = 0; i < prefixes.length; i++) {
			final String prefix = prefixes[i];
			final int prefixValue = prefixValues[i];

			map.put(prefix, getPrefixMap(prefixValue));
		}

		return map;
	}

	static Map<String, Integer> getPrefixMap(int prefixValue) {
		final Map<String, Integer> map = new HashMap<>(1);
		map.put("limit", prefixValue);

		return map;
	}
}
