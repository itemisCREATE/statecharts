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

import static org.yakindu.sct.ui.editor.editor.figures.utils.GraphicsUtil.fillVerticalGradientRectangle;
import static org.yakindu.sct.ui.editor.editor.figures.utils.GraphicsUtil.mixColor;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.graphics.Color;
import org.yakindu.base.xtext.utils.gmf.figures.SyntaxColoringLabel;
import org.yakindu.sct.ui.editor.editor.figures.utils.GridDataFactory;

/**
 *
 * @author muelder
 * @author terfloth
 *
 */
public class RegionFigure extends RectangleFigure {
	private WrappingLabel nameLabel;

	private RectangleFigure compartmentPane;

	private final IMapMode mapMode;

	private boolean drawRegionBgGradient;
	private boolean drawRegionShadows;
	private int regionBlurShadowWidth;

	public RegionFigure(IMapMode mapMode) {
		this.mapMode = mapMode;

		GridLayout layoutThis = new GridLayout(1, false);
		layoutThis.verticalSpacing = 2;
		this.setLayoutManager(layoutThis);
		this.setLineWidth(mapMode.DPtoLP(1));
		createContents();
	}

	private void createContents() {
		nameLabel = new SyntaxColoringLabel();
		GridData data = GridDataFactory.fillDefaults().grab(true, false).getData();
		data.horizontalIndent = 5;
		nameLabel.setTextPlacement(PositionConstants.WEST);
		this.add(nameLabel, data);

		/** Compartment container **/
		compartmentPane = new RectangleFigure();
		compartmentPane.setOutline(false);
		compartmentPane.setLayoutManager(new StackLayout());
		compartmentPane.setFill(false);
		this.add(compartmentPane, GridDataFactory.fillDefaults().grab(true, true).getData());
	}

	public WrappingLabel getNameLabel() {
		return nameLabel;
	}

	public RectangleFigure getCompartmentPane() {
		return compartmentPane;
	}

	public boolean getDrawRegionBgGradient() {
		return drawRegionBgGradient;
	}

	public void setDrawRegionBgGradient(boolean drawRegionBgGradient) {
		this.drawRegionBgGradient = drawRegionBgGradient;
	}

	public boolean getDrawRegionShadows() {
		return drawRegionShadows;
	}

	public void setDrawRegionShadows(boolean drawRegionShadows) {
		this.drawRegionShadows = drawRegionShadows;
	}

	public int getRegionBlurShadowWidth() {
		return regionBlurShadowWidth;
	}

	public void setRegionBlurShadowWidth(int regionBlurShadowWidth) {
		this.regionBlurShadowWidth = regionBlurShadowWidth;
	}

	@Override
	public void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		drawBlurredShadow(graphics);
	}

	// ========= drawing related methods ============================

	/**
	 * Fill the shape with a vertical color gradient. The gradient mixes a white
	 * into the configured background color.
	 */
	@Override
	protected void fillShape(Graphics graphics) {
		if (drawRegionBgGradient) {
			Color c = mixColor(getBackgroundColor(), ColorConstants.white, 220);
			fillVerticalGradientRectangle(graphics, getBounds(), getBackgroundColor(), c);
			c.dispose();
		} else {
			super.fillShape(graphics);
		}
	}

	public IMapMode getMapMode() {
		return mapMode;
	}

	private void drawBlurredShadow(Graphics graphics) {
		if (!drawRegionShadows) {
			return;
		}
		graphics.pushState();
		// TODO check
		int size = MapModeUtil.getMapMode(this)
				.DPtoLP(regionBlurShadowWidth);
		int step = MapModeUtil.getMapMode(this).DPtoLP(1);

		graphics.setForegroundColor(ColorConstants.gray);
		graphics.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(2));
		graphics.setClip(graphics.getClip(new Rectangle(getBounds())));
		graphics.setAlpha(150);
		outlineShape(graphics);
		graphics.translate(step, step);
		graphics.setAlpha(100);
		outlineShape(graphics);
		graphics.translate(step, step);
		graphics.setAlpha(60);
		outlineShape(graphics);
		graphics.translate(step, step);
		graphics.setAlpha(30);
		outlineShape(graphics);
		graphics.translate(step, step);
		graphics.setAlpha(20);
		outlineShape(graphics);

		graphics.popState();
	}

}
