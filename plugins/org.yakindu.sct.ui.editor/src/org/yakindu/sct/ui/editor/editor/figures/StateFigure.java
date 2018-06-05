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

import static org.yakindu.sct.ui.editor.editor.figures.utils.GraphicsUtil.fillVerticalGradientRoundedRectangle;
import static org.yakindu.sct.ui.editor.editor.figures.utils.GraphicsUtil.mixColor;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.graphics.Color;
import org.yakindu.base.xtext.utils.gmf.figures.SyntaxColoringLabel;
import org.yakindu.sct.ui.editor.editor.figures.utils.GridDataFactory;
import org.yakindu.sct.ui.editor.editor.themes.ThemeProvider;

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
		this.setCornerDimensions(new Dimension(mapMode.DPtoLP(15), mapMode
				.DPtoLP(15)));
		this.setOutline(true);
		createContents();
	}

	protected void createContents() {
		// Name Label
		nameFigure = new SyntaxColoringLabel();
		nameFigure.setAlignment(PositionConstants.CENTER);
		this.add(nameFigure, GridDataFactory.fillDefaults().grab(true, false)
				.getData());
		// Text compartment
		textCompartmentPane = new Figure();
		textCompartmentPane.setLayoutManager(new StackLayout());
		this.add(textCompartmentPane,
				GridDataFactory.fillDefaults().grab(true, true).getData());

		figureCompartmentPane = new Figure();
		figureCompartmentPane.setLayoutManager(new StackLayout());
		this.add(figureCompartmentPane,
				GridDataFactory.fillDefaults().grab(true, true).getData());
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

	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension result = super.getPreferredSize(wHint, hHint);
		return new Dimension(result.width + ThemeProvider.getInstance().getTheme().getStateBlurShadowWidth(),
				result.height + ThemeProvider.getInstance().getTheme().getStateBlurShadowWidth());
	}

	@Override
	public void setBounds(Rectangle rect) {
		// reduce the width and height with the blur shadow
		super.setBounds(new Rectangle(rect.x, rect.y, rect.width
				- ThemeProvider.getInstance().getTheme().getStateBlurShadowWidth(),
				rect.height - ThemeProvider.getInstance().getTheme().getStateBlurShadowWidth()));
	}

	// ========= drawing related methods ============================

	@Override
	public void paintFigure(Graphics graphics) {
		drawBlurredShadow(graphics);
		super.paintFigure(graphics);
	}

	/**
	 * Fill the shape with a vertical color gradient. The gradient mixes a white
	 * into the configured background color.
	 */
	@Override
	protected void fillShape(Graphics graphics) {
		if (ThemeProvider.getInstance().getTheme().getDrawStateBgGradient()) {
			Color c = mixColor(getBackgroundColor(), ColorConstants.white, 224);
			fillVerticalGradientRoundedRectangle(graphics, getBounds(), getCornerDimensions(), getBackgroundColor(), c);
			c.dispose();
		} else {
			super.fillShape(graphics);
		}
	}

	private void drawBlurredShadow(Graphics graphics) {
		if (!ThemeProvider.getInstance().getTheme().getDrawStateShadows()) {
			return;
		}
		graphics.pushState();

		int size = MapModeUtil.getMapMode(this)
				.DPtoLP(ThemeProvider.getInstance().getTheme().getStateBlurShadowWidth());
		int step = MapModeUtil.getMapMode(this).DPtoLP(-1);

		graphics.setForegroundColor(ColorConstants.gray);
		graphics.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(2));
		graphics.translate(size, size);
		graphics.setClip(graphics.getClip(new Rectangle(getBounds())).expand(
				size, size));
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
