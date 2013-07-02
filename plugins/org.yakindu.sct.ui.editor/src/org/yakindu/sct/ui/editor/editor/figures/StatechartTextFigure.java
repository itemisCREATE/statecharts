/**
 * Copyright (c) 2011 committers of YAKINDU and others.
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
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.yakindu.sct.ui.editor.editor.figures.utils.GridDataFactory;

import de.itemis.xtext.utils.gmf.figures.HighlightingWrappingLabel;

/**
 * Figure for text compartment statechart declarations
 * 
 * @author muelder
 * 
 */
public class StatechartTextFigure extends RectangleFigure {

	/**
	 * The Name of the statechart
	 */
	private WrappingLabel name;
	/**
	 * The text compartment for statechart expressions
	 */
	private Figure compartment;

	public StatechartTextFigure(IMapMode mapMode) {
		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 2;
		this.setLayoutManager(layout);
		this.setOutline(true);
		createContents();
	}

	private void createContents() {
		name = new HighlightingWrappingLabel();
		name.setLayoutManager(new StackLayout());
		GridData data = GridDataFactory.fillDefaults()
				.align(GridData.CENTER, GridData.CENTER).grab(true, false)
				.getData();
		this.add(name, data);
		// Text compartment
		compartment = new Figure();
		this.add(compartment, GridDataFactory.fillDefaults().grab(true, true)
				.getData());
	}

	public Figure getCompartment() {
		return compartment;
	}

	public WrappingLabel getName() {
		return name;
	}

}
