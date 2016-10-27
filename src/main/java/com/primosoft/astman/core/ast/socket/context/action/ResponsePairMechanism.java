/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket.context.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 18.08.16.
 *
 * @author atelizhenko
 */
final class ResponsePairMechanism {
	private final List<ResponsePair> responsePairList;

	ResponsePairMechanism() {
		responsePairList = new ArrayList<>();
	}

	void addPairs(List<ResponsePair> responsePairList) {
		if (responsePairList != null && !responsePairList.isEmpty())
			this.responsePairList.addAll(responsePairList);
	}

	void addPairs(ResponsePair... responsePairs) {
		if (responsePairs != null && responsePairs.length > 0)
			Collections.addAll(this.responsePairList, responsePairs);
	}

	void addPair(final ResponsePair responsePair) {
		if (responsePair != null)
			this.responsePairList.add(responsePair);
	}

	String convertResponse() {
		final StringBuilder responseBuffer = new StringBuilder();

		for (final ResponsePair responsePair : responsePairList) {
			responseBuffer
					.append(responsePair.toString())
					.append("\n");
		}

		responseBuffer.append("\n");
		return responseBuffer.toString();
	}

	void clear() {
		this.responsePairList.clear();
	}
}
