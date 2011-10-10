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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 *
 */
public class TextAreaPropertyDescriptor extends TextPropertyDescriptor {

	public TextAreaPropertyDescriptor(EAttribute feature, String labelName) {
		super(feature, labelName);
	}

	public TextAreaPropertyDescriptor(EAttribute feature, String labelName,
			String helpContextId) {
		this(feature, labelName);
		this.helpContextId = helpContextId;
	}

	public Text createControl(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		Text control = toolkit.createText(parent, "", SWT.MULTI);
		return control;
	}

	@Override
	protected void applyLayout(Control control) {
		GridDataFactory.fillDefaults().grab(true, true).applyTo(control);
	}	

}
