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
package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.yakindu.sct.statechart.diagram.editor.figures.RegionFigure;
import org.yakindu.sct.statechart.diagram.preferences.StatechartPreferenceManager;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class RegionEditPart extends ShapeNodeEditPart {

	public RegionEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new DefaultSizeNodeFigure(40, 40);
		figure.setLayoutManager(new StackLayout());
		figure.add(new RegionFigure(getMapMode()));
		return figure;
	}

	@Override
	public IFigure getFigure() {
		IFigure figure = super.getFigure();
		Color regionColor = StatechartPreferenceManager.getInstance().getRegionColor();
		figure.setBackgroundColor(regionColor);
		return figure;
	}

	@Override
	public IFigure getContentPane() {
		return getPrimaryShape().getCompartmentPane();
	}

	private RegionFigure getPrimaryShape() {
		return (RegionFigure) getFigure().getChildren().get(0);
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof RegionCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentPane();
			pane.setLayoutManager(new StackLayout());
			IFigure figure2 = ((RegionCompartmentEditPart) childEditPart)
					.getFigure();
			pane.add(figure2);
		}else if(childEditPart instanceof RegionNameEditPart){
			((RegionNameEditPart) childEditPart).setLabel(getPrimaryShape().getNameLabel());
		} else
			super.addChildVisual(childEditPart, index);
	}
}
