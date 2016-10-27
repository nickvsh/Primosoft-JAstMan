/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.listener;

import com.primosoft.astman.core.db.entity.ats.CallRecord;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created on 08.06.16.
 * JPA listener for model {@link CallRecord}
 *
 * @author atelizhenko
 */
public class CallRecordsListener {
	/**
	 * Initialize default fields method
	 *
	 * @param model model
	 */
	@PreUpdate
	public void onUpdate(CallRecord model) {
		model.setDate(new Date());
	}

	@PrePersist
	public void onPersist(CallRecord model) {
		model.setDate(new Date());
	}
}
