package org.yakindu.sct.refactoring.refactor.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;

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
