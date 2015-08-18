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
package org.yakindu.sct.model.stext.ui.help;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.yakindu.base.utils.jface.help.AbstractUserHelpDocumentationProvider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextUserHelpDocumentationProvider extends
		AbstractUserHelpDocumentationProvider implements
		IEObjectDocumentationProvider {

	private static final String PLUGIN_ID = "org.yakindu.sct.ui.editor";
	private static final String CONTEXT_ID = "stext_keyword";

	
	public String getDocumentation(EObject o) {
		if (o instanceof Keyword) {
			String name = CONTEXT_ID + "_" + ((Keyword) o).getValue();
			String helpContent = getHelp(PLUGIN_ID + "." + CONTEXT_ID);
			int beginIndex = helpContent.indexOf("<!-- Start " + name + " -->");
			int endIndex = helpContent.indexOf("<!-- End " + name + " -->");
			if (beginIndex >= 0 && endIndex >= 0 && endIndex > beginIndex) {
				return helpContent.substring(beginIndex, endIndex);
			}
		}
		return EMPTY_DOCUMENTATION;
	}

}
