package com.primosoft.astman.core.ast.algorithm;

import com.primosoft.astman.core.db.entity.ats.Operator;

import java.util.List;

/**
 * Created on 20.09.16.
 *
 * @author atelizhenko
 */
public interface OperatorAlgorithm extends Algorithm<List<Operator>, String> {
	@Override
	List<Operator> invokeAlgorithm(String groupName);
}
