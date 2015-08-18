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
package org.yakindu.gmf.runtime.treelayout.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.yakindu.gmf.runtime.treelayout.TreeLayoutUtil;
import org.yakindu.gmf.runtime.treelayout.UIUtils;

/**
 * 
 * @author Markus Muehlbrandt
 *
 */
public class UpdateAnnotationsOnReorientRelationshipCommand extends
		AbstractTransactionalCommand {

	private final ReorientRelationshipRequest request;

	private final IGraphicalEditPart sourceEditPart;

	public UpdateAnnotationsOnReorientRelationshipCommand(
			ReorientRelationshipRequest request,
			IGraphicalEditPart sourceEditPart) {
		super(request.getEditingDomain(), request.getLabel(), null);
		this.request = request;
		this.sourceEditPart = sourceEditPart;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		// Update annotations of old connection end;
		final IGraphicalEditPart oldEnd = UIUtils.getEditPart(request
				.getOldRelationshipEnd());
		if (oldEnd != null) {

			final List<IGraphicalEditPart> treeChildren = TreeLayoutUtil
					.getOrderedTreeChildren(oldEnd);
			treeChildren.remove(sourceEditPart);
			TreeLayoutUtil.setTreeNodesPositionAnnotation(TreeLayoutUtil
					.getViews(treeChildren));
		}

		// Update annotations of new connection end;
		final IGraphicalEditPart newEnd = UIUtils.getEditPart(request
				.getNewRelationshipEnd());
		if (newEnd != null) {
			final List<IGraphicalEditPart> treeChildren = TreeLayoutUtil
					.getOrderedTreeChildren(newEnd);
			treeChildren.add(sourceEditPart);

			TreeLayoutUtil.setTreeNodesPositionAnnotation(TreeLayoutUtil
					.getViews(treeChildren));

			// Update parentAnnotation to new end
			TreeLayoutUtil.setTreeNodeParentAnnotation(
					sourceEditPart.getNotationView(), newEnd.getNotationView());
		}

		return CommandResult.newOKCommandResult();
	}
}
