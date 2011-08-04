package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.policies.ContextSensitiveHelpPolicy;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartTextExpressionEditPart extends
		PlugableXtextLabelEditPart {

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
		installEditPolicy(
				EditPolicy.SELECTION_FEEDBACK_ROLE,
				new ContextSensitiveHelpPolicy(
						IYakinduSctHelpContextIds.SC_PROPERTIES_STATECHART_EXPRESSION));
	}

}
