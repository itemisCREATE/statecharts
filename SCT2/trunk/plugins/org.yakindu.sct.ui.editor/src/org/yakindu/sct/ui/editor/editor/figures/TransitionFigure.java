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
package org.yakindu.sct.ui.editor.editor.figures;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
/**
 * 
 * @author muelder
 *
 */
public class TransitionFigure extends PolylineConnectionEx {

	private final IMapMode mapMode;

	public TransitionFigure(IMapMode mapMode) {
		this.mapMode = mapMode;
		setLineWidth(mapMode.DPtoLP(1));
		setTargetDecoration(createTargetDecoration());
	}
	protected IMapMode getMapMode() {
		return mapMode;
	}

	private RotatableDecoration createTargetDecoration() {
		PolygonDecoration df = new PolygonDecoration();
		df.setFill(true);
		df.setLineWidth(getMapMode().DPtoLP(1));
		PointList pl = new PointList();
		pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(-1));
		pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
		pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
		df.setTemplate(pl);
		return df;
	}
}
