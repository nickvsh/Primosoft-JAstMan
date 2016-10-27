/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import java.util.Objects;

/**
 * Created on 05.09.16.
 *
 * @author atelizhenko
 */
public final class FunctionParameter {
	private String parameterName;
	private Object parameterValue;

	public FunctionParameter() {
	}

	public FunctionParameter(Object parameterValue) {
		this.parameterValue = parameterValue;
	}

	public FunctionParameter(String parameterName, Object parameterValue) {
		this.parameterName = parameterName;
		this.parameterValue = parameterValue;
	}

	String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	Object getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(Object parameterValue) {
		this.parameterValue = parameterValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(parameterName, parameterValue);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FunctionParameter)) return false;
		FunctionParameter that = (FunctionParameter) o;
		return Objects.equals(parameterName, that.parameterName) &&
				Objects.equals(parameterValue, that.parameterValue);
	}

	@Override
	public String toString() {
		return "FunctionParameter{" +
				"parameterName='" + parameterName + '\'' +
				", parameterValue=" + parameterValue +
				'}';
	}
}
