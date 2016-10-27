package com.primosoft.astman.core.db.entity.dlr;

import com.primosoft.astman.core.db.entity.Model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

/**
 * Created on 29.09.16.
 *
 * @author atelizhenko
 */
@Entity
@Table(name = "ivrs", schema = "dlr")
@NamedQueries({
		@NamedQuery(name = "DlrIvrs.findAll", query = "SELECT d FROM DlrIvrs d")
})
public class DlrIvrs implements Model<BigInteger> {
	private static final long serialVersionUID = 1279221587226605165L;

	private BigInteger id;
	private String name;
	private boolean disabled;
	private Date createDate;

	@Id
	@Override
	@Column(name = "id")
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "disabled")
	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creating_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DlrIvrs)) return false;
		DlrIvrs dlrIvrs = (DlrIvrs) o;
		return Objects.equals(id, dlrIvrs.id);
	}

	@Override
	public String toString() {
		return "DlrIvrs{" +
				"id=" + id +
				", name='" + name + '\'' +
				", disabled=" + disabled +
				", createDate=" + createDate +
				'}';
	}
}
