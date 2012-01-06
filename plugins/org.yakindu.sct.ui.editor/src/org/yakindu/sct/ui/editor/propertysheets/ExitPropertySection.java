/**
 * Copyright (c) 2012 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.propertysheets;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.yakindu.sct.model.sgraph.SGraphPackage;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExitPropertySection extends AbstractEditorPropertySection {
	
	private Text nameText;

	@Override
	public void createControls(Composite parent) {
		getToolkit().createLabel(parent, "Name: ");
		nameText = getToolkit().createText(parent, "");
		GridDataFactory.fillDefaults().grab(true, false).applyTo(nameText);
	}

	@Override
	public void bindModel(EMFDataBindingContext context) {
		IEMFValueProperty property = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.NAMED_ELEMENT__NAME);
		ISWTObservableValue observe = WidgetProperties.text(SWT.FocusOut)
				.observe(nameText);
		context.bindValue(observe, property.observe(eObject));
	}

}
