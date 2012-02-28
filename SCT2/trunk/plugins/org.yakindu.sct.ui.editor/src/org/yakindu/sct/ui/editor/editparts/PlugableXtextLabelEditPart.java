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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;
import org.yakindu.sct.ui.editor.policies.ExpressionDirectEditPolicy;

import com.google.inject.Injector;

import de.itemis.gmf.runtime.commons.parsers.AttributeParser;
import de.itemis.xtext.utils.gmf.directedit.XtextDirectEditManager;
import de.itemis.xtext.utils.gmf.directedit.XtextLabelEditPart;
import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter.IContextElementProvider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class PlugableXtextLabelEditPart extends XtextLabelEditPart
		implements ITextAwareEditPart, IContextElementProvider {

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
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, createDirectEditPolicy());
	}

	protected DirectEditPolicy createDirectEditPolicy() {
		if (injector != null) {
			ExpressionDirectEditPolicy expressionDirectEditPolicy = new ExpressionDirectEditPolicy();
			injector.injectMembers(expressionDirectEditPolicy);
			return expressionDirectEditPolicy;
		} else
			return new LabelDirectEditPolicy();
	}

	@Override
	protected DirectEditManager createDirectEditManager() {
		if (injector != null) {
			return new XtextDirectEditManager(this, injector,
					getEditorStyles(), this);
		} else {
			return new TextDirectEditManager(this);
		}
	}

	@Override
	public SpecificationElement resolveSemanticElement() {
		return (SpecificationElement) super.resolveSemanticElement();
	}

	public EObject getContextObject() {
		return resolveSemanticElement();
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == getFeature()) {
			refreshVisuals();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	private EAttribute getFeature() {
		return SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION;
	}

	public Injector getInjector() {
		return injector;
	}

	public String getEditText() {
		String exp = resolveSemanticElement().getSpecification();
		return exp != null ? exp : "";
	}

	public ICellEditorValidator getEditTextValidator() {
		return null;
	}

	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	public IParser getParser() {
		return new AttributeParser(getFeature(), DiagramActivator.PLUGIN_ID);
	}

	public IContentAssistProcessor getCompletionProcessor() {
		return null;
	}

}
