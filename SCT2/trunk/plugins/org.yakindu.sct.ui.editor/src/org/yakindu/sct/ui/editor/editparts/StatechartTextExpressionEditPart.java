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

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.policies.ContextSensitiveHelpPolicy;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartTextExpressionEditPart extends
		PlugableXtextLabelEditPart {

	public StatechartTextExpressionEditPart(View view) {
		super(view, SemanticTarget.StatechartSpecification);
	}

	@Override
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		View parentStateView = getParentStateView();
		if (parentStateView != null) {
			addListenerFilter("parentStateView", this, parentStateView);
		}
	}

	@Override
	protected void removeNotationalListeners() {
		View parentStateView = getParentStateView();
		if (parentStateView != null) {
			removeListenerFilter("parentStateView");
		}
		super.removeNotationalListeners();
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
						HelpContextIds.SC_PROPERTIES_STATECHART_EXPRESSION));
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	private View getParentStateView() {
		if (getParent() instanceof StatechartTextEditPart) {
			return ((StatechartTextEditPart) getParent()).getNotationView();
		}
		return null;
	}

	@Override
	protected int getEditorStyles() {
		return SWT.MULTI | SWT.V_SCROLL;
	}

}
