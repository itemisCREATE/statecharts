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
package org.yakindu.sct.ui.editor.validation;

import java.util.Set;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.emf.ecore.resource.Resource;
import org.yakindu.sct.model.sgraph.ui.validation.SCTIssue;

import com.google.common.collect.Multimap;
import com.google.inject.ImplementedBy;

/**
 * @author Johannes Dicks - Initial contribution and API
 */
@ImplementedBy(DefaultResourceChangeToIssueProcessor.class)
public interface IResourceChangeToIssueProcessor {

	ResourceDeltaToIssueResult process(IResourceChangeEvent event, Resource connectedResource,
			Multimap<String, SCTIssue> visibleIssues);

	public static class ResourceDeltaToIssueResult {
		private Multimap<String, SCTIssue> issues;
		private Set<String> changedElementIDs;

		public ResourceDeltaToIssueResult(Multimap<String, SCTIssue> issues, Set<String> changedElementIDs) {
			this.issues = issues;
			this.changedElementIDs = changedElementIDs;
		}
		public Multimap<String, SCTIssue> getIssues() {
			return issues;
		}
		public Set<String> getChangedElementIDs() {
			return changedElementIDs;
		}

	}


}