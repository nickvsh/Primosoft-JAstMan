/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.listener;

import com.primosoft.astman.core.db.entity.ats.CbCall;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Created on 08.06.16.
 * JPA listener for model {@link CbCall}
 *
 * @author atelizhenko
 */
public class CbCallsListener {
	/**
	 * Initialize default fields method
	 *
	 * @param model model
	 */
	@PreUpdate
	public void onUpdate(CbCall model) {
		model.setDirection('0');
		model.setStateId(1);
		model.setPriority(0);
	}

	@PrePersist
	public void onPersist(CbCall model) {
		model.setDirection('0');
		model.setStateId(1);
		model.setPriority(0);
	}
}
