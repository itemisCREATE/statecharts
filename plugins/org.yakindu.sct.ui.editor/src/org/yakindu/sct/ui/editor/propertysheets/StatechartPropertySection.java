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

	@Override
	protected Layout createLeftColumnLayout() {
		return new GridLayout(2, false);
	}

	@Override
	protected void createLeftColumnControls(Composite leftColumn) {
		createSpecificationControl(leftColumn);
	}


	@Override
	protected void createRightColumnControls(Composite rightColumn) {
		createNameControl(rightColumn);
		createRegionsControl(rightColumn);

	}

	private void createNameControl(Composite parent) {
		Label lblName = getToolkit().createLabel(parent, "Statechart Name: ");
		txtName = getToolkit().createText(parent, "");
		GridDataFactory.fillDefaults().applyTo(txtName);
		GridDataFactory.fillDefaults().applyTo(lblName);
	}

	private void createRegionsControl(Composite rightColumn) {
		Label label = getToolkit().createLabel(rightColumn, "Region Priority:");
		GridDataFactory.fillDefaults().applyTo(label);
		orderElementControl = new OrderElementControl(rightColumn,
				SGraphPackage.Literals.COMPOSITE_ELEMENT__REGIONS, this);
		GridDataFactory.fillDefaults().span(2, 0).grab(true, false)
				.applyTo(orderElementControl);
	}

	private void createSpecificationControl(Composite parent) {
		Injector injector = getInjector(SemanticTarget.StatechartSpecification);
		if (injector != null) {
			textControl = new StyledText(parent, SWT.MULTI | SWT.BORDER
					| SWT.V_SCROLL);
			enableXtext(textControl, injector);
			createHelpWidget(parent, textControl,
					HelpContextIds.SC_PROPERTIES_STATECHART_EXPRESSION);
		} else {
			textControl = getToolkit().createText(parent, "", SWT.MULTI);
		}
		GridDataFactory.fillDefaults().grab(true, true).applyTo(textControl);
	}

	@Override
	public void bindModel(EMFDataBindingContext context) {
		bindNameControl(context);
		bindSpecificationControl(context);
		orderElementControl.refreshInput();
	}

	private void bindSpecificationControl(EMFDataBindingContext context) {
		IEMFValueProperty modelProperty = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION);
		ISWTObservableValue uiProperty = WidgetProperties.text(SWT.FocusOut)
				.observe(textControl);
		context.bindValue(uiProperty, modelProperty.observe(eObject));
	}

	private void bindNameControl(EMFDataBindingContext context) {
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
		orderElementControl.dispose();
		super.dispose();
	}

}
