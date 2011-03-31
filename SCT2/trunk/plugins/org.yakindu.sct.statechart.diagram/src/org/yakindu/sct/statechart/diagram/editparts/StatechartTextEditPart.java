package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.editor.figures.StatechartTextFigure;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartTextEditPart extends ShapeNodeEditPart implements
		IPrimaryEditPart {

	public StatechartTextEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new NodeFigure();
		figure.setLayoutManager(new StackLayout());
		figure.add(new StatechartTextFigure(getMapMode()));
		return figure;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// Disables deletion of the text compartment view via keyboard
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new RootComponentEditPolicy());
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof StatechartTextExpressionEditPart) {
			IFigure pane = getPrimaryShape().getCompartment();
			pane.setLayoutManager(new StackLayout());
			IFigure compartmentFigure = ((StatechartTextExpressionEditPart) childEditPart)
					.getFigure();
			pane.add(compartmentFigure);
		} else
			super.addChildVisual(childEditPart, index);
	}

	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (childEditPart instanceof StatechartTextExpressionEditPart) {
			IFigure pane = getPrimaryShape().getCompartment();
			IFigure compartmentFigure = ((StatechartTextExpressionEditPart) childEditPart)
					.getFigure();
			pane.remove(compartmentFigure);
		} else
			super.removeChildVisual(childEditPart);
	}

	private StatechartTextFigure getPrimaryShape() {
		return (StatechartTextFigure) getFigure().getChildren().get(0);
	}
}
