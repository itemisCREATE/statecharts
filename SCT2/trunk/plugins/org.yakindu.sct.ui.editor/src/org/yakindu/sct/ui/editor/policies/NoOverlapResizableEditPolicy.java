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

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * Forbids overlapping of elements. Considers minimum size of host figure if
 * resized.
 * 
 * @author m.muehlbrandt
 * 
 */
public class NoOverlapResizableEditPolicy extends PreferredSizeCompartmentEditPolicy {

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
		return super.getResizeCommand(request);
	}

	@SuppressWarnings("unchecked")
	protected boolean isRequestValid(ChangeBoundsRequest request) {
		// Overlapping of nodes is not allowed
		final IGraphicalEditPart parent = (IGraphicalEditPart) getHost().getParent();
		final Rectangle newBounds = request.getTransformedRectangle(getHostFigure().getBounds());
		final List<IGraphicalEditPart> children = parent.getChildren();
		for (final IGraphicalEditPart child : children) {
			if (child != getHost() && child.getFigure().getBounds().intersects(newBounds)) {
				Rectangle intersection = child.getFigure().getBounds().getIntersection(newBounds);
				// allow snapping to OtherEditParts
				if (intersection.width() > 1 && intersection.height() > 1) {
					return false;
				}
			}
		}
		return true;
	}
	
}
