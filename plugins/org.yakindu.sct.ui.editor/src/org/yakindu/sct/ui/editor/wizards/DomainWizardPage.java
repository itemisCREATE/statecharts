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

import java.net.URL;
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
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
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
	private Object domainDescriptors;
	private Browser browser;

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
		domainCombo = new ComboViewer(composite, SWT.READ_ONLY);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(domainCombo.getCombo());
		domainCombo.setContentProvider(new ArrayContentProvider());
		domainCombo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IDomain) element).getName();
			}

			@Override
			public Image getImage(Object element) {
				IDomain domain = unwrap(domainCombo.getSelection());
				ImageRegistry imageRegistry = DiagramActivator.getDefault().getImageRegistry();
				Image image = imageRegistry.get(domain.getImagePath().toString());
				if (image == null)
					imageRegistry.put(domain.getImagePath().toString(),
							ImageDescriptor.createFromURL(domain.getImagePath()).createImage());
				return imageRegistry.get(domain.getImagePath().toString());
			}
		});

		domainCombo.setInput(domainDescriptors);
		final Composite composite2 = new Composite(composite, SWT.BORDER);
		composite2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite2.setLayout(new FillLayout());
		browser = new Browser(composite2, SWT.NONE);
		domainCombo.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				URL url = unwrap(domainCombo.getSelection()).getDocumentationProvider().getDocumentationURL();
				if (url != null)
					browser.setUrl(url.toString());
			}
		});
		setControl(composite);
	}

	private boolean domainSelected = false;

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

	@Override
	public void setVisible(boolean visible) {
		if (visible)
			trySelectDefaultDomain();
			this.domainSelected = true;
		super.setVisible(visible);
	}

	public boolean isPageComplete() {
		return super.isPageComplete() && domainSelected;
	}

	public String getDomainID() {
		return unwrap(domainCombo.getSelection()).getDomainID();
	}

	protected IDomain unwrap(ISelection selection) {
		IDomain domain = (IDomain) ((StructuredSelection) selection).getFirstElement();
		return domain;
	}

}
