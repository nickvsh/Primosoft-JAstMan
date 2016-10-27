package com.primosoft.astman.core.db.entity.dlr;

import com.primosoft.astman.core.db.entity.Model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created on 29.09.16.
 *
 * @author atelizhenko
 */
@Entity
@Table(name = "method_forms", schema = "dlr")
@NamedQueries({
		@NamedQuery(name = "DlrMethodForms.findAll", query = "SELECT d FROM DlrMethodForms d")
})
public class DlrMethodForms implements Model<BigInteger> {
	private static final long serialVersionUID = 2061189178953271221L;

	private BigInteger id;
	private DlrMethods dlrMethods;
	private String description;
	private boolean disabled;
	private String name;
	private DlrIvms dlrIvms;
	private DlrIvrs dlrIvrs;

	@Id
	@Override
	@Column(name = "id")
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "method_id", referencedColumnName = "id")
	public DlrMethods getDlrMethods() {
		return dlrMethods;
	}

	public void setDlrMethods(DlrMethods dlrMethods) {
		this.dlrMethods = dlrMethods;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "disabled")
	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "ivm_id", referencedColumnName = "id")
	public DlrIvms getDlrIvms() {
		return dlrIvms;
	}

	public void setDlrIvms(DlrIvms dlrIvms) {
		this.dlrIvms = dlrIvms;
	}

	@ManyToOne
	@JoinColumn(name = "ivr_id", referencedColumnName = "id")
	public DlrIvrs getDlrIvrs() {
		return dlrIvrs;
	}

	public void setDlrIvrs(DlrIvrs dlrIvrs) {
		this.dlrIvrs = dlrIvrs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DlrMethodForms)) return false;
		DlrMethodForms that = (DlrMethodForms) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public String toString() {
		return "DlrMethodForms{" +
				"id=" + id +
				", dlrMethods=" + dlrMethods +
				", description='" + description + '\'' +
				", disabled=" + disabled +
				", name='" + name + '\'' +
				", dlrIvms=" + dlrIvms +
				", dlrIvrs=" + dlrIvrs +
				'}';
	}
}
