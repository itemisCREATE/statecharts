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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.yakindu.sct.model.sgraph.ui.validation.SCTIssue;

import com.google.common.collect.Multimap;

/**
 * An statechart marker processor which maintains a given bunch of {@link SCTIssue}s by visiting a given marker delta.
 *
 * @author Johannes Dicks - Initial contribution and API
 */
public interface IMarkerChangeProcessor extends IResourceDeltaVisitor {

    /**
     * Returns the issues processed in time after {@link #setCurrentIssues(Multimap)}.
     *
     * @return the current visible issues
     */
    Multimap<String, SCTIssue> getCurrentIssues();

    /**
     * Set the current issues which will be maintained. Resets the internal updated IDs.
     *
     * @param liveIssues
     *            the actual state
     */
    void setCurrentIssues(Multimap<String, SCTIssue> liveIssues);

    /**
     * Returns the IDs of elements changed after the last call to {@link #setCurrentIssues(Multimap)}
     * 
     * @return the ids of related objects being updated during the current period (what ever a period is)
     */
    Set<String> getChangedElementIDs();

    /**
     * Processes the given delta if it contains {@link IResourceDelta.CHANGED } {@link IResourceDelta.MARKERS}. Implementers have to maintain the updated element IDs & current issues.
     */
    @Override
    boolean visit(IResourceDelta delta);

    /**
     * Create an issue for the given marker.
     *
     * @param marker
     *            a marker, might be a deleted marker
     * @param id
     *            the marker corresponds to this id
     * @return a statechart issue
     */
    SCTIssue createFromMarker(IMarker marker, String id);

}