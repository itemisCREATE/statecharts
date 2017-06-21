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
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DescriptionCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.base.xtext.utils.gmf.directedit.DoubleClickDirectEditDragTracker;
import org.yakindu.base.xtext.utils.gmf.directedit.DoubleClickDirectEditDragTracker.IDoubleClickCallback;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartDescriptionCompartmentEditPart extends DescriptionCompartmentEditPart {

	public StatechartDescriptionCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	public DragTracker getDragTracker(final Request request) {
		if (request instanceof SelectionRequest && ((SelectionRequest) request).getLastButtonPressed() == 3)
			return null;
		IDoubleClickCallback callback = new IDoubleClickCallback() {
			public void handleDoubleClick(int btn) {
				performDirectEditRequest(request);
			}
		};
		return new DoubleClickDirectEditDragTracker(this, getTopGraphicEditPart(), callback);
	}
}
