/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.command;

/**
 * Created on 17.08.16.
 *
 * @author atelizhenko
 */
public interface Command<Result> {
	Result invoke();
}
