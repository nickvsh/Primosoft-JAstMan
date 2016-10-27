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
@Table(name = "callbacks", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "CallBacks.findAll", query = "SELECT c FROM CallBack c")
})
public class CallBack implements Model<BigInteger> {
	private static final long serialVersionUID = -117070744473311647L;

	private BigInteger id;
	private String number;
	private Group group;
	private ExtNumber extNumber;
	private CallBackStatus callBackStatus;
	private Date beginDate;
	private Date endDate;
	private Operator operator;
	private String uid;

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
	 * Gets group.
	 *
	 * @return the group
	 */
	@ManyToOne
	@JoinColumn(name = "group_id", referencedColumnName = "id")
	public Group getGroup() {
		return group;
	}

	/**
	 * Sets group.
	 *
	 * @param group the group
	 */
	public void setGroup(Group group) {
		this.group = group;
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
	 * Gets call back statuses.
	 *
	 * @return the call back statuses
	 */
	@ManyToOne
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	public CallBackStatus getCallBackStatus() {
		return callBackStatus;
	}

	/**
	 * Sets call back statuses.
	 *
	 * @param callBackStatus the call back statuses
	 */
	public void setCallBackStatus(CallBackStatus callBackStatus) {
		this.callBackStatus = callBackStatus;
	}

	/**
	 * Gets begin date.
	 *
	 * @return the begin date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "begin_date")
	public Date getBeginDate() {
		return beginDate;
	}

	/**
	 * Sets begin date.
	 *
	 * @param beginDate the begin date
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * Gets end date.
	 *
	 * @return the end date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets end date.
	 *
	 * @param endDate the end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets operator.
	 *
	 * @return the operator
	 */
	@ManyToOne
	@JoinColumn(name = "answered_operator_id", referencedColumnName = "id")
	public Operator getOperator() {
		return operator;
	}

	/**
	 * Sets operator.
	 *
	 * @param operator the operator
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	/**
	 * Gets uid.
	 *
	 * @return the uid
	 */
	@Column(name = "uid")
	public String getUid() {
		return uid;
	}

	/**
	 * Sets uid.
	 *
	 * @param uid the uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CallBack)) return false;
		CallBack callBack = (CallBack) o;
		return Objects.equals(id, callBack.id);
	}

	@Override
	public String toString() {
		return "CallBack{" +
				"id=" + id +
				", number='" + number + '\'' +
				", group=" + group +
				", extNumber=" + extNumber +
				", callBackStatus=" + callBackStatus +
				", beginDate=" + beginDate +
				", endDate=" + endDate +
				", operator=" + operator +
				", uid='" + uid + '\'' +
				'}';
	}
}
