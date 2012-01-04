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
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.policies.ContextSensitiveHelpPolicy;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;

import de.itemis.xtext.utils.gmf.directedit.IXtextAwareEditPart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateTextCompartmentExpressionEditPart extends
		PlugableXtextLabelEditPart implements IXtextAwareEditPart {

	public StateTextCompartmentExpressionEditPart(View view) {
		super(view, SemanticTarget.StateSpecification);
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
		removeEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		installEditPolicy(
				EditPolicy.SELECTION_FEEDBACK_ROLE,
				new ContextSensitiveHelpPolicy(
						IYakinduSctHelpContextIds.SC_PROPERTIES_STATE_EXPRESSION));
	}

	private View getParentStateView() {
		if (getParent().getParent() instanceof StateEditPart) {
			return ((StateEditPart) getParent().getParent()).getNotationView();
		}
		return null;
	}

	@Override
	protected int getEditorStyles() {
		return SWT.MULTI;
	}
}
