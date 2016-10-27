/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats;

import com.primosoft.astman.core.db.entity.Model;
import com.primosoft.astman.core.db.entity.listener.CallRecordsListener;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

/**
 * Created on 08.06.16.
 *
 * @author atelizhenko
 */
@Entity
@Table(name = "callrecords", schema = "ats")
@EntityListeners(CallRecordsListener.class)
@NamedQueries({
		@NamedQuery(name = "CallRecords.findAll", query = "SELECT c FROM CallRecord c")
})
public class CallRecord implements Model<BigInteger> {
	private static final long serialVersionUID = -2559800993361732904L;

	private BigInteger id;
	private String fileName;
	private Date date;
	private Integer length;
	private Call call;

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
	 * Gets file name.
	 *
	 * @return the file name
	 */
	@Column(name = "filename")
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets file name.
	 *
	 * @param fileName the file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Gets date.
	 *
	 * @return the date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	/**
	 * Sets date.
	 *
	 * @param date the date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets length.
	 *
	 * @return the length
	 */
	@Column(name = "length")
	public Integer getLength() {
		return length;
	}

	/**
	 * Sets length.
	 *
	 * @param length the length
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * Gets call.
	 *
	 * @return the call
	 */
	@ManyToOne
	@JoinColumn(name = "call_id", referencedColumnName = "id")
	public Call getCall() {
		return call;
	}

	/**
	 * Sets call.
	 *
	 * @param call the call
	 */
	public void setCall(Call call) {
		this.call = call;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CallRecord)) return false;
		CallRecord that = (CallRecord) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public String toString() {
		return "CallRecord{" +
				"id=" + id +
				", fileName='" + fileName + '\'' +
				", date=" + date +
				", length=" + length +
				", call=" + call +
				'}';
	}
}
