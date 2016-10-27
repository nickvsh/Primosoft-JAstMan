package com.primosoft.astman.core.util;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 10.09.16.
 *
 * @author atelizhenko
 */
public final class BlockDiscover {

	private BlockDiscover() {

	}

	public static List<BlockHelper> discoverBlocks(final String block) {
		return Arrays.stream(block.split("\n\n"))
				.filter(splitBlock -> splitBlock.length() > 0)
				.map(BlockHelper::new)
				.filter(BlockHelper::hasValues)
				.collect(ImmutableListCollector.toImmutableList());
	}
}
