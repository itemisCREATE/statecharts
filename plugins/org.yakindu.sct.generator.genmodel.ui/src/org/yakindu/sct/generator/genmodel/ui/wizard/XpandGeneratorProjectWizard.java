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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.xtend.shared.ui.wizards.EclipseHelper;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class XpandGeneratorProjectWizard extends Wizard implements
		IWorkbenchWizard {

	private XpandGeneratorWizardPage1 projectPage;
	private final ProjectTemplate template = new ProjectTemplate();

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("New YAKINDU Xpand Generator Project");
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		projectPage = new XpandGeneratorWizardPage1("project"); //$NON-NLS-1$
		projectPage.setTitle("New YAKINDU Xpand Generator Project");
		projectPage.setDescription("Configure the Generator Project");
		addPage(projectPage);
	}

	@Override
	public boolean performFinish() {

		final ProjectData projectData = projectPage.getProjectData();

		final IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(final IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doCreateProject(projectData, monitor);
				} catch (CoreException e) {
					e.printStackTrace();
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
			MessageDialog.openError(getShell(), "Failed to create project",
					realException.getMessage());
			return false;
		}
		return true;
	}

	protected void doCreateProject(ProjectData projectData,
			IProgressMonitor monitor) throws CoreException {
		int ticks = projectData.pluginExport ? 10 : 7;
		monitor.beginTask("Create YAKINDU Xpand Generator Project", ticks);

		final IProject project = initProject(projectData.projectName,
				projectData.pluginExport, monitor);

		if (project == null) {
			return;
		}

		projectData.project = project;

		template.doGenerate(projectData, monitor);

		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}

	protected IProject initProject(String projectName, boolean pluginExport,
			IProgressMonitor monitor) {
		List<IProject> referencedProjects = Collections.emptyList();
		List<String> exportedPackages = Collections.emptyList();
		final List<String> srcFolders = new ArrayList<String>();
		srcFolders.add("src"); //$NON-NLS-1$
		srcFolders.add("src-gen"); //$NON-NLS-1$
		final Set<String> requiredBundles = new HashSet<String>();
		requiredBundles.add("org.eclipse.jdt.core;bundle-version=\"3.5.0\"");//$NON-NLS-1$
		requiredBundles.add("org.apache.commons.logging");//$NON-NLS-1$
		requiredBundles.add("org.apache.log4j;resolution:=optional");//$NON-NLS-1$
		requiredBundles.add("org.eclipse.xtend.profiler;resolution:=optional");//$NON-NLS-1$
		requiredBundles
				.add("org.yakindu.sct.model.sexec;bundle-version=\"1.0.0\"");//$NON-NLS-1$
		requiredBundles
				.add("org.yakindu.sct.model.sgen;bundle-version=\"1.0.0\"");//$NON-NLS-1$
		requiredBundles
				.add("org.yakindu.sct.model.sgraph;bundle-version=\"1.0.0\"");//$NON-NLS-1$
		requiredBundles
				.add("org.yakindu.sct.model.stext;bundle-version=\"1.0.0\"");//$NON-NLS-1$
		if (pluginExport) {
			requiredBundles
					.add("org.yakindu.sct.generator.core;bundle-version=\"1.0.0\"");//$NON-NLS-1$
		}

		IProject project = EclipseHelper.createExtXptProject(projectName,
				srcFolders, referencedProjects, requiredBundles,
				exportedPackages, new SubProgressMonitor(monitor, 3),
				getShell());
		return project;
	}

	public static String getResourceContents(final String resource,
			String encoding) {
		try {
			final InputStream inputStream = XpandGeneratorProjectWizard.class
					.getResourceAsStream(resource);
			final byte[] buffer = new byte[4096];
			final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			while (true) {
				int read;
				read = inputStream.read(buffer);
				if (read == -1) {
					break;
				}
				outputStream.write(buffer, 0, read);
			}
			outputStream.close();
			inputStream.close();
			return outputStream.toString(encoding);
		} catch (final IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
