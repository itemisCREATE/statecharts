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
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.propertysheets.OrderElementControl.ISourceObjectCallback;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;

import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartPropertySection extends
		AbstractTwoColumnEditorPropertySection implements ISourceObjectCallback {

	private Control textControl;
	private Text txtName;
	private OrderElementControl orderElementControl;
	private Text documentation;

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
		createRegionsControl(rightColumn);

	}

	protected void createNameControl(Composite parent) {
		Label lblName = getToolkit().createLabel(parent, "Statechart Name: ");
		txtName = getToolkit().createText(parent, "");
		GridDataFactory.fillDefaults().span(2,1).applyTo(lblName);
		new Label(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(txtName);
	}

	protected void createRegionsControl(Composite rightColumn) {
		Label label = getToolkit().createLabel(rightColumn, "Region Priority:");
		GridDataFactory.fillDefaults().applyTo(label);
		orderElementControl = new OrderElementControl(rightColumn,
				SGraphPackage.Literals.COMPOSITE_ELEMENT__REGIONS, this);
		GridDataFactory.fillDefaults().span(2, 0).grab(true, false)
				.applyTo(orderElementControl);
	}

	protected void createDocumentationControl(Composite rightColumn) {
		Label lblDocumentation = getToolkit().createLabel(rightColumn,
				"Documentation: ");
		documentation = getToolkit().createText(rightColumn, "", SWT.MULTI);
		GridDataFactory.fillDefaults().applyTo(lblDocumentation);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(documentation);

	}

	protected void createSpecificationControl(final Composite parent) {
		
		Injector injector = getInjector(SemanticTarget.StatechartSpecification);
		if (injector != null) {
			textControl = new StyledText(parent, SWT.MULTI | SWT.BORDER
					| SWT.V_SCROLL | SWT.WRAP);
			((StyledText) textControl).setAlwaysShowScrollBars(false);
			enableXtext(textControl, injector);
			createHelpWidget(parent, textControl,
					HelpContextIds.SC_PROPERTIES_STATECHART_EXPRESSION);
		} else {
			textControl = getToolkit().createText(parent, "", SWT.MULTI);
		}
		GridDataFactory.fillDefaults().grab(true, true).hint(parent.getSize())
				.applyTo(textControl);
	}

	@Override
	public void bindModel(EMFDataBindingContext context) {
		bindNameControl(context);
		bindSpecificationControl(context);
		bindDocumentationControl(context);
		orderElementControl.refreshInput();
	}

	private void bindDocumentationControl(EMFDataBindingContext context) {
		IEMFValueProperty property = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION);
		ISWTObservableValue observe = WidgetProperties.text(
				new int[] { SWT.FocusOut, SWT.DefaultSelection }).observe(
				documentation);
		context.bindValue(observe, property.observe(eObject));
	}

	protected void bindSpecificationControl(EMFDataBindingContext context) {
		IEMFValueProperty modelProperty = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION);
		ISWTObservableValue uiProperty = WidgetProperties.text(SWT.FocusOut)
				.observe(textControl);
		context.bindValue(uiProperty, modelProperty.observe(eObject), null,
				new UpdateValueStrategy() {
					@Override
					protected IStatus doSet(IObservableValue observableValue,
							Object value) {
						if (!getCompletionProposalAdapter()
								.isProposalPopupOpen())
							return super.doSet(observableValue, value);
						return Status.OK_STATUS;
					}
				});

	}

	protected void bindNameControl(EMFDataBindingContext context) {
		IEMFValueProperty property = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				BasePackage.Literals.NAMED_ELEMENT__NAME);
		ISWTObservableValue observe = WidgetProperties.text(
				new int[] { SWT.FocusOut, SWT.DefaultSelection }).observe(
				txtName);
		context.bindValue(observe, property.observe(eObject));
	}

	@Override
	public EObject getEObject() {
		return super.getEObject();
	}

	@Override
	public void dispose() {
		if (orderElementControl != null) {
			orderElementControl.dispose();
		}
		super.dispose();
	}

}
