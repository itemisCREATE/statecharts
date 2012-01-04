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
package org.yakindu.sct.ui.editor.wizards;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.yakindu.sct.ui.editor.StatechartImages;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.factories.FactoryUtils;
import org.yakindu.sct.ui.perspectives.PerspectiveUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CreationWizard extends Wizard implements INewWizard {

	public static final String ID = "org.yakindu.sct.ui.editor.StatechartDiagramWizard";

	protected IStructuredSelection selection = new StructuredSelection();

	protected CreationWizardPage modelFilePage;

	protected Resource diagram;

	private boolean openOnCreate = true;

	private IWorkbench workbench;

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("New YAKINDU Statechart");
		setNeedsProgressMonitor(true);

	}

	@Override
	public void addPages() {
		modelFilePage = new CreationWizardPage("DiagramModelFile",
				getSelection(), "sct");
		modelFilePage.setTitle("YAKINDU SCT Diagram");
		modelFilePage.setDescription("Create a new YAKINDU SCT Diagram File");
		modelFilePage.setImageDescriptor(StatechartImages.LOGO
				.imageDescriptor());
		addPage(modelFilePage);
	}

	@Override
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {
			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InterruptedException {
				diagram = createDiagram(modelFilePage.getURI(),
						modelFilePage.getURI(), monitor);
				if (isOpenOnCreate() && diagram != null) {
					try {
						openDiagram(diagram);
						PerspectiveUtil.switchToModelingPerspective(workbench
								.getActiveWorkbenchWindow());
					} catch (PartInitException e) {
						e.printStackTrace();
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (Exception e) {
			return false;
		}
		return diagram != null;
	}

	public static boolean openDiagram(Resource diagram)
			throws PartInitException {
		String path = diagram.getURI().toPlatformString(true);
		IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(new Path(path));
		if (workspaceResource instanceof IFile) {
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			return null != page.openEditor(new FileEditorInput(
					(IFile) workspaceResource), StatechartDiagramEditor.ID);
		}
		return false;
	}

	public static Resource createDiagram(URI diagramURI, URI modelURI,
			IProgressMonitor progressMonitor) {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		progressMonitor.beginTask("Creating diagram file ...", 3);
		final Resource resource = editingDomain.getResourceSet()
				.createResource(modelURI);
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				editingDomain, "Creating diagram file ...",
				Collections.EMPTY_LIST) {
			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				FactoryUtils.createStatechartModel(resource);

				try {
					resource.save(getSaveOptions());
				} catch (IOException e) {
					e.printStackTrace();
				}
				return CommandResult.newOKCommandResult();
			}

		};
		try {
			command.execute(progressMonitor,null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		setCharset(WorkspaceSynchronizer.getFile(resource));
		editingDomain.dispose();
		return resource;
	}

	public static Map<String, String> getSaveOptions() {
		Map<String, String> saveOptions = new HashMap<String, String>();
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
				Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
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

	public IStructuredSelection getSelection() {
		return selection;
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	public boolean isOpenOnCreate() {
		return openOnCreate;
	}

	public void setOpenOnCreate(boolean openOnCreate) {
		this.openOnCreate = openOnCreate;
	}

}
