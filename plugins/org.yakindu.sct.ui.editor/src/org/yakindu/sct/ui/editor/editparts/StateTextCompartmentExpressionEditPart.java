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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.yakindu.base.xtext.utils.gmf.directedit.IXtextAwareEditPart;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.policies.ContextSensitiveHelpPolicy;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateTextCompartmentExpressionEditPart extends SpecificationElementEditPart implements IXtextAwareEditPart {

	public StateTextCompartmentExpressionEditPart(View view) {
		super(view, State.class.getName());
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new ContextSensitiveHelpPolicy(
				HelpContextIds.SC_PROPERTIES_STATE_EXPRESSION));
	}

	@Override
	protected int getEditorStyles() {
		return SWT.MULTI;
	}

}
