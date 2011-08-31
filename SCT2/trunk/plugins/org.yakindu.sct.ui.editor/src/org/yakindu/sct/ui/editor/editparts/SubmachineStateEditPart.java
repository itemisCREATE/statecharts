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

import java.util.Collections;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.pictogram.PictogramEditPolicy;
import org.yakindu.sct.ui.editor.pictogram.SubchartPictogram;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SubmachineStateEditPart extends AbstractStateEditPart {

	public SubmachineStateEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(PictogramEditPolicy.ROLE, new PictogramEditPolicy(
				Collections.singletonList(new SubchartPictogram())));
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof SubmachineStateNameEditPart) {
			((SubmachineStateNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getNameFigure());
		} else {
			super.addChildVisual(childEditPart, index);
		}
	}

}
