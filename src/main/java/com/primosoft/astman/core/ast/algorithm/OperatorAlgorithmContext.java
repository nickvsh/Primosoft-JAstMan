package com.primosoft.astman.core.ast.algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

/**
 * Created on 21.09.16.
 *
 * @author atelizhenko
 */
public class OperatorAlgorithmContext {

	private final OperatorAlgorithm asIsOperatorAlgorithm;
	private final OperatorAlgorithm allOperatorsAlgorithm;
	private final OperatorAlgorithm dontSpeakAlgorithm;
	private final OperatorAlgorithm freeOperatorsAlgorithm;
	private final OperatorAlgorithm loginedOperatorsAlgorithm;
	private final OperatorAlgorithm oldestFreeOperatorsAlgorithm;

	@Autowired
	public OperatorAlgorithmContext(OperatorAlgorithm asIsOperatorAlgorithm,
									@Qualifier("allOperatorsOfGroupAlgorithm") OperatorAlgorithm allOperatorsAlgorithm,
									@Qualifier("dontSpeakOperatorsOfGroupAlgorithm") OperatorAlgorithm dontSpeakAlgorithm,
									@Qualifier("freeOperatorsOfGroupAlgorithm") OperatorAlgorithm freeOperatorsAlgorithm,
									@Qualifier("loginedOperatorsOfGroupAlgorithm") OperatorAlgorithm loginedOperatorsAlgorithm,
									@Qualifier("oldestFreeOperatorsOfGroupAlgorithm") OperatorAlgorithm oldestFreeOperatorsAlgorithm) {
		this.asIsOperatorAlgorithm = asIsOperatorAlgorithm;
		this.allOperatorsAlgorithm = allOperatorsAlgorithm;
		this.dontSpeakAlgorithm = dontSpeakAlgorithm;
		this.freeOperatorsAlgorithm = freeOperatorsAlgorithm;
		this.loginedOperatorsAlgorithm = loginedOperatorsAlgorithm;
		this.oldestFreeOperatorsAlgorithm = oldestFreeOperatorsAlgorithm;
	}

	public OperatorAlgorithm getOperatorAlgorithm(EOperatorAlgorithm algorithm) {
		final EOperatorAlgorithm operatorAlgorithm = Optional.ofNullable(algorithm).orElse(EOperatorAlgorithm.AS_IS);
		switch (operatorAlgorithm) {
			default:
			case AS_IS:
				return asIsOperatorAlgorithm;
			case ALL_OF_GROUP:
				return allOperatorsAlgorithm;
			case DONT_SPEAK_OF_GROUP:
				return dontSpeakAlgorithm;
			case FREE_OF_GROUP:
				return freeOperatorsAlgorithm;
			case LOGINED_OF_GROUP:
				return loginedOperatorsAlgorithm;
			case OLDEST_FREE_OF_GROUP:
				return oldestFreeOperatorsAlgorithm;
		}
	}
}
