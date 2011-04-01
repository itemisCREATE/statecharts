package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartTextExpressionEditPart extends
		PlugableXTextLabelEditPart {

	public StatechartTextExpressionEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// Disables deletion of the text compartment view via keyboard
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new RootComponentEditPolicy());
		removeEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);	
	}


}
