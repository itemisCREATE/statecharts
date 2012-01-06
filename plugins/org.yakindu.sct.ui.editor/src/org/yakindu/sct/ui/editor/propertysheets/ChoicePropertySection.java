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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.propertysheets.OrderElementControl.ISourceObjectCallback;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ChoicePropertySection extends AbstractEditorPropertySection
		implements ISourceObjectCallback {

	private OrderElementControl orderElementControl;

	@Override
	public void createControls(Composite parent) {
		Label label = getToolkit().createLabel(parent, "Transition Priority:");
		GridDataFactory.fillDefaults().applyTo(label);
		orderElementControl = new OrderElementControl(
				parent, SGraphPackage.Literals.VERTEX__OUTGOING_TRANSITIONS,
				this);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(orderElementControl);
	}

	@Override
	public void bindModel(EMFDataBindingContext context) {
		orderElementControl.refreshInput();
	}

	//Enhance visibility
	@Override
	public EObject getEObject() {
		return super.getEObject();
	}

}
