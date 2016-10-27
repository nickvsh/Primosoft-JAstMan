/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.ex;

import javax.persistence.PersistenceException;

/**
 * Created on 05.09.16.
 *
 * @author atelizhenko
 */
public class NoOperatorFound extends PersistenceException {
	private static final long serialVersionUID = 5166582917864893402L;

	/**
	 * Constructs a new <code>PersistenceException</code> exception
	 * with <code>null</code> as its detail message.
	 */
	public NoOperatorFound() {
		super();
	}

	/**
	 * Constructs a new <code>PersistenceException</code> exception
	 * with the specified detail message.
	 *
	 * @param message the detail message.
	 */
	public NoOperatorFound(String message) {
		super(message);
	}

	/**
	 * Constructs a new <code>PersistenceException</code> exception
	 * with the specified detail message and cause.
	 *
	 * @param message the detail message.
	 * @param cause   the cause.
	 */
	public NoOperatorFound(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new <code>PersistenceException</code> exception
	 * with the specified cause.
	 *
	 * @param cause the cause.
	 */
	public NoOperatorFound(Throwable cause) {
		super(cause);
	}
}
