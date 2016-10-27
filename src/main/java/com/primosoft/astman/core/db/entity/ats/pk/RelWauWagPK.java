/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats.pk;

import com.primosoft.astman.core.db.entity.EmbeddedModel;
import com.primosoft.astman.core.db.entity.ats.RelWauWag;
import com.primosoft.astman.core.db.entity.ats.WorkAppGroup;
import com.primosoft.astman.core.db.entity.ats.WorkAppUser;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * Created on 07.06.16.
 * Embeddable class for two PK for {@link RelWauWag}
 *
 * @author atelizhenko
 */
@Embeddable
public class RelWauWagPK implements EmbeddedModel {
	private static final long serialVersionUID = 5855227687216459471L;

	private WorkAppUser workAppUser;
	private WorkAppGroup workAppGroup;

	/**
	 * Gets work app users.
	 *
	 * @return the work app users
	 */
	@ManyToOne
	@JoinColumn(name = "work_app_user_id", referencedColumnName = "id")
	public WorkAppUser getWorkAppUser() {
		return workAppUser;
	}

	/**
	 * Sets work app users.
	 *
	 * @param workAppUser the work app users
	 */
	public void setWorkAppUser(WorkAppUser workAppUser) {
		this.workAppUser = workAppUser;
	}

	/**
	 * Gets work app groups.
	 *
	 * @return the work app groups
	 */
	@ManyToOne
	@JoinColumn(name = "work_app_group_id", referencedColumnName = "id")
	public WorkAppGroup getWorkAppGroup() {
		return workAppGroup;
	}

	/**
	 * Sets work app groups.
	 *
	 * @param workAppGroup the work app groups
	 */
	public void setWorkAppGroup(WorkAppGroup workAppGroup) {
		this.workAppGroup = workAppGroup;
	}

	@Override
	public int hashCode() {
		return Objects.hash(workAppUser, workAppGroup);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RelWauWagPK)) return false;
		RelWauWagPK that = (RelWauWagPK) o;
		return Objects.equals(workAppUser, that.workAppUser) &&
				Objects.equals(workAppGroup, that.workAppGroup);
	}

	@Override
	public String toString() {
		return "RelWauWagPK{" +
				"workAppUser=" + workAppUser +
				", workAppGroup=" + workAppGroup +
				'}';
	}
}
