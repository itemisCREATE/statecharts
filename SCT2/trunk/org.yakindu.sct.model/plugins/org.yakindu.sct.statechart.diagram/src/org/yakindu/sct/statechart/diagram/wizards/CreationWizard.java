/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.wizards;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.yakindu.sct.model.statechart.statechart.Statechart;
import org.yakindu.sct.model.statechart.statechart.StatechartFactory;
import org.yakindu.sct.statechart.diagram.DiagramActivator;
import org.yakindu.sct.statechart.diagram.editor.StatechartDiagramEditor;

public class CreationWizard extends Wizard implements INewWizard {

	protected IStructuredSelection selection;

	protected CreationWizardPage diagramModelFilePage;

	protected CreationWizardPage domainModelFilePage;

	protected Resource diagram;

	private final boolean openOnCreate = false;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("New YAKINDU Statechart");
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		diagramModelFilePage = new CreationWizardPage("DiagramModelFile", getSelection(), "sct");
		diagramModelFilePage.setTitle("YAKINDU SCT Diagram");
		diagramModelFilePage.setDescription("Create a new YAKINDU SCT Diagram File");
		addPage(diagramModelFilePage);

		domainModelFilePage = new CreationWizardPage("DomainModelFile", getSelection(), "sct_model") {

			@Override
			public void setVisible(boolean visible) {
				if (visible) {
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length() - ".sct".length());
					setFileName(CreationWizardPage.getUniqueFileName(getContainerFullPath(), fileName, "sct_model"));
				}
				super.setVisible(visible);
			}
		};
		domainModelFilePage.setTitle("YAKINDU Model File");
		domainModelFilePage.setDescription("Creates a new YAKINDU Model File");
		addPage(domainModelFilePage);
	}

	@Override
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				diagram = createDiagram(diagramModelFilePage.getURI(), domainModelFilePage.getURI(), monitor);
				if (isOpenOnCreate() && diagram != null) {
					try {
						openDiagram(diagram);
					} catch (PartInitException e) {
						e.printStackTrace();
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return false;
		}
		return diagram != null;
	}

	public IStructuredSelection getSelection() {
		return selection;
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	public boolean isOpenOnCreate() {
		return openOnCreate;
	}

	public static boolean openDiagram(Resource diagram) throws PartInitException {
		String path = diagram.getURI().toPlatformString(true);
		IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
		if (workspaceResource instanceof IFile) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			return null != page.openEditor(new FileEditorInput((IFile) workspaceResource), StatechartDiagramEditor.ID);
		}
		return false;
	}

	public static Resource createDiagram(URI diagramURI, URI modelURI, IProgressMonitor progressMonitor) {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		progressMonitor.beginTask("Creating diagram file ...", 3);
		final Resource diagramResource = editingDomain.getResourceSet().createResource(diagramURI);
		final Resource modelResource = editingDomain.getResourceSet().createResource(modelURI);
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain,
				"Creating diagram file ...", Collections.EMPTY_LIST) {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				Statechart statechart = StatechartFactory.eINSTANCE.createStatechart();
				modelResource.getContents().add(statechart);

				Diagram diagram = ViewService.createDiagram(statechart, StatechartDiagramEditor.ID,
						DiagramActivator.DIAGRAM_PREFERENCES_HINT);
				if (diagram != null) {
					diagramResource.getContents().add(diagram);
					diagram.setName("YAKINDU Statechart Model");
					diagram.setElement(statechart);
				}

				try {
					modelResource.save(getSaveOptions());
					diagramResource.save(getSaveOptions());
				} catch (IOException e) {
					e.printStackTrace();
				}
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new SubProgressMonitor(progressMonitor, 1),
					null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		setCharset(WorkspaceSynchronizer.getFile(modelResource));
		setCharset(WorkspaceSynchronizer.getFile(diagramResource));
		return diagramResource;
	}

	public static Map<String, String> getSaveOptions() {
		Map<String, String> saveOptions = new HashMap<String, String>();
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		return saveOptions;
	}

	public static void setCharset(IFile file) {
		if (file == null) {
			return;
		}
		try {
			file.setCharset("UTF-8", new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}
