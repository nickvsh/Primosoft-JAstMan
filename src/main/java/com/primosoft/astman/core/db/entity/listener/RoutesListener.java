/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.listener;

import com.primosoft.astman.core.db.entity.ats.Route;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Created on 07.06.16.
 * JPA listener for model {@link Route}
 *
 * @author atelizhenko
 */
public class RoutesListener {
	/**
	 * Initialize default fields method
	 *
	 * @param model model
	 */
	@PreUpdate
	public void onUpdate(Route model) {
		model.setStateId(0);
	}

	@PrePersist
	public void onPersist(Route model) {
		model.setStateId(0);
	}
}
