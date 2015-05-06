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
package de.itemis.gmf.runtime.commons.treelayout.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import de.itemis.gmf.runtime.commons.treelayout.TreeLayoutUtil;
import de.itemis.gmf.runtime.commons.treelayout.UIUtils;

/**
 * 
 * @author Markus Muehlbrandt
 *
 */
public class UpdateAnnotationsOnDestroyElementCommand extends
		AbstractTransactionalCommand {

	private final DestroyElementRequest request;

	private final IGraphicalEditPart parentTreeNodeEditPart;

	public UpdateAnnotationsOnDestroyElementCommand(
			DestroyElementRequest request,
			IGraphicalEditPart parentTreeNodeEditPart) {
		super(request.getEditingDomain(), request.getLabel(), null);
		Assert.isNotNull(request, "request is null.");
		Assert.isNotNull(parentTreeNodeEditPart,
				"parentTreeNodeEditPart is null.");
		this.request = request;
		this.parentTreeNodeEditPart = parentTreeNodeEditPart;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		parentTreeNodeEditPart.getParent().refresh();
		final List<IGraphicalEditPart> treeChildren = TreeLayoutUtil
				.getOrderedTreeChildren(parentTreeNodeEditPart);
		treeChildren.remove(UIUtils.getEditPart(request.getElementToDestroy()));
		TreeLayoutUtil.setTreeNodesPositionAnnotation(TreeLayoutUtil
				.getViews(treeChildren));

		return CommandResult.newOKCommandResult();
	}
}
