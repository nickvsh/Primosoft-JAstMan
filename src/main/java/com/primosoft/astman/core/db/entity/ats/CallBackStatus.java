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
 * Created on 07.06.16.
 *
 * @author atelizhenko
 */
@Entity
@Table(name = "call_statuses", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "CallBackStatuses.findAll", query = "SELECT c FROM CallBackStatus c")
})
public class CallBackStatus implements Model<BigInteger> {
	private static final long serialVersionUID = 2296119363049730775L;

	private BigInteger id;
	private String description;

	/**
	 * Getter
	 *
	 * @return id
	 */
	@Id
	@Column(name = "id")
	@Override
	public BigInteger getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Gets description.
	 *
	 * @return the description
	 */
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * Sets description.
	 *
	 * @param description the description
	 */
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
		if (!(o instanceof CallBackStatus)) return false;
		CallBackStatus that = (CallBackStatus) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(description, that.description);
	}

	@Override
	public String toString() {
		return "CallBackStatus{" +
				"id=" + id +
				", description='" + description + '\'' +
				'}';
	}
}
