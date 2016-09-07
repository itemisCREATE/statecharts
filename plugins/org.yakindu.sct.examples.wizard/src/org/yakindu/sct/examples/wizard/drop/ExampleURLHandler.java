/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.drop;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * Copied from {@link org.eclipse.epp.mpc.ui.MarketplaceUrlHandler}.
 * 
 * @author Thomas Kutz - Adjusted to work with example download URLs.
 */
public class ExampleURLHandler {

	private static final String EXAMPLE_INSTALL_URL = "https://github.com/Yakindu/examples/wiki/Downloading-an-example";
	private static final String SPLIT_REGEX = "&";
	private static final String EQUALS_REGEX = "=";
	private static final Object ID_KEY = "id";
	
	public static boolean isValidExample(String url) {
		return url != null && url.contains(EXAMPLE_INSTALL_URL);
	}
	
	public static String extractExampleId(String url) {
		Map<String, String> parsedQuery = parseQuery(url);
		return parsedQuery.get(ID_KEY);
	}
	
	/**
	 * Copied from {@link org.eclipse.epp.mpc.ui.MarketplaceUrlHandler.parseQuery(String)}
	 */
	private static Map<String, String> parseQuery(String url) {
		String query;
		try {
			query = new URL(url).getQuery();
		} catch (MalformedURLException e) {
			return Maps.newHashMap();
		}
		if (query == null) {
			return Maps.newHashMap();
		}
		Map<String, String> values = new LinkedHashMap<String, String>();
		String[] params = query.split(SPLIT_REGEX);
		for (String param : params) {
			String[] keyValue = param.split(EQUALS_REGEX);
			if (keyValue.length == 2) {
				String key = keyValue[0];
				String value = keyValue[1];
				values.put(key, value);
			}
		}
		return values;
	}
}
