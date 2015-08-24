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
package org.yakindu.base.gmf.runtime.figures;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

/**
 * 
 * {@link DefaultSizeNodeFigure} with fixed anchors on the ellipse child
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public class EllipseAnchorDefaultSizeNodeFigure extends DefaultSizeNodeFigure {

	public EllipseAnchorDefaultSizeNodeFigure(Dimension defSize) {
		super(defSize);
	}

	@Override
	protected ConnectionAnchor createAnchor(PrecisionPoint p) {
		return createDefaultAnchor();
	}

	@Override
	protected ConnectionAnchor createDefaultAnchor() {
		return new EllipseAnchor((IFigure) getChildren().get(0));
	}

}
