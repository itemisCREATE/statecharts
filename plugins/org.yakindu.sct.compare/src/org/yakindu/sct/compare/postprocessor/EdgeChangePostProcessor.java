/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.compare.postprocessor;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.diagram.internal.extensions.EdgeChange;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.yakindu.sct.model.sgraph.SGraphPackage;

/**
 * Postprocessor for adjusting dependencies between {@link EdgeChange} diffs and
 * {@link ReferenceChange}s for incoming/outgoing transitions.
 * 
 * @author thomas kutz - Initial contribution
 *
 */
@SuppressWarnings("restriction")
public class EdgeChangePostProcessor implements IPostProcessor {

	public EdgeChangePostProcessor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void postMatch(Comparison comparison, Monitor monitor) {
	}

	@Override
	public void postDiff(Comparison comparison, Monitor monitor) {
	}

	@Override
	public void postRequirements(Comparison comparison, Monitor monitor) {
	}

	@Override
	public void postEquivalences(Comparison comparison, Monitor monitor) {
	}

	@Override
	public void postConflicts(Comparison comparison, Monitor monitor) {
	}

	@Override
	public void postComparison(Comparison comparison, Monitor monitor) {
		for (Diff diff : comparison.getDifferences()) {
			if (diff instanceof EdgeChange) {
				EdgeChange edgeChange = (EdgeChange) diff;
				switch (edgeChange.getKind()) {
				case ADD:
					postProcessEdgeAddition(edgeChange);
					break;
				case DELETE:
					postProcessEdgeDeletion(edgeChange);
					break;
				default: // do nothing
				}

			}
		}
	}

	/**
	 * In this case by default following dependencies are created:<br>
	 * <br>
	 * EdgeDeletion --requires-> OutgoingTransitionDeletion <-requires--
	 * IncomingTransitionDeletion<br>
	 * <br>
	 * Needs to be changed into:<br>
	 * <br>
	 * EdgeDeletion --requires-> IncomingTransitionDeletion --requires->
	 * OutgoingTransitionDeletion<br>
	 * 
	 * @param edgeChange
	 */
	private void postProcessEdgeAddition(EdgeChange edgeChange) {
		Set<Diff> requiredIncomingTransitionAdditions = new HashSet<Diff>();
		for (Diff requireds : edgeChange.getRequires()) {
			if (requireds instanceof ReferenceChange) {
				ReferenceChange requiredRefChange = (ReferenceChange) requireds;
				// for required changes in outgoing transition refs we also need
				// to add the corresponding change in incoming transition refs
				if (requiredRefChange.getReference() == SGraphPackage.Literals.VERTEX__OUTGOING_TRANSITIONS
						&& requiredRefChange.getKind() == DifferenceKind.ADD) {
					requiredIncomingTransitionAdditions
							.addAll(findRequiredIncomingTransitionRefChange(
									requiredRefChange, DifferenceKind.ADD));
				}
			}
		}
		edgeChange.getRequires().addAll(requiredIncomingTransitionAdditions);
	}

	private Collection<Diff> findRequiredIncomingTransitionRefChange(
			ReferenceChange requiredRefChange, DifferenceKind changeKind) {
		for (Diff requiredBy : requiredRefChange.getRequiredBy()) {
			if (requiredBy instanceof ReferenceChange) {
				ReferenceChange requiredByRefChange = (ReferenceChange) requiredBy;
				if (requiredByRefChange.getReference() == SGraphPackage.Literals.VERTEX__INCOMING_TRANSITIONS
						&& requiredByRefChange.getKind() == changeKind) {
					return Collections
							.<Diff> singletonList(requiredByRefChange); // FIXME:
																		// collect
																		// all
																		// and
																		// return
																		// set?
																		// Are
																		// there
																		// cases
																		// where
																		// more
																		// than
																		// one
																		// should
																		// be
																		// returned?
				}
			}
		}
		return Collections.emptyList();
	}

	/**
	 * In this case by default following dependencies are created:<br>
	 * <br>
	 * EdgeDeletion <-requires-- OutgoingTransitionDeletion --requires->
	 * IncomingTransitionDeletion<br>
	 * <br>
	 * Needs to be changed into:<br>
	 * <br>
	 * EdgeDeletion --requires-> OutgoingTransitionDeletion --requires->
	 * IncomingTransitionDeletion<br>
	 * 
	 * @param edgeChange
	 */
	private void postProcessEdgeDeletion(EdgeChange edgeChange) {
		Set<Diff> requiredOutgoingTransitionDeletions = new HashSet<Diff>();
		for (Diff requireds : edgeChange.getRequiredBy()) {
			if (requireds instanceof ReferenceChange) {
				ReferenceChange requiredRefChange = (ReferenceChange) requireds;
				// for required changes in outgoing transition refs we also need
				// to add the corresponding change in incoming transition refs
				if (requiredRefChange.getReference() == SGraphPackage.Literals.VERTEX__OUTGOING_TRANSITIONS
						&& requiredRefChange.getKind() == DifferenceKind.DELETE) {
					requiredOutgoingTransitionDeletions.add(requiredRefChange);
				}
			}
		}
		edgeChange.getRequires().addAll(requiredOutgoingTransitionDeletions);
	}

}
