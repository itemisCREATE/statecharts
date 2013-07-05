/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.editparts.EntryEditPart;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class SetEntryKindCommand extends AbstractHandler {

	private Entry entry;
	
	public abstract EntryKind getEntryKind();
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		entry = unwrap(HandlerUtil.getCurrentSelection(event));
		
		if (entry == null)
			return null;
		SetValueCommand setCommand = new SetValueCommand(new SetRequest(entry,
				SGraphPackage.Literals.ENTRY__KIND, getEntryKind()));
		IOperationHistory history = OperationHistoryFactory
				.getOperationHistory();
		try {
			history.execute(setCommand, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
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
	
	@Override
	public boolean isEnabled() {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getSelection();
		entry = unwrap(selection);
		return entry != null && !entry.getKind().equals(getEntryKind());
	}

}
