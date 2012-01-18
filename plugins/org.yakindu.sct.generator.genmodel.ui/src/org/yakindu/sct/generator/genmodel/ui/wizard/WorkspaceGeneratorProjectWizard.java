/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class WorkspaceGeneratorProjectWizard extends
		XpandGeneratorProjectWizard {

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("New YAKINDU Workspace Generator Project");
		setNeedsProgressMonitor(true);
	}

	@Override
	public IProjectWizardPage getProjectPage() {
		WorkspaceGeneratorWizardPage1 projectPage = new WorkspaceGeneratorWizardPage1(
				"project"); //$NON-NLS-1$
		projectPage.setTitle("New YAKINDU Workspace Generator Project");
		projectPage.setDescription("Configure the Generator Project");
		return projectPage;
	}

}
