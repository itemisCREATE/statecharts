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
package de.itemis.gmf.runtime.commons.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;

/**
 * This is a generic base implementation with a 2 column layout for {@link Form}
 * based {@link ISection}. Clients can provide different
 * {@link IFormPropertyDescriptor}.
 * 
 * @author andreas muelder
 * 
 */
public abstract class GenericFormBasedPropertySection extends
		AbstractModelerPropertySection {

	private List<IFormPropertyDescriptor> descriptors;

	protected abstract void createPropertyDescriptors(
			List<IFormPropertyDescriptor> descriptors);

	public GenericFormBasedPropertySection() {
		descriptors = new ArrayList<IFormPropertyDescriptor>();
	}

	/**
	 * Hook method, clients may override
	 */
	protected Layout createBodyLayout() {
		return new GridLayout(3, false);
	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {

		super.createControls(parent, aTabbedPropertySheetPage);
		createPropertyDescriptors(descriptors);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);
		parent.setLayout(new GridLayout(1, true));

		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		Form form = toolkit.createForm(parent);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(form);

		form.getBody().setLayout(createBodyLayout());

		for (final IFormPropertyDescriptor descriptor : descriptors) {
			// Create the label in the first column
			descriptor.createLabelColumn(form.getBody());
			// create the control in the second column
			descriptor.createControlColumn(form.getBody());
			// create help button in third column
			descriptor.createHelpColumn(form.getBody());
		}
	}

	@Override
	public void refresh() {
		super.refresh();
		EObject eObject = getEObject();
		for (IFormPropertyDescriptor descriptor : descriptors) {
			descriptor.updateModelBinding(eObject);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		for (final IFormPropertyDescriptor descriptor : descriptors) {
			descriptor.dispose();
		}
	}
}
