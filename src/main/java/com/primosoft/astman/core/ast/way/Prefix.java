/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.way;

import javafx.beans.NamedArg;
import javafx.util.Pair;

/**
 * Created on 23.08.16.
 *
 * @author atelizhenko
 */
public class Prefix extends Pair<String, Integer> {
	private static final long serialVersionUID = 6312223226267889645L;

	/**
	 * Creates a new pair
	 *
	 * @param key   The key for this pair
	 * @param value The value to use for this pair
	 */
	Prefix(@NamedArg("key") String key, @NamedArg("value") Integer value) {
		super(key, value);
	}
}
