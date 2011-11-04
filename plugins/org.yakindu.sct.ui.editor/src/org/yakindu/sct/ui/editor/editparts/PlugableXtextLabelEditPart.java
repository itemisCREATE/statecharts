/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.ExpressionElement;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;
import org.yakindu.sct.ui.editor.policies.ExpressionDirectEditPolicy;

import com.google.inject.Injector;

import de.itemis.xtext.utils.gmf.directedit.XtextDirectEditManager;
import de.itemis.xtext.utils.gmf.directedit.XtextLabelEditPart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class PlugableXtextLabelEditPart extends XtextLabelEditPart {

	private Injector injector;

	protected abstract int getEditorStyles();

	public PlugableXtextLabelEditPart(View view, SemanticTarget target) {
		super(view);
		init(target);
	}

	private void init(SemanticTarget target) {
		IExpressionLanguageProvider registeredProvider = ExpressionLanguageProviderExtensions
				.getRegisteredProvider(target, resolveSemanticElement()
						.eResource().getURI().lastSegment());
		injector = registeredProvider.getInjector();
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		ExpressionDirectEditPolicy expressionDirectEditPolicy = new ExpressionDirectEditPolicy();
		injector.injectMembers(expressionDirectEditPolicy);
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				expressionDirectEditPolicy);
	}

	@Override
	protected XtextDirectEditManager createXTextDirectEditManager() {
		return new XtextDirectEditManager(this, injector, getEditorStyles());
	}

	@Override
	public ExpressionElement resolveSemanticElement() {
		return (ExpressionElement) super.resolveSemanticElement();
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == SGraphPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION) {
			refreshVisuals();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	public String getEditText() {
		String exp = resolveSemanticElement().getExpression();
		return exp != null ? exp : "";
	}

	public Injector getInjector() {
		return injector;
	}

}
