package com.primosoft.astman.core.db.dao;

import com.primosoft.astman.core.db.entity.dlr.DlrCalls;

import java.math.BigInteger;

/**
 * Created on 22.09.16.
 *
 * @author atelizhenko
 */
public interface IDlrCallsDao extends IGenericDao<BigInteger, DlrCalls> {
	BigInteger getNextLineal(BigInteger campaignId);

	BigInteger getNextTop(BigInteger campaignId);
}
