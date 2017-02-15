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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class LiveValidationIssueProcessor implements ISCTIssueProcessor {

	public static class IssueAdapter extends AdapterImpl {

		private List<Issue> issue;

		public IssueAdapter() {
			issue = Lists.newArrayList();
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == IssueAdapter.class;
		}

		public List<Issue> getIssues() {
			return issue;
		}
	}

	protected void removeIssueAdapter(Resource resource) {
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			Adapter existingAdapter = EcoreUtil.getExistingAdapter(next, IssueAdapter.class);
			if (existingAdapter != null) {
				next.eAdapters().remove(existingAdapter);
			}
		}
	}

	@Override
	public void processIssues(Resource resource, List<Issue> issues, IProgressMonitor monitor) {
		removeIssueAdapter(resource);
		Map<EObject, IssueAdapter> map = new HashMap<>();
		for (Issue issue : issues) {
			EObject eObject = resource.getResourceSet().getEObject(issue.getUriToProblem(), true);
			IssueAdapter issueAdapter = map.get(eObject);
			if (issueAdapter == null) {
				map.put(eObject, issueAdapter = new IssueAdapter());
			}
			issueAdapter.getIssues().add(issue);
		}
		Set<Entry<EObject, IssueAdapter>> entrySet = map.entrySet();
		for (Entry<EObject, IssueAdapter> entry : entrySet) {
			entry.getKey().eAdapters().add(entry.getValue());
		}
	}
}
