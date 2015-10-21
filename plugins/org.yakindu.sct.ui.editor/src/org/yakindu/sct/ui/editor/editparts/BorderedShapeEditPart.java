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
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.policies.FeedbackGraphicalNodeEditPolicy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class BorderedShapeEditPart extends AbstractBorderedShapeEditPart {

	private IGraphicalEditPart primaryChildEditPart;

	public BorderedShapeEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createMainFigure() {
		return null;
	}

	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if (primaryChildEditPart == null) {
			primaryChildEditPart = borderItemEditPart;
		}
		BorderItemLocator locator = new BorderItemLocator(getMainFigure()) {
			protected Rectangle getParentBorder() {
				Rectangle bounds = getParentFigure().getBounds().getCopy();
				bounds.expand(5, 5);
				return bounds;
			}
		};
		borderItemContainer.add(borderItemEditPart.getFigure(), locator);
	}

	@Override
	protected void performDirectEditRequest(Request request) {
		primaryChildEditPart.performRequest(request);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new FeedbackGraphicalNodeEditPolicy());
	}

}
