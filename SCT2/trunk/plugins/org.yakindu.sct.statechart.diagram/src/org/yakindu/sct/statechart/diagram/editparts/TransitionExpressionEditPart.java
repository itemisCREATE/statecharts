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
package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.model.sct.statechart.Transition;
import org.yakindu.sct.statechart.diagram.extensions.Extensions;
import org.yakindu.sct.statechart.diagram.extensions.IExpressionsProvider;
import org.yakindu.sct.statechart.diagram.policies.TransitionExpressionEditPolicy;

import com.google.inject.Injector;

import de.itemis.xtext.utils.gmf.directedit.IXTextAwareEditPart;
import de.itemis.xtext.utils.gmf.directedit.XTextDirectEditManager;
import de.itemis.xtext.utils.gmf.directedit.XTextLabelEditPart;

/**
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class TransitionExpressionEditPart extends XTextLabelEditPart implements
		IXTextAwareEditPart {

	private static Injector injector;

	private static final String EXPRESSIONS_EXTENSION = "org.yakindu.sct.statechart.diagram.expressions";

	public TransitionExpressionEditPart(View view) {
		super(view);
		if (injector == null) {
			createInjector();
		}
	}

	public void setLabel(IFigure figure) {
		setFigure(figure);
	}

	@Override
	protected IFigure createFigure() {
		return null;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new TransitionExpressionEditPolicy());
	}

	@Override
	public String getEditText() {
		System.out.println("Edit Text");
		//FIXME: If the passed String is not valid, we should save the invalid string instead
		if (resolveSemanticElement().getExpression() != null) {
			Serializer serializer = injector.getInstance(Serializer.class);
			String expression = serializer.serialize(resolveSemanticElement()
					.getExpression());
			System.out.println(expression);
			return expression;
		}
		return "";
	}

	public LabelEx getLabel() {
		return (LabelEx) getFigure();
	}

	@Override
	public void setLabelText(String text) {
		getLabel().setText(text);
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		System.out.println("Refresh Visuals");
		getLabel().setText(getEditText());
	}

	@Override
	protected XTextDirectEditManager createXTextDirectEditManager() {
		return new XTextDirectEditManager(this, injector, SWT.SINGLE);
	}

	private void createInjector() {
		Extensions<IExpressionsProvider> extensions = new Extensions<IExpressionsProvider>(
				EXPRESSIONS_EXTENSION);
		IExpressionsProvider registeredProvider = extensions
				.getRegisteredProvider(resolveSemanticElement());
		injector = registeredProvider.getInjector();
	}

	@Override
	public Transition resolveSemanticElement() {
		return (Transition) super.resolveSemanticElement();
	}
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		if(notification.getFeature() == StatechartPackage.Literals.TRANSITION__EXPRESSION)
			refreshVisuals();
	}

}
