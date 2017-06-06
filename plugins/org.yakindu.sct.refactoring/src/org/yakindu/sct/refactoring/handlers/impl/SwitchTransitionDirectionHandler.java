package org.yakindu.sct.refactoring.handlers.impl;

import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.refactoring.handlers.AbstractTransitionRefactoringHandler;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.refactoring.refactor.impl.SwitchTransitionDirection;

public class SwitchTransitionDirectionHandler extends AbstractTransitionRefactoringHandler {

	@Override
	public AbstractRefactoring<Transition> createRefactoring() {
		return new SwitchTransitionDirection();
	}

}
