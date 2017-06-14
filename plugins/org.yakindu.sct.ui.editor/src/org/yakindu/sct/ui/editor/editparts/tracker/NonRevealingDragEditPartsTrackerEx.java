/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editparts.tracker;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.tools.TargetingTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class NonRevealingDragEditPartsTrackerEx extends DragEditPartsTrackerEx {

	private static final int FLAG_ENABLE_DIRECT_EDIT = TargetingTool.MAX_FLAG << 2;

	public NonRevealingDragEditPartsTrackerEx(EditPart sourceEditPart) {
		super(sourceEditPart);
	}

	@Override
	protected void reveal(EditPart editpart) {
		// No reveal on selection
	}

	@Override
	protected boolean handleButtonUp(int button) {
		if (stateTransition(STATE_DRAG_IN_PROGRESS, STATE_TERMINAL)) {
			eraseSourceFeedback();
			eraseTargetFeedback();
			performDrag();
			return true;
		}
		if (isInState(STATE_DRAG)) {
			performSelection();
			if (getFlag(FLAG_ENABLE_DIRECT_EDIT))
				performDirectEdit();
			if (button == 1 && getSourceEditPart().getSelected() != EditPart.SELECTED_NONE)
				reveal(getSourceEditPart());
			setState(STATE_TERMINAL);
			return true;
		}
		return false;
	}
}
