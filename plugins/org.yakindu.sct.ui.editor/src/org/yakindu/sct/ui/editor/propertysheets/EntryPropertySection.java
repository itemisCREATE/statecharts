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
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.SGraphPackage;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EntryPropertySection extends AbstractEditorPropertySection {

	private Control nameText;

	private ComboViewer entryKindViewer;

	public void createControls(Composite parent) {
		createNameControl(parent);
		createEntryKindControl(parent);
	}

	@Override
	public void bindModel(EMFDataBindingContext context) {
		bindNameControl(context);
		bindEntryKindControl(context);
	}

	private void createNameControl(Composite parent) {
		getToolkit().createLabel(parent, "Name: ");
		nameText = getToolkit().createText(parent, "");
		GridDataFactory.fillDefaults().applyTo(nameText);
	}

	private void createEntryKindControl(Composite parent) {
		Label kindLabel = getToolkit().createLabel(parent, "Entry Kind: ");
		GridDataFactory.fillDefaults().applyTo(kindLabel);
		entryKindViewer = new ComboViewer(parent, SWT.READ_ONLY | SWT.SINGLE);
		entryKindViewer.setContentProvider(new ArrayContentProvider());
		entryKindViewer.setLabelProvider(new LabelProvider());
		entryKindViewer.setInput(EntryKind.values());
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(entryKindViewer.getControl());
	}

	private void bindNameControl(EMFDataBindingContext context) {
		IEMFValueProperty property = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.NAMED_ELEMENT__NAME);
		ISWTObservableValue observe = WidgetProperties.text(SWT.FocusOut)
				.observe(nameText);
		context.bindValue(observe, property.observe(eObject));
	}

	private void bindEntryKindControl(EMFDataBindingContext context) {
		IEMFValueProperty property = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.ENTRY__KIND);
		context.bindValue(
				ViewerProperties.singleSelection().observe(entryKindViewer),
				property.observe(eObject));
	}
}
