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
@Table(name = "methods", schema = "dlr")
@NamedQueries({
		@NamedQuery(name = "DlrMethods.findAll", query = "SELECT d FROM DlrMethods d")
})
public class DlrMethods implements Model<BigInteger> {
	private static final long serialVersionUID = 6919416831279594428L;

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
		if (!(o instanceof DlrMethods)) return false;
		DlrMethods that = (DlrMethods) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public String toString() {
		return "DlrMethods{" +
				"id=" + id +
				", description='" + description + '\'' +
				", disabled=" + disabled +
				'}';
	}
}
