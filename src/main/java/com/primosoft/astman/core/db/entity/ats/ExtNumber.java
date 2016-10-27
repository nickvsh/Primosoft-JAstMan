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
@Table(name = "ext_numbers", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "ExtNumbers.findAll", query = "SELECT e FROM ExtNumber e")
})
public class ExtNumber implements Model<BigInteger> {
	private static final long serialVersionUID = -6510227360431988578L;

	private BigInteger id;
	private String number;
	private String description;
	private Boolean disabled;
	private CallRoute callRoute;
	private String num;
	private String code;

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
	 * Gets number.
	 *
	 * @return the number
	 */
	@Column(name = "number")
	public String getNumber() {
		return number;
	}

	/**
	 * Sets number.
	 *
	 * @param number the number
	 */
	public void setNumber(String number) {
		this.number = number;
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
	 * Gets call routes.
	 *
	 * @return the call routes
	 */
	@ManyToOne
	@JoinColumn(name = "callroute_id", referencedColumnName = "id")
	public CallRoute getCallRoute() {
		return callRoute;
	}

	/**
	 * Sets call routes.
	 *
	 * @param callRoute the call routes
	 */
	public void setCallRoute(CallRoute callRoute) {
		this.callRoute = callRoute;
	}

	/**
	 * Gets num.
	 *
	 * @return the num
	 */
	@Column(name = "num", length = 7)
	public String getNum() {
		return num;
	}

	/**
	 * Sets num.
	 *
	 * @param num the num
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * Gets code.
	 *
	 * @return the code
	 */
	@Column(name = "code", length = 3)
	public String getCode() {
		return code;
	}

	/**
	 * Sets code.
	 *
	 * @param code the code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ExtNumber)) return false;
		ExtNumber that = (ExtNumber) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public String toString() {
		return "ExtNumber{" +
				"id=" + id +
				", number='" + number + '\'' +
				", description='" + description + '\'' +
				", disabled=" + disabled +
				", callRoute=" + callRoute +
				", num='" + num + '\'' +
				", code='" + code + '\'' +
				'}';
	}
}
