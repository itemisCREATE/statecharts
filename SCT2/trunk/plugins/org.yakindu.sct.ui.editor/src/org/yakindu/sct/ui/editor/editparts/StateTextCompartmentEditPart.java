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
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.editor.figures.utils.GridDataFactory;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateTextCompartmentEditPart extends ResizableCompartmentEditPart {

	public StateTextCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof StateTextCompartmentExpressionEditPart) {
			GridData data = GridDataFactory.fillDefaults().grab(true, true).getData();
			getContentPane().add(((StateTextCompartmentExpressionEditPart) childEditPart).getFigure(), data);
		} else
			super.addChildVisual(childEditPart, index);
	}

	@Override
	protected IFigure createFigure() {
		ResizableCompartmentFigure figure = (ResizableCompartmentFigure) super.createFigure();
		GridLayout gridLayout = new GridLayout(1, true);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		figure.getContentPane().setLayoutManager(gridLayout);
		figure.setBorder(null);
		figure.setToolTip((String) null);
		return figure;
	}
}
