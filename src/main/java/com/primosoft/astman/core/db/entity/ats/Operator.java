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
@Table(name = "operators", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "Operators.findBySipUser",
				query = "SELECT o FROM Operator o WHERE o.sipUser.id = :sipUserId"),
		@NamedQuery(name = "Operators.findByUserId",
				query = "SELECT o FROM Operator o WHERE o.workAppUser.id = :userId"),
		@NamedQuery(name = "Operators.findByUserIdList",
				query = "SELECT o FROM Operator o WHERE o.workAppUser.id in :userIdList"),
		@NamedQuery(name = "Operators.findAll", query = "SELECT o FROM Operator o")
})
public class Operator implements Model<BigInteger> {
	private static final long serialVersionUID = -4186974053968799392L;

	private BigInteger id;
	private SipUser sipUser;
	private String login;
	private ExtNumber extNumber;
	private boolean logined;
	private OperatorStatus operatorStatus;
	private boolean disabled;
	private String pcIpAddress;
	private WorkAppUser workAppUser;
	private String phoneIpAddress;

	/**
	 * Getter
	 *
	 * @return id
	 */
	@Id
	@Override
	@Column(name = "id")
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
	 * Gets sip users.
	 *
	 * @return the sip users
	 */
	@ManyToOne
	@JoinColumn(name = "sip_user_id", referencedColumnName = "id")
	public SipUser getSipUser() {
		return sipUser;
	}

	/**
	 * Sets sip users.
	 *
	 * @param sipUser the sip users
	 */
	public void setSipUser(SipUser sipUser) {
		this.sipUser = sipUser;
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
	 * Is logined boolean.
	 *
	 * @return the boolean
	 */
	@Column(name = "logined")
	public boolean isLogined() {
		return logined;
	}

	/**
	 * Sets logined.
	 *
	 * @param logined the logined
	 */
	public void setLogined(boolean logined) {
		this.logined = logined;
	}

	/**
	 * Gets operator statuses.
	 *
	 * @return the operator statuses
	 */
	@ManyToOne
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	public OperatorStatus getOperatorStatus() {
		return operatorStatus;
	}

	/**
	 * Sets operator statuses.
	 *
	 * @param operatorStatus the operator statuses
	 */
	public void setOperatorStatus(OperatorStatus operatorStatus) {
		this.operatorStatus = operatorStatus;
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
	 * Gets pc ip address.
	 *
	 * @return the pc ip address
	 */
	@Column(name = "pc_ipaddr")
	public String getPcIpAddress() {
		return pcIpAddress;
	}

	/**
	 * Sets pc ip address.
	 *
	 * @param pcIpAddress the pc ip address
	 */
	public void setPcIpAddress(String pcIpAddress) {
		this.pcIpAddress = pcIpAddress;
	}

	@OneToOne
	@JoinColumn(name = "smyk_user_id", referencedColumnName = "id")
	public WorkAppUser getWorkAppUser() {
		return workAppUser;
	}

	public void setWorkAppUser(WorkAppUser workAppUser) {
		this.workAppUser = workAppUser;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, sipUser, login, extNumber, logined, operatorStatus, disabled, pcIpAddress,
				workAppUser, phoneIpAddress);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Operator)) return false;
		Operator operator = (Operator) o;
		return logined == operator.logined &&
				disabled == operator.disabled &&
				Objects.equals(id, operator.id) &&
				Objects.equals(sipUser, operator.sipUser) &&
				Objects.equals(login, operator.login) &&
				Objects.equals(extNumber, operator.extNumber) &&
				Objects.equals(operatorStatus, operator.operatorStatus) &&
				Objects.equals(pcIpAddress, operator.pcIpAddress) &&
				Objects.equals(workAppUser, operator.workAppUser) &&
				Objects.equals(phoneIpAddress, operator.phoneIpAddress);
	}

	@Override
	public String toString() {
		return "Operator{" +
				"id=" + id +
				", sipUser=" + sipUser +
				", login='" + login + '\'' +
				", extNumber=" + extNumber +
				", logined=" + logined +
				", operatorStatus=" + operatorStatus +
				", disabled=" + disabled +
				", pcIpAddress='" + pcIpAddress + '\'' +
				", workAppUser=" + workAppUser +
				", phoneIpAddress='" + phoneIpAddress + '\'' +
				'}';
	}
}
