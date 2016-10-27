/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats;


import com.primosoft.astman.core.db.entity.Model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

/**
 * Created on 07.06.16.
 *
 * @author atelizhenko
 */
@Entity
@Table(name = "work_app_users", schema = "ats", catalog = "asterisk")
@NamedQueries({
		@NamedQuery(name = "WorkAppUsers.findById", query = "SELECT w FROM WorkAppUser w WHERE w.id = :id"),
		@NamedQuery(name = "WorkAppUsers.findAll", query = "SELECT w FROM WorkAppUser w"),
		@NamedQuery(name = "WorkAppUsers.updateStatusId", query = "UPDATE WorkAppUser w SET w.statusId =:appStatusId WHERE w.id =:userId")
})
public class WorkAppUser implements Model<BigInteger> {
	private static final long serialVersionUID = -2225479162876930141L;

	private BigInteger id;
	private String login;
	private Short extNumberId;
	private Short statusId;
	private String ipAddress;
	private BigInteger atsUserId;
	private String phoneIpAddress;
	private boolean disabled;
	private Date statusDate;
	private String name;
	private Short oRouteId;
	private Integer systemId;
	private Date citlBct;
	private Date citlEct;
	private Date citlSbct;
	private Integer parentUserId;
	private Operator operator;

	/**
	 * Instantiates a new Work app users.
	 */
	public WorkAppUser() {
	}

	/**
	 * Instantiates a new Work app users.
	 *
	 * @param id the id
	 */
	public WorkAppUser(BigInteger id) {
		this.id = id;
	}

	/**
	 * Getter
	 *
	 * @return id
	 */
	@Id
	@Override
	@Column(name = "id", nullable = false)
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
	 * Gets login.
	 *
	 * @return the login
	 */
	@Column(name = "login")
	public String getLogin() {
		return login;
	}

	/**
	 * Sets login.
	 *
	 * @param login the login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets ext number id.
	 *
	 * @return the ext number id
	 */
	@Column(name = "ext_number_id")
	public Short getExtNumberId() {
		return extNumberId;
	}

	/**
	 * Sets ext number id.
	 *
	 * @param extNumberId the ext number id
	 */
	public void setExtNumberId(Short extNumberId) {
		this.extNumberId = extNumberId;
	}

	/**
	 * Gets status id.
	 *
	 * @return the status id
	 */
	@Column(name = "status_id")
	public Short getStatusId() {
		return statusId;
	}

	/**
	 * Sets status id.
	 *
	 * @param statusId the status id
	 */
	public void setStatusId(Short statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets ip address.
	 *
	 * @return the ip address
	 */
	@Column(name = "ipaddr")
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Sets ip address.
	 *
	 * @param ipAddress the ip address
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Gets ats user id.
	 *
	 * @return the ats user id
	 */
	@Column(name = "ats_user_id")
	public BigInteger getAtsUserId() {
		return atsUserId;
	}

	/**
	 * Sets ats user id.
	 *
	 * @param atsUserId the ats user id
	 */
	public void setAtsUserId(BigInteger atsUserId) {
		this.atsUserId = atsUserId;
	}

	/**
	 * Gets phone ip address.
	 *
	 * @return the phone ip address
	 */
	@Column(name = "phone_ipaddr")
	public String getPhoneIpAddress() {
		return phoneIpAddress;
	}

	/**
	 * Sets phone ip address.
	 *
	 * @param phoneIpAddress the phone ip address
	 */
	public void setPhoneIpAddress(String phoneIpAddress) {
		this.phoneIpAddress = phoneIpAddress;
	}

	/**
	 * Is disabled boolean.
	 *
	 * @return the boolean
	 */
	@Column(name = "disabled")
	public boolean isDisabled() {
		return disabled;
	}

	/**
	 * Sets disabled.
	 *
	 * @param disabled the disabled
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * Gets status date.
	 *
	 * @return the status date
	 */
	@Column(name = "status_date")
	public Date getStatusDate() {
		return statusDate;
	}

	/**
	 * Sets status date.
	 *
	 * @param statusDate the status date
	 */
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
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
	 * Gets route id.
	 *
	 * @return the route id
	 */
	@Column(name = "o_route_id")
	public Short getoRouteId() {
		return oRouteId;
	}

	/**
	 * Sets route id.
	 *
	 * @param oRouteId the o route id
	 */
	public void setoRouteId(Short oRouteId) {
		this.oRouteId = oRouteId;
	}

	/**
	 * Gets system id.
	 *
	 * @return the system id
	 */
	@Column(name = "system_id")
	public Integer getSystemId() {
		return systemId;
	}

	/**
	 * Sets system id.
	 *
	 * @param systemId the system id
	 */
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	/**
	 * Gets citl bct.
	 *
	 * @return the citl bct
	 */
	@Column(name = "citl_bct")
	public Date getCitlBct() {
		return citlBct;
	}

	/**
	 * Sets citl bct.
	 *
	 * @param citlBct the citl bct
	 */
	public void setCitlBct(Date citlBct) {
		this.citlBct = citlBct;
	}

	/**
	 * Gets citl ect.
	 *
	 * @return the citl ect
	 */
	@Column(name = "citl_ect")
	public Date getCitlEct() {
		return citlEct;
	}

	/**
	 * Sets citl ect.
	 *
	 * @param citlEct the citl ect
	 */
	public void setCitlEct(Date citlEct) {
		this.citlEct = citlEct;
	}

	/**
	 * Gets citl sbct.
	 *
	 * @return the citl sbct
	 */
	@Column(name = "citl_sbct")
	public Date getCitlSbct() {
		return citlSbct;
	}

	/**
	 * Sets citl sbct.
	 *
	 * @param citlSbct the citl sbct
	 */
	public void setCitlSbct(Date citlSbct) {
		this.citlSbct = citlSbct;
	}

	/**
	 * Gets parent user id.
	 *
	 * @return the parent user id
	 */
	@Column(name = "parent_user_id")
	public Integer getParentUserId() {
		return parentUserId;
	}

	/**
	 * Sets parent user id.
	 *
	 * @param parentUserId the parent user id
	 */
	public void setParentUserId(Integer parentUserId) {
		this.parentUserId = parentUserId;
	}

	@OneToOne(mappedBy = "workAppUser")
	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof WorkAppUser)) return false;
		WorkAppUser that = (WorkAppUser) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public String toString() {
		return "WorkAppUser{" +
				"id=" + id +
				", login='" + login + '\'' +
				", extNumberId=" + extNumberId +
				", statusId=" + statusId +
				", ipAddress='" + ipAddress + '\'' +
				", atsUserId=" + atsUserId +
				", phoneIpAddress='" + phoneIpAddress + '\'' +
				", disabled=" + disabled +
				", statusDate=" + statusDate +
				", name='" + name + '\'' +
				", oRouteId=" + oRouteId +
				", systemId=" + systemId +
				", citlBct=" + citlBct +
				", citlEct=" + citlEct +
				", citlSbct=" + citlSbct +
				", parentUserId=" + parentUserId +
				'}';
	}
}
