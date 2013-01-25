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
package org.yakindu.sct.refactoring.handlers.impl;

import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.yakindu.sct.refactoring.handlers.AbstractRefactoringHandler;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.refactoring.refactor.impl.GroupStatesIntoCompositeRefactoring;

import com.google.common.collect.Lists;
/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class GroupStatesIntoCompositeHandler extends
		AbstractRefactoringHandler<View> {

	@Override
	public AbstractRefactoring<View> createRefactoring() {
		return new GroupStatesIntoCompositeRefactoring();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setContext(AbstractRefactoring<View> refactoring,
			ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		List<IGraphicalEditPart> editParts = structuredSelection.toList();
		List<View> result = Lists.newArrayList();
		for (IGraphicalEditPart editPart : editParts) {
			result.add(editPart.getNotationView());
		}
		refactoring.setContextObjects(result);
	}

}
