/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.gmf.runtime.editparts;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.gmf.runtime.figures.EllipseAnchorDefaultSizeNodeFigure;

/**
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public abstract class EllipseFixedSizeShapeNodeEditPart extends FixedSizeShapeNodeEditPart {

	public EllipseFixedSizeShapeNodeEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new EllipseAnchorDefaultSizeNodeFigure(getDefaultSize());
		figure.setLayoutManager(getLayoutManager());
		figure.add(createPrimaryShape());
		return figure;
	}
}
