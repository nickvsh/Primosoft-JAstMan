package com.primosoft.astman.core.ast.algorithm;

import com.primosoft.astman.core.db.entity.ats.Operator;

import java.util.Collections;
import java.util.List;

/**
 * Created on 21.09.16.
 *
 * @author atelizhenko
 */
final class AsIsOperatorAlgorithm implements OperatorAlgorithm {
	@Override
	public List<Operator> invokeAlgorithm(String groupName) {
		return Collections.emptyList();
	}
}
