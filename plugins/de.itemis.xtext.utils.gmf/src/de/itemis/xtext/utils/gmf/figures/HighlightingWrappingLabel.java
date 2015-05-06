/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package de.itemis.xtext.utils.gmf.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class HighlightingWrappingLabel extends WrappingLabel implements MouseMotionListener {

	private static final MarginBorder NO_FOCUS_BORDER = new MarginBorder(new Insets(1, 1, 1, 1));
	private static final LineBorder FOCUS_BORDER = new LineBorder(ColorConstants.lightGray);

	public HighlightingWrappingLabel() {
		setBorder(NO_FOCUS_BORDER);
		addMouseMotionListener(this);
	}

	public void mouseEntered(MouseEvent me) {
		setBorder(FOCUS_BORDER);
	}

	public void mouseExited(MouseEvent me) {
		setBorder(NO_FOCUS_BORDER);
	}

	public void mouseDragged(MouseEvent me) {
		// Nothing to do
	}

	public void mouseHover(MouseEvent me) {
		// Nothing to do
	}

	public void mouseMoved(MouseEvent me) {
		// Nothing to do
	}

}
