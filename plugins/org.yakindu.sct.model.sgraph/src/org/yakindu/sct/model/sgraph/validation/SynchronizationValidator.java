/**
 * Copyright (c) 2012-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.validation;

import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.areOrthogonal;
import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.collectAncestors;
import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.sources;
import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.targets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * 
 * All validation constraints for the meta model element {@link Synchronization}
 * 
 */
public class SynchronizationValidator extends AbstractSGraphValidator {


	private static final String SYNCHRONIZATION_TRANSITIONS_REQUIRE_N_OUT_MSG = "A synchronization must have at least one outgoing transition.";
	public static final String SYNCHRONIZATION_TRANSITIONS_REQUIRE_N_OUT_CODE = "synchronization.transitions.RequireNOut";

	@Check(CheckType.FAST)
	public void checkSynchronizationTransitionsRequireNOut(Synchronization sync) {
		if (sync.getOutgoingTransitions().size() == 0) {
			error(SYNCHRONIZATION_TRANSITIONS_REQUIRE_N_OUT_MSG, sync, null, -1, SYNCHRONIZATION_TRANSITIONS_REQUIRE_N_OUT_CODE);
		}
	}


	
	private static final String SYNCHRONIZATION_TRANSITIONS_REQUIRE_MULTIPLE_IN_OR_MULTIPLE_OUT_MSG = "A synchronization must have either multiple incoming or multiple outgoing transitions.";
	public static final String SYNCHRONIZATION_TRANSITIONS_REQUIRE_MULTIPLE_IN_OR_MULTIPLE_OUT_CODE = "synchronization.transitions.RequireMultipleInOrMultipleOut";
	
	@Check(CheckType.FAST)
	public void checkSynchronizationTransitionsRequireMultipleInOrMultipleOut(Synchronization sync) {
		int in = sync.getIncomingTransitions().size();
		int out = sync.getOutgoingTransitions().size();
		if (in < 2 && out < 2) {
			error(SYNCHRONIZATION_TRANSITIONS_REQUIRE_MULTIPLE_IN_OR_MULTIPLE_OUT_MSG, sync, null, -1, SYNCHRONIZATION_TRANSITIONS_REQUIRE_MULTIPLE_IN_OR_MULTIPLE_OUT_CODE);
		}
	}


	
	private static final String SYNCHRONIZATION_REQUIRES_ORTHOGONAL_SOURCE_STATES_MSG = "The source states of a synchronization must be orthogonal.";
	public static final String SYNCHRONIZATION_REQUIRES_ORTHOGONAL_SOURCE_STATES_CODE = "synchronization.RequiresOrthogonalSourceStates";

	@Check
	public void checkSynchronizationRequiresOrthogonalSourceStates(Synchronization sync) {
		List<Vertex> sourceVertices = sources(sync.getIncomingTransitions());
		if (!areOrthogonal(sourceVertices)) {
			error(SYNCHRONIZATION_REQUIRES_ORTHOGONAL_SOURCE_STATES_MSG, sync, null, -1, SYNCHRONIZATION_REQUIRES_ORTHOGONAL_SOURCE_STATES_CODE);
		}
	}

	
	
	private static final String SYNCHRONIZATION_REQUIRES_ORTHOGONAL_TARGET_STATES_MSG = "The target states of a synchronization must be orthogonal.";
	public static final String SYNCHRONIZATION_REQUIRES_ORTHOGONAL_TARGET_STATES_CODE = "synchronization.RequiresOrthogonalTargetStates";

	@Check
	public void checkSynchronizationRequiresOrthogonalTargetStates(Synchronization sync) {
		List<Vertex> sourceVertices = targets(sync.getOutgoingTransitions());
		if (!areOrthogonal(sourceVertices)) {
			error(SYNCHRONIZATION_REQUIRES_ORTHOGONAL_TARGET_STATES_MSG, sync, null, -1, SYNCHRONIZATION_REQUIRES_ORTHOGONAL_TARGET_STATES_CODE);
		}
	}


	
	private static final String SYNCHRONIZATION_REQUIRES_SOURCE_STATES_ORTHOGONAL_TO_TARGET_STATES_MSG = "A synchronization's source states must be orthogonal to it's target states. (Common ancestor must be a region.)";
	public static final String SYNCHRONIZATION_REQUIRES_SOURCE_STATES_ORTHOGONAL_TO_TARGET_STATES_CODE = "synchronization.RequiresSourceStatesOrthogonalToTargetStates";

	@Check
	public void checkSynchronizationRequiresSourceStatesOrthogonalToTargetStates(Synchronization sync) {
		
		List<Transition> incoming = sync.getIncomingTransitions();
		List<List<EObject>> inAncestorsList = new ArrayList<>();
		for (Transition trans : incoming) {
			inAncestorsList.add(collectAncestors(trans.getSource(), new ArrayList<EObject>()));
		}

		List<Transition> outgoing = sync.getOutgoingTransitions();
		List<List<EObject>> outAncestorsList = new ArrayList<>();
		for (Transition trans : outgoing) {
			outAncestorsList.add(collectAncestors(trans.getTarget(), new ArrayList<EObject>()));
		}

		Set<Transition> inOrthogonal = new HashSet<>();
		Set<Transition> outOrthogonal = new HashSet<>();

		if (incoming.size() == 0 || outgoing.size() == 0) {
			return;
		}

		for (int i = 0; i < incoming.size(); i++) {
			for (int j = 0; j < outgoing.size(); j++) {

				List<Vertex> states = new ArrayList<>(
						Arrays.asList(incoming.get(i).getSource(), outgoing.get(j).getTarget()));

				if (areOrthogonal(states)) {
					inOrthogonal.add(incoming.get(i));
					outOrthogonal.add(outgoing.get(j));
				}
			}
		}
		for (Transition trans : inOrthogonal) {
			error(SYNCHRONIZATION_REQUIRES_SOURCE_STATES_ORTHOGONAL_TO_TARGET_STATES_MSG, trans, null, -1,
					SYNCHRONIZATION_REQUIRES_SOURCE_STATES_ORTHOGONAL_TO_TARGET_STATES_CODE);
		}
		for (Transition trans : outOrthogonal) {
			error(SYNCHRONIZATION_REQUIRES_SOURCE_STATES_ORTHOGONAL_TO_TARGET_STATES_MSG, trans, null, -1,
					SYNCHRONIZATION_REQUIRES_SOURCE_STATES_ORTHOGONAL_TO_TARGET_STATES_CODE);
		}

	}

}
