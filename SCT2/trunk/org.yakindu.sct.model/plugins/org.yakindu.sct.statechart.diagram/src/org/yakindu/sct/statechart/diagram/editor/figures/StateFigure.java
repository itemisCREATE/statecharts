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
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.graphics.Color;
import org.yakindu.sct.model.statechart.statechart.State;
import org.yakindu.sct.statechart.diagram.editor.figures.utils.GridDataFactory;
import org.yakindu.sct.statechart.diagram.utils.FontConstants;

/**
 * {@link IFigure} implementation for {@link State}s.
 * 
 */
public class StateFigure extends RoundedRectangle {

	private static final int BLUR_SHADOW_WIDTH = 5;

	private WrappingLabel nameFigure;
	private WrappingLabel entryLabel;
	private WrappingLabel doLabel;
	private WrappingLabel exitLabel;
	private RectangleFigure compartmentPane;

	public StateFigure(IMapMode mapMode) {
		GridLayout layoutThis = new GridLayout();
		layoutThis.numColumns = 1;
		layoutThis.makeColumnsEqualWidth = false;
		this.setLayoutManager(layoutThis);
		this.setCornerDimensions(new Dimension(10, 10));
		this.setLineWidth(1);
		this.setBorder(new LineBorder());
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
		nameFigure.setText("<name>");
		nameFigure.setFont(FontConstants.DEFAULT);

		labelFigure.add(nameFigure, getLabelData());

		entryLabel = new WrappingLabel();
		entryLabel.setText("<entry>");

		labelFigure.add(entryLabel, getLabelData());

		doLabel = new WrappingLabel();
		doLabel.setText("<do>");
		labelFigure.add(doLabel, getLabelData());

		exitLabel = new WrappingLabel();
		exitLabel.setText("<exit>");

		labelFigure.add(exitLabel, getLabelData());

		createCompartmentFigure();

	}

	@Override
	public void paint(Graphics graphics) {
		setForegroundColor(ColorConstants.lightGray);
		drawBlurredShadow(graphics);
		super.paint(graphics);
	}

	private GridData getLabelData() {
		return GridDataFactory.fillDefaults().align(GridData.CENTER, GridData.CENTER).grab(true, false).getData();
	}

	private void createCompartmentFigure() {
		compartmentPane = new RectangleFigure();
		compartmentPane.setOutline(false);
		compartmentPane.setBorder(new LineBorder());
		compartmentPane.setLineWidth(1);
		this.add(compartmentPane, GridDataFactory.fillDefaults().align(GridData.FILL, GridData.FILL).grab(true, true)
				.getData());
	}

	public WrappingLabel getNameFigure() {
		return nameFigure;
	}

	public WrappingLabel getEntryLabel() {
		return entryLabel;
	}

	public WrappingLabel getDoLabel() {
		return doLabel;
	}

	public WrappingLabel getExitLabel() {
		return exitLabel;
	}

	public RectangleFigure getCompartmentPane() {
		return compartmentPane;
	}

	// TODO In Util methode
	private void drawBlurredShadow(Graphics graphics) {
		graphics.pushState();

		int size = MapModeUtil.getMapMode(this).DPtoLP(BLUR_SHADOW_WIDTH);
		int step = MapModeUtil.getMapMode(this).DPtoLP(-1);

		graphics.setForegroundColor(ColorConstants.gray);
		graphics.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(2));
		graphics.translate(size, size);
		graphics.setClip(graphics.getClip(new Rectangle(getBounds())).expand(size, size));
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

	@Override
	protected void fillShape(Graphics graphics) {
		Color c = mixColor(getBackgroundColor(), ColorConstants.white, 220);
		fillVerticalGradientRoundedRectangle(graphics, getBounds(), corner, getBackgroundColor(), c);
		c.dispose();
	}

}
