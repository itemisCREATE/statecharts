package org.yakindu.sct.generator.genmodel.ui.wizard;

import org.eclipse.jface.wizard.WizardPage;

public abstract class IProjectWzardPage extends WizardPage {

	protected IProjectWzardPage(String pageName) {
		super(pageName);
	}

	protected abstract ProjectData getProjectData();
}
