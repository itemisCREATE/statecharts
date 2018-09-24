/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.providers;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.ui.editor.editor.figures.PriorityFigure;
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;

/**
 * @author andreas muelder - Initial contribution and API
 */
public class TransitionPriorityDecorationProvider extends AbstractPriorityDecorationProvider {

	@Override
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget.getAdapter(EditPart.class);
		if (editPart instanceof GraphicalEditPart || editPart instanceof AbstractConnectionEditPart) {
			EditDomain ed = editPart.getViewer().getEditDomain();
			if (!(ed instanceof DiagramEditDomain)) {
				return;
			}
			if (shouldInstall(((DiagramEditDomain) ed).getEditorPart()) && editPart instanceof TransitionEditPart) {
				IDecorator decorator = createStatusDecorator(decoratorTarget);
				decorators.add(decorator);
				decoratorTarget.installDecorator(getDecoratorKey(), decorator);
			}
		}
	}

	protected IDecorator createStatusDecorator(IDecoratorTarget decoratorTarget) {
		return new TransitionPriorityDecorator(decoratorTarget);
	}

	public static class TransitionPriorityDecorator extends AbstractPriorityDecorator {

		public TransitionPriorityDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget, SGraphPackage.Literals.VERTEX__OUTGOING_TRANSITIONS);
		}

		@Override
		public void activate() {
			if (!(semanticElement instanceof Transition)
					|| !(((Transition) semanticElement).eContainer() instanceof Vertex)) {
				return;
			}
			if (((Transition) semanticElement).eContainer() != null) {
				owningElement = (Vertex) ((Transition) semanticElement).eContainer();
			}
			super.activate();
		}

		@Override
		public void deactivate() {
			if (!(semanticElement instanceof Transition)) {
				return;
			}
			owningElement = null;
			super.deactivate();
		}

		public boolean needsDecoration(IGraphicalEditPart editPart) {
			Transition transition = (Transition) editPart.resolveSemanticElement();
			Vertex container = (Vertex) transition.eContainer();
			return container.getOutgoingTransitions().size() > 1;

		}

		public void createDecorators(IGraphicalEditPart editPart) {
			PriorityFigure figure = new PriorityFigure(MapModeUtil.getMapMode(), getPriority(editPart));
			figure.setSize(10, 10);
			getDecoratorTarget().addDecoration(figure,
					new ConnectionLocator((Connection) editPart.getFigure(), ConnectionLocator.SOURCE), false);
			figure.setToolTip(new Label("Transition Priority " + getPriority(editPart)));

		}

		public int getPriority(IGraphicalEditPart editPart) {
			Transition transition = ((Transition) editPart.resolveSemanticElement());
			Vertex container = (Vertex) transition.eContainer();
			int indexOf = container.getOutgoingTransitions().indexOf(transition);
			// visible priorities should start with 1
			return indexOf + 1;
		}
	}

}
