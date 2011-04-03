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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;

public class JunctionFigure extends Ellipse {

	public JunctionFigure() {
		init();
	}

	private void init() {
		this.setOutline(true);
		this.setLineWidth(2);
		this.setSize(new Dimension(10, 10));
		this.setBorder(new MarginBorder(2, 2, 2, 2));
		this.setBackgroundColor(ColorConstants.white);
		this.setForegroundColor(ColorConstants.black);
	}

}