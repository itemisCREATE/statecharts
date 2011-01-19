/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.yakindu.sct.statechart.diagram.editor.figures.StateFigure;
import org.yakindu.sct.statechart.diagram.editor.figures.utils.MapModeUtils;
import org.yakindu.sct.statechart.diagram.policies.RelationshipSemanticEditPolicy;
import org.yakindu.sct.statechart.diagram.preferences.StatechartPreferenceManager;

/**
 * The {@link StateEditPart} for {@link State} model elements.
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class StateEditPart extends ShapeNodeEditPart implements
		IPrimaryEditPart {

	public StateEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new DefaultSizeNodeFigure(
				MapModeUtils.getDefaultSizeDimension(getMapMode()));
		figure.setLayoutManager(new StackLayout());
		StateFigure stateFigure = new StateFigure(getMapMode());
		figure.add(stateFigure);
		return figure;
	}

	@Override
	public IFigure getFigure() {
		IFigure figure = super.getFigure();
		Color stateColor = StatechartPreferenceManager.getInstance()
				.getStateColor();
		figure.setBackgroundColor(stateColor);
		return figure;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RelationshipSemanticEditPolicy());
		// We don't want to allow creation for parent editpart on a State
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy() {
					@Override
					protected Command getCreateElementAndViewCommand(
							CreateViewAndElementRequest request) {
						return UnexecutableCommand.INSTANCE;
					}
				});
	}

	@Override
	public IFigure getContentPane() {
		return getPrimaryShape().getFigureCompartmentPane();
	}

	private StateFigure getPrimaryShape() {
		return (StateFigure) getFigure().getChildren().get(0);
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof StateFigureCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureCompartmentPane();
			pane.setLayoutManager(new StackLayout());
			IFigure compartmentFigure = ((StateFigureCompartmentEditPart) childEditPart)
					.getFigure();
			pane.add(compartmentFigure);
//		} 
//		else if (childEditPart instanceof StateTextCompartmentEditPart) {
//			IFigure pane = getPrimaryShape().getTextCompartmentPane();
//			pane.setLayoutManager(new StackLayout());
//			IFigure compartmentFigure = ((StateTextCompartmentEditPart) childEditPart)
//					.getFigure();
//			pane.add(compartmentFigure);
		} else if (childEditPart instanceof StateNameEditPart) {
			((StateNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getNameFigure());
		} else {
			super.addChildVisual(childEditPart, index);
		}
	}
}
