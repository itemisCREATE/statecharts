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
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.commands.ToggleShowDocumentationCommand;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.policies.ContextSensitiveHelpPolicy;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;

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
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE,
				new ContextSensitiveHelpPolicy(
						HelpContextIds.SC_PROPERTIES_STATE_EXPRESSION));
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

	@Override
	public State resolveSemanticElement() {
		return (State) super.resolveSemanticElement();
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
		return GMFNotationUtil.getStringValueStyle(getParentStateView(),
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
