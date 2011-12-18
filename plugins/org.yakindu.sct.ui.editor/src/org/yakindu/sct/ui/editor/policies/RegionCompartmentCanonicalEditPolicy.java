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
package org.yakindu.sct.ui.editor.policies;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.ui.editor.providers.SemanticHints;
import org.yakindu.sct.ui.editor.utils.SemanticHintUtil;

import com.google.common.collect.Lists;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class RegionCompartmentCanonicalEditPolicy extends
		CanonicalConnectionEditPolicy {

	@Override
	protected List getSemanticChildrenList() {
		return getSemanticHost().getVertices();
	}

	@Override
	protected List getSemanticConnectionsList() {
		List<Transition> transitions = Lists.newArrayList();
		EList<Vertex> vertices = getSemanticHost().getVertices();
		for (Vertex vertex : vertices) {
			transitions.addAll(vertex.getOutgoingTransitions());
		}
		return transitions;
	}

	protected boolean shouldIncludeConnection(Edge connection,
			Collection<View> children) {
		// Connections should only be included, when the source vertex is
		// contained in the region this edit policy belongs to
		Transition transition = (Transition) connection.getElement();
		Vertex source = transition.getSource();
		if (!getSemanticHost().getVertices().contains(source)) {
			return false;
		}
		return super.shouldIncludeConnection(connection, children);
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

	protected boolean shouldDeleteView(View view) {
		//#Bug 349119 
		if (ViewType.NOTE.equals(view.getType())
				| ViewType.NOTEATTACHMENT.equals(view.getType())
				|| ViewType.TEXT.equals(view.getType())) {
			return false;
		}
		return true;
	}

	@Override
	protected String getDefaultFactoryHint() {
		return SemanticHints.TRANSITION;
	}
}
