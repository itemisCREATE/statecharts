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

import static org.yakindu.sct.statechart.diagram.editor.figures.utils.GraphicsUtil.fillVerticalGradientRoundedRectangle;
import static org.yakindu.sct.statechart.diagram.editor.figures.utils.GraphicsUtil.mixColor;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.graphics.Color;
import org.yakindu.sct.statechart.diagram.editor.figures.utils.GridDataFactory;

/**
 * 
 * @author muelder
 * 
 */
public class StateFigure extends RoundedRectangle {

	private static final int BLUR_SHADOW_WIDTH = 5;

	private WrappingLabel nameFigure;
	private Figure figureCompartmentPane;
	private Figure textCompartmentPane;

	public StateFigure(IMapMode mapMode) {
		GridLayout layout = new GridLayout(1, false);
		this.setLayoutManager(layout);
		this.setCornerDimensions(new Dimension(mapMode.DPtoLP(15), mapMode
				.DPtoLP(15)));
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
	
	
	//========= drawing related methods ============================

	
	@Override
	public void paintFigure(Graphics graphics) {
		setForegroundColor(ColorConstants.lightGray);
		drawBlurredShadow(graphics);
		super.paintFigure(graphics);
	}
	
	
	/**
	 * Fill the shape with a vertical color gradient. The gradient mixes a white into the configured background color. 
	 */
	@Override
	protected void fillShape(Graphics graphics) {
		Color c=mixColor(getBackgroundColor(), ColorConstants.white, 224);
		fillVerticalGradientRoundedRectangle(graphics, getBounds(), corner, getBackgroundColor(), c);
		c.dispose();
	}
	
	
	private void drawBlurredShadow(Graphics graphics) {
		// draw the shadow...
		graphics.pushState();

		int size = MapModeUtil.getMapMode(this).DPtoLP(BLUR_SHADOW_WIDTH);
		int step = MapModeUtil.getMapMode(this).DPtoLP(-1);
		
		graphics.setForegroundColor(ColorConstants.gray);
		graphics.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(2));
		graphics.translate(size, size);
		graphics.setClip(graphics.getClip(new Rectangle(getBounds()))
				.expand(size, size));
		graphics.setAlpha(20);
		outlineShape(graphics);
		graphics.translate(step, step);
		graphics.setAlpha(30);
		outlineShape(graphics);
		graphics.translate(step, step);
		graphics.setAlpha(60);
		outlineShape(graphics);
		graphics.translate(step, step);
		graphics.setAlpha(100);
		outlineShape(graphics);
		graphics.translate(step, step);
		graphics.setAlpha(150);
		outlineShape(graphics);

		graphics.popState();
	}



}
