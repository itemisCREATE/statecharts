package org.yakindu.sct.statechart.diagram.editor.figures;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

/**
 *TODO move to commons
 * {@link DefaultSizeNodeFigure} with fixed anchors on the ellipse child
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public class EllipseAnchorDefaultSizeNodeFigure extends DefaultSizeNodeFigure {

	public EllipseAnchorDefaultSizeNodeFigure(Dimension defSize) {
		super(defSize);
	}

	@Override
	protected ConnectionAnchor createAnchor(PrecisionPoint p) {
		return createDefaultAnchor();
	}

	@Override
	protected ConnectionAnchor createDefaultAnchor() {
		return new EllipseAnchor((IFigure) getChildren().get(0));
	}

}
