/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.listener;

import com.primosoft.astman.core.db.entity.ats.Call;
import com.primosoft.astman.core.db.entity.ats.WorkAppUser;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created on 07.06.16.
 * JPA listener for model {@link Call}
 *
 * @author atelizhenko
 */
public class CallsListener {
	/**
	 * Initialize default fields method
	 *
	 * @param model model
	 */
	@PreUpdate
	public void onUpdate(Call model) {
		model.setOperatorId(BigInteger.ZERO);
		model.setInsideStatusId(BigInteger.TEN);
		model.setGroupId(BigInteger.ZERO);
		model.setExtNumberId(BigInteger.ZERO);
		model.setBeginDate(new Date());
		model.setCallRecordId(BigInteger.ZERO);
		model.setOutsideStatusId(BigInteger.TEN);
		model.setWorkAppUser(new WorkAppUser(BigInteger.ZERO));
	}

	@PrePersist
	public void onPersist(Call model) {
		model.setOperatorId(BigInteger.ZERO);
		model.setInsideStatusId(BigInteger.TEN);
		model.setGroupId(BigInteger.ZERO);
		model.setExtNumberId(BigInteger.ZERO);
		model.setBeginDate(new Date());
		model.setCallRecordId(BigInteger.ZERO);
		model.setOutsideStatusId(BigInteger.TEN);
		model.setWorkAppUser(new WorkAppUser(BigInteger.ZERO));
	}
}
