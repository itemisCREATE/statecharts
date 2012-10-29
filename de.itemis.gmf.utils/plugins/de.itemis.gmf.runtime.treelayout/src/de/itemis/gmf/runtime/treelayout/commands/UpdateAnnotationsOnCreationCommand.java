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
package de.itemis.gmf.runtime.treelayout.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

import de.itemis.gmf.runtime.treelayout.TreeLayoutUtil;

/**
 * 
 * @author Markus Muehlbrandt
 *
 */
public class UpdateAnnotationsOnCreationCommand extends
		AbstractTransactionalCommand {

	public static final String TREE_NODE_PARENT = "TreeNodeParent";

	public static final String ELEMENTS_TO_MERGE = "ElementsToMerge";

	private final CreateViewAndElementRequest request;

	public UpdateAnnotationsOnCreationCommand(
			TransactionalEditingDomain domain,
			CreateViewAndElementRequest request) {
		super(domain, "Update Annotations On Creation", null);
		this.request = request;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		final Object parent = request.getExtendedData().get(TREE_NODE_PARENT);
		if (parent != null && parent instanceof IGraphicalEditPart) {
			final IGraphicalEditPart parentEditPart = (IGraphicalEditPart) parent;
			final List<IGraphicalEditPart> editPartList = TreeLayoutUtil
					.getOrderedTreeChildren(parentEditPart);

			// Look if creation is done in context of merging elements, remove
			// elements to merge and update
			// annotation of elements.
			final Object object = request.getExtendedData().get(
					ELEMENTS_TO_MERGE);
			if (object != null && object instanceof List<?>) {
				final List<IGraphicalEditPart> elements = (List<IGraphicalEditPart>) object;
				editPartList.removeAll(elements);
				final List<View> viewList = TreeLayoutUtil.getViews(elements);
				TreeLayoutUtil.setTreeNodesPositionAnnotation(viewList);
			}

			final int position = TreeLayoutUtil.getNewTreeNodePosition(
					request.getLocation(), editPartList);
			if (position != -1 && !request.getViewDescriptors().isEmpty()) {
				final ViewDescriptor viewDescriptor = request
						.getViewDescriptors().get(0);
				final View newView = (View) viewDescriptor
						.getAdapter(View.class);
				final List<View> viewList = TreeLayoutUtil
						.getViews(editPartList);
				if (position == viewList.size()) {
					viewList.add(newView);
				} else {
					viewList.add(position, newView);
				}
				TreeLayoutUtil.setTreeNodesPositionAnnotation(viewList);
				TreeLayoutUtil.setTreeNodeParentAnnotation(newView,
						parentEditPart.getNotationView());

				return CommandResult.newOKCommandResult();
			}
		}
		return CommandResult.newErrorCommandResult(new ExecutionException(
				"ParentTreeNode EditPart not found."));
	}
}
