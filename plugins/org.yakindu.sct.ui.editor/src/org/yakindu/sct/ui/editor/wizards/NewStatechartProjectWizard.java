/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.ide.undo.CreateProjectOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.ui.editor.StatechartImages;
import org.yakindu.sct.ui.editor.wizards.CreationWizard.DiagramCreationDesccription;

/**
 * 
 * @author Thomas Kutz - Initial contribution and API
 *
 */
public class NewStatechartProjectWizard extends Wizard implements INewWizard {

	private static final String STATECHART_NAME = "model.sct";

	private WizardNewProjectCreationPage mainPage;

	private Resource diagram;

	private IProject newProject;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("New YAKINDU Statechart Project");
	}

	@Override
	public void addPages() {
		initProjectCreationPage();
	}

	protected void initProjectCreationPage() {
		mainPage = new WizardNewProjectCreationPage("basicNewProjectPage");
		mainPage.setTitle("Project");
		mainPage.setDescription("Create a new project resource.");
		mainPage.setImageDescriptor(StatechartImages.LOGO.imageDescriptor());
		addPage(mainPage);
	}

	@Override
	public boolean performFinish() {
		if (createNewProject()) {
			return createNewStatechart();
		}
		return false;
	}

	private boolean createNewProject() {
		// get a project handle
		final IProject newProjectHandle = mainPage.getProjectHandle();

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(newProjectHandle.getName());
		description.setLocationURI(mainPage.getLocationURI());

		// create the new project operation
		IRunnableWithProgress op = monitor -> {
			CreateProjectOperation op1 = new CreateProjectOperation(description, "New Project");
			try {
				op1.execute(monitor, WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
			} catch (ExecutionException e) {
				throw new InvocationTargetException(e);
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		newProject = newProjectHandle;
		return true;

	}

	protected boolean createNewStatechart() {
		final DiagramCreationDesccription create = getDiagramDescription();

		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				diagram = new DiagramCreator().createDiagram(create, monitor);
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return diagram != null;
	}

	protected DiagramCreationDesccription getDiagramDescription() {
		URI uri = getModelURI();
		String domainID = BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral();
		return new DiagramCreationDesccription(uri, domainID);
	}

	public URI getModelURI() {
		return URI.createPlatformResourceURI(URI.encodeFragment(getModelFilePath().toString(), true), false);
	}

	private IPath getModelFilePath() {
		if (newProject != null) {
			return newProject.getFile(STATECHART_NAME).getFullPath();
		}
		return null;
	}

}
