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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.help.HelpSystem;
import org.eclipse.help.IToc;
import org.eclipse.help.ITopic;
import org.eclipse.help.IUAElement;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.yakindu.base.utils.jface.help.AbstractUserHelpDocumentationProvider;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenUserHelpDocumentationProvider extends AbstractUserHelpDocumentationProvider
		implements
			IEObjectDocumentationProvider {

	private static final String PLUGIN_ID = "org.yakindu.sct.ui.editor";
	private static final String CONTEXT_ID = "sgen_feature";
	private static final String YSCT_LABEL = "YAKINDU Statechart Tools";

	/*
	 * Documentation cache, maps the resource URL of an HTML file to its actual
	 * contents:
	 */
	private static final Map<String, String> docuCache = new WeakHashMap<String, String>();

	public String getDocumentation(EObject o) {
		if (o instanceof FeatureConfiguration) {
			FeatureType type = ((FeatureConfiguration) o).getType();
			if (type != null) {
				return getFeatureTypeDocumentation(type.getName());
			}
		} else if (o instanceof FeatureType) {
			FeatureType type = (FeatureType) o;
			if (type != null) {
				return getFeatureTypeDocumentation(type.getName());
			}
		} else if (o instanceof FeatureParameter) {
			FeatureType type = ((FeatureParameter) o).getFeatureType();
			if (type != null) {
				return getFeatureTypeDocumentation(type.getName());
			}
		} else if (o instanceof Statechart) {
			URI uri = EcoreUtil.getURI(o);
			return uri.isPlatform() ? uri.toPlatformString(true) : uri.toFileString();
		}
		return EMPTY_DOCUMENTATION;
	}

	/**
	 * <p>
	 * Looks up the documentation snippet of an SGen feature <em>name</em> by
	 * searching all documentation files.
	 * </p>
	 * 
	 * @param name
	 *            The feature to look for.
	 * @return the documentation snippet as HTML code.
	 */
	protected String getFeatureTypeDocumentation(String name) {
		if(name == null)
			return EMPTY_DOCUMENTATION;
		name = CONTEXT_ID + "_" + name.toLowerCase();

		/* Lookup all help resources, i.e., files containing documentation: */
		final IToc[] tocs = HelpSystem.getTocs();
		IToc ysctToc = null;
		for (final IToc toc : tocs) {
			final String label = toc.getLabel();
			if (label.contains(YSCT_LABEL)) {
				ysctToc = toc;
				break;
			}
		}
		if (ysctToc == null)
			return EMPTY_DOCUMENTATION;
		final Set<String> helpResources = getHelpResources(ysctToc);

		/* Search the help resources found for the feature we ar looking for: */
		for (final String helpResource : helpResources) {
			final String href = helpResource.substring(1);
			String userHelp = docuCache.get(href);
			if (userHelp == null) {
				URL url;
				try {
					url = new URL("platform:/plugin/" + href);
				} catch (MalformedURLException e) {
					e.printStackTrace();
					continue;
				}
				try {
					userHelp = convertStreamToString(url.openConnection().getInputStream());
					docuCache.put(href, userHelp);
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}

			int beginIndex = userHelp.indexOf("<!-- Start " + name + " -->");
			int endIndex = userHelp.indexOf("<!-- End " + name + " -->");
			if (beginIndex >= 0 && endIndex >= 0 && endIndex > beginIndex) {
				return userHelp.substring(beginIndex, endIndex);
			}
		}

		return EMPTY_DOCUMENTATION;
	}

	public ArrayList<String> getDocumentedFeatures() {
		ArrayList<String> features = new ArrayList<String>();
		String userHelp = getHelp(PLUGIN_ID + "." + CONTEXT_ID);

		// <!-- Start sgen_feature_naming -->
		Pattern p = Pattern.compile("\\Q<!-- Start " + CONTEXT_ID + "_\\E" + "(\\S+) -->");
		Matcher m = p.matcher(userHelp);

		while (m.find()) {
			features.add(m.group(1));
		}

		return features;
	}

	/**
	 * <p>
	 * Recursively traverses a table of contents and returns a set containing
	 * all file resource URLs found in the tree.
	 * </p>
	 *
	 * @param toc
	 *            The {@link IToc} to start at.
	 * @return see above.
	 */
	private Set<String> getHelpResources(final IToc toc) {
		final Set<String> helpResources = new HashSet<String>();
		final IUAElement[] children = toc.getChildren();
		for (final IUAElement e : children) {
			addHelpResources(helpResources, e);
		}
		return helpResources;
	}

	private void addHelpResources(final Set<String> helpResources, final IUAElement e) {
		if (e instanceof ITopic) {
			final ITopic c = (ITopic) e;
			String href = c.getHref();
			if (href != null) {
				int hashPos = href.indexOf('#');
				if (hashPos > 0)
					href = href.substring(0, hashPos);
				helpResources.add(href);
			}
			for (final IUAElement e1 : c.getChildren()) {
				addHelpResources(helpResources, e1);
			}
		}
	}

}
