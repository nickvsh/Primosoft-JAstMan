/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.listener;

import com.primosoft.astman.core.db.entity.ats.CallRoute;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Created on 07.06.16.
 * JPA listener for model {@link CallRoute}
 *
 * @author atelizhenko
 */
public class CallRoutesListener {
	/**
	 * Initialize default fields method
	 *
	 * @param model model
	 */
	@PreUpdate
	public void onUpdate(CallRoute model) {
		model.setDisabled(false);
	}

	@PrePersist
	public void onPersist(CallRoute model) {
		model.setDisabled(false);
	}
}
