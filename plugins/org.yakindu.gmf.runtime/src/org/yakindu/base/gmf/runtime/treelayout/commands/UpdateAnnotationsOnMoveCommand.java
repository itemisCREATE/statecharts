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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.base.gmf.runtime.treelayout.TreeLayoutConstraint;
import org.yakindu.base.gmf.runtime.treelayout.TreeLayoutUtil;

/**
 * 
 * @author Markus Muehlbrandt
 *
 */
public class UpdateAnnotationsOnMoveCommand extends
		AbstractTransactionalCommand {

	private final IGraphicalEditPart editPart;

	private final TreeLayoutConstraint layoutConstraint;

	public UpdateAnnotationsOnMoveCommand(
			TransactionalEditingDomain editingDomain,
			IGraphicalEditPart editPart, TreeLayoutConstraint layoutConstraint) {
		super(editingDomain, "Move TreeNode", null);
		this.editPart = editPart;
		this.layoutConstraint = layoutConstraint;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		final View parentView = TreeLayoutUtil.getTreeNodeParentView(editPart
				.getNotationView());

		if (parentView != null) {
			final IGraphicalEditPart parentEditPart = (IGraphicalEditPart) editPart
					.findEditPart(editPart.getParent(), parentView.getElement());
			if (parentEditPart != null) {
				final List<IGraphicalEditPart> treeChildren = new ArrayList<IGraphicalEditPart>(

				TreeLayoutUtil.getOrderedTreeChildren(parentEditPart));
				if (!treeChildren.isEmpty()) {
					final int oldPos = treeChildren.indexOf(editPart);
					final int newPos = layoutConstraint.getTreeInnerRankIndex();

					if (newPos != -1) {
						if (oldPos != newPos) {
							final IGraphicalEditPart element = treeChildren
									.get(oldPos);
							treeChildren.remove(oldPos);
							treeChildren.add(newPos, element);
							TreeLayoutUtil
									.setTreeNodesPositionAnnotation(TreeLayoutUtil
											.getViews(treeChildren));
						}
					}
					return CommandResult.newOKCommandResult();
				}

			}
		}
		return CommandResult
				.newErrorCommandResult("Parent view or parent edit part not found!");
	}
}
