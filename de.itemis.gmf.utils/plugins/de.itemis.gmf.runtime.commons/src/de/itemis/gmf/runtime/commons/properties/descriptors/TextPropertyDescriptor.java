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

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Implementation of {@link IFormPropertyDescriptor} for a {@link Text} control.
 * 
 * @author andreas muelder
 * 
 */
public class TextPropertyDescriptor extends AbstractPropertyDescriptor {

	public TextPropertyDescriptor(EAttribute feature, String labelName) {
		super(feature, labelName);
	}

	public TextPropertyDescriptor(EAttribute feature, String labelName, String helpContextId) {
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

	public Object getControlValue() {
		Text text = getControl();
		return (text.getText() != null && text.getText().trim().length() != 0) ? text
				.getText().trim() : null;
	}

	public void setControlValue(Object value) {
		if (value != null) {
			Assert.isTrue(value instanceof String, "Illegal value " + value);
			Text text = (Text) getControl();
			text.setText((String) value);
		}
	}

	@Override
	public Text getControl() {
		return (Text) super.getControl();
	}

}
