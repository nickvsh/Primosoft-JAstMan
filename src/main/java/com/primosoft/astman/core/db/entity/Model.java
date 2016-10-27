/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity;

import java.io.Serializable;

/**
 * Created on 23.05.16.
 * Base model entity class.
 *
 * @author atelizhenko
 */
public interface Model<Id extends Serializable> extends Serializable {
	/**
	 * Getter. Base method for getting primary key for current entity model.
	 *
	 * @return primary key for current entity model
	 */
	Id getId();
}
