/**
 * Copyright (c) 2013-2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editor.proposals;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.ui.editor.modifications.AbstractSemanticModification;

/**
 * This modification add a new outgoing transition to a new target state to a source state.
 * This modification will set the {@link #transitionSpecification} and {@link #stateName} if it is specified.
 * 
 * @author andreas muelder - Initial contribution and API
 * @author terfloth - adapted to new hooks.
 * 
 */
public class AddOutgoingStateModification extends AbstractSemanticModification {
	
	
	protected String transitionSpecification;
	protected String stateName;
	
	
	public AddOutgoingStateModification(View view) {
		this(view, null, null);
	}
	public AddOutgoingStateModification(View view, String transitionSpecification, String stateName) {
		super();
		setTargetView(view);
		this.transitionSpecification = transitionSpecification;
		this.stateName = stateName;
	}


	
	public String getTransitionSpecification() {
		return transitionSpecification;
	}
	
	public void setTransitionSpecification(String transitionSpecification) {
		this.transitionSpecification = transitionSpecification;
	}
	
	public String getStateName() {
		return stateName;
	}
	
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
	@Override
	protected boolean check(EObject semanticObject, View view) {
		return semanticObject instanceof State;
	}

	@Override
	protected void execute(EObject semanticElement, View view) {
		State state = (State) semanticElement;
		State newState = SGraphFactory.eINSTANCE.createState();
		Transition transition = SGraphFactory.eINSTANCE.createTransition();
		state.getParentRegion().getVertices().add(newState);
		transition.setSource(state);
		transition.setTarget(newState);
		
		if (transitionSpecification != null) transition.setSpecification(transitionSpecification);
		if (stateName != null) newState.setName(stateName);
	}
}
