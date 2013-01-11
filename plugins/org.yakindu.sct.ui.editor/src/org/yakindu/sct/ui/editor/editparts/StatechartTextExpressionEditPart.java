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
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.commands.ToggleShowDocumentationCommand;
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
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE,
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

	@Override
	public Statechart resolveSemanticElement() {
		return (Statechart) super.resolveSemanticElement();
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
		StringValueStyle style = (StringValueStyle) getParentStateView()
				.getNamedStyle(NotationPackage.Literals.STRING_VALUE_STYLE,
						ToggleShowDocumentationCommand.FEATURE_TO_SHOW);
		return style;
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == NotationPackage.Literals.STRING_VALUE_STYLE__STRING_VALUE) {
			refreshVisuals();
		}
		super.handleNotificationEvent(notification);
	}

}
