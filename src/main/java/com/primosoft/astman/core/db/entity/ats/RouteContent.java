/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats;

import com.primosoft.astman.core.db.entity.Model;
import com.primosoft.astman.core.db.entity.ats.pk.RouteContentPK;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created on 07.06.16.
 *
 * @author atelizhenko
 */
@Entity
@Table(name = "o_route_content", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "RouteContent.findAll", query = "SELECT r FROM RouteContent r")
})
public class RouteContent implements Model<RouteContentPK> {
	private static final long serialVersionUID = -71401367644939772L;

	private RouteContentPK id;
	private ExtNumber extNumber;
	private Double maxLoad;

	/**
	 * Getter
	 *
	 * @return id
	 */
	@EmbeddedId
	@Override
	public RouteContentPK getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(RouteContentPK id) {
		this.id = id;
	}

	/**
	 * Gets ext numbers.
	 *
	 * @return the ext numbers
	 */
	@ManyToOne
	@JoinColumn(name = "ext_number_id", referencedColumnName = "id")
	public ExtNumber getExtNumber() {
		return extNumber;
	}

	/**
	 * Sets ext numbers.
	 *
	 * @param extNumber the ext numbers
	 */
	public void setExtNumber(ExtNumber extNumber) {
		this.extNumber = extNumber;
	}

	/**
	 * Gets max load.
	 *
	 * @return the max load
	 */
	@Column(name = "max_load")
	public Double getMaxLoad() {
		return maxLoad;
	}

	/**
	 * Sets max load.
	 *
	 * @param maxLoad the max load
	 */
	public void setMaxLoad(Double maxLoad) {
		this.maxLoad = maxLoad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RouteContent)) return false;
		RouteContent that = (RouteContent) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public String toString() {
		return "RouteContent{" +
				"id=" + id +
				", extNumber=" + extNumber +
				", maxLoad=" + maxLoad +
				'}';
	}
}
