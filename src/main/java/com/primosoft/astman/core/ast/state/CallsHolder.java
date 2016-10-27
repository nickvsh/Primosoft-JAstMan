/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.state;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created on 06.09.16.
 *
 * @author atelizhenko
 */
public class CallsHolder {
	private final Map<String, Object> calls;

	public CallsHolder() {
		calls = new ConcurrentHashMap<>();
	}
}
