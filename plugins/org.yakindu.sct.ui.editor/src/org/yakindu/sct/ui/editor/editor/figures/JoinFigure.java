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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;

public class JoinFigure extends RectangleFigure {

	public JoinFigure() {
		this.setSize(new Dimension(15, 40));
		this.setForegroundColor(ColorConstants.black);
		this.setBackgroundColor(ColorConstants.white);
		this.setEnabled(false);
	}
}