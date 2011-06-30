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

import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
/**
 * 
 * @author andreas muelder
 * 
 */
public class EntryBorderItemEditPart extends AbstractBorderItemEditPart {

	public EntryBorderItemEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = new NodeFigure();
		figure.setLayoutManager(new StackLayout());
		return figure;
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof EntryLabelEditPart) {
			getFigure().add(((EntryLabelEditPart) childEditPart).getFigure());
		} else
			super.addChildVisual(childEditPart, index);
	}

	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (childEditPart instanceof EntryLabelEditPart) {
			getFigure().remove(((EntryLabelEditPart) childEditPart).getFigure());
		} else
			super.removeChildVisual(childEditPart);
	}

}
