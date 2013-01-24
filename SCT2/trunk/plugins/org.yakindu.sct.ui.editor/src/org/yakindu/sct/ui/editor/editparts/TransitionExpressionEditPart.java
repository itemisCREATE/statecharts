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

import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.ui.editor.commands.ToggleShowDocumentationCommand;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.policies.ContextSensitiveHelpPolicy;
import org.yakindu.sct.ui.editor.policies.TransitionExpressionComponentEditPolicy;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;

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
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		View parentStateView = getParentView();
		if (parentStateView != null) {
			addListenerFilter("parentView", this, parentStateView);
		}
	}

	@Override
	protected void removeNotationalListeners() {
		View parentStateView = getParentView();
		if (parentStateView != null) {
			removeListenerFilter("parentView");
		}
		super.removeNotationalListeners();
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new TransitionExpressionComponentEditPolicy());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE,
				new ContextSensitiveHelpPolicy(
						HelpContextIds.SC_PROPERTIES_TRANSITION_EXPRESSION));
	}

	@Override
	protected int getEditorStyles() {
		return SWT.MULTI;
	}

	@Override
	public Transition resolveSemanticElement() {
		return (Transition) super.resolveSemanticElement();
	}

	private View getParentView() {
		return ((TransitionEditPart) getParent()).getNotationView();
	}

	@Override
	protected void updateTooltipText() {
		StringValueStyle style = getFeatureToShowStyle();
		if (style != null
				&& style.getStringValue().equals(
						BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION
								.getName())) {
			Label tooltip = new Label((String) resolveSemanticElement()
					.getSpecification());
			getFigure().setToolTip(tooltip);
		} else
			super.updateTooltipText();
	}

	@Override
	protected void updateLabelText() {
		StringValueStyle style = getFeatureToShowStyle();
		if (style != null
				&& style.getStringValue().equals(
						BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION
								.getName())) {
			getFigure().setText(resolveSemanticElement().getDocumentation());
		} else
			super.updateLabelText();
	}

	private StringValueStyle getFeatureToShowStyle() {
		return GMFNotationUtil.getStringValueStyle(getParentView(),
				ToggleShowDocumentationCommand.FEATURE_TO_SHOW);
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == NotationPackage.Literals.STRING_VALUE_STYLE__STRING_VALUE) {
			refreshVisuals();
		}
		super.handleNotificationEvent(notification);
	}
}
