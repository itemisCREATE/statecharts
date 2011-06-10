package de.itemis.gmf.runtime.commons.editparts;

import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;

/**
 * TODO This is a workaround for GMF bug #349042 This class can be removed
 * entirely if the provided patch is applied in GMF
 * 
 * @author andreas muelder
 * 
 */
public class FixedXYLayoutEditPolicy extends XYLayoutEditPolicy {

	@Override
	protected Object getConstraintFor(ChangeBoundsRequest request,
			GraphicalEditPart child) {

		Rectangle locationAndSize = new PrecisionRectangle(child.getFigure()
				.getBounds());
		child.getFigure().translateToAbsolute(locationAndSize);
		locationAndSize = request.getTransformedRectangle(locationAndSize);
		translateFromAbsoluteToLayoutRelative(locationAndSize);
		Rectangle rect = (Rectangle) getConstraintFor(request, child,
				locationAndSize);
		Rectangle cons = getCurrentConstraintFor(child);
		if (cons != null) {
			if (request.getSizeDelta().width == 0)
				rect.width = cons.width;
			if (request.getSizeDelta().height == 0)
				rect.height = cons.height;
		}
		return rect;
	}
}
