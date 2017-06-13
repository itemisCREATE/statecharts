package org.yakindu.sct.refactoring.handlers;

import java.util.Collections;

import org.eclipse.jface.viewers.ISelection;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;

import com.google.common.collect.Lists;

public abstract class AbstractTransitionRefactoringHandler extends AbstractRefactoringHandler<TransitionEditPart> {

	@Override
	public void setContext(AbstractRefactoring<TransitionEditPart> refactoring, ISelection selection) {
		TransitionEditPart element = (TransitionEditPart) getFirstElement(selection);
		if (element == null) {
			refactoring.setContextObjects(Collections.<TransitionEditPart>emptyList());
		} else {
			refactoring.setContextObjects(Lists.newArrayList(element));
		}
	}

}
