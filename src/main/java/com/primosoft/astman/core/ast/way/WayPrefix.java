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
final class WayPrefix {
	private final String wayPrefix;
	private final Map<String, Integer> value;
	private final List<Prefix> prefixList;

	WayPrefix(String wayPrefix, Map<String, Integer> value) {
		this.wayPrefix = wayPrefix;
		this.value = value;
		this.prefixList = new ArrayList<>(value.size());

		for (Map.Entry<String, Integer> entry : value.entrySet()) {
			final String limit = entry.getKey();
			final Integer valueLimit = entry.getValue();

			prefixList.add(new Prefix(limit, valueLimit));
		}
	}

	public final String getWayPrefix() {
		return wayPrefix;
	}

	public final Map<String, Integer> getValue() {
		return value;
	}

	public final List<Prefix> getPrefixList() {
		return prefixList;
	}
}
