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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;

public class InitialStateFigure extends Ellipse {

	public InitialStateFigure() {
		init();
	}

	private void init() {
		this.setLayoutManager(new BorderLayout());
		this.setOutline(false);
		this.setLineWidth(0);
		this.setSize(new Dimension(2, 2));
		this.setBorder(new MarginBorder(2, 2, 2, 2));
	}
	
}