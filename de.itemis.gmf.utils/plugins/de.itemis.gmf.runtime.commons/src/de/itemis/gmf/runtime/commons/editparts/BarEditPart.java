package de.itemis.gmf.runtime.commons.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.itemis.gmf.runtime.commons.editpolicies.BarResizeEditPolicy;

/**
 * Basic abstract EditPart for all Bar EditParts with a resize edit policy for
 * fixed width or height.
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public abstract class BarEditPart extends ShapeNodeEditPart {

	// Default width and height for all Bars
	private static final int DEFAULT_WIDTH = 200;
	private static final int DEFAULT_HEIGHT = 6;

	public abstract IFigure createPrimaryFigure();

	public BarEditPart(final View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final DefaultSizeNodeFigure nodeFigure = new DefaultSizeNodeFigure(
				getMapMode().DPtoLP(DEFAULT_WIDTH), getMapMode().DPtoLP(
						DEFAULT_HEIGHT));
		nodeFigure.setLayoutManager(new StackLayout());
		nodeFigure.add(createPrimaryFigure());
		return nodeFigure;
	}

	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		return new BarResizeEditPolicy();
	}

}

