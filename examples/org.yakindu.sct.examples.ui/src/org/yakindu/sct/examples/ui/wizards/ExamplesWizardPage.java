package org.yakindu.sct.examples.ui.wizards;

import java.io.File;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.yakindu.sct.examples.ui.service.IExampleService;
import org.yakindu.sct.examples.ui.service.MockExampleService;

public class ExamplesWizardPage extends WizardPage {

	public static final String WIZARD_TITLE = "Select an example";
	public static final String WIZARD_DESCRIPTION = "This wizard creates statechart examples.";

	// TODO guice
	private IExampleService exampleService = new MockExampleService();

	public ExamplesWizardPage(ISelection selection) {
		super(WIZARD_TITLE);
		setTitle(WIZARD_TITLE);
		setDescription(WIZARD_DESCRIPTION);
		setPageComplete(false);
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(container);
		GridLayout layout = new GridLayout(2, true);
		container.setLayout(layout);
		createTreeViewer(container);
		createDetailsPane(container);
		setControl(container);
	}

	protected void createTreeViewer(Composite container) {
		TreeViewer viewer = new TreeViewer(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridDataFactory.fillDefaults().applyTo(viewer.getControl());
		viewer.setContentProvider(new ExampleContentProvider());
		viewer.setLabelProvider(new ExampleLabelProvider());
		viewer.setInput(exampleService.getAllExamples());

	}

	protected void createDetailsPane(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);

		// TODO: Show Image
		Label title = new Label(container, SWT.NONE);
		title.setText("<title>");

		GridDataFactory.fillDefaults().applyTo(title);

		Label description = new Label(container, SWT.NONE);
		description.setText("<description>");
		GridDataFactory.fillDefaults().applyTo(description);

	}

}