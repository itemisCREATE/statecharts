/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.yakindu.sct.ui.editor.editor.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

public class FinalStateFigure extends Ellipse {

	protected IMapMode mapMode;

	public FinalStateFigure(IMapMode mapMode) {
		this.mapMode = mapMode;
		BorderLayout layout = new BorderLayout();

		this.setLayoutManager(layout);

		this.setOutline(false);
		this.setLineWidth(0);
		this.setBackgroundColor(ColorConstants.black);
		createContents();
	}

	protected void createContents() {
		int size = mapMode.DPtoLP(2);
		this.setBorder(new MarginBorder(size, size, size, size));
		Ellipse whiteCircle = new Ellipse();
		whiteCircle.setOutline(false);
		whiteCircle.setLineWidth(1);
		whiteCircle.setBackgroundColor(ColorConstants.white);
		size = mapMode.DPtoLP(3);
		whiteCircle.setBorder(new MarginBorder(size, size, size, size));
		BorderLayout layout = new BorderLayout();
		whiteCircle.setLayoutManager(layout);
		Object data = BorderLayout.CENTER;
		this.add(whiteCircle, data);
		Ellipse blackCircle = new Ellipse();
		blackCircle.setOutline(false);
		blackCircle.setLineWidth(mapMode.DPtoLP(1));
		blackCircle.setBackgroundColor(ColorConstants.black);
		data = BorderLayout.CENTER;
		whiteCircle.add(blackCircle, data);
	}

}