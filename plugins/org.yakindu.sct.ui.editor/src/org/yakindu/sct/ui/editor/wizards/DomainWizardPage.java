/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.wizards;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomainDescriptor;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DomainWizardPage extends WizardPage {

	private ComboViewer domainCombo;

	private Label description;

	private Label image;

	private Object domainDescriptors;

	protected DomainWizardPage(String pageName) {
		this(pageName, DomainRegistry.getDomainDescriptors());
	}
	protected DomainWizardPage(String pageName, List<IDomainDescriptor> domainDescriptors) {
		super(pageName);
		this.domainDescriptors = domainDescriptors;
	}

	public void createControl(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
		GridLayoutFactory.fillDefaults().applyTo(composite);
		final Group domainSelectionGroup = new Group(composite, SWT.NONE);
		domainSelectionGroup.setText("Select the statechart domain:");

		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(domainSelectionGroup);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(domainSelectionGroup);

		Label spacer = new Label(domainSelectionGroup, SWT.NONE);
		GridDataFactory.fillDefaults().span(2, 1).applyTo(spacer);

		image = new Label(domainSelectionGroup, SWT.NONE);
		GridDataFactory.fillDefaults().grab(false, false).applyTo(image);
		domainCombo = new ComboViewer(domainSelectionGroup, SWT.READ_ONLY);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(domainCombo.getCombo());
		domainCombo.setContentProvider(new ArrayContentProvider());
		domainCombo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IDomainDescriptor) element).getName();
			}
		});
		domainCombo.setInput(domainDescriptors);

		description = new Label(domainSelectionGroup, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(description);
		setControl(composite);
		domainCombo.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				IDomainDescriptor domain = unwrap(event.getSelection());
				description.setText(domain.getDescription());
				image.setImage(domain.getImage());
				domainSelectionGroup.layout();

			}

		});
		domainCombo.setSelection(new StructuredSelection(DomainRegistry
				.getDomainDescriptor(BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral())));

		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("org.yakindu.sct.ui.wizard.create.contribution");
		if (configurationElements.length > 0) {

			Label spacer2 = new Label(domainSelectionGroup, SWT.NONE);
			GridDataFactory.fillDefaults().span(2, 1).applyTo(spacer2);
			for (IConfigurationElement iConfigurationElement : configurationElements) {
				try {
					CreationWizardContribution contribution = (CreationWizardContribution) iConfigurationElement
							.createExecutableExtension("class");
					contribution.toDomainWizardPage(composite);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getDomainID() {
		return unwrap(domainCombo.getSelection()).getDomainID();
	}

	private IDomainDescriptor unwrap(ISelection selection) {
		IDomainDescriptor domain = (IDomainDescriptor) ((StructuredSelection) selection).getFirstElement();
		return domain;
	}

}
