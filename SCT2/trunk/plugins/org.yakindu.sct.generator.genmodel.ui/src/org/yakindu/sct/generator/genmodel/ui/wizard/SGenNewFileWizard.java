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

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.yakindu.sct.generator.genmodel.ui.internal.SGenActivator;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenNewFileWizard extends Wizard implements INewWizard {

	public static final String ID = "org.yakindu.sct.generator.genmodel.ui.SGenNewFileWizard";

	protected SGenWizardPage1 modelFilePage;

	private IStructuredSelection selection;

	protected SGenWizardPage2 generatorConfigPage;

	@Inject
	private IResourceDescriptions resourceDescriptions;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("New Yakindu SGen Model");
		setNeedsProgressMonitor(true);

	}

	@Override
	public void addPages() {
		modelFilePage = new SGenWizardPage1("fileName", selection, "sgen");
		modelFilePage.setTitle("YAKINDU SCT Diagram");
		modelFilePage.setDescription("Create a new YAKINDU SCT Diagram File");
		addPage(modelFilePage);
		generatorConfigPage = new SGenWizardPage2("Statecharts",
				resourceDescriptions, modelFilePage);
		generatorConfigPage.setTitle("Generator Configuration");
		generatorConfigPage
				.setDescription("Select the Statecharts and the Generator type");
		addPage(generatorConfigPage);
	}

	@Override
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {
			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InterruptedException {
				// TODO: Does not work for linked projects
				IPath containerFullPath = modelFilePage.getContainerFullPath();
				IPath location = ResourcesPlugin.getWorkspace().getRoot()
						.getLocation();
				location = location.append(containerFullPath);
				String osString = location.toOSString();
				System.out.println(osString);
				String generatorId = generatorConfigPage.getGeneratorId();
				createDefaultModel(osString, generatorId);
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private void createDefaultModel(String target, String generatorId) {
		ArrayList<Statechart> statecharts = Lists.newArrayList();
		ModelCreator creator = new ModelCreator(generatorId, statecharts);
		GeneratorModel model = creator.create();
		Injector injector = SGenActivator.getInstance().getInjector(
				"org.yakindu.sct.generator.genmodel.SGen");
		ISerializer serializer = injector.getInstance(ISerializer.class);
		try {
			serializer.serialize(model, new FileWriter(target), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public IStructuredSelection getSelection() {
		return selection;
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

}
