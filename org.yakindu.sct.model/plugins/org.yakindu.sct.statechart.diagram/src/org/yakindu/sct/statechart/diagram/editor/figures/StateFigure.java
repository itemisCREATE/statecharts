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

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.yakindu.sct.model.statechart.statechart.State;
import org.yakindu.sct.statechart.diagram.editor.figures.utils.GridDataFactory;
import org.yakindu.sct.statechart.diagram.utils.FontConstants;

/**
 * {@link IFigure} implementation for {@link State}s.
 * 
 */
public class StateFigure extends RoundedRectangle {

	private WrappingLabel nameFigure;
	private RectangleFigure figureCompartmentPane;
	private RectangleFigure textCompartmentPane;

	private final IMapMode mapMode;

	public StateFigure(IMapMode mapMode) {
		this.mapMode = mapMode;
		GridLayout layoutThis = new GridLayout();
		layoutThis.numColumns = 1;
		layoutThis.makeColumnsEqualWidth = false;
		this.setLayoutManager(layoutThis);
		this.setCornerDimensions(new Dimension(mapMode.DPtoLP(20), mapMode.DPtoLP(20)));
		this.setOutline(true);
		createContents();
	}

	private void createContents() {

		RectangleFigure labelFigure = new RectangleFigure();
		labelFigure.setOutline(false);
		labelFigure.setLineWidth(1);
		this.add(labelFigure, GridDataFactory.fillDefaults().grab(true, false).getData());

		GridLayout layoutStateLabelRectangle0 = new GridLayout();
		layoutStateLabelRectangle0.numColumns = 1;
		layoutStateLabelRectangle0.makeColumnsEqualWidth = false;
		labelFigure.setLayoutManager(layoutStateLabelRectangle0);

		nameFigure = new WrappingLabel();
		nameFigure.setFont(FontConstants.DEFAULT);

		labelFigure.add(nameFigure, getLabelData());
		createTextCompartmentFigure();
		createFigureCompartmentFigure();

	}

	private GridData getLabelData() {
		GridData data = GridDataFactory.fillDefaults().align(GridData.CENTER, GridData.CENTER).grab(true, false)
				.getData();
		data.heightHint = mapMode.DPtoLP(15);
		return data;
	}

	private void createFigureCompartmentFigure() {
		figureCompartmentPane = new RectangleFigure();
		figureCompartmentPane.setOutline(false);
		GridData data = GridDataFactory.fillDefaults().align(GridData.FILL, GridData.FILL).grab(true, true).getData();
		data.heightHint = mapMode.DPtoLP(15);
		this.add(figureCompartmentPane, data);
	}

	private void createTextCompartmentFigure() {
		textCompartmentPane = new RectangleFigure();
		textCompartmentPane.setOutline(false);
		GridData data = GridDataFactory.fillDefaults().align(GridData.FILL, GridData.FILL).grab(true, true).getData();
		data.heightHint = mapMode.DPtoLP(15);
		this.add(textCompartmentPane, data);
	}

	public WrappingLabel getNameFigure() {
		return nameFigure;
	}

	public RectangleFigure getFigureCompartmentPane() {
		return figureCompartmentPane;
	}

	public RectangleFigure getTextCompartmentPane() {
		return textCompartmentPane;
	}

}
