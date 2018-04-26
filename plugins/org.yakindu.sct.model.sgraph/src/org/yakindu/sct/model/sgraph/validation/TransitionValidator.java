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

import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.commonAncestor;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * 
 * All validation constraints for the meta model element {@link Transition}
 * 
 */
public class TransitionValidator extends AbstractSGraphValidator {

	private static final String TRANSITION_SOURCE_TARGET_NOT_ORTHOGONAL_MSG = "Source and target of a transition must not be located in orthogonal regions!";
	public static final String TRANSITION_SOURCE_TARGET_NOT_ORTHOGONAL_CODE = "transition.source.target";

	private static final String INITIAL_ENTRY_WITH_TRANSITION_TO_CONTAINER_MSG = "Outgoing transitions from entries can only target to sibling or inner states.";
	public static final String INITIAL_ENTRY_WITH_TRANSITION_TO_CONTAINER_CODE = "transition.source.entry";

	@Check
	public void orthogonalTransition(Transition transition) {
		Vertex source = transition.getSource();
		Vertex target = transition.getTarget();
		if ((source instanceof Synchronization) || (target instanceof Synchronization))
			return;
		EObject commonAncestor = commonAncestor(source, target);
		if (commonAncestor instanceof CompositeElement) {
			error(TRANSITION_SOURCE_TARGET_NOT_ORTHOGONAL_MSG, transition, null, -1,
					TRANSITION_SOURCE_TARGET_NOT_ORTHOGONAL_CODE);
		}
	}

	@Check(CheckType.FAST)
	public void initialEntryWithTransitionToContainer(Transition t) {
		if (t.getSource() instanceof Entry && !isChildOrSibling(t.getSource(), t.getTarget())) {
			error(INITIAL_ENTRY_WITH_TRANSITION_TO_CONTAINER_MSG, t, null, -1,
					INITIAL_ENTRY_WITH_TRANSITION_TO_CONTAINER_CODE);
		}
	}

	protected boolean isChildOrSibling(Vertex source, Vertex target) {
		TreeIterator<EObject> iter = source.getParentRegion().eAllContents();
		while (iter.hasNext()) {
			if (target == iter.next()) {
				return true;
			}
		}
		return false;
	}
}
