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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;

import de.itemis.gmf.runtime.commons.properties.GenericFormBasedPropertySection;

/**
 * Interface for a property descriptor used with a
 * {@link GenericFormBasedPropertySection}. This PropertySection consists of a
 * {@link Form} control with a 3 column GridLayout per Default.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IFormPropertyDescriptor {
	/**
	 * Return the label for the first column of the property page.
	 */
	void createLabelColumn(Composite parent);

	/**
	 * creates a control for the second column of the property page.
	 */
	void createControlColumn(Composite parent);

	/**
	 * Creates a help button for the third column of the property page.
	 */
	void createHelpColumn(Composite parent);

	/**
	 * Creates the binding between UI and model
	 */
	void updateModelBinding(EObject eObject);

	/**
	 * Disposes the UI related parts
	 */
	void dispose();

}
