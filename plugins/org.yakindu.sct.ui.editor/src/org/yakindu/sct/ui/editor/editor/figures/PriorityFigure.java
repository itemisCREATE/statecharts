/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editor.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class PriorityFigure extends Ellipse {

	private static final Font SMALL_FONT = new Font(null, "Arial", 7, SWT.NORMAL);
	private static final Font NORMAL_FONT = new Font(null, "Arial", 8, SWT.NORMAL);
	protected IMapMode mapMode;

	public PriorityFigure(IMapMode mapMode, int priority) {
		this.setLayoutManager(new StackLayout());
		setForegroundColor(ColorConstants.black);
		setBackgroundColor(ColorConstants.white);
		this.setOutline(false);
		setOpaque(false);
		setFill(true);
		this.setLineWidth(-1);
		Label label = new Label(String.valueOf(priority));
		label.setFont(priority > 9 ? SMALL_FONT : NORMAL_FONT);
		add(label);
	}

}