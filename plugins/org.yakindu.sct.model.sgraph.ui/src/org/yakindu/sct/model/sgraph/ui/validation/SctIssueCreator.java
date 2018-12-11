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

import org.eclipse.core.resources.IMarker;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

/**
 * @author Johannes Dicks - Initial contribution and API
 */
public class SctIssueCreator implements ISctIssueCreator {

	@Inject
	IssueUtil issueCreator;

	@Override
	public SCTIssue createFromMarker(final IMarker marker, final String id) {
		final Issue delegate = issueCreator.createIssue(marker);
		return create(delegate,id);
	}

	@Override
	public SCTIssue create(Issue delegate, String id) {
		final SCTIssue issue = new SCTIssue(delegate, id);
		return issue;
	}

}
