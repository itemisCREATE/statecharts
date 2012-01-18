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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class XpandGeneratorProjectWizard extends Wizard implements
		IWorkbenchWizard {

	private IProjectWizardPage projectPage;

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("New YAKINDU Xpand Generator Project");
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		projectPage = getProjectPage();
		addPage(projectPage);
	}

	protected IProjectWizardPage getProjectPage() {
		XpandGeneratorWizardPage1 projectPage = new XpandGeneratorWizardPage1(
				"project"); //$NON-NLS-1$
		projectPage.setTitle("New YAKINDU Xpand Generator Project");
		projectPage.setDescription("Configure the Generator Project");
		return projectPage;
	}

	@Override
	public boolean performFinish() {

		final ProjectData projectData = projectPage.getProjectData();

		final IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(final IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					GeneratorProjectTemplate template = new GeneratorProjectTemplate();
					template.setMonitor(monitor);
					template.generate(projectData);
				} catch (Exception e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (final InterruptedException e) {
			return false;
		} catch (final InvocationTargetException e) {
			final Throwable realException = e.getTargetException();
			realException.printStackTrace();
			MessageDialog.openError(getShell(), "Failed to create project",
					realException.getMessage());
			return false;
		}
		return true;
	}

}
