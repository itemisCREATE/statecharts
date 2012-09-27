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
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.Issue.IssueImpl;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTMarkerCreator extends MarkerCreator {

	public static final String ELEMENT_ID = "elementId";

	@Override
	protected void setMarkerAttributes(Issue issue, IResource resource,
			IMarker marker) throws CoreException {
		super.setMarkerAttributes(issue, resource, marker);
		if (issue instanceof WrappingIssue) {
			marker.setAttribute(ELEMENT_ID,
					((WrappingIssue) issue).getNotationViewURI());
		}
	}

	/**
	 * 
	 * @author andreas muelder - Initial contribution and API x
	 */
	public static class WrappingIssue extends IssueImpl {

		private final Issue delegate;

		private final String notationViewURI;

		public WrappingIssue(final Issue delegate, String notationViewURI) {
			this.delegate = delegate;
			this.notationViewURI = notationViewURI;

		}

		public String getNotationViewURI() {
			return notationViewURI;
		}

		public Severity getSeverity() {
			return delegate.getSeverity();
		}

		public String getMessage() {
			return delegate.getMessage();
		}

		public String getCode() {
			return delegate.getCode();
		}

		public CheckType getType() {
			return delegate.getType();
		}

		public URI getUriToProblem() {
			return delegate.getUriToProblem();
		}

		public Integer getLineNumber() {
			return delegate.getLineNumber();
		}

		public Integer getOffset() {
			return delegate.getOffset();
		}

		public Integer getLength() {
			return delegate.getLength();
		}

		public boolean isSyntaxError() {
			return delegate.isSyntaxError();
		}

		public String[] getData() {
			return delegate.getData();
		}
	}

}
