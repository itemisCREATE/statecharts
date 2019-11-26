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
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.editor.figures.StatechartTextFigure;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.policies.PreferredSizeHandlerEditPolicy;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartTextEditPart extends ShapeNodeEditPart implements IPrimaryEditPart {

	public StatechartTextEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new NodeFigure();
		figure.setLayoutManager(new StackLayout());
		figure.add(new StatechartTextFigure(getMapMode()));
		figure.setMinimumSize(new Dimension(0, 0));
		return figure;
	}

	@Override
	public void activate() {
		super.activate();
	}

	@Override
	public void deactivate() {
		super.deactivate();
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		// Disables deletion of the text compartment view if additional elements
		// are selected too
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new SemanticEditPolicy() {
			@Override
			protected boolean shouldProceed(DestroyRequest destroyRequest) {
				return false;
			}
		});

		// Disables deletion of the text compartment view via keyboard
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new PreferredSizeHandlerEditPolicy() {
		});
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof StatechartNameEditPart) {
			((StatechartNameEditPart) childEditPart).setLabel(getPrimaryShape().getName());
		} else if (childEditPart instanceof StatechartTextExpressionEditPart) {
			IFigure pane = getPrimaryShape().getCompartment();
			pane.setLayoutManager(new StackLayout());
			IFigure compartmentFigure = ((StatechartTextExpressionEditPart) childEditPart).getFigure();
			pane.add(compartmentFigure);
		} else
			super.addChildVisual(childEditPart, index);
	}

	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (childEditPart instanceof StatechartTextExpressionEditPart) {
			IFigure pane = getPrimaryShape().getCompartment();
			IFigure compartmentFigure = ((StatechartTextExpressionEditPart) childEditPart).getFigure();
			pane.remove(compartmentFigure);
		} else
			super.removeChildVisual(childEditPart);
	}

	@Override
	protected void refreshVisibility() {
		setVisibility(isDefinitionSectionInlined());
	}

	@Override
	public void refresh() {
		refreshVisibility();
		super.refresh();
	}

	protected boolean isDefinitionSectionInlined() {
		BooleanValueStyle style = DiagramPartitioningUtil.getInlineDefinitionSectionStyle(getDiagramView());
		return style != null ? style.isBooleanValue() : true;
	}

	private StatechartTextFigure getPrimaryShape() {
		return (StatechartTextFigure) getFigure().getChildren().get(0);
	}
}
