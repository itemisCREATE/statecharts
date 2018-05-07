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

	private static final String RANSITION_SOURCE_NOT_ORTHOGONAL_TO_TARGET_MSG = "Source and target of a transition must not be located in orthogonal regions!";
	public static final String  TRANSITION_SOURCE_NOT_ORTHOGONAL_TO_TARGET_CODE = "transition.SourceNotOrthogonalToTarget";

	@Check
	public void checkTransitionSourceNotOrthogonalToTarget(Transition transition) {
		Vertex source = transition.getSource();
		Vertex target = transition.getTarget();
		if ((source instanceof Synchronization) || (target instanceof Synchronization))
			return;
		EObject commonAncestor = commonAncestor(source, target);
		if (commonAncestor instanceof CompositeElement) {
			error(RANSITION_SOURCE_NOT_ORTHOGONAL_TO_TARGET_MSG, transition, null, -1,
					TRANSITION_SOURCE_NOT_ORTHOGONAL_TO_TARGET_CODE);
		}
	}


	
}
