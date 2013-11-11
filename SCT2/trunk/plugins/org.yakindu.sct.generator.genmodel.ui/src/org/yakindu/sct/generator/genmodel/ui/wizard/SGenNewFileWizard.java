/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.wizard;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.yakindu.sct.builder.nature.SCTNature;
import org.yakindu.sct.builder.nature.ToggleSCTNatureAction;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.model.sgen.GeneratorModel;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenNewFileWizard extends Wizard implements INewWizard {

	private static final String SGEN_EDITOR_ID = "org.yakindu.sct.generator.genmodel.SGen";

	public static final String ID = "org.yakindu.sct.generator.genmodel.ui.SGenNewFileWizard";

	protected SGenWizardPage1 modelFilePage;

	private IStructuredSelection selection;

	protected SGenWizardPage2 generatorConfigPage;

	@Inject
	private ResourceSet resourceSet;
	@Inject
	private Injector injector;

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("New Yakindu SGen Model");
		setNeedsProgressMonitor(true);

	}

	@Override
	public void addPages() {
		modelFilePage = new SGenWizardPage1("fileName", selection, "sgen");
		modelFilePage.setTitle("YAKINDU Generator Model");
		modelFilePage.setDescription("Create a new YAKINDU Generator Model");
		addPage(modelFilePage);
		generatorConfigPage = new SGenWizardPage2("content", modelFilePage, selection);
		injector.injectMembers(generatorConfigPage);
		generatorConfigPage.setTitle("YAKINDU Generator model configuration");
		generatorConfigPage.setDescription("Select the generator type and the content");
		addPage(generatorConfigPage);
	}

	@Override
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				ensureSCTNature(getProject(modelFilePage.getContainerFullPath()));
				Resource resource = createDefaultModel(modelFilePage.getURI());
				openModel(resource);
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	protected boolean openModel(Resource model) throws PartInitException {
		String path = model.getURI().toPlatformString(true);
		IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
		if (workspaceResource instanceof IFile) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			return null != page.openEditor(new FileEditorInput((IFile) workspaceResource), SGEN_EDITOR_ID);
		}
		return false;
	}

	protected void ensureSCTNature(IProject project) throws CoreException {
		if (project.getNature(SCTNature.NATURE_ID) == null) {
			new ToggleSCTNatureAction().toggleNature(project);
		}
	}

	protected IProject getProject(IPath containerFullPath) {
		if (containerFullPath.segmentCount() == 1) {
			return ResourcesPlugin.getWorkspace().getRoot().getProject(containerFullPath.lastSegment());
		}
		return ResourcesPlugin.getWorkspace().getRoot().getFolder(containerFullPath).getProject();
	}

	private Resource createDefaultModel(URI uri) {
		List<EObject> selectedObjects = generatorConfigPage.getSelectedElements();
		GeneratorDescriptor selectedGenerator = generatorConfigPage.getSelectedGenerator();
		ModelCreator creator = new ModelCreator(selectedGenerator, selectedObjects);
		GeneratorModel model = creator.create();

		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(model);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resource;
	}

	public IStructuredSelection getSelection() {
		return selection;
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

}
