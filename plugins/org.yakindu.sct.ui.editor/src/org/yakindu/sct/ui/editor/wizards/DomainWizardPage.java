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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.DomainRegistry.DomainDescriptor;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DomainWizardPage extends WizardPage {

	private ComboViewer domainCombo;

	private Label description;

	protected DomainWizardPage(String pageName) {
		super(pageName);
	}

	public void createControl(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
		GridLayoutFactory.fillDefaults().applyTo(composite);
		Group domainSelectionGroup = new Group(composite, SWT.NONE);
		domainSelectionGroup.setText("Select the Statechart domain:");
		GridLayoutFactory.fillDefaults().applyTo(domainSelectionGroup);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(domainSelectionGroup);
		domainCombo = new ComboViewer(domainSelectionGroup, SWT.READ_ONLY);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(domainCombo.getCombo());
		domainCombo.setContentProvider(new ArrayContentProvider());
		domainCombo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((DomainDescriptor) element).getDomainID();
			}
		});
		domainCombo.setInput(DomainRegistry.getDomainDescriptors());
		description = new Label(domainSelectionGroup, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(description);
		setControl(composite);
		domainCombo.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				DomainDescriptor domain = unwrap(event.getSelection());
				description.setText(domain.getDescription());
				composite.layout();

			}

		});
		domainCombo.setSelection(new StructuredSelection(DomainRegistry.getDomainDescriptors().get(0)));

		Link sctLink = new Link(composite, SWT.NONE);
		sctLink.setText("<a>Get additional Statechart Domain Extensions</a>");
		sctLink.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				org.eclipse.swt.program.Program.launch("http://statecharts.org/");
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	public String getDomainID() {
		return unwrap(domainCombo.getSelection()).getDomainID();
	}

	private DomainDescriptor unwrap(ISelection selection) {
		DomainDescriptor domain = (DomainDescriptor) ((StructuredSelection) selection).getFirstElement();
		return domain;
	}

}
