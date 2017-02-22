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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.ui.resources.FileChangeManager;
import org.eclipse.gmf.runtime.common.ui.resources.IFileObserver;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.sct.model.sgraph.ui.validation.SCTIssue;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.preferences.StatechartPreferenceConstants;

import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * 
 *
 * @author Andreas Mülder - Initial contribution and API
 *
 */
public class DefaultValidationIssueStore implements IValidationIssueStore, IFileObserver, IMarkerType {

	@Inject
	private IssueUtil issueCreator;

	private List<IResourceIssueStoreListener> listener;
	// the URI of the notation element
	private Multimap<String, SCTIssue> persistentIssues;
	private Multimap<String, SCTIssue> liveIssues;
	private boolean connected = false;

	private Resource resource;

	public DefaultValidationIssueStore() {
		listener = Lists.newArrayList();
		persistentIssues = ArrayListMultimap.create();
		liveIssues = ArrayListMultimap.create();
	}

	protected String getMarkerType() {
		return SCT_MARKER_TYPE;
	}

	@Override
	public void addIssueStoreListener(IResourceIssueStoreListener listener) {
		this.listener.add(listener);
	}

	@Override
	public void removeIssueStoreListener(IResourceIssueStoreListener listener) {
		this.listener.remove(listener);
	}

	protected void notifyListeners() {
		for (IResourceIssueStoreListener iResourceIssueStoreListener : listener) {
			iResourceIssueStoreListener.issuesChanged();
		}
	}

	@Override
	public void connect(Resource resource) {
		if (connected)
			throw new IllegalStateException("Issue store is already connected to a resource");
		connected = true;
		this.resource = resource;
		IFile file = WorkspaceSynchronizer.getFile(resource);
		if (file != null && file.isAccessible()) {
			FileChangeManager.getInstance().addFileObserver(this);
		}
		reloadMarkerIssues();
	}

	protected void reloadMarkerIssues() {
		persistentIssues.clear();
		List<IMarker> markers = new ArrayList<IMarker>();
		try {
			IFile file = WorkspaceSynchronizer.getFile(resource);
			if (file != null && file.isAccessible()) {
				markers.addAll(Arrays.asList(file.findMarkers(getMarkerType(), true, IResource.DEPTH_INFINITE)));
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		for (IMarker iMarker : markers) {
			SCTIssue issue = createFromMarker(iMarker);
			persistentIssues.put(issue.getNotationViewURI(), issue);
		}
		notifyListeners();
	}

	@Override
	public void disconnect(Resource resource) {
		IFile file = WorkspaceSynchronizer.getFile(resource);
		if (file != null && file.isAccessible()) {
			FileChangeManager.getInstance().removeFileObserver(this);
		}
		persistentIssues.clear();
		connected = false;
	}

	protected SCTIssue createFromMarker(IMarker marker) {
		String notationURI = marker.getAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID, "");
		Issue delegate = issueCreator.createIssue(marker);
		SCTIssue issue = new SCTIssue(delegate, notationURI);
		return issue;
	}

	@Override
	public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
		liveIssues.clear();
		for (Issue issue : issues) {
			if (issue instanceof SCTIssue) {
				String notationViewURI = ((SCTIssue) issue).getNotationViewURI();
				liveIssues.put(notationViewURI, (SCTIssue) issue);
			}
		}
		notifyListeners();
	}

	@Override
	public List<SCTIssue> getIssues(String uri) {
		List<SCTIssue> result = Lists.newArrayList();
		if (!liveValidationEnabled()) {
			result.addAll(persistentIssues.get(uri));
			return result;
		} else {
			result.addAll(liveIssues.get(uri));
			Iterables.addAll(result, Iterables.filter(persistentIssues.get(uri), new Predicate<SCTIssue>() {
				public boolean apply(SCTIssue input) {
					return input.getType() == CheckType.NORMAL || input.getType() == CheckType.EXPENSIVE;
				}
			}));
		}
		return result;

	}

	protected boolean liveValidationEnabled() {
		return DiagramActivator.getDefault().getPreferenceStore()
				.getBoolean(StatechartPreferenceConstants.PREF_LIVE_VALIDATION);
	}

	@Override
	public void handleMarkerAdded(IMarker marker) {
		reloadMarkerIssues();
	}

	@Override
	public void handleMarkerDeleted(IMarker marker, @SuppressWarnings("rawtypes") Map attributes) {
		reloadMarkerIssues();

	}

	@Override
	public void handleMarkerChanged(IMarker marker) {
		reloadMarkerIssues();
	}

	@Override
	public void handleFileRenamed(IFile oldFile, IFile file) {
		// Nothing to do
	}

	@Override
	public void handleFileMoved(IFile oldFile, IFile file) {
		// Nothing to do
	}

	@Override
	public void handleFileDeleted(IFile file) {
		// Nothing to do
	}

	@Override
	public void handleFileChanged(IFile file) {
		// Nothing to do
	}
}
