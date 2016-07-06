/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.pages;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.examples.wizard.service.ExampleData;
import org.yakindu.sct.examples.wizard.service.ExampleWizardConstants;
import org.yakindu.sct.examples.wizard.service.IExampleService;

import com.google.inject.Inject;

/**
 * 
 * @author t00manysecretss
 * @author andreas muelder - Replace Image Gallery with Browser widget
 * 
 */

public class SelectExamplePage extends WizardPage
		implements ExampleWizardConstants, ISelectionChangedListener, SelectionListener {

	@Inject
	private IExampleService exampleService;
	private TreeViewer viewer;
	private ExampleData selection;
	private Browser browser;
	private MessageArea messageArea;

	public SelectExamplePage() {
		super(SELECT_PAGE_TITLE);
		setTitle(SELECT_PAGE_TITLE);
		setDescription(SELECT_PAGE_DESCRIPTION);
		setPageComplete(false);
	}

	public void createControl(Composite parent) {
		Composite root = new Composite(parent, SWT.NONE);
		root.setLayout(new GridLayout(1, true));
		createUpdateGroup(root);
		SashForm container = new SashForm(root, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
		createTreeViewer(container);
		createDetailsPane(container);
		container.setWeights(new int[] { 1, 2 });
		setControl(container);
	}

	private void createUpdateGroup(Composite root) {
		messageArea = new MessageArea(root);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(messageArea);
		messageArea.addSelectionListener(this);
		messageArea.hide();

	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			try {
				getWizard().getContainer().run(true, false, new IRunnableWithProgress() {
					@Override
					public void run(final IProgressMonitor monitor)
							throws InvocationTargetException, InterruptedException {
						init(monitor);
					}
				});
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			viewer.setInput(null);
			browser.setUrl("about:blank");
		}

	}

	private void init(final IProgressMonitor monitor) {
		if (!exampleService.exists()) {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					messageArea.showDownload();
				}
			});
		} else if (!exampleService.isUpToDate()) {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					messageArea.showUpdate();
				}
			});
		} else {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					setInput(monitor);
				}
			});
		}
	}

	protected void setInput(final IProgressMonitor monitor) {
		final List<ExampleData> input = exampleService.getExamples(new NullProgressMonitor());

		messageArea.hide();
		viewer.setInput(input);
		viewer.expandAll();
	}

	protected void createTreeViewer(Composite container) {
		viewer = new TreeViewer(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(viewer.getControl());
		viewer.setContentProvider(new ExampleContentProvider());
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new ExampleLabelProvider()));
		viewer.addSelectionChangedListener(this);
	}

	protected void updateSelection(ExampleData data) {
		selection = data;
		setDetailPaneContent(data);
		setPageComplete(true);
		setErrorMessage(null);
		viewer.refresh();
	}

	protected void setDetailPaneContent(ExampleData exampleData) {
		String url = exampleData.getProjectDir().getAbsolutePath() + File.separator + "index.html";
		browser.setUrl(url);
	}

	protected void createDetailsPane(Composite parent) {
		final Composite composite = new Composite(parent, SWT.BORDER);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new FillLayout());
		browser = new Browser(composite, SWT.NONE);
	}

	public ExampleData getSelection() {
		return selection;
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		Object firstElement = ((StructuredSelection) event.getSelection()).getFirstElement();
		if (firstElement instanceof ExampleData)
			updateSelection((ExampleData) firstElement);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		try {
			getWizard().getContainer().run(true, true, new IRunnableWithProgress() {
				@Override
				public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					final IStatus status = exampleService.fetchAllExamples(monitor);
					Display.getDefault().syncExec(new Runnable() {
						@Override
						public void run() {
							if (status.isOK()) {
								SelectExamplePage.this.setInput(monitor);
							} else {
								messageArea.showError(status.getMessage());
							}
						}
					});
				}
			});

		} catch (InvocationTargetException | InterruptedException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);

	}

}