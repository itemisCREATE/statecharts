package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.editor.figures.EllipseAnchorDefaultSizeNodeFigure;

/**
 * TODO move to commons
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public abstract class EllipseFixedSizeShapeNodeEditPart extends
		FixedSizeShapeNodeEditPart {

	public EllipseFixedSizeShapeNodeEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new EllipseAnchorDefaultSizeNodeFigure(
				getDefaultSize());
		figure.setLayoutManager(getLayoutManager());
		figure.add(getPrimaryShape());
		return figure;
	}
	
	public abstract Ellipse getPrimaryShape();

}
