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
package org.yakindu.sct.examples.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.yakindu.sct.examples.wizard.pages.SelectExamplePage;
import org.yakindu.sct.examples.wizard.service.ExampleImporter;
import org.yakindu.sct.examples.wizard.service.ExampleModelOpener;
import org.yakindu.sct.examples.wizard.service.ExampleWizardConstants;
import org.yakindu.sct.examples.wizard.service.ExampleWizardModule;
import org.yakindu.sct.examples.wizard.service.data.ExampleData;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * 
 * @author t00manysecretss
 * 
 */

public class ExampleWizard extends Wizard implements INewWizard, ExampleWizardConstants {

	@Inject
	private SelectExamplePage page;
	@Inject
	private ExampleModelOpener opener;
	@Inject
	private ExampleImporter importer;

	public ExampleWizard() {
		super();
		setWindowTitle(WINDOW_TITLE);
		setNeedsProgressMonitor(true);
		Guice.createInjector(new ExampleWizardModule()).injectMembers(this);
	}

	public ExampleWizard(String exampleId) {
		this();
		page.setInstallExampleId(exampleId);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// Nothing do do
	}

	public void addPages() {
		addPage(page);
	}

	public boolean performFinish() {
		final List<ExampleData> selection = page.getSelection();
		if (selection != null) {
			try {
				getContainer().run(true, true, new IRunnableWithProgress() {
					@Override
					public void run(IProgressMonitor monitor) throws InvocationTargetException {
						for (ExampleData exampleData : selection) {
							if (overrideIfExists(exampleData)) {
								IProject project = importer.importExample(exampleData, monitor);
								opener.openModelFiles(project);
							}
						}
					}
				});
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	protected boolean overrideIfExists(ExampleData selection) {
		String name = selection.getProjectDir().getName();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
		if (project.exists()) {
			OverrideRunnable runnable = new OverrideRunnable(getShell(), name);
			Display.getDefault().syncExec(runnable);
			if (runnable.isOverride()) {
				try {
					project.delete(true, new NullProgressMonitor());
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
			return runnable.isOverride();
		}
		return true;
	}

	private static class OverrideRunnable implements Runnable {

		private boolean override = false;
		private Shell shell;
		private String name;

		public OverrideRunnable(Shell shell, String name) {
			this.shell = shell;
			this.name = name;
		}

		@Override
		public void run() {
			override = MessageDialog.openQuestion(shell, "Project Exists",
					String.format("Project %s already exists in your workspace. Do you want to override it?", name));
		}

		public boolean isOverride() {
			return override;
		}

	}
}