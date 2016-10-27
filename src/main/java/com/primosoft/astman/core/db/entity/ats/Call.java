/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats;

import com.primosoft.astman.core.db.entity.Model;
import com.primosoft.astman.core.db.entity.listener.CallsListener;

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
@EntityListeners(CallsListener.class)
@Table(name = "calls", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "Calls.findAll", query = "SELECT c FROM Call c")
})
public class Call implements Model<BigInteger> {
	private static final long serialVersionUID = 3140274642492902785L;

	private BigInteger id;
	private String number;
	private BigInteger operatorId;
	private BigInteger insideStatusId;
	private BigInteger typeId;
	private BigInteger groupId;
	private BigInteger extNumberId;
	private Date beginDate;
	private BigInteger callRecordId;
	private String context;
	private String uid;
	private String insideChannel;
	private String outsideChannel;
	private BigInteger outsideStatusId;
	private Date insideAnswerTime;
	private Date outsideAnswerTime;
	private WorkAppUser workAppUser;
	private Date endDate;
	private String cdrUniqueId;

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
	 * Gets operator id.
	 *
	 * @return the operator id
	 */
	@Column(name = "operator_id")
	public BigInteger getOperatorId() {
		return operatorId;
	}

	/**
	 * Sets operator id.
	 *
	 * @param operatorId the operator id
	 */
	public void setOperatorId(BigInteger operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * Gets inside status id.
	 *
	 * @return the inside status id
	 */
	@Column(name = "inside_status_id")
	public BigInteger getInsideStatusId() {
		return insideStatusId;
	}

	/**
	 * Sets inside status id.
	 *
	 * @param insideStatusId the inside status id
	 */
	public void setInsideStatusId(BigInteger insideStatusId) {
		this.insideStatusId = insideStatusId;
	}

	/**
	 * Gets type id.
	 *
	 * @return the type id
	 */
	@Column(name = "type_id")
	public BigInteger getTypeId() {
		return typeId;
	}

	/**
	 * Sets type id.
	 *
	 * @param typeId the type id
	 */
	public void setTypeId(BigInteger typeId) {
		this.typeId = typeId;
	}

	/**
	 * Gets group id.
	 *
	 * @return the group id
	 */
	@Column(name = "group_id")
	public BigInteger getGroupId() {
		return groupId;
	}

	/**
	 * Sets group id.
	 *
	 * @param groupId the group id
	 */
	public void setGroupId(BigInteger groupId) {
		this.groupId = groupId;
	}

	/**
	 * Gets ext number id.
	 *
	 * @return the ext number id
	 */
	@Column(name = "ext_number_id")
	public BigInteger getExtNumberId() {
		return extNumberId;
	}

	/**
	 * Sets ext number id.
	 *
	 * @param extNumberId the ext number id
	 */
	public void setExtNumberId(BigInteger extNumberId) {
		this.extNumberId = extNumberId;
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
	 * Gets call record id.
	 *
	 * @return the call record id
	 */
	@Column(name = "callrecord_id")
	public BigInteger getCallRecordId() {
		return callRecordId;
	}

	/**
	 * Sets call record id.
	 *
	 * @param callRecordId the call record id
	 */
	public void setCallRecordId(BigInteger callRecordId) {
		this.callRecordId = callRecordId;
	}

	/**
	 * Gets context.
	 *
	 * @return the context
	 */
	@Column(name = "context")
	public String getContext() {
		return context;
	}

	/**
	 * Sets context.
	 *
	 * @param context the context
	 */
	public void setContext(String context) {
		this.context = context;
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

	/**
	 * Gets inside channel.
	 *
	 * @return the inside channel
	 */
	@Column(name = "inside_channel")
	public String getInsideChannel() {
		return insideChannel;
	}

	/**
	 * Sets inside channel.
	 *
	 * @param insideChannel the inside channel
	 */
	public void setInsideChannel(String insideChannel) {
		this.insideChannel = insideChannel;
	}

	/**
	 * Gets outside channel.
	 *
	 * @return the outside channel
	 */
	@Column(name = "outside_channel")
	public String getOutsideChannel() {
		return outsideChannel;
	}

	/**
	 * Sets outside channel.
	 *
	 * @param outsideChannel the outside channel
	 */
	public void setOutsideChannel(String outsideChannel) {
		this.outsideChannel = outsideChannel;
	}

	/**
	 * Gets outside status id.
	 *
	 * @return the outside status id
	 */
	@Column(name = "outside_status_id")
	public BigInteger getOutsideStatusId() {
		return outsideStatusId;
	}

	/**
	 * Sets outside status id.
	 *
	 * @param outsideStatusId the outside status id
	 */
	public void setOutsideStatusId(BigInteger outsideStatusId) {
		this.outsideStatusId = outsideStatusId;
	}

	/**
	 * Gets inside answer time.
	 *
	 * @return the inside answer time
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "inside_answ_time")
	public Date getInsideAnswerTime() {
		return insideAnswerTime;
	}

	/**
	 * Sets inside answer time.
	 *
	 * @param insideAnswerTime the inside answer time
	 */
	public void setInsideAnswerTime(Date insideAnswerTime) {
		this.insideAnswerTime = insideAnswerTime;
	}

	/**
	 * Gets outside answer time.
	 *
	 * @return the outside answer time
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "outside_answ_time")
	public Date getOutsideAnswerTime() {
		return outsideAnswerTime;
	}

	/**
	 * Sets outside answer time.
	 *
	 * @param outsideAnswerTime the outside answer time
	 */
	public void setOutsideAnswerTime(Date outsideAnswerTime) {
		this.outsideAnswerTime = outsideAnswerTime;
	}

	/**
	 * Gets work app users.
	 *
	 * @return the work app users
	 */
	@ManyToOne
	@JoinColumn(name = "work_app_user_id", referencedColumnName = "id")
	public WorkAppUser getWorkAppUser() {
		return workAppUser;
	}

	/**
	 * Sets work app users.
	 *
	 * @param workAppUser the work app users
	 */
	public void setWorkAppUser(WorkAppUser workAppUser) {
		this.workAppUser = workAppUser;
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
	 * Gets cdr unique id.
	 *
	 * @return the cdr unique id
	 */
	@Column(name = "cdr_uniqid")
	public String getCdrUniqueId() {
		return cdrUniqueId;
	}

	/**
	 * Sets cdr unique id.
	 *
	 * @param cdrUniqueId the cdr unique id
	 */
	public void setCdrUniqueId(String cdrUniqueId) {
		this.cdrUniqueId = cdrUniqueId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Call)) return false;
		Call call = (Call) o;
		return Objects.equals(id, call.id);
	}

	@Override
	public String toString() {
		return "Call{" +
				"id=" + id +
				", number='" + number + '\'' +
				", operatorId=" + operatorId +
				", insideStatusId=" + insideStatusId +
				", typeId=" + typeId +
				", groupId=" + groupId +
				", extNumberId=" + extNumberId +
				", beginDate=" + beginDate +
				", callRecordId=" + callRecordId +
				", context='" + context + '\'' +
				", uid='" + uid + '\'' +
				", insideChannel='" + insideChannel + '\'' +
				", outsideChannel='" + outsideChannel + '\'' +
				", outsideStatusId=" + outsideStatusId +
				", insideAnswerTime=" + insideAnswerTime +
				", outsideAnswerTime=" + outsideAnswerTime +
				", workAppUser=" + workAppUser +
				", endDate=" + endDate +
				", cdrUniqueId='" + cdrUniqueId + '\'' +
				'}';
	}
}
