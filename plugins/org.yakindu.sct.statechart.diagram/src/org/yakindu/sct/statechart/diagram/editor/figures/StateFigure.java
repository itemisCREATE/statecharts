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
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.yakindu.sct.statechart.diagram.editor.figures.utils.GridDataFactory;

/**
 * 
 * @author muelder
 * 
 */
public class StateFigure extends RoundedRectangle {

	private WrappingLabel nameFigure;
	private Figure figureCompartmentPane;
	private Figure textCompartmentPane;

	public StateFigure(IMapMode mapMode) {
		GridLayout layout = new GridLayout(1, false);
		this.setLayoutManager(layout);
		this.setCornerDimensions(new Dimension(mapMode.DPtoLP(20), mapMode
				.DPtoLP(20)));
		this.setOutline(true);
		createContents();
	}

	private void createContents() {
		// Name Label
		nameFigure = new WrappingLabel();
		nameFigure.setAlignment(PositionConstants.CENTER);
		this.add(nameFigure, GridDataFactory.fillDefaults().align(GridData.CENTER, GridData.CENTER).grab(true, false)
				.getData());
		// Text compartment
		textCompartmentPane = new Figure();
		this.add(textCompartmentPane,
				GridDataFactory.fillDefaults().getData());
		// Figure Compartment
		figureCompartmentPane = new Figure();
		this.add(figureCompartmentPane,
				GridDataFactory.fillDefaults().getData());

	}

	public WrappingLabel getNameFigure() {
		return nameFigure;
	}

	public Figure getFigureCompartmentPane() {
		return figureCompartmentPane;
	}

	public Figure getTextCompartmentPane() {
		return textCompartmentPane;
	}

}
