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

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class LiveFeedbackNonResizableEditPolicy extends NonResizableEditPolicyEx {

	private boolean connectionStart = true;
	private Rectangle originalBounds = null;
	private ChangeBoundsRequest NULL_REQUEST = new ChangeBoundsRequest(REQ_MOVE_CHILDREN);

	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		if (connectionStart) {
			originalBounds = getHostFigure().getBounds().getCopy();
			getHostFigure().translateToAbsolute(originalBounds);
			connectionStart = false;
		}
		Rectangle bounds = request.getTransformedRectangle(originalBounds.getCopy());
		getHostFigure().getParent().translateToRelative(bounds);
		getHostFigure().setBounds(bounds);
		getHostFigure().getParent().setConstraint(getHostFigure(), bounds);
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

}
