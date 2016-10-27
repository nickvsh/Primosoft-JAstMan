package com.primosoft.astman.core.ast.algorithm;

/**
 * Created on 22.09.16.
 *
 * @author atelizhenko
 */
public enum ECallAlgorithm {
	NEXT_LINEAL_CALL(0),
	NEXT_TOP_CALL(1);

	private final int value;

	ECallAlgorithm(int value) {
		this.value = value;
	}

	public static ECallAlgorithm getCallAlgorithm(int value) {
		for (ECallAlgorithm algorithm : values()) {
			if (algorithm.getValue() == value)
				return algorithm;
		}
		return NEXT_LINEAL_CALL;
	}

	public final int getValue() {
		return value;
	}
}
