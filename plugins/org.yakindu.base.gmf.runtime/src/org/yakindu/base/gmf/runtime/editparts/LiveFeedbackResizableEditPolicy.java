/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.base.gmf.runtime.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.ResizeTracker;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.yakindu.base.gmf.runtime.editpolicies.SetPreferredSizeRequest;

/**
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public class LiveFeedbackResizableEditPolicy extends ResizableEditPolicyEx {

	private boolean connectionStart = true;
	protected Rectangle originalBounds = null;
	private final ChangeBoundsRequest NULL_REQUEST = new ChangeBoundsRequest(REQ_MOVE_CHILDREN);

	@Override
	public void activate() {
		super.activate();
		originalBounds = getPreferredSizeFigure().getBounds().getCopy();
		getHostFigure().translateToAbsolute(originalBounds);
	}

	@Override
	protected void eraseChangeBoundsFeedback(ChangeBoundsRequest request) {
		connectionStart = true;
		super.eraseChangeBoundsFeedback(request);
	}

	@Override
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		NULL_REQUEST.setEditParts(getHost());
		return getHost().getParent().getCommand(NULL_REQUEST);
	}

	protected IFigure getPreferredSizeFigure() {
		return getHostFigure();
	}

	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		if (request instanceof SetPreferredSizeRequest) {
			SetPreferredSizeRequest req = new SetPreferredSizeRequest(REQ_RESIZE_CHILDREN);
			req.setEditParts(getHost());
			req.setCenteredResize(request.isCenteredResize());
			req.setConstrainedMove(request.isConstrainedMove());
			req.setConstrainedResize(request.isConstrainedResize());
			req.setSnapToEnabled(request.isSnapToEnabled());
			req.setMoveDelta(request.getMoveDelta());
			req.setSizeDelta(request.getSizeDelta());
			req.setLocation(request.getLocation());
			req.setExtendedData(request.getExtendedData());
			req.setResizeDirection(request.getResizeDirection());
			return getHost().getParent().getCommand(req);
		}
		NULL_REQUEST.setEditParts(getHost());
		return getHost().getParent().getCommand(NULL_REQUEST);
	}

	@Override
	protected ResizeTracker getResizeTracker(int direction) {

		return new ResizeTracker((GraphicalEditPart) getHost(), direction) {
			@Override
			protected void enforceConstraintsForResize(ChangeBoundsRequest request) {
				final IFigure figure = getHostFigure();
				Dimension prefSize = figure.getPreferredSize().getCopy();
				figure.translateToAbsolute(prefSize);
				Rectangle bounds = originalBounds.getCopy();
				bounds = bounds.expand(-8, -8);
				figure.translateToAbsolute(bounds);
				bounds = request.getTransformedRectangle(bounds);
				if (bounds.width < prefSize.width) {
					request.getSizeDelta().width = request.getSizeDelta().width + (prefSize.width - bounds.width);
				}
				if (bounds.height < prefSize.height) {
					request.getSizeDelta().height = request.getSizeDelta().height + (prefSize.height - bounds.height);
				}
				request.setSizeDelta(request.getSizeDelta());
			}
		};
	}

	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		if (connectionStart) {
			originalBounds = getPreferredSizeFigure().getBounds().getCopy();
			getHostFigure().translateToAbsolute(originalBounds);
			connectionStart = false;
		}
		Rectangle rect = request.getTransformedRectangle(originalBounds.getCopy());
		getHostFigure().getParent().translateToRelative(rect);
		getHostFigure().setBounds(rect);
		getHostFigure().getParent().setConstraint(getHostFigure(), rect);
	}

}
