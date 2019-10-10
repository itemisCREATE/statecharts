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
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.handlers.HandlerUtil;
import org.yakindu.base.gmf.runtime.editpolicies.SetPreferredSizeRequest;
import org.yakindu.sct.refactoring.handlers.AbstractViewRefactoringHandler;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.refactoring.refactor.impl.InlineSubdiagramRefactoring;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

/**
 * Handler for {@link InlineSubdiagramRefactoring}.
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
			super.execute(event);
		setPreferredSize(event);
		return null;
	}

	private Object setPreferredSize(ExecutionEvent event) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) getFirstElement(HandlerUtil.getCurrentSelection(event));
		Command cmd = editPart.getCommand(new SetPreferredSizeRequest(editPart));
		AbstractRefactoring.executeCommand(new CommandProxy(cmd), editPart.resolveSemanticElement().eResource());
		return null;
	}

	private boolean allEditorsAreClosed(ExecutionEvent event) {
		StateEditPart firstElement = (StateEditPart) getFirstElement(HandlerUtil.getCurrentSelection(event));
		return DiagramPartitioningUtil.closeSubdiagramEditors(firstElement.resolveSemanticElement());
	}
}
