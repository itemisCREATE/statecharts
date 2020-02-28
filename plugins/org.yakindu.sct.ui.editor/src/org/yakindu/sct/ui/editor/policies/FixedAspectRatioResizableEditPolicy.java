/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.handles.ResizeHandle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.yakindu.base.gmf.runtime.editparts.LiveFeedbackResizableEditPolicy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class FixedAspectRatioResizableEditPolicy extends LiveFeedbackResizableEditPolicy {

	@SuppressWarnings("rawtypes")
	protected List createSelectionHandles() {
		List list = new ArrayList();
		createMoveHandle(list);
		createResizeHandle(list, PositionConstants.SOUTH_EAST);
		createResizeHandle(list, PositionConstants.SOUTH_WEST);
		createResizeHandle(list, PositionConstants.NORTH_WEST);
		createResizeHandle(list, PositionConstants.NORTH_EAST);
		return list;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void createResizeHandle(List handles, final int direction) {
		handles.add(new ResizeHandle(getHost(), direction) {
			@Override
			protected DragTracker createDragTracker() {
				return new LiveFeedbackResizeTracker(getHost(), direction) {
					@Override
					public void mouseDrag(MouseEvent event, EditPartViewer viewer) {
						event.stateMask |= SWT.SHIFT;
						super.mouseDrag(event, viewer);
					}
				};
			};
		});
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

}