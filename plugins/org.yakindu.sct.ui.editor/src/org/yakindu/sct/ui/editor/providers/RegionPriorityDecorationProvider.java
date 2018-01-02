/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.providers;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.editor.figures.PriorityFigure;
import org.yakindu.sct.ui.editor.editparts.RegionEditPart;

/**
 * @author andreas muelder - Initial contribution and API
 */
public class RegionPriorityDecorationProvider extends AbstractPriorityDecorationProvider {

	@Override
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget.getAdapter(EditPart.class);
		if (editPart instanceof GraphicalEditPart || editPart instanceof AbstractConnectionEditPart) {
			EditDomain ed = editPart.getViewer().getEditDomain();
			if (!(ed instanceof DiagramEditDomain)) {
				return;
			}
			if (shouldInstall(((DiagramEditDomain) ed).getEditorPart()) && editPart instanceof RegionEditPart) {
				IDecorator decorator = createStatusDecorator(decoratorTarget);
				decorators.add(decorator);
				decoratorTarget.installDecorator(getDecoratorKey(), decorator);
			}
		}
	}

	protected IDecorator createStatusDecorator(IDecoratorTarget decoratorTarget) {
		return new RegionPriorityDecorator(decoratorTarget);
	}

	public static class RegionPriorityDecorator extends AbstractPriorityDecorator {

		public RegionPriorityDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget, SGraphPackage.COMPOSITE_ELEMENT__REGIONS);
		}

		@Override
		public void activate() {
			super.activate();
			if (!(semanticElement instanceof Region)) {
				return;
			}
			if (semanticElement.eContainer() != null) {
				owningElement = semanticElement.eContainer();
			}
		}

		@Override
		public void deactivate() {
			if (!(semanticElement instanceof Region)) {
				return;
			}
			owningElement = null;
			super.deactivate();
		}

		public boolean needsDecoration(IGraphicalEditPart editPart) {
			Region element = ((Region) editPart.resolveSemanticElement());
			CompositeElement container = (CompositeElement) element.eContainer();
			return container.getRegions().size() > 1;
		}

		public void createDecorators(IGraphicalEditPart editPart) {
			PriorityFigure figure = new PriorityFigure(MapModeUtil.getMapMode(), getPriority(editPart));
			figure.setSize(10, 10);
			setDecoration(
					getDecoratorTarget().addShapeDecoration(figure, IDecoratorTarget.Direction.NORTH_WEST, -1, false));
		}

		public int getPriority(IGraphicalEditPart editPart) {
			Region element = ((Region) editPart.resolveSemanticElement());
			CompositeElement container = (CompositeElement) element.eContainer();
			int indexOf = container.getRegions().indexOf(element);
			// visible priorities should start with 1
			return indexOf + 1;
		}
	}
}
