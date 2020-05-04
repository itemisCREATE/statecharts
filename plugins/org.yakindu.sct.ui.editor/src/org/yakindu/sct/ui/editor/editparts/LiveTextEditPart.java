/**
* Copyright (c) 2020 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
*/
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.TextEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.base.gmf.runtime.editparts.LiveFeedbackResizableEditPolicy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class LiveTextEditPart extends TextEditPart {

	public LiveTextEditPart(View view) {
		super(view);
	}
	
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new LiveFeedbackResizableEditPolicy());
	}

}

