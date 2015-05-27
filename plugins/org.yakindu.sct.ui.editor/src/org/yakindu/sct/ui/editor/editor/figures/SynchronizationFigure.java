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
package org.yakindu.sct.ui.editor.editor.figures;

import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * 
 * @author andreas muelder
 * 
 */
public class SynchronizationFigure extends RoundedRectangle {

	private final static int defaultSize = 8;

	private IMapMode mapMode;

	public SynchronizationFigure(IMapMode mapMode) {
		this.mapMode = mapMode;
		this.setLineWidth(1);
		this.setPreferredSize(new Dimension(getMapMode().DPtoLP(defaultSize),
				getMapMode().DPtoLP(defaultSize)));
	}

	public IMapMode getMapMode() {
		return mapMode;
	}

}
