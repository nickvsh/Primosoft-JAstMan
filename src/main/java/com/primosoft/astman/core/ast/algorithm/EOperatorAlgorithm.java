package com.primosoft.astman.core.ast.algorithm;

/**
 * Created on 21.09.16.
 *
 * @author atelizhenko
 */
public enum EOperatorAlgorithm {
	AS_IS(0),
	ALL_OF_GROUP(1),
	DONT_SPEAK_OF_GROUP(6),
	FREE_OF_GROUP(4),
	LOGINED_OF_GROUP(2),
	OLDEST_FREE_OF_GROUP(8);

	private final int value;

	EOperatorAlgorithm(int value) {
		this.value = value;
	}

	public static EOperatorAlgorithm getOperatorAlgorithm(int value) {
		for (EOperatorAlgorithm algorithm : values()) {
			if (algorithm.getValue() == value)
				return algorithm;
		}
		return AS_IS;
	}

	public final int getValue() {
		return value;
	}
}
