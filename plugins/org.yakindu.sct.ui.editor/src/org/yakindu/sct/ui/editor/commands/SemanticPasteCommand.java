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
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.ui.action.actions.global.ClipboardContentsHelper;
import org.eclipse.gmf.runtime.common.ui.action.actions.global.ClipboardManager;
import org.eclipse.gmf.runtime.common.ui.util.ICustomData;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

/**
 * 
 * @author andreas muelder
 * 
 */
public class SemanticPasteCommand extends AbstractTransactionalCommand {

	private static final String PASTE = "Paste";
	private final List<EObject> targets;

	public SemanticPasteCommand(List<EObject> target) {
		super(TransactionUtil.getEditingDomain(target.get(0)), PASTE, null);
		this.targets = target;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		ICustomData[] clipboardData = ClipboardManager.getInstance()
				.getClipboardData(SemanticCopyCommand.DRAWING_SURFACE,
						ClipboardContentsHelper.getInstance());
		String data = new String(clipboardData[0].getData());
		for (EObject target : targets) {
			ClipboardUtil.pasteElementsFromString(data, target, null,
					new NullProgressMonitor());
		}
		return CommandResult.newOKCommandResult();
	}

}
