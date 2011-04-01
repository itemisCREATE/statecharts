/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.policies;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.yakindu.model.sct.statechart.Region;
import org.yakindu.model.sct.statechart.Transition;
import org.yakindu.model.sct.statechart.Vertex;
import org.yakindu.sct.statechart.diagram.providers.SemanticHints;
import org.yakindu.sct.statechart.diagram.utils.SemanticHintUtil;

import com.google.common.collect.Lists;

/**
 * 
 * @author muelder
 * 
 */
public class RegionCompartmentCanonicalEditPolicy extends
		CanonicalConnectionEditPolicy {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected List getSemanticChildrenList() {
		return getSemanticHost().getVertices();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected List getSemanticConnectionsList() {
		List<Transition> transitions = Lists.newArrayList();
		EList<Vertex> vertices = getSemanticHost().getVertices();
		for (Vertex vertex : vertices) {
			transitions.addAll(vertex.getOutgoingTransitions());
		}
		return transitions;
	}

	@Override
	protected EObject getSourceElement(EObject relationship) {
		Assert.isTrue(relationship instanceof Transition);
		Transition transition = (Transition) relationship;
		return transition.getSource();
	}

	@Override
	protected EObject getTargetElement(EObject relationship) {
		Assert.isTrue(relationship instanceof Transition);
		Transition transition = (Transition) relationship;
		return transition.getTarget();
	}

	@Override
	public Region getSemanticHost() {
		return (Region) super.getSemanticHost();
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	@Override
	protected String getFactoryHint(IAdaptable elementAdapter) {
		EObject modelElement = (EObject) elementAdapter
				.getAdapter(EObject.class);
		String factoryHint = SemanticHintUtil.getSemanticHint(modelElement);
		return factoryHint;
	}

	@Override
	protected String getDefaultFactoryHint() {
		return SemanticHints.TRANSITION;
	}
}
