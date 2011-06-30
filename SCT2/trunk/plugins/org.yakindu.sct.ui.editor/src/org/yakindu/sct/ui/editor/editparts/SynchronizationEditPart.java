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
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.editor.figures.SynchronizationFigure;

import de.itemis.gmf.runtime.commons.editparts.BarEditPart;

/**
 * 
 * @author andreas muelder
 * 
 */
public class SynchronizationEditPart extends BarEditPart {

	public SynchronizationEditPart(View view) {
		super(view);
	}

	@Override
	public IFigure createPrimaryFigure() {
		return new SynchronizationFigure(getMapMode());
	}

}
