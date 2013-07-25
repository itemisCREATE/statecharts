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
package org.yakindu.sct.ui.editor.editor.proposals;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import de.itemis.xtext.utils.gmf.proposals.AbstractSemanticModification;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class AddOutgoingStateModification extends AbstractSemanticModification {

	public boolean IsModificationFor(EObject object) {
		return object instanceof State;
	}

	@Override
	protected void internalExecute(EObject semanticElement, View view) {
		State state = (State) semanticElement;
		State newState = SGraphFactory.eINSTANCE.createState();
		Transition transition = SGraphFactory.eINSTANCE.createTransition();
		state.getParentRegion().getVertices().add(newState);
		transition.setSource(state);
		transition.setTarget(newState);
	}
}
