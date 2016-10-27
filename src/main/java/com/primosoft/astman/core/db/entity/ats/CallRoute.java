/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats;

import com.primosoft.astman.core.db.entity.Model;
import com.primosoft.astman.core.db.entity.listener.CallRoutesListener;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created on 07.06.16.
 *
 * @author atelizhenko
 */
@Entity
@EntityListeners(CallRoutesListener.class)
@Table(name = "callroutes", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "CallRoutes.findAll", query = "SELECT c FROM CallRoute c"),
		@NamedQuery(name = "CallRoutes.findAllActive", query = "SELECT c FROM CallRoute c WHERE c.disabled=false")
})
public class CallRoute implements Model<BigInteger> {
	private static final long serialVersionUID = -7276033868537398673L;

	private BigInteger id;
	private String srv;
	private String pref;
	private Integer capacity;
	private Integer load;
	private String name;
	private String srvHost;
	private String chainIdentPattern;
	private Boolean disabled;

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
	 * Gets srv.
	 *
	 * @return the srv
	 */
	@Column(name = "srv")
	public String getSrv() {
		return srv;
	}

	/**
	 * Sets srv.
	 *
	 * @param srv the srv
	 */
	public void setSrv(String srv) {
		this.srv = srv;
	}

	/**
	 * Gets pref.
	 *
	 * @return the pref
	 */
	@Column(name = "pref")
	public String getPref() {
		return pref;
	}

	/**
	 * Sets pref.
	 *
	 * @param pref the pref
	 */
	public void setPref(String pref) {
		this.pref = pref;
	}

	/**
	 * Gets capacity.
	 *
	 * @return the capacity
	 */
	@Column(name = "capacity")
	public Integer getCapacity() {
		return capacity;
	}

	/**
	 * Sets capacity.
	 *
	 * @param capacity the capacity
	 */
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	/**
	 * Gets load.
	 *
	 * @return the load
	 */
	@Column(name = "load")
	public Integer getLoad() {
		return load;
	}

	/**
	 * Sets load.
	 *
	 * @param load the load
	 */
	public void setLoad(Integer load) {
		this.load = load;
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
	 * Gets srv host.
	 *
	 * @return the srv host
	 */
	@Column(name = "srv_host")
	public String getSrvHost() {
		return srvHost;
	}

	/**
	 * Sets srv host.
	 *
	 * @param srvHost the srv host
	 */
	public void setSrvHost(String srvHost) {
		this.srvHost = srvHost;
	}

	/**
	 * Gets chain ident pattern.
	 *
	 * @return the chain ident pattern
	 */
	@Column(name = "chan_ident_pattern")
	public String getChainIdentPattern() {
		return chainIdentPattern;
	}

	/**
	 * Sets chain ident pattern.
	 *
	 * @param chainIdentPattern the chain ident pattern
	 */
	public void setChainIdentPattern(String chainIdentPattern) {
		this.chainIdentPattern = chainIdentPattern;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CallRoute)) return false;
		CallRoute that = (CallRoute) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public String toString() {
		return "CallRoute{" +
				"id=" + id +
				", srv='" + srv + '\'' +
				", pref='" + pref + '\'' +
				", capacity=" + capacity +
				", load=" + load +
				", name='" + name + '\'' +
				", srvHost='" + srvHost + '\'' +
				", chainIdentPattern='" + chainIdentPattern + '\'' +
				", disabled=" + disabled +
				'}';
	}
}
