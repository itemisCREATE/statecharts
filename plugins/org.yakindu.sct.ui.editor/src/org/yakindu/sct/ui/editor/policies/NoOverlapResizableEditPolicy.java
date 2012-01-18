/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.policies;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;

/**
 * Forbids overlapping of elements. Considers minimum size of host figure if
 * resized.
 * 
 * @author m.muehlbrandt
 * 
 */
public abstract class NoOverlapResizableEditPolicy extends ResizableShapeEditPolicy {

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
			adjustRequest((ChangeBoundsRequest) request);
		}
		return super.getResizeCommand(request);
	}

	protected abstract boolean isRequestValid(ChangeBoundsRequest request);

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
			newSizeDelta.width = request.getSizeDelta().width
					+ (minimumSize.width - newBounds.width);
		}
		if (newBounds.height < minimumSize.height) {
			newSizeDelta.height = request.getSizeDelta().height
					+ (minimumSize.height - newBounds.height);
		}
		request.setSizeDelta(newSizeDelta);
	}
}
