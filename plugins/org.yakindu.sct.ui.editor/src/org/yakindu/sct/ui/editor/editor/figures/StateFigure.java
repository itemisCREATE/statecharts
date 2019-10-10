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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.yakindu.base.xtext.utils.gmf.figures.SyntaxColoringLabel;
import org.yakindu.sct.ui.editor.editor.figures.utils.GridDataFactory;

/**
 * 
 * @author andreas muelder
 * @author axel terfloth
 * 
 */
public class StateFigure extends RoundedRectangle {

	private WrappingLabel nameFigure;
	private Figure textCompartmentPane;
	private Figure figureCompartmentPane;

	public StateFigure(IMapMode mapMode) {
		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 0;
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		this.setLayoutManager(layout);
		this.setCornerDimensions(new Dimension(mapMode.DPtoLP(15), mapMode.DPtoLP(15)));
		this.setOutline(true);
		createContents();
	}

	protected void createContents() {
		// Name Label
		nameFigure = new SyntaxColoringLabel();
		nameFigure.setAlignment(PositionConstants.CENTER);
		this.add(nameFigure, GridDataFactory.fillDefaults().grab(true, false).getData());
		// Text compartment
		textCompartmentPane = new Figure();
		textCompartmentPane.setLayoutManager(new StackLayout());
		this.add(textCompartmentPane, GridDataFactory.fillDefaults().grab(true, true).getData());

		figureCompartmentPane = new Figure();
		figureCompartmentPane.setLayoutManager(new StackLayout());
		this.add(figureCompartmentPane, GridDataFactory.fillDefaults().grab(true, true).getData());
	}

	public WrappingLabel getNameFigure() {
		return nameFigure;
	}

	public Figure getTextCompartmentPane() {
		return textCompartmentPane;
	}

	public Figure getFigureCompartmentPane() {
		return figureCompartmentPane;
	}

}
