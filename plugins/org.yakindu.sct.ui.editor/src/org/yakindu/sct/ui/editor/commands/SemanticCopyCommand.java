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

import java.util.ArrayList;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * @author andreas muelder
 * 
 */
public class SemanticCopyCommand extends AbstractTransactionalCommand {

	private static final String COPY = "Copy";

	// TODO
	public static final String DRAWING_SURFACE = "Drawing Surface";

	private final List<IGraphicalEditPart> selectedObjects;

	public SemanticCopyCommand(TransactionalEditingDomain domain,
			List<IGraphicalEditPart> selectedObjects) {
		super(domain, COPY, null);
		this.selectedObjects = selectedObjects;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		String semanticString = ClipboardUtil.copyElementsToString(
				getSemanticElements(), null, new NullProgressMonitor());
		String notationString = ClipboardUtil.copyElementsToString(
				getNotationElements(), null, new NullProgressMonitor());

		CustomData semanticData = new CustomData(DRAWING_SURFACE,
				semanticString.getBytes());
		CustomData notationData = new CustomData(DRAWING_SURFACE,
				notationString.getBytes());

		ClipboardManager.getInstance().addToCache(
				new ICustomData[] { notationData, semanticData },
				CustomDataTransfer.getInstance());
		
		ClipboardManager.getInstance().flushCacheToClipboard();
		
		return CommandResult.newOKCommandResult();
	}

	protected List<EObject> getSemanticElements() {
		List<EObject> result = new ArrayList<EObject>();
		for (IGraphicalEditPart editPart : selectedObjects) {
			EObject resolveSemanticElement = editPart.resolveSemanticElement();
			result.add(resolveSemanticElement);
		}
		return result;
	}

	protected List<View> getNotationElements() {
		List<View> result = new ArrayList<View>();
		for (IGraphicalEditPart editPart : selectedObjects) {
			View view = editPart.getNotationView();
			result.add(view);
		}
		return result;
	}
}
