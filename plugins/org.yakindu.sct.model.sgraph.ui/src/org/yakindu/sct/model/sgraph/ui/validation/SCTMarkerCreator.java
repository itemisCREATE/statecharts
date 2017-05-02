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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.validation.Issue;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTMarkerCreator extends MarkerCreator {

	@Override
	protected void setMarkerAttributes(Issue issue, IResource resource, IMarker marker) throws CoreException {
		super.setMarkerAttributes(issue, resource, marker);
		if (issue instanceof SCTIssue) {
			marker.setAttribute(SCTMarkerType.SEMANTIC_ELEMENT_ID, ((SCTIssue) issue).getSemanticURI());
		}
	}

}
