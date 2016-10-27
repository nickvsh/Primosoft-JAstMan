/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats;

import com.primosoft.astman.core.db.entity.Model;
import com.primosoft.astman.core.db.entity.ats.pk.RelWauWagPK;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created on 07.06.16.
 *
 * @author atelizhenko
 */
@Entity
@Table(name = "rel_wau_wag", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "RelWauWag.findDontSpeakOfGroup",
				query = "SELECT r.id.workAppUser.operator " +
						"FROM RelWauWag r " +
						"WHERE r.workAppGroup.name = :groupName " +
						"AND r.id.workAppUser.statusId in (10, 20, 11)" +
						"AND r.id.workAppUser.operator.operatorStatus.id in (10,20,21,22,23,24,11)"),
		@NamedQuery(name = "RelWauWag.findFreeOfGroup",
				query = "SELECT r.id.workAppUser.operator " +
						"FROM RelWauWag r " +
						"WHERE r.workAppGroup.name = :groupName " +
						"AND r.id.workAppUser.statusId = 10" +
						"AND r.id.workAppUser.operator.operatorStatus.id = 10"),
		@NamedQuery(name = "RelWauWag.findLoginedOfGroup",
				query = "SELECT r.id.workAppUser.operator " +
						"FROM RelWauWag r " +
						"WHERE r.workAppGroup.name = :groupName " +
						"AND r.id.workAppUser.statusId <> -10" +
						"AND r.id.workAppUser.operator.operatorStatus.id <> -10"),
		@NamedQuery(name = "RelWauWag.findAll", query = "SELECT r FROM RelWauWag r")
})
public class RelWauWag implements Model<RelWauWagPK> {
	private static final long serialVersionUID = -7285780425164289081L;

	private RelWauWagPK id;
	private WorkAppGroup workAppGroup;

	/**
	 * Getter
	 *
	 * @return id
	 */
	@EmbeddedId
	@Override
	public RelWauWagPK getId() {
		return id;
	}

	public void setId(RelWauWagPK id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "work_app_group_id", referencedColumnName = "id", insertable = false, updatable = false)
	public WorkAppGroup getWorkAppGroup() {
		return workAppGroup;
	}

	public void setWorkAppGroup(WorkAppGroup workAppGroup) {
		this.workAppGroup = workAppGroup;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, workAppGroup);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RelWauWag)) return false;
		RelWauWag relWauWag = (RelWauWag) o;
		return Objects.equals(id, relWauWag.id) &&
				Objects.equals(workAppGroup, relWauWag.workAppGroup);
	}

	@Override
	public String toString() {
		return "RelWauWag{" +
				"id=" + id +
				", workAppGroup=" + workAppGroup +
				'}';
	}
}
