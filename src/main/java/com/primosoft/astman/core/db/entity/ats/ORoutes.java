package com.primosoft.astman.core.db.entity.ats;

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
@Table(name = "o_routes", schema = "ats")
@NamedQueries({
		@NamedQuery(name = "ORoutes.findAll", query = "SELECT o FROM ORoutes o")
})
public class ORoutes implements Model<BigInteger> {
	private static final long serialVersionUID = 9120691852462311538L;

	private BigInteger id;
	private String name;
	private int stateId;

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

	@Column(name = "state_id")
	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ORoutes)) return false;
		ORoutes oRoutes = (ORoutes) o;
		return Objects.equals(id, oRoutes.id);
	}

	@Override
	public String toString() {
		return "ORoutes{" +
				"id=" + id +
				", name='" + name + '\'' +
				", stateId=" + stateId +
				'}';
	}
}
