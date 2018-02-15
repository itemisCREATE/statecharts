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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sgraph.SpecificationElement;

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
			setIssueReason(marker, (SCTIssue) issue);
		}
	}

	protected void setIssueReason(IMarker marker, SCTIssue issue) {
		EObject e = issue.getEObject();
		if (e == null) {
			return;
		}

		if (e instanceof NamedElement && isNamingIssue(issue.getMessage())) {
			try {
				marker.setAttribute(SCTMarkerType.NAMEDELEMENT_NAME, true);
			} catch (CoreException e1) {
				e1.printStackTrace();
			}
		}
		if (e instanceof SpecificationElement) {
			try {
				marker.setAttribute(SCTMarkerType.SPECIFICATIONELMENT_SPECIFICATION, true);
			} catch (CoreException e1) {
				e1.printStackTrace();
			}
		}
	}

	protected boolean isNamingIssue(String message) {
		return message.toLowerCase().contains("name") || message.toLowerCase().contains("duplicate");
	}

}
