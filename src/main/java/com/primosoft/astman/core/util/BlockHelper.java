/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.util;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/**
 * Created on 17.08.16.
 *
 * @author atelizhenko
 */
public final class BlockHelper {
	private final String block;
	private final Map<BlockKey, String> blockMap;

	public BlockHelper(String block) {
		this.block = block;
		this.blockMap = new WeakHashMap<>();

		generateBlock();
	}

	private void generateBlock() {
		Arrays.stream(block.split("\n"))
				.filter(splitBlock -> splitBlock.length() > 0)
				.map(splitBlock -> splitBlock.split(":"))
				.filter(splitBlock -> splitBlock.length == 2)
				.forEach(splitBlock -> blockMap.put(BlockKey.getBlockKey(splitBlock[0].trim()), splitBlock[1].trim()));
	}

	public BlockHelper(BlockHelper blockHelper) {
		this.block = blockHelper.block;
		this.blockMap = new WeakHashMap<>(blockHelper.blockMap);

		generateBlock();
	}

	public final boolean hasValues() {
		return blockMap.size() > 0;
	}

	public final String getValue(String key) {
		return getValue(BlockKey.getBlockKey(key));
	}

	public final String getValue(BlockKey key) {
		final String value = blockMap.get(key);
		return value != null ? value : "";
	}

	public final void addValue(BlockKey key, String value) {
		if (key != null && value != null) {
			blockMap.put(key, value);
		}
	}

	public final void clear() {
		blockMap.clear();
	}

	public final ActionKey getActionKey() {
		return ActionKey.getActionKey(getValue(BlockKey.ACTION));
	}

	@Override
	public int hashCode() {
		return Objects.hash(block, blockMap);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BlockHelper)) return false;
		BlockHelper that = (BlockHelper) o;
		return Objects.equals(block, that.block) &&
				Objects.equals(blockMap, that.blockMap);
	}

	@Override
	public String toString() {
		return "BlockHelper{" +
				"block='" + block + '\'' +
				", blockMap=" + blockMap +
				'}';
	}
}
