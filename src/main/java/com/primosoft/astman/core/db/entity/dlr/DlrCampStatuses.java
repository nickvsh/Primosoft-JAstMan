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
@Table(name = "camp_statuses", schema = "dlr")
@NamedQueries({
		@NamedQuery(name = "DlrCampStatuses.findAll", query = "SELECT d FROM DlrCampStatuses d")
})
public class DlrCampStatuses implements Model<BigInteger> {
	private static final long serialVersionUID = 8067434294950029063L;

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
		if (!(o instanceof DlrCampStatuses)) return false;
		DlrCampStatuses that = (DlrCampStatuses) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public String toString() {
		return "DlrCampStatuses{" +
				"id=" + id +
				", description='" + description + '\'' +
				", disabled=" + disabled +
				'}';
	}
}
