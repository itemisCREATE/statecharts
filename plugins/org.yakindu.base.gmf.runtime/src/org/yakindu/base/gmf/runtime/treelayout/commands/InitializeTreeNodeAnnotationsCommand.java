/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Markus Muehlbrandt - initial API and implementation
 * 
 */
package org.yakindu.base.gmf.runtime.treelayout.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.yakindu.base.gmf.runtime.treelayout.TreeLayoutUtil;

/**
 * 
 * @author Markus Muehlbrandt
 *
 */
public class InitializeTreeNodeAnnotationsCommand extends
		AbstractTransactionalCommand {

	private final IGraphicalEditPart treeRootNodeEditPart;

	public InitializeTreeNodeAnnotationsCommand(
			TransactionalEditingDomain domain,
			IGraphicalEditPart treeRootNodeEditPart) {
		super(domain, "InitializeTreeNodeAnnotationsCommand", null);
		this.treeRootNodeEditPart = treeRootNodeEditPart;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (CommandUtil.executeUndoableOperation(
				annotateElements(TreeLayoutUtil
						.getOrderedTreeChildren(treeRootNodeEditPart))).isOK()) {
			return CommandResult.newOKCommandResult();
		}
		return CommandResult.newErrorCommandResult(new ExecutionException(
				"Error while annotating model elements!"));
	}

	private CompositeTransactionalCommand annotateElements(
			List<IGraphicalEditPart> elements) {
		final CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), "AnnotateChildren");
		cmd.add(new SetTreeNodesPositionAnnotationCommand(getEditingDomain(),
				TreeLayoutUtil.getViews(elements)));
		for (final IGraphicalEditPart editPart : elements) {
			final List<IGraphicalEditPart> children = TreeLayoutUtil
					.getOrderedTreeChildren(editPart);
			if (!children.isEmpty()) {
				cmd.add(annotateElements(children));
			}
		}
		return cmd;
	}

}
