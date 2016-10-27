package com.primosoft.astman.core.db.dao;

/**
 * Created on 12.09.16.
 *
 * @author atelizhenko
 */
interface FunctionalNamesConstant {
	String ATS_SCHEMA = "ATS";
	String DLR_SCHEMA = "DLR";

	String FINISH_CITL_SC = "FINISH_CITL_SC";
	String HANGUP_CITL_MC = "HANGUP_CITL_MC";
	String BEGIN_CITL_SC = "BEGIN_CITL_SC";

	String GET_OPER_OLDEST_FREE = "GET_OPER_OLDEST_FREE";

	String NEXT_LINEAL = "NEXT_LINEAL";
	String NEXT_TOP = "NEXT_TOP";

	default String createCallFunction(String functionName, int countOutgoingParams) {
		return createCallFunction(null, functionName, countOutgoingParams);
	}

	default String createCallFunction(String schema, String functionName, int countOutgoingParams) {
		final StringBuilder outgoingParamsBuilder = new StringBuilder();
		for (int i = 1; i <= countOutgoingParams; i++) {
			outgoingParamsBuilder.append("?");
			if (i != countOutgoingParams)
				outgoingParamsBuilder.append(",");
		}
		return "{ CALL " + (schema != null && !schema.isEmpty() ? schema + "." : "")
				+ functionName + "(" + outgoingParamsBuilder.toString() + ") }";
	}
}
