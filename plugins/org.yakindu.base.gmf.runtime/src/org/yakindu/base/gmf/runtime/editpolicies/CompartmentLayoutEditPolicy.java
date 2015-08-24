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
package org.yakindu.base.gmf.runtime.editpolicies;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.OrderedLayout;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.AddCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.commands.RepositionEObjectCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.base.gmf.runtime.commands.CompartmentChildCreateCommand;
import org.yakindu.base.gmf.runtime.commands.CompartmentRepositionEObjectCommand;

/**
 * @see http://wiki.eclipse.org/GMF/Recipes
 * 
 */
public class CompartmentLayoutEditPolicy extends
		org.eclipse.gef.editpolicies.FlowLayoutEditPolicy {

	private EStructuralFeature feature = null;

	public static enum RequestParameterKeys {
		RegionFeedbackIndex
	}

	/**
	 * Internal command which validates if a view is already a child of parent
	 * and moving it to prefered index instead of adding it twice (What leads to
	 * an exception see {@link AbstractEList#add(int index, E object)}).
	 * 
	 * @author markus muehlbrandt
	 * 
	 */
	private class CompartmentAddCommand extends AddCommand {

		private IAdaptable parent;
		private IAdaptable child;
		private int index;

		public CompartmentAddCommand(TransactionalEditingDomain editingDomain,
				IAdaptable parent, IAdaptable child, int index) {
			super(editingDomain, parent, child, index);
			assert null != parent : "Null parent in CompartmentAddCommand";//$NON-NLS-1$
			assert null != child : "Null child in CompartmentAddCommand";//$NON-NLS-1$		
			this.parent = parent;
			this.child = child;
			this.index = index;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {

			View childView = (View) child.getAdapter(View.class);
			View parentView = (View) parent.getAdapter(View.class);

			if (parentView.getPersistedChildren().contains(childView)
					&& index != ViewUtil.APPEND) {
				parentView.getPersistedChildren().move(index, childView);
			} else if (index == ViewUtil.APPEND) {
				parentView.insertChild(childView);
			} else {
				parentView.insertChildAt(childView, index);
			}
			return CommandResult.newOKCommandResult();
		}
	}

	/**
	 * @param feature
	 *            has to be an EList
	 */
	public CompartmentLayoutEditPolicy(EStructuralFeature feature) {
		super();
		this.feature = feature;
	}

	@Override
	protected Command createAddCommand(EditPart child, EditPart after) {
		int index = getHost().getChildren().indexOf(after);
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		AddCommand command = new CompartmentAddCommand(editingDomain,
				new EObjectAdapter((View) getHost().getModel()),
				new EObjectAdapter((View) child.getModel()), index);
		return new ICommandProxy(command);
	}

	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		ResizableEditPolicyEx policy = new ResizableEditPolicyEx();
		policy.setResizeDirections(0);
		return policy;
	}

	@Override
	@SuppressWarnings("rawtypes")
	protected Command createMoveChildCommand(EditPart child, EditPart after) {

		int newIndex;
		int displacement;

		int childIndex = getHost().getChildren().indexOf(child);
		int afterIndex = getHost().getChildren().indexOf(after);

		if (afterIndex == -1) {
			newIndex = getHost().getChildren().size() - 1;
			displacement = newIndex - childIndex;
		} else {
			newIndex = afterIndex;
			displacement = afterIndex - childIndex;
			if (childIndex <= afterIndex) {
				newIndex--;
				displacement--;
			}
		}

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();

		RepositionEObjectCommand command = new CompartmentRepositionEObjectCommand(
				child, editingDomain, "", (EList) ((View) child.getParent()
						.getModel()).getElement().eGet(feature),
				((View) child.getModel()).getElement(), displacement, newIndex);

		eraseLayoutTargetFeedback(null);

		return new ICommandProxy(command);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		if (request instanceof CreateViewAndElementRequest) {

			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
					.getEditingDomain();
			CompositeTransactionalCommand cc = new CompositeTransactionalCommand(
					editingDomain, DiagramUIMessages.AddCommand_Label);

			Iterator<?> descriptors = ((CreateViewRequest) request)
					.getViewDescriptors().iterator();

			while (descriptors.hasNext()) {
				CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor) descriptors
						.next();

				int feedBackIndex = getFeedbackIndexFor(request);

				// obtain CreateElementRequest and add initial region feedback
				// index to request map. This index is needed to add the
				// semantic element at the correct listIndex
				CreateElementRequest createElementRequest = (CreateElementRequest) ((CreateViewAndElementRequest) request)
						.getViewAndElementDescriptor()
						.getCreateElementRequestAdapter()
						.getAdapter(CreateElementRequest.class);

				if (createElementRequest != null) {
					createElementRequest.getParameters().put(
							RequestParameterKeys.RegionFeedbackIndex,
							feedBackIndex);
				}

				CreateCommand createCommand = new CompartmentChildCreateCommand(
						editingDomain, descriptor,
						(View) (getHost().getModel()), feedBackIndex);

				cc.compose(createCommand);
			}
			return new ICommandProxy(cc.reduce());
		}

		return null;
	}

	@Override
	protected boolean isHorizontal() {
		IFigure figure = ((IGraphicalEditPart) getHost()).getContentPane();
		if (figure.getLayoutManager() instanceof OrderedLayout) {
			return ((OrderedLayout) figure.getLayoutManager()).isHorizontal();
		}
		return true;
	}

	@Override
	protected Command getDeleteDependantCommand(Request request) {
		return null;
	}

	@Override
	protected Command getOrphanChildrenCommand(Request request) {
		return null;
	}
}