/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.listener;

import com.primosoft.astman.core.db.entity.ats.Group;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Created on 07.06.16.
 * JPA listener for model {@link Group}
 *
 * @author atelizhenko
 */
public class GroupsListener {
	/**
	 * Initialize default fields method
	 *
	 * @param model model
	 */
	@PreUpdate
	public void onUpdate(Group model) {
		model.setDisabled(false);
	}

	@PrePersist
	public void onPersist(Group model) {
		model.setDisabled(false);
	}
}
