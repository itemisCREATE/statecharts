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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;

/**
 * This is a generic base implementation with a 2 column layout for {@link Form}
 * based {@link ISection}. Clients can provide different
 * {@link IFormPropertyDescriptor}. This class cares about value initialization,
 * adds {@link Listener}s to the controls and updates the underlying EMF model
 * to reflect changes.
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

		form.getBody().setLayout(createBodyLayout()); // returns 3 column grid by default now

		for (final IFormPropertyDescriptor descriptor : descriptors) {
			// Create the label in the first column
			descriptor.createLabel(form.getBody());
			// create the control inthe second column
			descriptor.initControl(form.getBody());
			// create help button in third column 
			descriptor.addHelp(form.getBody());
			final Control control = descriptor.getControl();
			// Add a focus listener to apply model changes on focus lost
			control.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					applyModelChanges(descriptor);
				}
				
				public void focusGained(FocusEvent e) {
					// Nothing to do
				}
			});
		}
	}
	
	protected void applyModelChanges(IFormPropertyDescriptor propertyDescriptor){
		executeSetCommand(new SetRequest(getEObject(), propertyDescriptor
				.getEAttribute(), propertyDescriptor.getControlValue()));		
	}
	
	/**
	 * Executes the {@link SetValueCommand} via the {@link IOperationHistory} to
	 * allow undo / redo
	 */
	protected void executeSetCommand(SetRequest request) {
		SetValueCommand command = new SetValueCommand(request);
		IOperationHistory operationHistory = OperationHistoryFactory
				.getOperationHistory();
		try {
			operationHistory.execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void refresh() {
		EObject eObject = getEObject();
		for (IFormPropertyDescriptor descriptor : descriptors) {
			Object value = eObject.eGet(descriptor.getEAttribute());
			descriptor.setControlValue(value);
		}
	}

}
