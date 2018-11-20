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

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.yakindu.sct.model.sgraph.ui.validation.ISctIssueCreator;
import org.yakindu.sct.model.sgraph.ui.validation.SCTIssue;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerType;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Johannes Dicks - initial contribution and API
 */
public class DefaultResourceChangeToIssueProcessor implements IResourceChangeToIssueProcessor {

	@Inject
	private ISctIssueCreator issueCreator;

	private Multimap<String, SCTIssue> currentIssues;
	private Set<String> changedIssuesElementIDs;
	
	@Override
	public ResourceDeltaToIssueResult process(IResourceChangeEvent event, Resource connectedResource,
			Multimap<String, SCTIssue> visibleIssues) {
		final IFile file = WorkspaceSynchronizer.getFile(connectedResource);
		if (file == null) {
		    return null;
		}
		final IResourceDelta deltaForFile = getDeltaForFile(event, file);
		if (deltaForFile == null) {
			return null;
		}
		currentIssues = HashMultimap.create(visibleIssues);
		changedIssuesElementIDs = Sets.newHashSet();
		
		if ((IResourceDelta.CHANGED == deltaForFile.getKind()) && ((deltaForFile.getFlags() & IResourceDelta.MARKERS) != 0)) {
			processMarkerDelta(deltaForFile);
		}
		return new ResourceDeltaToIssueResult(currentIssues,changedIssuesElementIDs);
	}
	

	protected IResourceDelta getDeltaForFile(final IResourceChangeEvent event, final IFile file) {
		final String[] segments = file.getFullPath().segments();
		IResourceDelta currentDelta = event.getDelta();
		for (final String segment : segments) {
			final IResourceDelta matchingDelta = currentDelta.findMember(new Path(segment));
			if (matchingDelta != null) {
				currentDelta = matchingDelta;
				continue;
			}
			return null;
		}
		return currentDelta;
	}


	protected void processMarkerDelta(final IResourceDelta delta) {
		final IMarkerDelta[] markerDeltas = getSortedMarkerDelta(delta);
		
		for (final IMarkerDelta markerDelta : markerDeltas) {
			final Object elementID = markerDelta
					.getAttribute(SCTMarkerType.SEMANTIC_ELEMENT_ID);
			if (elementID == null) {
				continue;
			}
			dispatchMarkerDelta(markerDelta, elementID.toString());
		}
	}


	private IMarkerDelta[] getSortedMarkerDelta(final IResourceDelta delta) {
		IMarkerDelta[] markerDeltas = delta.getMarkerDeltas();
		//sort IResourceDelta.CHANGED > IResourceDelta.REMOVED > IResourceDelta.ADDED 
		Arrays.sort(markerDeltas, new Comparator<IMarkerDelta>(){
			@Override
			public int compare(IMarkerDelta o1, IMarkerDelta o2) {
				return -((Integer)o1.getKind()).compareTo(o2.getKind());
			}
		});
	
		return markerDeltas;
	}

	protected void dispatchMarkerDelta(final IMarkerDelta iMarkerDelta, final String elementID) {
		switch (iMarkerDelta.getKind()) {
			case IResourceDelta.ADDED :
				addSCTIssue(iMarkerDelta, elementID);
				break;
			case IResourceDelta.REMOVED :
				removeSCTIssue(iMarkerDelta, elementID);
				break;
			case IResourceDelta.CHANGED :
				removeSCTIssue(iMarkerDelta, elementID);
				addSCTIssue(iMarkerDelta, elementID);
				break;
			default :
				break;
		}
	}

	protected void addSCTIssue(final IMarkerDelta iMarkerDelta, final String elementID) {
		currentIssues.put(elementID, issueCreator.createFromMarker(iMarkerDelta.getMarker(), elementID));
		changedIssuesElementIDs.add(elementID);
	}

	protected void removeSCTIssue(final IMarkerDelta iMarkerDelta, final String elementID) {
		final String message = (String) iMarkerDelta.getAttributes().get(IMarker.MESSAGE);
		final Iterator<SCTIssue> iterator = currentIssues.get(elementID).iterator();
		while (iterator.hasNext()) {
			final SCTIssue sctIssue = iterator.next();
			if (sctIssue.getMessage().equals(message)) {
				iterator.remove();
			}
		}
		changedIssuesElementIDs.add(elementID);
	}


}