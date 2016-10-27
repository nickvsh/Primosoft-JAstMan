/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats;

import com.primosoft.astman.core.db.entity.Model;
import com.primosoft.astman.core.db.entity.listener.CbCallsListener;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created on 08.06.16.
 *
 * @author atelizhenko
 */
@Entity
@EntityListeners(CbCallsListener.class)
@Table(name = "cb_calls", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "CbCalls.findAll", query = "SELECT c FROM CbCall c")
})
public class CbCall implements Model<BigInteger> {
	private static final long serialVersionUID = -2969977393463925490L;

	private BigInteger id;
	private Call srcCall;
	private WorkAppGroup groups;
	private Integer stateId;
	private Character direction;
	private Call backCall;
	private Integer priority;

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
	 * Gets src calls.
	 *
	 * @return the src calls
	 */
	@ManyToOne
	@JoinColumn(name = "src_call_id", referencedColumnName = "id")
	public Call getSrcCall() {
		return srcCall;
	}

	/**
	 * Sets src calls.
	 *
	 * @param srcCall the src calls
	 */
	public void setSrcCall(Call srcCall) {
		this.srcCall = srcCall;
	}

	/**
	 * Gets groups.
	 *
	 * @return the groups
	 */
	@ManyToOne
	@JoinColumn(name = "group_id", referencedColumnName = "id")
	public WorkAppGroup getGroups() {
		return groups;
	}

	/**
	 * Sets groups.
	 *
	 * @param groups the groups
	 */
	public void setGroups(WorkAppGroup groups) {
		this.groups = groups;
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

	/**
	 * Gets direction.
	 *
	 * @return the direction
	 */
	@Column(name = "direction")
	public Character getDirection() {
		return direction;
	}

	/**
	 * Sets direction.
	 *
	 * @param direction the direction
	 */
	public void setDirection(Character direction) {
		this.direction = direction;
	}

	/**
	 * Gets back calls.
	 *
	 * @return the back calls
	 */
	@ManyToOne
	@JoinColumn(name = "back_call_id", referencedColumnName = "id")
	public Call getBackCall() {
		return backCall;
	}

	/**
	 * Sets back calls.
	 *
	 * @param backCall the back calls
	 */
	public void setBackCall(Call backCall) {
		this.backCall = backCall;
	}

	/**
	 * Gets priority.
	 *
	 * @return the priority
	 */
	@Column(name = "priority")
	public Integer getPriority() {
		return priority;
	}

	/**
	 * Sets priority.
	 *
	 * @param priority the priority
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CbCall)) return false;
		CbCall cbCall = (CbCall) o;
		return Objects.equals(id, cbCall.id);
	}

	@Override
	public String toString() {
		return "CbCall{" +
				"id=" + id +
				", srcCall=" + srcCall +
				", groups=" + groups +
				", stateId=" + stateId +
				", direction=" + direction +
				", backCall=" + backCall +
				", priority=" + priority +
				'}';
	}
}
