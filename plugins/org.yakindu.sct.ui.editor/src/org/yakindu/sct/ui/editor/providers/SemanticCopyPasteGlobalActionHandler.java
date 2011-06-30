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
package org.yakindu.sct.ui.editor.providers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.yakindu.sct.ui.editor.commands.SemanticCopyCommand;
import org.yakindu.sct.ui.editor.commands.SemanticPasteCommand;

/**
 * 
 * @author andreas muelder
 * 
 */
public class SemanticCopyPasteGlobalActionHandler extends
		DiagramGlobalActionHandler {

	public ICommand getCommand(IGlobalActionContext cntxt) {
		String actionId = cntxt.getActionId();
		if (actionId.equals(GlobalActionId.COPY)) {
			return getCopyCommand(cntxt);
		} else if (actionId.equals(GlobalActionId.CUT)) {
			return getCutCommand(cntxt);
		} else if (actionId.equals(GlobalActionId.PASTE)) {
			return getPasteCommand(cntxt);
		}
		return super.getCommand(cntxt);
	}

	private ICommand getCutCommand(IGlobalActionContext cntxt) {
		// TODO: Implement me
		return null;
	}

	protected ICommand getCopyCommand(IGlobalActionContext cntxt) {
		List<EObject> objects = getSelectedElements(cntxt.getSelection());
		if (objects.size() > 0) {
			TransactionalEditingDomain domain = TransactionUtil
					.getEditingDomain(objects.get(0));
			SemanticCopyCommand copyCmd = new SemanticCopyCommand(domain,
					objects);
			return copyCmd;
		}
		return null;
	}

	private ICommand getPasteCommand(IGlobalActionContext cntxt) {
		List<EObject> objects = getSelectedElements(cntxt.getSelection());
		if (objects.size() > 0) {
			return new SemanticPasteCommand(objects);
		}
		return null;
	}

	protected List<EObject> getSelectedElements(ISelection selection) {
		List<EObject> results = new ArrayList<EObject>();
		if (selection == null || selection.isEmpty())
			return results;
		Iterator<?> iterator = ((IStructuredSelection) selection).iterator();
		while (iterator.hasNext()) {
			Object selectedElement = iterator.next();
			if (selectedElement instanceof EditPart) {
				EObject element = (EObject) ((EditPart) selectedElement)
						.getAdapter(EObject.class);
				results.add(element);
			}
		}
		return results;
	}

}
