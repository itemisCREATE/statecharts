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
package org.yakindu.sct.ui.editor.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.ui.action.actions.global.ClipboardManager;
import org.eclipse.gmf.runtime.common.ui.util.CustomData;
import org.eclipse.gmf.runtime.common.ui.util.CustomDataTransfer;
import org.eclipse.gmf.runtime.common.ui.util.ICustomData;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

/**
 * 
 * @author andreas muelder
 * 
 */
public class SemanticCopyCommand extends AbstractTransactionalCommand {

	private static final String COPY = "Copy";

	// TODO
	public static final String DRAWING_SURFACE = "Drawing Surface";

	private final List<EObject> selectedObjects;

	public SemanticCopyCommand(TransactionalEditingDomain domain,
			List<EObject> selectedObjects) {
		super(domain, COPY, null);
		this.selectedObjects = selectedObjects;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		String clipString = ClipboardUtil.copyElementsToString(
				getSelectedObjects(), null, new NullProgressMonitor());

		CustomData data = new CustomData(DRAWING_SURFACE, clipString.getBytes());
		ClipboardManager.getInstance().addToCache(new ICustomData[] { data },
				CustomDataTransfer.getInstance());

		return CommandResult.newOKCommandResult();
	}

	private List<EObject> getSelectedObjects() {
		return selectedObjects;
	}

}
