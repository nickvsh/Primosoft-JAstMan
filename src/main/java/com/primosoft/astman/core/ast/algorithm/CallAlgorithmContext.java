package com.primosoft.astman.core.ast.algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

/**
 * Created on 22.09.16.
 *
 * @author atelizhenko
 */
public class CallAlgorithmContext {
	private final CallAlgorithm defaultNextLinearCallAlgorithm;
	private final CallAlgorithm nextTopCallAlgorithm;

	@Autowired
	public CallAlgorithmContext(@Qualifier("nextLinearCallAlgorithm") CallAlgorithm defaultNextLinearCallAlgorithm,
								@Qualifier("nextTopCallAlgorithm") CallAlgorithm nextTopCallAlgorithm) {
		this.defaultNextLinearCallAlgorithm = defaultNextLinearCallAlgorithm;
		this.nextTopCallAlgorithm = nextTopCallAlgorithm;
	}

	public CallAlgorithm getCallAlgorithm(ECallAlgorithm algorithm) {
		final ECallAlgorithm callAlgorithm = Optional.ofNullable(algorithm).orElse(ECallAlgorithm.NEXT_LINEAL_CALL);
		switch (callAlgorithm) {
			default:
			case NEXT_LINEAL_CALL:
				return defaultNextLinearCallAlgorithm;
			case NEXT_TOP_CALL:
				return nextTopCallAlgorithm;
		}
	}
}
