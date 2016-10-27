/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.way;

import com.primosoft.astman.core.log.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.primosoft.astman.core.ast.way.WayUtil.getServerWay;

/**
 * Created on 19.08.16.
 *
 * @author atelizhenko
 */
public class CallWay {
	private final WayTechnology wayTechnology;
	private final Logger logger;

	@Autowired
	public CallWay(@Qualifier("asteriskLogger") Logger logger) {
		this.logger = logger;
		this.wayTechnology = new WayTechnology("SIP", createWayList());
	}

	private List<Map<String, Map<String, Map<String, Integer>>>> createWayList() {
		logger.trace("Creating way list");

		final Map<String, Map<String, Map<String, Integer>>> astWay =
				getServerWay(new String[]{"ast"}, new String[]{"", "044"}, new int[]{90, 60});
		final Map<String, Map<String, Map<String, Integer>>> astToKievWay =
				getServerWay(new String[]{"asttokiev"}, new String[]{"044", "032", "132"}, new int[]{20, 60, 60});
		final List<Map<String, Map<String, Map<String, Integer>>>> wayList = new ArrayList<>(2);
		wayList.add(astWay);
		wayList.add(astToKievWay);

		return wayList;
	}

	public final WayTechnology getWayTechnology() {
		return wayTechnology;
	}
}
