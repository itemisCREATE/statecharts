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
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.yakindu.sct.ui.editor.editor.figures.utils.GridDataFactory;

/**
 * Adds a Figure Compartment to the Statefigure.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CompositeStateFigure extends StateFigure {

	private Figure figureCompartmentPane;

	public CompositeStateFigure(IMapMode mapMode) {
		super(mapMode);
	}

	@Override
	protected void createContents() {
		super.createContents();
		// Figure Compartment
		figureCompartmentPane = new Figure();
		figureCompartmentPane.setLayoutManager(new StackLayout());
		this.add(figureCompartmentPane,
				GridDataFactory.fillDefaults().grab(true, true).getData());

	}

	public Figure getFigureCompartmentPane() {
		return figureCompartmentPane;
	}
}
