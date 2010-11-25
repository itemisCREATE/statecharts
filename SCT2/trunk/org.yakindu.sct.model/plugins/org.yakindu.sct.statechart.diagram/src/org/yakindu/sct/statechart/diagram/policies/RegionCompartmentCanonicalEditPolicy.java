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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.yakindu.sct.model.statechart.statechart.Region;
import org.yakindu.sct.model.statechart.statechart.Transition;
import org.yakindu.sct.statechart.diagram.providers.ProviderConstants;
import org.yakindu.sct.statechart.diagram.utils.SemanticHintUtil;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class RegionCompartmentCanonicalEditPolicy extends CanonicalConnectionEditPolicy {

	@Override
	protected List getSemanticChildrenList() {
		return getSemanticHost().getVertices();
	}

	@Override
	protected List getSemanticConnectionsList() {
		return getSemanticHost().getTransitions();
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
		EObject modelElement = (EObject) elementAdapter.getAdapter(EObject.class);
		String factoryHint =  SemanticHintUtil.getSemanticHint(modelElement);
		return factoryHint;
	}
	
	@Override
	protected String getDefaultFactoryHint() {
		return ProviderConstants.TRANSITION;
	}
}
