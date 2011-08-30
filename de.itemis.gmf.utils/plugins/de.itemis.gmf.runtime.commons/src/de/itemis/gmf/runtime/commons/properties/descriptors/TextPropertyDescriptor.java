/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package de.itemis.gmf.runtime.commons.properties.descriptors;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Implementation of {@link IFormPropertyDescriptor} for a {@link Text} control.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TextPropertyDescriptor extends AbstractPropertyDescriptor {

	public TextPropertyDescriptor(EStructuralFeature feature, String labelName) {
		super(feature, labelName);
	}

	public TextPropertyDescriptor(EStructuralFeature feature, String labelName,
			String helpContextId) {
		super(feature, labelName, helpContextId);
	}

	public Text createControl(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		Text control = toolkit.createText(parent, "");
		applyLayout(control);
		return control;
	}

	/**
	 * hook method, clients may override
	 */
	protected void applyLayout(Text control) {
		GridDataFactory.fillDefaults().grab(true, false).applyTo(control);
	}


	@Override
	public Text getControl() {
		return (Text) super.getControl();
	}

	@Override
	protected IObservableValue getWidgetValue() {
		return  WidgetProperties.text(SWT.FocusOut)
			.observe(getControl());
	}

}
