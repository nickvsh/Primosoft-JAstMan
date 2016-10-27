/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats.pk;

import com.primosoft.astman.core.db.entity.EmbeddedModel;
import com.primosoft.astman.core.db.entity.ats.Group;
import com.primosoft.astman.core.db.entity.ats.Operator;
import com.primosoft.astman.core.db.entity.ats.RelOpGr;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * Created on 08.06.16.
 * Embeddable class for two PK for {@link RelOpGr}
 *
 * @author atelizhenko
 */
@Embeddable
public class RelOpGrPK implements EmbeddedModel {
	private static final long serialVersionUID = 3742493082548264416L;

	private Group group;
	private Operator operator;

	/**
	 * Gets group.
	 *
	 * @return the group
	 */
	@ManyToOne
	@JoinColumn(name = "group_id", referencedColumnName = "id")
	public Group getGroup() {
		return group;
	}

	/**
	 * Sets group.
	 *
	 * @param group the group
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * Gets operator.
	 *
	 * @return the operator
	 */
	@ManyToOne
	@JoinColumn(name = "operator_id", referencedColumnName = "id")
	public Operator getOperator() {
		return operator;
	}

	/**
	 * Sets operator.
	 *
	 * @param operator the operator
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RelOpGrPK)) return false;
		RelOpGrPK relOpGrPK = (RelOpGrPK) o;
		return Objects.equals(group, relOpGrPK.group) &&
				Objects.equals(operator, relOpGrPK.operator);
	}

	@Override
	public int hashCode() {
		return Objects.hash(group, operator);
	}
}
