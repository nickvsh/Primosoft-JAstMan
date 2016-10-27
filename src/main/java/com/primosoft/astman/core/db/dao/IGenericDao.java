/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao;

import com.primosoft.astman.core.db.dao.impl.FunctionParameter;
import com.primosoft.astman.core.db.dao.impl.FunctionResult;
import com.primosoft.astman.core.db.entity.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 23.05.16.
 * Generic dao interface for base methods with data base.
 *
 * @author atelizhenko
 */
public interface IGenericDao<Id extends Serializable, Entity extends Model<Id>> extends Serializable, FunctionalNamesConstant {
	/**
	 * Save current entity
	 *
	 * @param entity entity to save
	 * @return saved entity
	 */
	Entity save(Entity entity);

	/**
	 * Get current entity by identifier
	 *
	 * @param id identifier of entity
	 * @return entity
	 */
	Entity getById(Id id);

	/**
	 * Get list of all entities
	 *
	 * @return list of all entities
	 */
	List<Entity> getAll();

	/**
	 * Delete current entity
	 *
	 * @param entity entity to delete
	 */
	void delete(Entity entity);

	/**
	 * Execute function and return list of results
	 *
	 * @param functionName  full name of function
	 * @param parameterList parameters
	 * @param result        result binding
	 * @param <T>           generic result
	 * @return list of generic results
	 */
	<T> List<T> executeFunction(final String functionName, List<FunctionParameter> parameterList, FunctionResult<T> result);

	/**
	 * Execute function
	 *
	 * @param functionName  full name of function
	 * @param parameterList parameters
	 */
	void executeFunction(final String functionName, List<FunctionParameter> parameterList);
}
