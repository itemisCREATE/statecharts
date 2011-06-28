/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.editparts.EntryEditPart;

/**
 * Abstract base class for {@link IActionDelegate} that change the entry kind of
 * an Entry.
 * 
 * @author andreas muelder
 * 
 */
public abstract class ChangeEntryKindCommand implements IActionDelegate {

	private Entry entry;

	public abstract EntryKind getEntryKind();

	/**
	 * Unwraps the given selection
	 * 
	 * @param selection
	 * @return
	 */
	public Entry unwrap(ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object firstElement = structuredSelection.getFirstElement();
		if (firstElement == null)
			return null;
		return ((EntryEditPart) firstElement).resolveSemanticElement();
	}

	public void run(IAction action) {

		if (entry == null)
			return;
		SetValueCommand setCommand = new SetValueCommand(new SetRequest(entry,
				SGraphPackage.Literals.ENTRY__KIND, getEntryKind()));
		IOperationHistory history = OperationHistoryFactory
				.getOperationHistory();
		try {
			history.execute(setCommand, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		entry = unwrap(selection);
		if (entry == null)
			return;
		if (entry.getKind().equals(getEntryKind())) {
			action.setEnabled(false);
			action.setChecked(true);
		} else {
			action.setEnabled(true);
			action.setChecked(false);
		}
	}
}
