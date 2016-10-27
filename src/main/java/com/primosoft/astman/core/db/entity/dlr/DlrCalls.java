package com.primosoft.astman.core.db.entity.dlr;

import com.primosoft.astman.core.db.entity.Model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created on 22.09.16.
 *
 * @author atelizhenko
 */
@Entity
@Table(name = "calls", schema = "dlr")
@NamedQueries({
		@NamedQuery(name = "DlrCalls.findAll", query = "SELECT d FROM DlrCalls d")
})
public class DlrCalls implements Model<BigInteger> {
	private static final long serialVersionUID = 2692655672584662514L;

	private BigInteger id;
	private String number;
	private Long caseId;
	private Integer serial;
	private Integer priority;
	private Short retries;
	private Short maxRetr;
	private String dstOper;
	private String answOper;
	private Long clientId;
	private Long srcPhoneId;
	private Long lastAttemptId;

	@Id
	@Column(name = "id", nullable = false)
	@Override
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Basic
	@Column(name = "number", nullable = false, length = -1)
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Basic
	@Column(name = "case_id", nullable = true)
	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}

	@Basic
	@Column(name = "serial", nullable = true)
	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	@Basic
	@Column(name = "priority", nullable = true)
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Basic
	@Column(name = "retries", nullable = false)
	public Short getRetries() {
		return retries;
	}

	public void setRetries(Short retries) {
		this.retries = retries;
	}

	@Basic
	@Column(name = "max_retr", nullable = true)
	public Short getMaxRetr() {
		return maxRetr;
	}

	public void setMaxRetr(Short maxRetr) {
		this.maxRetr = maxRetr;
	}

	@Basic
	@Column(name = "dst_oper", nullable = true, length = -1)
	public String getDstOper() {
		return dstOper;
	}

	public void setDstOper(String dstOper) {
		this.dstOper = dstOper;
	}

	@Basic
	@Column(name = "answ_oper", nullable = true, length = -1)
	public String getAnswOper() {
		return answOper;
	}

	public void setAnswOper(String answOper) {
		this.answOper = answOper;
	}

	@Basic
	@Column(name = "client_id", nullable = true)
	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	@Basic
	@Column(name = "src_phone_id", nullable = true)
	public Long getSrcPhoneId() {
		return srcPhoneId;
	}

	public void setSrcPhoneId(Long srcPhoneId) {
		this.srcPhoneId = srcPhoneId;
	}

	@Basic
	@Column(name = "last_attempt_id", nullable = true)
	public Long getLastAttemptId() {
		return lastAttemptId;
	}

	public void setLastAttemptId(Long lastAttemptId) {
		this.lastAttemptId = lastAttemptId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, number, caseId, serial, priority, retries, maxRetr, dstOper, answOper, clientId,
				srcPhoneId, lastAttemptId);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DlrCalls dlrCalls = (DlrCalls) o;
		return Objects.equals(id, dlrCalls.id) &&
				Objects.equals(number, dlrCalls.number) &&
				Objects.equals(caseId, dlrCalls.caseId) &&
				Objects.equals(serial, dlrCalls.serial) &&
				Objects.equals(priority, dlrCalls.priority) &&
				Objects.equals(retries, dlrCalls.retries) &&
				Objects.equals(maxRetr, dlrCalls.maxRetr) &&
				Objects.equals(dstOper, dlrCalls.dstOper) &&
				Objects.equals(answOper, dlrCalls.answOper) &&
				Objects.equals(clientId, dlrCalls.clientId) &&
				Objects.equals(srcPhoneId, dlrCalls.srcPhoneId) &&
				Objects.equals(lastAttemptId, dlrCalls.lastAttemptId);
	}
}
