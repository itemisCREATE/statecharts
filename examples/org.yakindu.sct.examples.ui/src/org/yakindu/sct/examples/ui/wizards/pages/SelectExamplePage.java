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
package org.yakindu.sct.examples.ui.wizards.pages;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;

import javax.swing.text.html.ImageView;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.yakindu.sct.examples.ui.wizards.ExampleData;
import org.yakindu.sct.examples.ui.wizards.ExampleWizardConstants;
import org.yakindu.sct.examples.ui.wizards.IExampleService;
import org.yakindu.sct.examples.ui.wizards.provider.ExampleContentProvider;
import org.yakindu.sct.examples.ui.wizards.provider.ExampleLabelProvider;

import com.google.inject.Inject;

/**
 * 
 * @author t00manysecretss
 * 
 */

public class SelectExamplePage extends WizardPage implements ExampleWizardConstants, ISelectionChangedListener {

	@Inject
	private IExampleService exampleService;
	private TreeViewer viewer;
	private Label description;
	private ExampleData selection;
	private ImageViewer imageViewer;

	public SelectExamplePage() {
		super(SELECT_PAGE_TITLE);
		setTitle(SELECT_PAGE_TITLE);
		setDescription(SELECT_PAGE_DESCRIPTION);
		setPageComplete(false);
	}

	public void createControl(Composite parent) {
		SashForm container = new SashForm(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
		createTreeViewer(container);
		createDetailsPane(container);
		container.setWeights(new int[] { 1, 2 });
		setControl(container);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			initialize();
		}
	}

	protected void initialize() {
		try {
			getWizard().getContainer().run(true, false, new IRunnableWithProgress() {

				@Override
				public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					final IStatus status = exampleService.init(monitor);
					final List<ExampleData> input = exampleService.getExamples(new NullProgressMonitor());
					Display.getDefault().syncExec(new Runnable() {
						@Override
						public void run() {
							if (status.isOK()) {
								setErrorMessage(null);
								setPageComplete(true);
								viewer.setInput(input);
								viewer.expandAll();
								getShell().layout();
							} else {
								setErrorMessage(status.getMessage());
								setPageComplete(false);
							}
							monitor.done();

						}
					});
				}
			});

		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
			setErrorMessage(e.getMessage());
			setPageComplete(true);
		}
	}

	protected void createTreeViewer(Composite container) {
		viewer = new TreeViewer(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(viewer.getControl());
		viewer.setContentProvider(new ExampleContentProvider());
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(
				new ExampleLabelProvider(createImageDescriptor(FILEICON), createImageDescriptor(FOLDERICON))));
		viewer.addSelectionChangedListener(this);
	}

	protected ImageDescriptor createImageDescriptor(Path path) {
		Bundle bundle = FrameworkUtil.getBundle(ExampleLabelProvider.class);
		URL url = FileLocator.find(bundle, path, null);
		return ImageDescriptor.createFromURL(url);
	}

	protected void updateSelection(ExampleData data) {
		if (!data.hasChildren() && data != selection) {
			selection = data;
			description.setText(selection.getDescription());
			setImageViewerInput(data);
			setPageComplete(true);
			setErrorMessage(null);
		} else if (selection == null && data.hasChildren()) {
			setErrorMessage(WIZARD_ERROR_NOTHING_SELECTED);
		}
		viewer.refresh();
	}

	protected void setImageViewerInput(ExampleData exampleData) {
		imageViewer.setViewerInput(exampleData.getFullImagePathes());
		getShell().layout(true, true);
	}

	protected void createDetailsPane(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginTop = 0;
		layout.numColumns = 1;
		container.setLayout(layout);
		imageViewer = new ImageViewer(container);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(imageViewer);
		Label descriptionLabel = new Label(container, SWT.NONE);
		descriptionLabel.setText("Description");
		FontDescriptor boldDescriptor = FontDescriptor.createFrom(descriptionLabel.getFont()).setStyle(SWT.BOLD);
		Font boldFont = boldDescriptor.createFont(descriptionLabel.getDisplay());
		descriptionLabel.setFont(boldFont);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(descriptionLabel);
		description = new Label(container, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(description);
	}

	public ExampleData getSelection() {
		return selection;
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		Object firstElement = ((StructuredSelection) event.getSelection()).getFirstElement();
		updateSelection((ExampleData) firstElement);
	}
}