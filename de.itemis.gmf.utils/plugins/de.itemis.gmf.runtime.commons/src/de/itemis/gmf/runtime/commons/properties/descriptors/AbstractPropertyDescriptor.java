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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Abstract base class for all implementers of {@link IFormPropertyDescriptor}.
 * 
 * @author andreas muelder
 * 
 */
public abstract class AbstractPropertyDescriptor implements
		IFormPropertyDescriptor {

	private final EAttribute feature;
	private final String labelName;

	private Control control;

	protected abstract Control createControl(Composite parent);

	public void initControl(Composite parent) {
		control = createControl(parent);
	}

	public AbstractPropertyDescriptor(EAttribute feature, String labelName) {
		this.feature = feature;
		this.labelName = labelName;
	}

	public EAttribute getEAttribute() {
		return feature;
	}

	public Label createLabel(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		Label label = toolkit.createLabel(parent, labelName);
		applyLayout(label);
		return label;
	}

	/**
	 * Hook method, clients may override if another layouting is needed
	 */
	protected void applyLayout(Control control) {
		GridDataFactory.fillDefaults().applyTo(control);
	}

	public Control getControl() {
		return control;
	}

}
