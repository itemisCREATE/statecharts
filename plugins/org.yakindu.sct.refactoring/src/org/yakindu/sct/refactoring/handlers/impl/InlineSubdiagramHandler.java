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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.handlers.HandlerUtil;
import org.yakindu.sct.refactoring.handlers.AbstractViewRefactoringHandler;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.refactoring.refactor.impl.InlineSubdiagramRefactoring;
import org.yakindu.sct.ui.editor.breadcrumb.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class InlineSubdiagramHandler extends AbstractViewRefactoringHandler {

	@Override
	public AbstractRefactoring<View> createRefactoring() {
		return new InlineSubdiagramRefactoring();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (allEditorsAreClosed(event))
			return super.execute(event);
		return null;
	}

	private boolean allEditorsAreClosed(ExecutionEvent event) {
		StateEditPart firstElement = (StateEditPart) getFirstElement(HandlerUtil.getCurrentSelection(event));
		return DiagramPartitioningUtil.closeSubdiagramEditors(firstElement.resolveSemanticElement());
	}
}
