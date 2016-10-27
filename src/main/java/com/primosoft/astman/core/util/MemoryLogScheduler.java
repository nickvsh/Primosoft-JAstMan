/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.util;

import com.primosoft.astman.core.log.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
@Scope("prototype")
public class MemoryLogScheduler {
	private final Logger logger;
	private final MemoryConverter memoryConverter;

	@Autowired
	public MemoryLogScheduler(@Qualifier("memoryLogger") Logger logger, MemoryConverter memoryConverter) {
		this.logger = logger;
		this.memoryConverter = memoryConverter;
	}

	public void logMemory() {
		final MemoryConverter memoryConverter = init();

		logger.warn("*************************************************************");
		logger.warn("FreeMemory:\t" + memoryConverter.getFreeMemory());
		logger.warn("MaxMemory:\t" + memoryConverter.getMaxMemory());
		logger.warn("TotalMemory:\t" + memoryConverter.getTotalMemory());
		logger.warn("*************************************************************");
	}

	private MemoryConverter init() {
		memoryConverter.setConverterCode(MemoryConverter.MB);

		memoryConverter.setCores(Runtime.getRuntime().availableProcessors());
		memoryConverter.setFreeMemory(Runtime.getRuntime().freeMemory());
		memoryConverter.setMaxMemory(Runtime.getRuntime().maxMemory());
		memoryConverter.setTotalMemory(Runtime.getRuntime().totalMemory());

		return memoryConverter;
	}

	public void flushMemoryCounter() {
		memoryConverter.clear();
	}
}
