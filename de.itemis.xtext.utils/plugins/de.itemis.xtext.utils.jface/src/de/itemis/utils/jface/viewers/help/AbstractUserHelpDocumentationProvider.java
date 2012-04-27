/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package de.itemis.utils.jface.viewers.help;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.help.IContext;
import org.eclipse.help.IHelpResource;
import org.eclipse.help.internal.context.ContextFileProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

import com.google.common.collect.Maps;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public abstract class AbstractUserHelpDocumentationProvider implements
		IEObjectDocumentationProvider {

	public static final String EMPTY_DOCUMENTATION = "";

	private Map<String, String> helpContentCache;

	public AbstractUserHelpDocumentationProvider() {
		helpContentCache = Maps.newHashMap();
	}

	protected String getHelp(String contextId) {
		if (helpContentCache.get(contextId) != null) {
			return helpContentCache.get(contextId);
		}
		try {
			helpContentCache.put(contextId, parseHelp(contextId));
		} catch (Exception e) {
			e.printStackTrace();
			helpContentCache.put(contextId, EMPTY_DOCUMENTATION);
		}
		return helpContentCache.get(contextId);
	}

	private String parseHelp(String contextId) throws Exception {
		ContextFileProvider provider = new ContextFileProvider();
		IContext context = provider.getContext(contextId, Locale.getDefault()
				.toString());
		IHelpResource[] relatedTopics = context.getRelatedTopics();
		Assert.isTrue(relatedTopics != null);
		// We assume that there is only one topic registered
		IHelpResource helpResource = relatedTopics[0];
		String href = helpResource.getHref().substring(1);
		URL url = new URL("platform:/plugin/" + href);
		return convertStreamToString(url.openConnection().getInputStream());
	}

	public String convertStreamToString(InputStream is) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder builder = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			builder.append(line);
			builder.append("\n");
		}
		is.close();
		return builder.toString();
	}

}
