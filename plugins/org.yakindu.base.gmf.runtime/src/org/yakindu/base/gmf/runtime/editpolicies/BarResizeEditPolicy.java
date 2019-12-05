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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.ResizeTracker;
import org.yakindu.base.gmf.runtime.editparts.LiveFeedbackResizableEditPolicy;

/**
 * resize edit policy for fixed width or height.
 * 
 * @author benjamin.schwertfeger@itemis.de
 * 
 */
public class BarResizeEditPolicy extends LiveFeedbackResizableEditPolicy {

	private static final int thickness = 8;

	@Override
	protected ResizeTracker getResizeTracker(int direction) {

		return new ResizeTracker((GraphicalEditPart) getHost(), direction) {
			@Override
			protected void enforceConstraintsForResize(ChangeBoundsRequest request) {
				Rectangle locationAndSize = getOriginalBounds();
				
				final Rectangle origRequestedBounds = request.getTransformedRectangle(locationAndSize);
				final Rectangle modified = origRequestedBounds.getCopy();
				checkAndPrepareConstraint(request, modified);
				Dimension newDelta = new Dimension(modified.width - locationAndSize.width,
						modified.height - locationAndSize.height);
				request.setSizeDelta(newDelta);
				final Point moveDelta = request.getMoveDelta();
				request.setMoveDelta(new Point(moveDelta.x - origRequestedBounds.x + modified.x,
						moveDelta.y - origRequestedBounds.y + modified.y));
			}
		};
	}

	private void checkAndPrepareConstraint(final ChangeBoundsRequest request, final Rectangle rect) {
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
	}

}
