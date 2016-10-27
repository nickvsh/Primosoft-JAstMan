package com.primosoft.astman.core.ast.algorithm;

import com.primosoft.astman.core.db.entity.dlr.DlrCalls;

import java.math.BigInteger;

/**
 * Created on 22.09.16.
 *
 * @author atelizhenko
 */
public interface CallAlgorithm extends Algorithm<DlrCalls, BigInteger> {
	@Override
	DlrCalls invokeAlgorithm(BigInteger campaignId);
}
