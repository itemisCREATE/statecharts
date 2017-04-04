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
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.sct.model.sgraph.ui.validation.SCTIssue;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerCreator;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.preferences.StatechartPreferenceConstants;
import org.yakindu.sct.ui.editor.validation.IMarkerType;
import org.yakindu.sct.ui.editor.validation.IValidationIssueStore;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * Maintains the list of current issues based on persistent markers and live validation results.
 *
 * @author Johannes Dicks - Initial contribution and API
 */
public class DefaultValidationIssueStore implements IValidationIssueStore, IResourceChangeListener {

    protected final List<IResourceIssueStoreListener> listener;
    protected final Multimap<String, SCTIssue> visibleIssues;
    protected boolean connected = false;

    protected Resource connectedResource;

    @Inject
    private IMarkerChangeProcessor markerChangeProcessor;
 
    public DefaultValidationIssueStore() {
        listener = Lists.newArrayList();
        visibleIssues = ArrayListMultimap.create();
    }

    protected String getMarkerType() {
        return IMarkerType.SCT_MARKER_TYPE;
    }

    @Override
    public void addIssueStoreListener(final IResourceIssueStoreListener newListener) {
        synchronized (listener) {
            listener.add(newListener);
        }
    }

    @Override
    public void removeIssueStoreListener(final IResourceIssueStoreListener oldListener) {
        synchronized (listener) {
            listener.remove(oldListener);
        }
    }

    protected void notifyListeners() {
        synchronized (listener) {
            for (final IResourceIssueStoreListener iResourceIssueStoreListener : listener) {
                iResourceIssueStoreListener.issuesChanged();
            }
        }
    }

    protected void notifyListeners(final String semanticURI) {
        synchronized (listener) {
            for (final IResourceIssueStoreListener iResourceIssueStoreListener : listener) {
                if (semanticURI.equals(iResourceIssueStoreListener.getSemanticURI())) {
                    iResourceIssueStoreListener.issuesChanged();
                }
            }
        }
    }

    protected synchronized void reloadMarkerIssues() {
        final Multimap<String, SCTIssue> newLiveIssues = ArrayListMultimap.create();
        final List<IMarker> markers = Lists.newArrayList();
        try {
            final IFile file = WorkspaceSynchronizer.getFile(connectedResource);
            if ((file != null) && file.isAccessible()) {
                markers.addAll(Arrays.asList(file.findMarkers(getMarkerType(), true, IResource.DEPTH_INFINITE)));
            }
        } catch (final CoreException e) {
           e.printStackTrace();
        }
        for (final IMarker iMarker : markers) {
            final SCTIssue issue = markerChangeProcessor.createFromMarker(iMarker,
                    iMarker.getAttribute(org.eclipse.gmf.runtime.common.core.resources.IMarker.ELEMENT_ID, ""));
            newLiveIssues.put(issue.getSemanticURI(), issue);
        }
        switchLiveIssues(newLiveIssues);
    }

    @Override
    public void connect(final Resource resource) {
        if (connected) {
            throw new IllegalStateException("Issue store is already connected to a resource");
        }
        connectedResource = resource;
        final IFile file = WorkspaceSynchronizer.getFile(resource);
        if ((file != null) && file.isAccessible()) {
            ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
            connected = true;
        }
        reloadMarkerIssues();
    }

    @Override
    public void disconnect(final Resource resource) {
        final IFile file = WorkspaceSynchronizer.getFile(resource);
        if ((file != null) && file.isAccessible()) {
            ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
            connected = false;
            connectedResource = null;
            synchronized (listener) {
                listener.clear();
            }
        }
    }

    @Override
    public synchronized void processIssues(final List<Issue> issues, final IProgressMonitor monitor) {
        final Multimap<String, SCTIssue> newLiveIssues = ArrayListMultimap.create();
        for (final Issue issue : issues) {
            if (issue instanceof SCTIssue) {
                final String semanticURI = ((SCTIssue) issue).getSemanticURI();
                newLiveIssues.put(semanticURI, (SCTIssue) issue);
            }
        }
        switchLiveIssues(newLiveIssues);
    }

    protected void switchLiveIssues(final Multimap<String, SCTIssue> newLiveIssues) {
        synchronized (visibleIssues) {
            visibleIssues.clear();
            visibleIssues.putAll(newLiveIssues);
        }
        notifyListeners();
    }

    @Override
    public synchronized List<SCTIssue> getIssues(final String uri) {
        final List<SCTIssue> result = Lists.newArrayList();
        synchronized (visibleIssues) {
            Iterables.addAll(result, visibleIssues.get(uri));
        }
        return result;
    }

    protected boolean liveValidationEnabled() {
        return DiagramActivator.getDefault().getPreferenceStore()
                .getBoolean(StatechartPreferenceConstants.PREF_LIVE_VALIDATION);
    }

    protected boolean isSctMarker(final IMarker marker) {
        try {
            return isSctMarker(marker.getAttributes());
        } catch (final CoreException e) {
           e.printStackTrace();
        }
        return false;
    }

    protected boolean isSctMarker(final Map<?, ?> markerAttributes) {
        return markerAttributes.get(SCTMarkerCreator.ELEMENT_ID) != null;
    }

    @Override
    public void resourceChanged(final IResourceChangeEvent event) {
        // after a change...
        if ((IResourceChangeEvent.POST_CHANGE != event.getType())) {
            return;
        }
        final IFile file = WorkspaceSynchronizer.getFile(connectedResource);
        final IResourceDelta deltaForFile = getDeltaForFile(event, file);
        // if the current resource was changed...
        if (deltaForFile == null) {
            return;
        }
        try {
            synchronized (visibleIssues) {
                markerChangeProcessor.setCurrentIssues(visibleIssues);
                // visit and prepare future visible issues
                deltaForFile.accept(markerChangeProcessor);
                //don't forget to clear current issues
                visibleIssues.clear();
                // set the issues visible in future...
                visibleIssues.putAll(markerChangeProcessor.getCurrentIssues());
            }
            // notify interested listeners...
            for (final String string : markerChangeProcessor.getChangedElementIDs()) {
                notifyListeners(string);
            }
        } catch (final CoreException e) {
            e.printStackTrace();
        }
    }

    protected IResourceDelta getDeltaForFile(final IResourceChangeEvent event, final IFile file) {
        final String[] segments = file.getFullPath().segments();
        IResourceDelta currentDelta = event.getDelta();
        for (final String segment : segments) {
            final IResourceDelta matchingDelta = currentDelta.findMember(new Path(segment));
            if (matchingDelta != null) {
            	//found the path segment within the current delta...
                currentDelta = matchingDelta;
                //continue finding the next segement within the previously matched delta.
                continue;
            }
            //...this delta does not include the given file
            return null;
        }
        //all segments matched, this is the delta for the given file
        return currentDelta;
    }

}
