package org.yakindu.sct.ui.editor.policies;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;

public class NoOverlapResizableEditPolicy extends ResizableShapeEditPolicy {

	@Override
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		if (!isRequestValid(request)) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getMoveCommand(request);
	}

	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		if (!isRequestValid(request)) {
			return UnexecutableCommand.INSTANCE;
		}
		
		if (request instanceof ChangeBoundsRequest) {
			adjustRequest((ChangeBoundsRequest)request);
		}
		return super.getResizeCommand(request);
	}

	@SuppressWarnings("unchecked")
	protected boolean isRequestValid(ChangeBoundsRequest request) {
		// Overlapping of nodes is not allowed
		final IGraphicalEditPart parent = (IGraphicalEditPart) getHost()
				.getParent();
		final Rectangle newBounds = request.getTransformedRectangle(getHostFigure().getBounds());
		final List<IGraphicalEditPart> children = parent.getChildren();
		for (final IGraphicalEditPart child : children) {
			if (child == getHost()) {
				continue;
			}
			if (child.getFigure().getBounds().intersects(newBounds)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Do not allow resizing smaller than the MinimumSize of the {@link Figure}.
	 */
	protected void adjustRequest(ChangeBoundsRequest request) {
		final IFigure figure = getHostFigure();
		final Dimension minimumSize = figure.getMinimumSize();
		final Rectangle bounds = figure.getBounds().getCopy();
		final Rectangle newBounds = request.getTransformedRectangle(bounds);
		final Dimension newSizeDelta = request.getSizeDelta().getCopy();
		if (newBounds.width < minimumSize.width) {
			newSizeDelta.width = request.getSizeDelta().width + (minimumSize.width - newBounds.width);
		}
		if (newBounds.height < minimumSize.height) {
			newSizeDelta.height = request.getSizeDelta().height + (minimumSize.height - newBounds.height);
		}
		request.setSizeDelta(newSizeDelta);
	}
}
