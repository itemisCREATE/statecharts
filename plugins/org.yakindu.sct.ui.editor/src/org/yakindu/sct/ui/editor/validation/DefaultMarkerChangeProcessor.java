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

import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.sct.model.sgraph.ui.validation.SCTIssue;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Encapsulates functionalities to process resource deltas markers and convert them into an efficient data structure.
 */
public class DefaultMarkerChangeProcessor implements IMarkerChangeProcessor {

    @Inject
    private IssueUtil issueCreator;

    private Multimap<String, SCTIssue> currentIssues;
    private Set<String> relatedElementIDs;

    @Override
    public Multimap<String, SCTIssue> getCurrentIssues() {
        return currentIssues;
    }

    @Override
    public void setCurrentIssues(final Multimap<String, SCTIssue> liveIssues) {
        currentIssues = ArrayListMultimap.create(liveIssues);
        relatedElementIDs = Sets.newHashSet();
    }

    @Override
    public Set<String> getChangedElementIDs() {
        return relatedElementIDs;
    }

    @Override
    public boolean visit(final IResourceDelta delta) {
        if ((IResourceDelta.CHANGED == delta.getKind()) && ((delta.getFlags() & IResourceDelta.MARKERS) != 0)) {
            processMarkerDelta(delta);
        }
        return true;
    }

    protected void processMarkerDelta(final IResourceDelta delta) {
        final IMarkerDelta[] markerDeltas = delta.getMarkerDeltas();

        for (final IMarkerDelta markerDelta : markerDeltas) {
            final Object elementID =
                    markerDelta.getAttribute(org.eclipse.gmf.runtime.common.core.resources.IMarker.ELEMENT_ID);
            if (elementID == null) {
                continue;
            }
            dispatchMarkerDelta(markerDelta, elementID.toString());
        }
    }

    protected void dispatchMarkerDelta(final IMarkerDelta iMarkerDelta, final String elementID) {
        switch (iMarkerDelta.getKind()) {
        case IResourceDelta.ADDED:
            addSCTIssue(iMarkerDelta, elementID);
            break;
        case IResourceDelta.REMOVED:
            removeSCTIssue(iMarkerDelta, elementID);
            break;
        case IResourceDelta.CHANGED:
            removeSCTIssue(iMarkerDelta, elementID);
            addSCTIssue(iMarkerDelta, elementID);
            break;
        default:
            break;
        }
    }

    protected void addSCTIssue(final IMarkerDelta iMarkerDelta, final String elementID) {
        currentIssues.put(elementID, createFromMarker(iMarkerDelta.getMarker(), elementID));
        relatedElementIDs.add(elementID);
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
        relatedElementIDs.add(elementID);
    }

    @Override
    public SCTIssue createFromMarker(final IMarker marker, final String id) {
        final Issue delegate = issueCreator.createIssue(marker);
        final SCTIssue issue = new SCTIssue(delegate, id);
        return issue;
    }
}