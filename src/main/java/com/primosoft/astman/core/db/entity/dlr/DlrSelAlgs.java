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
@Table(name = "selalgs", schema = "dlr")
@NamedQueries({
		@NamedQuery(name = "DlrSelAlgs.findAll", query = "SELECT d FROM DlrSelAlgs d")
})
public class DlrSelAlgs implements Model<BigInteger> {
	private static final long serialVersionUID = -5975467599542654939L;

	private BigInteger id;
	private String description;
	private boolean disabled;

	@Id
	@Override
	@Column(name = "id")
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DlrSelAlgs)) return false;
		DlrSelAlgs that = (DlrSelAlgs) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public String toString() {
		return "DlrSelAlgs{" +
				"id=" + id +
				", description='" + description + '\'' +
				", disabled=" + disabled +
				'}';
	}
}
