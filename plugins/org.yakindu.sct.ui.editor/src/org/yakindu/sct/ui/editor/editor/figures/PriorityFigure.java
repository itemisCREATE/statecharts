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
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.yakindu.sct.ui.editor.utils.FontScalingUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class PriorityFigure extends Ellipse {

	private static final FontData SMALL_FONT = new FontData("Arial", 7, SWT.NORMAL);
	private static final FontData NORMAL_FONT = new FontData("Arial", 8, SWT.NORMAL);
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
		label.setFont(createFont(priority));
		add(label);
	}

	protected Font createFont(int priority) {
		return JFaceResources.getResources().createFont(
				FontDescriptor.createFrom(FontScalingUtil.scaleFont(priority > 9 ? SMALL_FONT : NORMAL_FONT)));
	}

}