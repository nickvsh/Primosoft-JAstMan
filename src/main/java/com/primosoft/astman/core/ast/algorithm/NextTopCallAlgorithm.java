package com.primosoft.astman.core.ast.algorithm;

import com.primosoft.astman.core.db.entity.dlr.DlrCalls;
import com.primosoft.astman.core.db.service.IAlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

/**
 * Created on 22.09.16.
 *
 * @author atelizhenko
 */
final class NextTopCallAlgorithm implements CallAlgorithm {
	private final IAlgorithmService algorithmService;

	@Autowired
	NextTopCallAlgorithm(IAlgorithmService algorithmService) {
		this.algorithmService = algorithmService;
	}

	@Override
	public DlrCalls invokeAlgorithm(BigInteger campaignId) {
		return algorithmService.getNextByTopCall(campaignId);
	}
}
