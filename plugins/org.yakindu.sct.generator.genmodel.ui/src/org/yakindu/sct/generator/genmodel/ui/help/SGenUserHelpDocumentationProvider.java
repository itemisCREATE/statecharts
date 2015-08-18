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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.yakindu.base.utils.jface.help.AbstractUserHelpDocumentationProvider;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureType;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenUserHelpDocumentationProvider extends AbstractUserHelpDocumentationProvider implements
		IEObjectDocumentationProvider {

	private static final String PLUGIN_ID = "org.yakindu.sct.ui.editor";
	private static final String CONTEXT_ID = "sgen_feature";

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
		}
		return EMPTY_DOCUMENTATION;
	}

	protected String getFeatureTypeDocumentation(String name) {
		name = CONTEXT_ID + "_" + name.toLowerCase();
		String userHelp = getHelp(PLUGIN_ID + "." + CONTEXT_ID);
		int beginIndex = userHelp.indexOf("<!-- Start " + name + " -->");
		int endIndex = userHelp.indexOf("<!-- End " + name + " -->");
		if (beginIndex >= 0 && endIndex >= 0 && endIndex > beginIndex) {
			return userHelp.substring(beginIndex, endIndex);
		}
		return EMPTY_DOCUMENTATION;
	}
}
