/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats;

import com.primosoft.astman.core.db.entity.Model;
import com.primosoft.astman.core.db.entity.ats.pk.RelOpGrPK;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created on 08.06.16.
 *
 * @author atelizhenko
 */
@Entity
@Table(name = "rel_op_gr", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "RelOpGr.findAllOfGroup",
				query = "SELECT r.id.operator FROM RelOpGr r WHERE r.id.group.name = :groupName"),
		@NamedQuery(name = "RelOpGr.findAll", query = "SELECT r FROM RelOpGr r")
})
public class RelOpGr implements Model<RelOpGrPK> {
	private static final long serialVersionUID = -5222645987247264020L;

	private RelOpGrPK id;

	/**
	 * Getter
	 *
	 * @return id
	 */
	@EmbeddedId
	@Override
	public RelOpGrPK getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(RelOpGrPK id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RelOpGr)) return false;
		RelOpGr relOpGr = (RelOpGr) o;
		return Objects.equals(id, relOpGr.id);
	}

	@Override
	public String toString() {
		return "RelOpGr{" +
				"id=" + id +
				'}';
	}
}
