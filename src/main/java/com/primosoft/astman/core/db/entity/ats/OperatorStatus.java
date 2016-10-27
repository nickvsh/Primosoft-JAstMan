/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats;


import com.primosoft.astman.core.db.entity.Model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created on 18.03.16.
 *
 * @author atelizhenko
 */
@Entity
@Table(name = "operator_statuses", schema = "ats", catalog = "asterisk")
@NamedQueries({
		@NamedQuery(name = "OperatorStatuses.findAll", query = "SELECT o FROM OperatorStatus o")
})
public class OperatorStatus implements Model<BigInteger> {
	private static final long serialVersionUID = 883025558439876365L;

	private BigInteger id;
	private String description;

	/**
	 * Getter
	 *
	 * @return id
	 */
	@Id
	@Column(name = "id", nullable = false)
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Basic
	@Column(name = "description", nullable = true, length = -1)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, description);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OperatorStatus that = (OperatorStatus) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(description, that.description);
	}
}
