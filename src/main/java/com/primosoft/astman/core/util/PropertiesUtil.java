/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
public class PropertiesUtil {
	private final Properties properties;

	public PropertiesUtil() {
		properties = new Properties();
	}

	public void loadFile() throws IOException {
		try (final InputStream inputStream = getCorrectStream()) {
			properties.load(inputStream);
		}
	}

	private InputStream getCorrectStream() throws FileNotFoundException {
		final String propertyFilePath = "config/config.properties";
		final InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(propertyFilePath);
		return resourceAsStream != null ? resourceAsStream : new FileInputStream(propertyFilePath);
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
