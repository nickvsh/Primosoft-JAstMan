package com.primosoft.astman.core.ast.algorithm;

import com.primosoft.astman.core.db.entity.ats.Operator;
import com.primosoft.astman.core.db.service.IAlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on 20.09.16.
 *
 * @author atelizhenko
 */
final class LoginedOperatorsOfGroupAlgorithm implements OperatorAlgorithm {
	private final IAlgorithmService algorithmService;

	@Autowired
	public LoginedOperatorsOfGroupAlgorithm(IAlgorithmService algorithmService) {
		this.algorithmService = algorithmService;
	}

	@Override
	public List<Operator> invokeAlgorithm(String groupName) {
		return algorithmService.getLoginedOfGroupList(groupName);
	}
}
