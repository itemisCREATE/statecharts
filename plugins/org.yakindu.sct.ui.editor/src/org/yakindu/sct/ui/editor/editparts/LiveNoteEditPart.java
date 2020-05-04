/**
* Copyright (c) 2020 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
*/
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.NoteEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.base.gmf.runtime.editparts.LiveFeedbackResizableEditPolicy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class LiveNoteEditPart extends NoteEditPart{

	public LiveNoteEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new LiveFeedbackResizableEditPolicy());
	}

}
