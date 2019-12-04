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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class LiveFeedbackNonResizableEditPolicy extends NonResizableEditPolicyEx {

	private boolean connectionStart = true;
	private Rectangle originalBounds = null;
	private ChangeBoundsRequest NULL_REQUEST = new ChangeBoundsRequest(REQ_MOVE_CHILDREN);
	private String lastRequest = "";

	@Override
	public void activate() {
		super.activate();
		originalBounds = getHostFigure().getBounds().getCopy();
		getHostFigure().translateToAbsolute(originalBounds);
	}

	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		// If REQ_DROP is delivered 2 times in a row it is a "real" drop and not only a
		// hover over existing elements in the same region
		if (RequestConstants.REQ_DROP.equals(request.getType()) && RequestConstants.REQ_DROP.equals(lastRequest)) {
			Rectangle rect = originalBounds.getCopy();
			getHostFigure().getParent().translateToRelative(rect);
			getHostFigure().setBounds(rect);
			super.showChangeBoundsFeedback(request);
			lastRequest = (String) request.getType();
			return;
		}
		super.eraseChangeBoundsFeedback(request);
		enforceConstraintForMove(request);
		if (connectionStart) {
			originalBounds = getHostFigure().getBounds().getCopy();
			getHostFigure().translateToAbsolute(originalBounds);
			connectionStart = false;
		}
		Rectangle bounds = request.getTransformedRectangle(originalBounds.getCopy());
		getHostFigure().getParent().translateToRelative(bounds);
		getHostFigure().setBounds(bounds);
		getHostFigure().getParent().setConstraint(getHostFigure(), bounds);
		lastRequest = (String) request.getType();
	}

	@Override
	protected void eraseChangeBoundsFeedback(ChangeBoundsRequest request) {
		connectionStart = true;
		super.eraseChangeBoundsFeedback(request);
	}

	@Override
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		if (RequestConstants.REQ_DROP.equals(request.getType())) {
			return super.getMoveCommand(request);
		}
		NULL_REQUEST.setEditParts(getHost());
		return getHost().getParent().getCommand(NULL_REQUEST);
	}

	protected void enforceConstraintForMove(ChangeBoundsRequest request) {
		Rectangle relativeBounds = originalBounds.getCopy();
		Rectangle transformed = request.getTransformedRectangle(relativeBounds);
		getHostFigure().getParent().translateToRelative(transformed);
		if (transformed.x < 0) {
			Point moveDelta = request.getMoveDelta();
			moveDelta.x -= transformed.x;
		}
		if (transformed.y < 0) {
			Point moveDelta = request.getMoveDelta();
			moveDelta.y -= transformed.y;
		}
	}

}
