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
package org.yakindu.base.gmf.runtime.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;

/**
 * resize edit policy for fixed width or height.
 * 
 * @author benjamin.schwertfeger@itemis.de
 * 
 */
public class BarResizeEditPolicy extends ResizableEditPolicyEx {

	private final int thickness;

	/**
	 * Default thickness of 8.
	 */
	public BarResizeEditPolicy() {
		thickness = 8;
	}

	public BarResizeEditPolicy(int thickness) {
		this.thickness = thickness;
	}

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
		GraphicalEditPart editPart = (IGraphicalEditPart) getHost();
		Rectangle locationAndSize = new PrecisionRectangle(editPart.getFigure()
				.getBounds());
		editPart.getFigure().translateToAbsolute(locationAndSize);

		final Rectangle origRequestedBounds = request
				.getTransformedRectangle(locationAndSize);
		final Rectangle modified = origRequestedBounds.getCopy();
		checkAndPrepareConstraint(request, modified);
		// final Dimension sizeDelta = request.getSizeDelta();

		Dimension newDelta = new Dimension(modified.width
				- locationAndSize.width, modified.height
				- locationAndSize.height);
		// ((IGraphicalEditPart) getHost()).getFigure()
		// .translateToAbsolute(newDelta);
		request.setSizeDelta(newDelta);
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
		GraphicalEditPart editPart = null;
		for (Object ep : request.getEditParts()) {
			if (editPart == null && ep instanceof GraphicalEditPart) {
				editPart = (GraphicalEditPart) ep;
				editPart.getFigure().translateToRelative(rect);
			}
		}

		if (rect.width / rect.height < 1) {
			if ((request.getResizeDirection() & PositionConstants.WEST) != 0) {
				rect.x += rect.width - thickness;
			}
			rect.width = thickness;
		} else {
			if ((request.getResizeDirection() & PositionConstants.NORTH) != 0) {
				rect.y += rect.height - thickness;
			}
			rect.height = thickness;
		}

		if (editPart != null) {
			editPart.getFigure().translateToAbsolute(rect);
		}
		// rect.setSize(size);
	}

}
