/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats;

import com.primosoft.astman.core.db.entity.Model;
import com.primosoft.astman.core.db.entity.listener.RoutesListener;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created on 07.06.16.
 *
 * @author atelizhenko
 */
@Entity
@EntityListeners(RoutesListener.class)
@Table(name = "o_routes", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "Routes.findAll", query = "SELECT r FROM Route r")
})
public class Route implements Model<BigInteger> {
	private static final long serialVersionUID = -2699425721892493631L;

	private BigInteger id;
	private String name;
	private Integer stateId;

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
	 * Gets name.
	 *
	 * @return the name
	 */
	@Column(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets state id.
	 *
	 * @return the state id
	 */
	@Column(name = "state_id")
	public Integer getStateId() {
		return stateId;
	}

	/**
	 * Sets state id.
	 *
	 * @param stateId the state id
	 */
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Route)) return false;
		Route route = (Route) o;
		return Objects.equals(id, route.id);
	}

	@Override
	public String toString() {
		return "Route{" +
				"id=" + id +
				", name='" + name + '\'' +
				", stateId=" + stateId +
				'}';
	}
}
