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

import java.util.Collections;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;

import com.google.inject.Injector;

import de.itemis.xtext.utils.jface.viewers.StyledTextXtextAdapter;
import de.itemis.xtext.utils.jface.viewers.context.CloningBasedFakeContextResourcesProvider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartPropertySection extends AbstractEditorPropertySection {

	private Control textControl;
	private Text nameText;

	public void createControls(Composite parent) {
		createNameControl(parent);
		createSpecificationControl(parent);
	}

	private void createNameControl(Composite parent) {
		getToolkit().createLabel(parent, "Name: ");
		nameText = getToolkit().createText(parent, "");
		GridDataFactory.fillDefaults().applyTo(nameText);
	}

	private void createSpecificationControl(Composite parent) {
		Label nameLabel = getToolkit().createLabel(parent, "Specification: ");
		GridDataFactory.fillDefaults().applyTo(nameLabel);
		Injector injector = getInjector(SemanticTarget.StatechartSpecification);
		if (injector != null) {
			textControl = new StyledText(parent, SWT.MULTI | SWT.BORDER
					| SWT.V_SCROLL);
			StyledTextXtextAdapter xtextAdapter = new StyledTextXtextAdapter(
					injector, new CloningBasedFakeContextResourcesProvider(
							Collections
									.singletonList(getActiveEditorResource())));
			xtextAdapter.adapt((StyledText) textControl);
		} else {
			textControl = getToolkit().createText(parent, "", SWT.MULTI);
		}
		GridDataFactory.fillDefaults().grab(true, true).applyTo(textControl);
	}

	@Override
	public void bindModel(EMFDataBindingContext context) {
		bindNameControl(context);
		bindSpecificationControl(context);
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
				SGraphPackage.Literals.NAMED_ELEMENT__NAME);
		ISWTObservableValue observe = WidgetProperties.text(SWT.FocusOut)
				.observe(nameText);
		context.bindValue(observe, property.observe(eObject));
	}

}
