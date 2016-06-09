package org.yakindu.sct.examples.ui.wizards.pages;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.yakindu.sct.examples.ui.wizards.ExampleWizardConstants;

public class AskPermissionPage extends WizardPage implements ExampleWizardConstants {

	
	public AskPermissionPage(ISelection selection) {
		super(ASK_PAGE_TITLE);
		setPageComplete(true);
		setTitle(ASK_PAGE_TITLE);
		setDescription(ASK_PAGE_DESCRIPTION);
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent,SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		Label label = new Label(container,SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(label);
		label.setText(ASK_PAGE_LABEL_TEXT);
		label.setAlignment(SWT.CENTER);
		setControl(container);
	}

}
