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

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.ui.action.actions.global.ClipboardContentsHelper;
import org.eclipse.gmf.runtime.common.ui.action.actions.global.ClipboardManager;
import org.eclipse.gmf.runtime.common.ui.util.ICustomData;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.clipboard.SCTClipboardUtil;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author andreas muelder
 * 
 */
public class SemanticPasteCommand extends AbstractTransactionalCommand {

	private static final String PASTE = "Paste";
	private final List<IGraphicalEditPart> targets;

	public SemanticPasteCommand(List<IGraphicalEditPart> target) {
		super(
				TransactionUtil.getEditingDomain(target.get(0)
						.getNotationView()), PASTE, null);
		this.targets = target;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		
		ICustomData[] clipboardData = ClipboardManager.getInstance()
				.getClipboardData(SemanticCopyCommand.DRAWING_SURFACE,
						ClipboardContentsHelper.getInstance());
		
		Object object = SCTClipboardUtil.getObjectFromByteArray(clipboardData[0].getData());
		
		if (object instanceof Map<?, ?>) {
			copyElementsAndNotationViewAttributes((Map<byte[], String>) object);
		}
		
		else {
			String dataString = new String(clipboardData[0].getData());
			for (IGraphicalEditPart target : targets) {
				
				Collection semanticElements = ClipboardUtil.pasteElementsFromString(dataString,
						target.resolveSemanticElement(), null,
						new NullProgressMonitor());
			}
		}
		return CommandResult.newOKCommandResult();
	}
	
	@SuppressWarnings("unchecked")
	private void copyElementsAndNotationViewAttributes(Map<byte[], String> map) {
		for (IGraphicalEditPart target : targets) {
			Resource resource = target.resolveSemanticElement().eResource();
			for (byte[] semanticKeySet : map.keySet()) {

				EObject eObject = resource.getEObject(map.get(semanticKeySet));

				if (eObject instanceof Node) {
					Node view = (Node) eObject;

					Collection<EObject> semanticElements = (Collection<EObject>) ClipboardUtil
							.pasteElementsFromString(
									new String(semanticKeySet),
									target.resolveSemanticElement(), null,
									new NullProgressMonitor());

					EObject semanticElement = semanticElements.iterator()
							.next();

					View compartmentView = getStateCompartmentView(target.getNotationView());
					if (compartmentView!=null) {
						Node newNode = ViewService.createNode(
								compartmentView, semanticElement,
								view.getType(), target.getDiagramPreferencesHint());
						
						newNode.setLayoutConstraint(EcoreUtil.copy(view
								.getLayoutConstraint()));
					}
				}
			}
		}
	}
	
	private View getStateCompartmentView(View stateView) {
		for (Object object : stateView.getChildren()) {
			if (object instanceof View
					&& ((View) object).getType() == SemanticHints.REGION_COMPARTMENT) {
				return (View) object;
			}
		}
		return null;
	}
	
}
