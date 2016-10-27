/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity;

import java.io.Serializable;

/**
 * Created on 24.11.15.
 * Base DTO interface.
 *
 * @author atelizhenko
 */
public interface DTO extends Serializable {

	/**
	 * Pattern Builder
	 */
	interface BuilderDTO {
		/**
		 * Returns a dto built from the parameters previously set.
		 *
		 * @return a dto built with parameters of this builder
		 */
		DTO build();
	}
}
