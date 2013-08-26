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
package org.yakindu.sct.ui.editor.propertysheets;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.propertysheets.OrderElementControl.ISourceObjectCallback;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;

import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatePropertySection extends AbstractTwoColumnEditorPropertySection implements ISourceObjectCallback {

	private Control txtSpecification;
	private Control txtName;
	private Text txtDoc;

	private OrderElementControl orderElementControl;

	@Override
	protected Layout createLeftColumnLayout() {
		return new GridLayout(2, false);
	}

	@Override
	protected void createLeftColumnControls(Composite leftColumn) {
		createNameControl(leftColumn);
		createSpecificationControl(leftColumn);
	}

	@Override
	protected void createRightColumnControls(Composite rightColumn) {
		createDocumentationControl(rightColumn);
		createTransitionsControl(rightColumn);
	}

	protected Control doCreateNameControl(Composite parent) {
		return getToolkit().createText(parent, "");
	}

	protected Control getNameControl() {
		return this.txtName;
	}

	protected void createNameControl(final Composite parent) {
		Label lblName = getToolkit().createLabel(parent, "State Name: ");
		txtName = doCreateNameControl(parent);
		GridDataFactory.fillDefaults().span(2, 1).applyTo(lblName);
		new Label(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(txtName);
	}

	protected void createDocumentationControl(Composite rightColumn) {
		Label lblDocumentation = getToolkit().createLabel(rightColumn, "Documentation: ");
		txtDoc = getToolkit().createText(rightColumn, "", SWT.MULTI);
		GridDataFactory.fillDefaults().applyTo(lblDocumentation);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(txtDoc);
	}

	protected void createSpecificationControl(final Composite parent) {
		Injector injector = getInjector(SemanticTarget.StateSpecification);
		if (injector != null) {
			txtSpecification = new StyledText(parent, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);
			((StyledText) txtSpecification).setAlwaysShowScrollBars(false);
			enableXtext(txtSpecification, injector);
			createHelpWidget(parent, txtSpecification, HelpContextIds.SC_PROPERTIES_STATE_EXPRESSION);
		} else {
			txtSpecification = getToolkit().createText(parent, "", SWT.MULTI);
		}
		GridDataFactory.fillDefaults().grab(true, true).hint(parent.getSize()).applyTo(txtSpecification);
	}

	protected void createTransitionsControl(Composite parent) {
		Label label = getToolkit().createLabel(parent, "Transition Priority:");
		GridDataFactory.fillDefaults().applyTo(label);
		orderElementControl = new OrderElementControl(parent, SGraphPackage.Literals.VERTEX__OUTGOING_TRANSITIONS, this);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(orderElementControl);
	}

	protected State getState() {
		return (State) eObject;
	}

	@Override
	public void bindModel(EMFDataBindingContext context) {
		bindNameControl(context);
		bindSpecificationControl(context);
		bindDocumentationControl(context);
		orderElementControl.refreshInput();
	}

	protected void bindDocumentationControl(EMFDataBindingContext context) {
		IEMFValueProperty property = EMFEditProperties.value(TransactionUtil.getEditingDomain(eObject),
				BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION);
		ISWTObservableValue observe = WidgetProperties.text(new int[] { SWT.FocusOut, SWT.DefaultSelection }).observe(
				txtDoc);
		context.bindValue(observe, property.observe(eObject));
	}

	protected void bindSpecificationControl(EMFDataBindingContext context) {
		IEMFValueProperty specificationProperty = EMFEditProperties.value(TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION);
		ISWTObservableValue specificationTextProperty = WidgetProperties.text(SWT.FocusOut).observe(txtSpecification);
		context.bindValue(specificationTextProperty, specificationProperty.observe(eObject), null,
				new UpdateValueStrategy() {
					@Override
					protected IStatus doSet(IObservableValue observableValue, Object value) {
						if (getCompletionProposalAdapter() != null && !getCompletionProposalAdapter().isProposalPopupOpen())
							return super.doSet(observableValue, value);
						return Status.OK_STATUS;
					}
				});
	}

	protected void bindNameControl(EMFDataBindingContext context) {
		IEMFValueProperty nameProperty = EMFEditProperties.value(TransactionUtil.getEditingDomain(eObject),
				BasePackage.Literals.NAMED_ELEMENT__NAME);
		ISWTObservableValue nameTextProperty = WidgetProperties.text(new int[] { SWT.FocusOut, SWT.DefaultSelection })
				.observe(txtName);
		context.bindValue(nameTextProperty, nameProperty.observe(eObject));
	}

	@Override
	public EObject getEObject() {
		return super.getEObject();
	}

}
