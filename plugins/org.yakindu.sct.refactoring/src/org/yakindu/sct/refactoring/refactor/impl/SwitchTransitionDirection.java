package org.yakindu.sct.refactoring.refactor.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;

/* 
 * TODO: This is not really a Refactoring. A Refactoring changes stuff without changing what it does, which does
 * not apply on this "refactoring". There does not seem to be a better place for this at the moment, so when something like
 * Modifications exists, this should be moved there.
 */
public class SwitchTransitionDirection extends AbstractRefactoring<TransitionEditPart> {

	@Override
	protected void internalExecute() {
		switchTransitionDirection();
	}

	protected void switchTransitionDirection() {
		TransitionEditPart transitionEditPart = getContextObject();
		Transition transition = transitionEditPart.resolveSemanticElement();
		
		Vertex oldSource = transition.getSource();
		Vertex oldTarget = transition.getTarget();
		
		transition.setTarget(oldSource);
		transition.setSource(oldTarget);
		
		EditPart oldSourceEP = transitionEditPart.getSource();
		EditPart oldTargetEP = transitionEditPart.getTarget();
		
		transitionEditPart.setTarget(oldSourceEP);
		transitionEditPart.setSource(oldTargetEP);
	}
	

	@Override
	protected String getCommandLabel() {
		return "Switch Transition direction";
	}
	
	@Override
	protected Resource getResource() {
		return getContextObject().resolveSemanticElement().eResource();
	}
}
