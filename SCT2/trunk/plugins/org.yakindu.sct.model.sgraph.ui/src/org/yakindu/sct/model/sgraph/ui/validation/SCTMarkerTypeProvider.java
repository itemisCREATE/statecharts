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
package org.yakindu.sct.model.sgraph.ui.validation;

import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerCreator.WrappingIssue;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTMarkerTypeProvider extends MarkerTypeProvider {

	@Override
	public String getMarkerType(Issue issue) {
		if (issue instanceof WrappingIssue) {
			return "org.yakindu.sct.ui.editor.diagnostic";
		}
		return super.getMarkerType(issue);
	}
}
