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
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
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
		Diagram diagram = DiagramPartitioningUtil.getSubDiagram(firstElement.resolveSemanticElement());
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorReference[] refs = activePage.getEditorReferences();
		for (IEditorReference ref : refs) {
			try {
				if (ref.getEditorInput() instanceof IDiagramEditorInput) {
					IDiagramEditorInput diagramInput = (IDiagramEditorInput) ref.getEditorInput();
					if (diagramInput.getDiagram().equals(diagram)) {
						boolean close = MessageDialog.openQuestion(new Shell(), "Close subdiagram editor?",
								"The subdiagram is still open in another editor. Do you want to close it?");
						if (close) {
							activePage.closeEditor(ref.getEditor(false), false);
						}
						return close;
					}
				}
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
