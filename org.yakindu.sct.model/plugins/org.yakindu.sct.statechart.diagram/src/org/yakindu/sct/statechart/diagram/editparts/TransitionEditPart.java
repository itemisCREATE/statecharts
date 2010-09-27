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

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.editor.figures.TransitionFigure;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class TransitionEditPart extends ConnectionNodeEditPart {

	public TransitionEditPart(View view) {
		super(view);
	}

	@Override
	protected Connection createConnectionFigure() {
		return new TransitionFigure(getMapMode());
	}

}
