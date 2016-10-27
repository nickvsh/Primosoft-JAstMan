/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket.context.action;

import javafx.beans.NamedArg;
import javafx.util.Pair;

/**
 * Created on 18.08.16.
 *
 * @author atelizhenko
 */
class ResponsePair extends Pair<String, String> {
	private static final long serialVersionUID = 6283069168078354793L;

	/**
	 * Creates a new pair
	 *
	 * @param key   The key for this pair
	 * @param value The value to use for this pair
	 */
	public ResponsePair(@NamedArg("key") String key, @NamedArg("value") String value) {
		super(key, value);
	}

	/**
	 * <p><code>String</code> representation of this
	 * <code>Pair</code>.</p>
	 * <p>
	 * <p>The default name/value delimiter '=' is always used.</p>
	 *
	 * @return <code>String</code> representation of this <code>Pair</code>
	 */
	@Override
	public String toString() {
		return getKey() + ":" + getValue();
	}
}
