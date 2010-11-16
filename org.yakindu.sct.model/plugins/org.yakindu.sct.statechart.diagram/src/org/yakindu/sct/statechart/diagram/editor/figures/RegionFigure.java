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
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.yakindu.sct.statechart.diagram.editor.figures.utils.GridDataFactory;
import org.yakindu.sct.statechart.diagram.utils.FontConstants;

public class RegionFigure extends RoundedRectangle {

	private WrappingLabel nameLabel;

	private RectangleFigure compartmentPane;

	private final IMapMode mapMode;

	public RegionFigure(IMapMode mapMode) {
		this.mapMode = mapMode;
		setLayoutManager(new XYLayout());

		GridLayout layoutThis = new GridLayout();
		layoutThis.numColumns = 1;
		layoutThis.makeColumnsEqualWidth = true;
		layoutThis.verticalSpacing = 2;
		this.setLayoutManager(layoutThis);

		this.setCornerDimensions(new Dimension(mapMode.DPtoLP(20), mapMode.DPtoLP(20)));
		this.setLineWidth(mapMode.DPtoLP(1));
		createContents();
	}

	private void createContents() {

		RectangleFigure labelFigure = new RectangleFigure();
		labelFigure.setOutline(false);
		this.add(labelFigure, GridDataFactory.fillDefaults().align(GridData.CENTER, GridData.CENTER).grab(true, false)
				.getData());
		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 2;
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = true;
		labelFigure.setLayoutManager(layout);

		/** Priority Label **/
		nameLabel = new WrappingLabel();
		nameLabel.setFont(FontConstants.DEFAULT);
		GridData data = GridDataFactory.fillDefaults().align(GridData.CENTER, GridData.CENTER).grab(true, true)
				.getData();
		data.heightHint = mapMode.DPtoLP(15);
		labelFigure.add(nameLabel, data);

		/** Compartment container **/
		compartmentPane = new RectangleFigure();
		compartmentPane.setOutline(false);
		GridLayout compartmentLayout = new GridLayout();
		compartmentLayout.numColumns = 1;
		compartmentLayout.makeColumnsEqualWidth = true;
		compartmentPane.setLayoutManager(compartmentLayout);
		this.add(compartmentPane, GridDataFactory.fillDefaults().grab(true, true).getData());
	}

	public WrappingLabel getNameLabel() {
		return nameLabel;
	}

	public RectangleFigure getCompartmentPane() {
		return compartmentPane;
	}

}
