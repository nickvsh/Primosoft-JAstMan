/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats;

import com.primosoft.astman.core.db.entity.Model;
import com.primosoft.astman.core.db.entity.listener.WorkAppGroupsListener;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created on 07.06.16.
 *
 * @author atelizhenko
 */
@Entity
@EntityListeners(WorkAppGroupsListener.class)
@Table(name = "work_app_groups", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "WorkAppGroups.findAll", query = "SELECT w FROM WorkAppGroup w")
})
public class WorkAppGroup implements Model<BigInteger> {
	private static final long serialVersionUID = 2721553167419376760L;

	private BigInteger id;
	private String name;
	private Boolean disabled;
	private BigInteger serverId;

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
	 * Gets disabled.
	 *
	 * @return the disabled
	 */
	@Column(name = "disabled")
	public Boolean getDisabled() {
		return disabled;
	}

	/**
	 * Sets disabled.
	 *
	 * @param disabled the disabled
	 */
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * Gets server id.
	 *
	 * @return the server id
	 */
	@Column(name = "server_id")
	public BigInteger getServerId() {
		return serverId;
	}

	/**
	 * Sets server id.
	 *
	 * @param serverId the server id
	 */
	public void setServerId(BigInteger serverId) {
		this.serverId = serverId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof WorkAppGroup)) return false;
		WorkAppGroup that = (WorkAppGroup) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public String toString() {
		return "WorkAppGroup{" +
				"id=" + id +
				", name='" + name + '\'' +
				", disabled=" + disabled +
				", serverId=" + serverId +
				'}';
	}
}
