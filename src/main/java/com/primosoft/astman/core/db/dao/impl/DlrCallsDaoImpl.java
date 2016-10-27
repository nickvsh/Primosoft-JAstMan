package com.primosoft.astman.core.db.dao.impl;

import com.primosoft.astman.core.db.dao.IDlrCallsDao;
import com.primosoft.astman.core.db.dao.IGenericDao;
import com.primosoft.astman.core.db.entity.dlr.DlrCalls;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

/**
 * Created on 22.09.16.
 *
 * @author atelizhenko
 */
@Repository(value = "dlrCallsDao")
@Transactional(readOnly = true)
public class DlrCallsDaoImpl extends GenericDao<BigInteger, DlrCalls> implements IDlrCallsDao, IGenericDao<BigInteger, DlrCalls> {
	private static final long serialVersionUID = 5442041756323441148L;

	@Override
	@Transactional
	public BigInteger getNextLineal(BigInteger campaignId) {
		final List<BigInteger> result = executeFunction(
				createCallFunction(DLR_SCHEMA, NEXT_LINEAL, 1),
				Collections.singletonList(new FunctionParameter(campaignId.intValue())),
				resultSet -> BigInteger.valueOf(resultSet.getLong(1))
		);
		return result.stream().findFirst().orElse(BigInteger.ZERO);
	}

	@Override
	@Transactional
	public BigInteger getNextTop(BigInteger campaignId) {
		final List<BigInteger> result = executeFunction(
				createCallFunction(DLR_SCHEMA, NEXT_TOP, 1),
				Collections.singletonList(new FunctionParameter(campaignId.intValue())),
				resultSet -> BigInteger.valueOf(resultSet.getLong(1))
		);
		return result.stream().findFirst().orElse(BigInteger.ZERO);
	}
}
