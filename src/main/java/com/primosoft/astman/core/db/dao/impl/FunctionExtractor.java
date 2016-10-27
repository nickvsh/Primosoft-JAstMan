/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import java.util.Map;

/**
 * Created on 05.09.16.
 *
 * @author atelizhenko
 */
public interface FunctionExtractor<T> {
	T extractFromFunction(Map<String, ?> parameters);
}
