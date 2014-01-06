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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.yakindu.sct.model.sgraph.ChoiceKind;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.propertysheets.OrderElementControl.ISourceObjectCallback;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ChoicePropertySection extends AbstractEditorPropertySection implements ISourceObjectCallback {

	private OrderElementControl orderElementControl;
	private ComboViewer choiceKindViewer;

	@Override
	public void createControls(Composite parent) {

		Label label = getToolkit().createLabel(parent, "Choice kind:");
		GridDataFactory.fillDefaults().applyTo(label);
		choiceKindViewer = new ComboViewer(parent);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(choiceKindViewer.getControl());
		choiceKindViewer.setContentProvider(new ArrayContentProvider());
		choiceKindViewer.setLabelProvider(new LabelProvider());
		choiceKindViewer.setInput(ChoiceKind.values());
		label = getToolkit().createLabel(parent, "Transition Priority:");
		GridDataFactory.fillDefaults().applyTo(label);
		orderElementControl = new OrderElementControl(parent, SGraphPackage.Literals.VERTEX__OUTGOING_TRANSITIONS, this);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(orderElementControl);
	}

	@Override
	public void bindModel(EMFDataBindingContext context) {
		orderElementControl.refreshInput();
		bindChoiceKind(context);
	}

	protected void bindChoiceKind(EMFDataBindingContext context) {
		IEMFValueProperty property = EMFEditProperties.value(TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.CHOICE__KIND);
		context.bindValue(ViewerProperties.singleSelection().observe(choiceKindViewer), property.observe(eObject));
	}

	// Enhance visibility
	@Override
	public EObject getEObject() {
		return super.getEObject();
	}

}
