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
package org.yakindu.sct.statechart.diagram.editor.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.yakindu.model.sct.statechart.State;

/**
 * {@link IFigure} implementation for {@link State}s.
 * 
 */
public class StateFigure extends RoundedRectangle {

	private WrappingLabel nameFigure;
	private Figure figureCompartmentPane;
	//private RectangleFigure textCompartmentPane;

	public StateFigure(IMapMode mapMode) {
		ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout(false);
		layout.setStretchMajorAxis(true);
		layout.setStretchMinorAxis(true);
		this.setLayoutManager(layout);
		this.setCornerDimensions(new Dimension(mapMode.DPtoLP(20), mapMode
				.DPtoLP(20)));
		this.setOutline(true);
		createContents();
	}

	private void createContents() {
		//Name Label
		nameFigure = new WrappingLabel();
		nameFigure.setAlignment(PositionConstants.CENTER);
		this.add(nameFigure,0.2);
		//Figure Compartment
		figureCompartmentPane = new Figure();
		this.add(figureCompartmentPane, 0.8);

	}

//	private void createTextCompartmentFigure() {
//		textCompartmentPane = new RectangleFigure();
//		textCompartmentPane.setOutline(false);
//		GridData data = GridDataFactory.fillDefaults()
//				.align(GridData.FILL, GridData.FILL).grab(true, true).getData();
//		data.heightHint = mapMode.DPtoLP(15);
//		this.add(textCompartmentPane, data);
//	}

	public WrappingLabel getNameFigure() {
		return nameFigure;
	}

	public Figure getFigureCompartmentPane() {
		return figureCompartmentPane;
	}

//	public RectangleFigure getTextCompartmentPane() {
//		return textCompartmentPane;
//	}

}
