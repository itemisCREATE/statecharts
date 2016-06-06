package org.yakindu.sct.examples.ui.wizards;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.yakindu.sct.examples.ui.service.IExampleService;
import org.yakindu.sct.examples.ui.service.MockExampleService;

public class ExamplesWizardPage extends WizardPage {

	// TODO guice
	private IExampleService exampleService = new MockExampleService();

	public ExamplesWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("Select an example");
		setDescription("This wizard creates statechart examples.");
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		container.setLayout(layout);
		createExamplesViewer(container);
		createDetailsPane(container);
		setControl(container);
	}

	protected void createDetailsPane(Composite container) {
		Composite details = new Composite(container, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		details.setLayout(layout);

		// TODO: Show Image
		Label title = new Label(container, SWT.NONE);
		title.setText("Example Title here...");

		GridDataFactory.fillDefaults().applyTo(title);

		Label description = new Label(container, SWT.NONE);
		description.setText("Description here...");
		GridDataFactory.fillDefaults().applyTo(description);

	}

	protected void createExamplesViewer(Composite container) {
		TableViewer viewer = new TableViewer(container);
		GridDataFactory.fillDefaults().applyTo(viewer.getControl());
		viewer.setContentProvider(new ExampleContentProvider());
		viewer.setLabelProvider(new ExampleLabelProvider());
		viewer.setInput(exampleService.getAllExamples());

	}
}