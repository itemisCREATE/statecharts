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

import static org.eclipse.gef.EditPolicy.COMPONENT_ROLE;
import static org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE;
import static org.eclipse.gef.EditPolicy.SELECTION_FEEDBACK_ROLE;
import static org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE;

import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
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
public class StatechartTextExpressionEditPart extends SpecificationElementEditPart {

	public StatechartTextExpressionEditPart(View view) {
		super(view, SemanticTarget.StatechartSpecification);
	}
	
	@Override
	public WrappingLabel getFigure() {
		// TODO Auto-generated method stub
		return super.getFigure();
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// Disables deletion of the text compartment via keyboard
		installEditPolicy(COMPONENT_ROLE, new RootComponentEditPolicy());
		removeEditPolicy(PRIMARY_DRAG_ROLE);
		installEditPolicy(SELECTION_FEEDBACK_ROLE, new ContextSensitiveHelpPolicy(
				HelpContextIds.SC_PROPERTIES_STATECHART_EXPRESSION));
		removeEditPolicy(CONNECTION_HANDLES_ROLE);
	}

	@Override
	protected int getEditorStyles() {
		return SWT.MULTI | SWT.V_SCROLL;
	}
}
