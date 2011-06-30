package de.itemis.gmf.runtime.commons.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;

/**
 * resize edit policy for fixed width or height of 6.
 * 
 * @author benjamin.schwertfeger@itemis.de
 * 
 */
public class BarResizeEditPolicy extends ResizableEditPolicyEx {
	@Override
	protected void showChangeBoundsFeedback(final ChangeBoundsRequest request) {
		final IFigure feedback = getDragSourceFeedbackFigure();

		final PrecisionRectangle rect = new PrecisionRectangle(
				getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());
		// the unchanged value can be set to zero, because
		// the size will be recalculated later
		checkAndPrepareConstraint(request, rect);

		feedback.translateToRelative(rect);
		feedback.setBounds(rect);
	}

	@Override
	protected Command getResizeCommand(final ChangeBoundsRequest request) {
		final Rectangle origRequestedBounds = request
				.getTransformedRectangle(((IGraphicalEditPart) getHost())
						.getFigure().getBounds());
		final Rectangle modified = origRequestedBounds.getCopy();
		checkAndPrepareConstraint(request, modified);
		final Dimension sizeDelta = request.getSizeDelta();
		request.setSizeDelta(new Dimension(sizeDelta.width
				- origRequestedBounds.width + modified.width, sizeDelta.height
				- origRequestedBounds.height + modified.height));
		final Point moveDelta = request.getMoveDelta();
		request.setMoveDelta(new Point(moveDelta.x - origRequestedBounds.x
				+ modified.x, moveDelta.y - origRequestedBounds.y + modified.y));
		return super.getResizeCommand(request);
	}

	/**
	 * Modifies the rectangle dependant of the given request and the compartment
	 * which is a child of this host.
	 * 
	 * @param request
	 * @param rect
	 * @param c
	 */
	private void checkAndPrepareConstraint(final ChangeBoundsRequest request,
			final Rectangle rect) {
		if (rect.width / rect.height < 1) {
			if ((request.getResizeDirection() & PositionConstants.WEST) != 0) {
				rect.x += rect.width - 6;
			}
			rect.width = 6;
		} else {
			if ((request.getResizeDirection() & PositionConstants.NORTH) != 0) {
				rect.y += rect.height - 6;
			}
			rect.height = 6;
		}
		// rect.setSize(size);
	}
}
