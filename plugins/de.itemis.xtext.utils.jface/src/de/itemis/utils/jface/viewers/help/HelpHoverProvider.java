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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

/**
 * Removes the first line, since the documentation already contains a header.
 * It also removes the open declaration action
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class HelpHoverProvider extends DefaultEObjectHoverProvider {

	
	@Override
	protected boolean hasHover(EObject o) {
		if (o instanceof Keyword)
			return true;
		return super.hasHover(o);
	}

	protected String getHoverInfoAsHtml(EObject o) {
		StringBuffer buffer = new StringBuffer();
		String documentation = getDocumentation(o);
		if (documentation != null && documentation.length() > 0) {
			buffer.append(documentation);
		}
		String hover = buffer.toString();
		if (hover == null
				|| AbstractUserHelpDocumentationProvider.EMPTY_DOCUMENTATION
						.equals(hover))
			return null;
		return hover;
	}
	

}
