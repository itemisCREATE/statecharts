/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;

/**
 * 
 * Do not allow resizing smaller than the preferred size of the compartment
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class PreferredSizeCompartmentEditPolicy extends ResizableEditPolicyEx {

	@Override
	public void showSourceFeedback(Request request) {
		if (request.getType().equals(RequestConstants.REQ_RESIZE)) {
			adjustRequest((ChangeBoundsRequest) request);
		}
		super.showSourceFeedback(request);
	}

	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		if (request.getType().equals(RequestConstants.REQ_RESIZE)) {
			adjustRequest((ChangeBoundsRequest) request);
		}
		return super.getResizeCommand(request);
	}

	protected void adjustRequest(ChangeBoundsRequest request) {
		final IFigure figure = getHostFigure();
		final Dimension prefSize = figure.getPreferredSize();
		final Rectangle newBounds = request.getTransformedRectangle(figure.getBounds().getCopy());
		final Dimension newSizeDelta = request.getSizeDelta().getCopy();
		if (newBounds.width < prefSize.width) {
			newSizeDelta.width = request.getSizeDelta().width + (prefSize.width - newBounds.width);
		}
		if (newBounds.height < prefSize.height) {
			newSizeDelta.height = request.getSizeDelta().height + (prefSize.height - newBounds.height);
		}
		request.setSizeDelta(newSizeDelta);
	}

}
