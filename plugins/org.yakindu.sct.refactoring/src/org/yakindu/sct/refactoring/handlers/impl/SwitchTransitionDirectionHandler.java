package org.yakindu.sct.refactoring.handlers.impl;

import org.yakindu.sct.refactoring.handlers.AbstractTransitionRefactoringHandler;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.refactoring.refactor.impl.SwitchTransitionDirection;
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;

public class SwitchTransitionDirectionHandler extends AbstractTransitionRefactoringHandler {

	@Override
	public AbstractRefactoring<TransitionEditPart> createRefactoring() {
		return new SwitchTransitionDirection();
	}

}
