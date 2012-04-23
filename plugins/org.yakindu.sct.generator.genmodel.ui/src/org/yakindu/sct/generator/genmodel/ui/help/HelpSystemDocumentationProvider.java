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
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureType;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class HelpSystemDocumentationProvider extends
		AbstractHelpSystemDocumentationProvider implements
		IEObjectDocumentationProvider {

	public static final String EMPTY_DOCUMENTATION = "";

	@Override
	protected String getContextId() {
		return "org.yakindu.sct.ui.editor.sc_genmodel_features";
	}

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
		String helpContent = parseHelpContent();
		int beginIndex = helpContent.indexOf("<h4 id=\"" + name + "\">");
		int endIndex = helpContent.indexOf("<!-- End " + name + " -->");
		if (beginIndex >= 0 && endIndex >= 0 && endIndex > beginIndex) {
			return helpContent.substring(beginIndex, endIndex);
		}
		return EMPTY_DOCUMENTATION;
	}
}
