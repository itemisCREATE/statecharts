/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTRenderedDiagramRootEditPart extends RenderedDiagramRootEditPart {

	public static final String WATERMARK_LAYER = "Watermark Layer";

	public SCTRenderedDiagramRootEditPart(MeasurementUnit mu) {
		super(mu);
	}

	@Override
	protected void createLayers(LayeredPane layeredPane) {
		super.createLayers(layeredPane);
		layeredPane.add(new FreeformLayer(), WATERMARK_LAYER);
	}
}
