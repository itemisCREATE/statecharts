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

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.ui.editor.DiagramActivator;

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
		this(pageName, DomainRegistry.getDomains());
	}

	protected DomainWizardPage(String pageName, List<IDomain> domainDescriptors) {
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
				return ((IDomain) element).getName();
			}
		});
		domainCombo.setInput(domainDescriptors);

		description = new Label(domainSelectionGroup, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(description);
		setControl(composite);
		domainCombo.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				IDomain domain = unwrap(event.getSelection());
				description.setText(domain.getDescription());
				image.setImage(asImage(domain));
				domainSelectionGroup.layout();

			}

			private Image asImage(IDomain domain) {
				ImageRegistry imageRegistry = DiagramActivator.getDefault().getImageRegistry();
				Image image = imageRegistry.get(domain.getImagePath().toString());
				if (image == null)
					imageRegistry.put(domain.getImagePath().toString(),
							ImageDescriptor.createFromURL(domain.getImagePath()).createImage());
				return imageRegistry.get(domain.getImagePath().toString());
			}

		});

		trySelectDefaultDomain();
	}

	private void trySelectDefaultDomain() {
		try {
			domainCombo.setSelection(new StructuredSelection(
					DomainRegistry.getDomain(BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral())));
		} catch (IllegalArgumentException e) {
			// Can be ignored, if no default domain available no explicit domain
			// selection will be done and the first one initialized in
			// comboViewer will be selected implicitly
		}
	}

	private boolean visible = false;

	@Override
	public void setVisible(boolean visible) {
		this.visible = true;
		super.setVisible(visible);
	}
	
	public boolean domainSelected() {
		return visible;
	}

	public boolean isPageComplete() {
		return super.isPageComplete() && visible;
	}

	public String getDomainID() {
		return unwrap(domainCombo.getSelection()).getDomainID();
	}

	protected IDomain unwrap(ISelection selection) {
		IDomain domain = (IDomain) ((StructuredSelection) selection).getFirstElement();
		return domain;
	}

}
