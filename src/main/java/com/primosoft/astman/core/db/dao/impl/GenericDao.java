/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 23.05.16.
 *
 * @author atelizhenko
 */
@Transactional(readOnly = true)
public abstract class GenericDao<Id extends Serializable, Entity extends Model<Id>> implements IGenericDao<Id, Entity> {
	private static final long serialVersionUID = -2516521494075863258L;

	private JdbcTemplate jdbcTemplate;
	@PersistenceContext
	private EntityManager entityManager;
	private Class<Entity> templateClass;

	@Autowired
	@SuppressWarnings("unchecked")
	public GenericDao() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		final Type[] actualTypeArguments = type.getActualTypeArguments();
		final Type actualTypeArgument = actualTypeArguments[1];
		templateClass = (Class<Entity>) actualTypeArgument;
	}

	/**
	 * Save current entity
	 *
	 * @param entity entity to save
	 * @return saved entity
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public Entity save(Entity entity) {
		entityManager.persist(entity);
		return entity;
	}

	/**
	 * Get current entity by identifier
	 *
	 * @param id identifier of entity
	 * @return entity
	 */
	public Entity getById(Id id) {
		return entityManager.find(templateClass, id);
	}

	/**
	 * Get list of all entities
	 *
	 * @return list of all entities
	 */
	public List<Entity> getAll() {
		return entityManager.createQuery(String.format(
				"SELECT o FROM %s o", templateClass.getSimpleName()),
				templateClass).getResultList();
	}

	/**
	 * Delete current entity
	 *
	 * @param entity entity to delete
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public void delete(Entity entity) {
		entityManager.remove(entity);
	}

	/**
	 * Execute function and return list of results
	 *
	 * @param functionName  full name of function
	 * @param parameterList parameters
	 * @param result        result binding
	 * @param <T>           generic result
	 * @return list of generic results
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public <T> List<T> executeFunction(final String functionName, List<FunctionParameter> parameterList, FunctionResult<T> result) {
		return jdbcTemplate.execute(
				(CallableStatementCreator) con -> con.prepareCall(functionName),
				cs -> {
					buildParameters(cs, parameterList);

					final ResultSet resultSet = cs.executeQuery();
					final List<T> resultList = new ArrayList<>();
					while (resultSet.next()) {
						resultList.add(result.buildResult(resultSet));
					}

					return Collections.unmodifiableList(resultList);
				});
	}

	private void buildParameters(CallableStatement callableStatement, List<FunctionParameter> parameterList) throws SQLException {
		int index = 0;
		for (FunctionParameter parameter : parameterList) {
			final String parameterName = parameter.getParameterName();
			final Object parameterValue = parameter.getParameterValue();

			++index;

			if (parameterName == null || parameterName.isEmpty()) {
				callableStatement.setObject(index, parameterValue);
			} else {
				callableStatement.setObject(parameterName, parameterValue);
			}
		}
	}

	/**
	 * Execute function
	 *
	 * @param functionName  full name of function
	 * @param parameterList parameters
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public void executeFunction(final String functionName, List<FunctionParameter> parameterList) {
		jdbcTemplate.execute(
				(CallableStatementCreator) con -> con.prepareCall(functionName),
				cs -> {
					buildParameters(cs, parameterList);

					cs.execute();
					return null;
				});
	}

	final EntityManager getEntityManager() {
		return entityManager;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
