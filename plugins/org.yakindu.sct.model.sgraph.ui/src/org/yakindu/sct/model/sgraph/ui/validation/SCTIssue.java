/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sgraph.ui.validation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.Issue.IssueImpl;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTIssue extends IssueImpl {

	private final Issue delegate;

	private final String semanticURI;

	public SCTIssue(final Issue delegate, String semanticURI) {
		this.delegate = delegate;
		this.semanticURI = semanticURI;
	}

	public String getSemanticURI() {
		return semanticURI;
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