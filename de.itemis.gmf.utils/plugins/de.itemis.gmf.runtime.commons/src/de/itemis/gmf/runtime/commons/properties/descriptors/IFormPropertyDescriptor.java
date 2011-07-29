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
import org.eclipse.jface.viewers.CellEditor.LayoutData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.Form;

import de.itemis.gmf.runtime.commons.properties.GenericFormBasedPropertySection;

/**
 * Interface for a property descirptor used with a
 * {@link GenericFormBasedPropertySection}. This PropertySection consists of a
 * {@link Form} control with a 2 column GridLayout per Default. An
 * implementation of this interface has to ensure that the returned
 * {@link Label} and {@link Control} has the right {@link LayoutData}.
 * 
 * @author andreas muelder
 * 
 */
public interface IFormPropertyDescriptor {
	/**
	 * Return the label for the first column of the property page.
	 */
	Label createLabel(Composite parent);

	/**
	 * creates a control for the second column of the property page.
	 */
	void initControl(Composite parent);

	/**
	 * Returns the control
	 */
	Control getControl();

	/**
	 * Returns the the result of the Control that should be stored in the model.
	 */
	Object getControlValue();

	/**
	 * Set the value to the given control
	 */
	void setControlValue(Object value);

	/**
	 * Returns the {@link EAttribute} where the Control value should be stored
	 * in
	 */
	EAttribute getEAttribute();

	/**
	 * Creates a help button for the third column of the property page.
	 */
	void addHelp(Composite parent);

}
