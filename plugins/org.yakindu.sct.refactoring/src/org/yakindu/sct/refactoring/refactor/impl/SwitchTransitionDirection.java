package org.yakindu.sct.refactoring.refactor.impl;

import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;

public class SwitchTransitionDirection extends AbstractRefactoring<Transition> {

	@Override
	protected void internalExecute() {
		switchTransitionDirection();
	}

	protected void switchTransitionDirection() {
		Transition transition = getContextObject();
		
		Vertex oldSource = transition.getSource();
		Vertex oldTarget = transition.getTarget();
		
		transition.setTarget(null);
		transition.setSource(null);
		
		transition.setTarget(oldSource);
		transition.setSource(oldTarget);
	}
	

	@Override
	protected String getCommandLabel() {
		return "Switch Transition direction";
	}

}
