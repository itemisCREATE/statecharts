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
package org.yakindu.sct.ui.editor.commands;

import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CreateSubdiagramCommand extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Node state = unwrap(HandlerUtil.getCurrentSelection(event));
		if (state == null)
			return null;
		CreateSubDiagramCommand cmd = new CreateSubDiagramCommand(state);
		executeCommand(cmd);
		return null;
	}

	protected void executeCommand(AbstractTransactionalCommand operation) {
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		try {
			history.execute(operation, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public Node unwrap(ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object firstElement = structuredSelection.getFirstElement();
		if (firstElement == null)
			return null;
		return (Node) ((StateEditPart) firstElement).getNotationView();
	}

	@Override
	public boolean isEnabled() {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null)
			return false;
		ISelection selection = activeWorkbenchWindow.getActivePage().getSelection();
		if (selection == null)
			return false;
		Node unwrap = unwrap(selection);
		if (unwrap == null) {
			return false;
		}
		State state = (State) unwrap.getElement();
		if (state==null || state.isComposite())
			return false;
		BooleanValueStyle inlineStyle = DiagramPartitioningUtil.getInlineStyle(unwrap);
		if (inlineStyle != null && !inlineStyle.isBooleanValue())
			return false;
		return super.isEnabled();
	}

	protected static class CreateSubDiagramCommand extends AbstractTransactionalCommand {

		private Node node;

		public CreateSubDiagramCommand(Node node) {
			super(TransactionUtil.getEditingDomain(node), "Create Subdiagram", Collections
					.singletonList(WorkspaceSynchronizer.getFile(node.eResource())));
			this.node = node;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			BooleanValueStyle inlineStyle = DiagramPartitioningUtil.getInlineStyle(node);
			if (inlineStyle != null) {
				inlineStyle.setBooleanValue(false);
			} else {
				inlineStyle = DiagramPartitioningUtil.createInlineStyle();
				inlineStyle.setBooleanValue(false);
				node.getStyles().add(inlineStyle);
			}
			Diagram subdiagram = ViewService.createDiagram(node.getElement(), StatechartDiagramEditor.ID,
					DiagramActivator.DIAGRAM_PREFERENCES_HINT);
			node.eResource().getContents().add(subdiagram);
			return CommandResult.newOKCommandResult();
		}

	}
}
