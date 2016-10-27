/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.listener;

import com.primosoft.astman.core.db.entity.ats.WorkAppGroup;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.math.BigInteger;

/**
 * Created on 07.06.16.
 * JPA listener for model {@link WorkAppGroup}
 *
 * @author atelizhenko
 */
public class WorkAppGroupsListener {
	/**
	 * Initialize default fields method
	 *
	 * @param model model
	 */
	@PrePersist
	public void onUpdate(WorkAppGroup model) {
		model.setServerId(BigInteger.valueOf(-1));
	}

	@PreUpdate
	public void onPersist(WorkAppGroup model) {
		model.setServerId(BigInteger.valueOf(-1));
	}
}
