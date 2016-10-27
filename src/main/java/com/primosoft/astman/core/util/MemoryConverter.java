/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.util;

/**
 * Created on 06.04.16.
 * MemoryConverter
 *
 * @author atelizhenko
 */
public final class MemoryConverter {
	/**
	 * The constant KB.
	 */
	public static final int KB = 1;
	/**
	 * The constant MB.
	 */
	public static final int MB = 2;
	/**
	 * The constant GB.
	 */
	public static final int GB = 3;
	private int cores;
	private long freeMemory;
	private long maxMemory;
	private long totalMemory;
	private Integer converterCode;

	MemoryConverter() {
	}

	/**
	 * Gets cores.
	 *
	 * @return the cores
	 */
	public int getCores() {
		return cores;
	}

	/**
	 * Sets cores.
	 *
	 * @param cores the cores
	 */
	public void setCores(int cores) {
		this.cores = cores;
	}

	/**
	 * Gets free memory.
	 *
	 * @return the free memory
	 */
	public long getFreeMemory() {
		return convert(freeMemory);
	}

	/**
	 * Sets free memory.
	 *
	 * @param freeMemory the free memory
	 */
	public void setFreeMemory(long freeMemory) {
		this.freeMemory = freeMemory;
	}

	private Long convert(Long number) {
		if (getConverterCode() == null)
			throw new IllegalArgumentException("MemoryConverter code is null.");
		if (number == null)
			throw new IllegalArgumentException("Number is null");
		final long K = 1024;
		final long M = K * K;
		final long G = M * K;
		switch (getConverterCode()) {
			case 1:
				return number / K;
			default:
			case 2:
				return number / M;

			case 3:
				return number / G;
		}
	}

	/**
	 * Gets converter code.
	 *
	 * @return the converter code
	 */
	public Integer getConverterCode() {
		return converterCode;
	}

	/**
	 * Sets converter code.
	 *
	 * @param converterCode the converter code
	 */
	public void setConverterCode(Integer converterCode) {
		this.converterCode = converterCode;
	}

	/**
	 * Gets max memory.
	 *
	 * @return the max memory
	 */
	public long getMaxMemory() {
		return convert(maxMemory);
	}

	/**
	 * Sets max memory.
	 *
	 * @param maxMemory the max memory
	 */
	public void setMaxMemory(long maxMemory) {
		this.maxMemory = maxMemory;
	}

	/**
	 * Gets total memory.
	 *
	 * @return the total memory
	 */
	public long getTotalMemory() {
		return convert(totalMemory);
	}

	/**
	 * Sets total memory.
	 *
	 * @param totalMemory the total memory
	 */
	public void setTotalMemory(long totalMemory) {
		this.totalMemory = totalMemory;
	}

	/**
	 * Clear parameters
	 */
	public void clear() {
		cores = 0;
		freeMemory = 0;
		maxMemory = 0;
		totalMemory = 0;
	}
}
