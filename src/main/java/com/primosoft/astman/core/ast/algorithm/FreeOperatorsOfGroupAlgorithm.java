package com.primosoft.astman.core.ast.algorithm;

import com.primosoft.astman.core.db.entity.ats.Operator;
import com.primosoft.astman.core.db.service.IAlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on 21.09.16.
 *
 * @author atelizhenko
 */
final class FreeOperatorsOfGroupAlgorithm implements OperatorAlgorithm {
	private final IAlgorithmService algorithmService;

	@Autowired
	public FreeOperatorsOfGroupAlgorithm(IAlgorithmService algorithmService) {
		this.algorithmService = algorithmService;
	}

	@Override
	public List<Operator> invokeAlgorithm(String groupName) {
		return algorithmService.getFreeOfGroupList(groupName);
	}
}
