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
package org.yakindu.base.gmf.runtime.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * Extends {@link ChangeBoundsRequest} to calculate the preferred size delta.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SetPreferredSizeRequest extends ChangeBoundsRequest {

	public SetPreferredSizeRequest(String reqResizeChildren) {
		super(reqResizeChildren);
	}

	public SetPreferredSizeRequest(IGraphicalEditPart host) {
		super(RequestConstants.REQ_RESIZE);
		setEditParts(host);
		double zoom = ((DiagramRootEditPart) host.getRoot()).getZoomManager().getZoom();
		IFigure figure = host.getFigure();
		Dimension prefSize = figure.getLayoutManager().getPreferredSize(figure, -1, -1).getCopy().scale(zoom);
		prefSize.expand(8,8);
		Dimension currentSize = figure.getSize().scale(zoom);
		Dimension newDimension = new Dimension(prefSize.width - currentSize.width,
				prefSize.height - currentSize.height);
		setSizeDelta(newDimension);
	}


}
