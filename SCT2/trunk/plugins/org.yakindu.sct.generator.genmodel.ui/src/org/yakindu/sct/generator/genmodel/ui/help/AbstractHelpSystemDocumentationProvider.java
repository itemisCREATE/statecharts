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
package org.yakindu.sct.generator.genmodel.ui.help;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;

import org.eclipse.core.runtime.Assert;
import org.eclipse.help.IContext;
import org.eclipse.help.IHelpResource;
import org.eclipse.help.internal.context.ContextFileProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public abstract class AbstractHelpSystemDocumentationProvider implements
		IEObjectDocumentationProvider {

	protected abstract String getContextId();

	protected String parseHelpContent() {
		ContextFileProvider provider = new ContextFileProvider();
		IContext context = provider.getContext(getContextId(), Locale
				.getDefault().toString());
		IHelpResource[] relatedTopics = context.getRelatedTopics();
		Assert.isTrue(relatedTopics != null && relatedTopics.length == 1);
		IHelpResource helpResource = relatedTopics[0];
		BufferedReader in = null;
		try {
			String href = helpResource.getHref().substring(1);
			URL url = new URL("platform:/plugin/" + href);
			InputStream inputStream = url.openConnection().getInputStream();
			in = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder builder = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				builder.append(inputLine);
			}
			return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
