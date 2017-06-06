package org.yakindu.sct.refactoring.handlers;

import java.util.Collections;

import org.eclipse.jface.viewers.ISelection;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;

import com.google.common.collect.Lists;

public abstract class AbstractTransitionRefactoringHandler extends AbstractRefactoringHandler<Transition> {

	@Override
	public void setContext(AbstractRefactoring<Transition> refactoring, ISelection selection) {
		TransitionEditPart element = (TransitionEditPart) getFirstElement(selection);
		if (element == null) {
			refactoring.setContextObjects(Collections.<Transition>emptyList());
		} else {
			Transition transition = element.resolveSemanticElement();
			refactoring.setContextObjects(Lists.newArrayList(transition));
		}
	}

}
