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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenNewFileWizard extends Wizard implements INewWizard {

	public static final String ID = "org.yakindu.sct.generator.genmodel.ui.SGenNewFileWizard";

	protected SGenWizardPage1 modelFilePage;

	private IStructuredSelection selection;

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("New Yakindu SGen Model");
		setNeedsProgressMonitor(true);

	}

	@Override
	public void addPages() {
		modelFilePage = new SGenWizardPage1("DiagramModelFile", selection,
				"sgen");
		modelFilePage.setTitle("YAKINDU SCT Diagram");
		modelFilePage.setDescription("Create a new YAKINDU SCT Diagram File");
		addPage(modelFilePage);
	}

	@Override
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {
			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InterruptedException {
				generateFile();
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	protected void generateFile() throws CoreException {
		
		IPath containerFullPath = modelFilePage.getContainerFullPath();
		String outlet = containerFullPath.toFile().getAbsolutePath();
		System.out.println(outlet);
		
		OutputImpl output = new OutputImpl();
		output.addOutlet(new Outlet(false, System.getProperty("file.encoding"),
				null, true, outlet));

		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(
				output, null);
		execCtx.getResourceManager().setFileEncoding("Cp1252");
		execCtx.registerMetaModel(new JavaBeansMetaModel());

		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate(
				"org::yakindu::sct::generator::genmodel::ui::wizard::SGenNewProject::main",
				getProjectInfo());
		// TODO: Update only current project
		ResourcesPlugin
				.getWorkspace()
				.getRoot()
				.refreshLocal(IResource.DEPTH_INFINITE,
						new NullProgressMonitor());
	}

	private Object getProjectInfo() {
		return null;
	}

	public IStructuredSelection getSelection() {
		return selection;
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

}
