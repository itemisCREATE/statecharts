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
package org.yakindu.sct.refactoring.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractRefactoringHandler<T extends EObject> extends AbstractHandler {

	private AbstractRefactoring<T> refactoring;

	public abstract AbstractRefactoring<T> createRefactoring();

	public abstract void setContext(AbstractRefactoring<T> refactoring, ISelection selection);

	public AbstractRefactoringHandler() {
		refactoring = createRefactoring();
	}

	protected Object getFirstElement(ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		return structuredSelection.getFirstElement();
	}

	/**
	 * Calculates the enabled state based on the refactoring state
	 */
	@Override
	public boolean isEnabled() {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null)
			return false;
		ISelection selection = activeWorkbenchWindow.getActivePage().getSelection();
		if (selection == null)
			return false;
		setContext(refactoring, selection);
		return refactoring.isExecutable();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		refactoring.execute();
		return null;
	}

}
