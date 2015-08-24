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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.yakindu.base.gmf.runtime.parsers.StringAttributeParser;
import org.yakindu.base.xtext.utils.gmf.directedit.IEAttributeProvider;
import org.yakindu.base.xtext.utils.gmf.directedit.XtextDirectEditManager;
import org.yakindu.base.xtext.utils.gmf.directedit.XtextLabelEditPart;
import org.yakindu.base.xtext.utils.jface.viewers.ContextElementAdapter.IContextElementProvider;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomainInjectorProvider;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.policies.EAttributeDirectEditPolicy;

import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class PlugableXtextLabelEditPart extends XtextLabelEditPart implements ITextAwareEditPart,
		IContextElementProvider, IEAttributeProvider {

	private static final String PRIMARY_VIEW_LISTENER = "primaryViewListener";

	private Injector injector;

	protected abstract int getEditorStyles();

	public PlugableXtextLabelEditPart(View view, String target) {
		super(view);
		init(target);
	}

	@Override
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		addListenerFilter(PRIMARY_VIEW_LISTENER, this, getPrimaryView());
	}

	@Override
	protected void removeNotationalListeners() {
		removeListenerFilter(PRIMARY_VIEW_LISTENER);
		super.removeNotationalListeners();
	}

	private void init(String target) {
		IDomainInjectorProvider injectorProvider = DomainRegistry.getDomainDescriptor(resolveSemanticElement())
				.getDomainInjectorProvider();
		injector = injectorProvider.getEmbeddedEditorInjector(target);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new EAttributeDirectEditPolicy(this));
	}

	@Override
	protected DirectEditManager createDirectEditManager() {
		if (injector != null) {
			return new XtextDirectEditManager(this, injector, getEditorStyles(), this);
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

	public Injector getInjector() {
		return injector;
	}

	public String getEditText() {
		String exp = (String) resolveSemanticElement().eGet(getAttribute());
		return exp != null ? exp : "";
	}

	public ICellEditorValidator getEditTextValidator() {
		return null;
	}

	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	public IParser getParser() {
		return new StringAttributeParser(this, DiagramActivator.PLUGIN_ID);
	}

	public IContentAssistProcessor getCompletionProcessor() {
		return null;
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == getAttribute()
				|| notification.getFeature() == NotationPackage.Literals.STRING_VALUE_STYLE__STRING_VALUE) {
			refreshVisuals();
		}
		super.handleNotificationEvent(notification);
	}

	@Override
	protected void refreshVisuals() {
		updateLabelText();
		super.refreshVisuals();
	}

	@Override
	protected void updateLabelText() {
		String label = (String) resolveSemanticElement().eGet(getAttribute());
		getFigure().setText(label);
	}

}
