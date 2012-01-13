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
public class TransitionExpressionEditPart extends
		PlugableExternalXtextLabelEditPart implements IXtextAwareEditPart {

	public TransitionExpressionEditPart(View view) {
		super(view, SemanticTarget.TransitionSpecification);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicy.SELECTION_FEEDBACK_ROLE,
				new ContextSensitiveHelpPolicy(
						IYakinduSctHelpContextIds.SC_PROPERTIES_TRANSITION_EXPRESSION));
	}

	@Override
	protected int getEditorStyles() {
		return SWT.MULTI;
	}

}
