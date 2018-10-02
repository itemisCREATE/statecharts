/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.service;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.yakindu.sct.examples.wizard.service.data.ExampleData;

/**
 * 
 * @author t00manysecretss
 * 
 */
public class ExampleImporter {

	@SuppressWarnings("deprecation")
	public IProject importExample(ExampleData edata, IProgressMonitor monitor) {
		try {
			IProjectDescription original = ResourcesPlugin.getWorkspace()
					.loadProjectDescription(new Path(edata.getProjectDir().getAbsolutePath()).append("/.project"));
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(edata.getProjectDir().getName());

			IProjectDescription clone = ResourcesPlugin.getWorkspace().newProjectDescription(original.getName());
			clone.setBuildSpec(original.getBuildSpec());
			clone.setComment(original.getComment());
			clone.setDynamicReferences(original.getDynamicReferences());
			clone.setNatureIds(original.getNatureIds());
			clone.setReferencedProjects(original.getReferencedProjects());
			if (project.exists()) {
				return project;
			}
			project.create(clone, monitor);
			project.open(monitor);

			@SuppressWarnings("unchecked")
			List<IFile> filesToImport = FileSystemStructureProvider.INSTANCE.getChildren(edata.getProjectDir());
			ImportOperation io = new ImportOperation(project.getFullPath(), edata.getProjectDir(),
					FileSystemStructureProvider.INSTANCE, new IOverwriteQuery() {

						@Override
						public String queryOverwrite(String pathString) {
							return IOverwriteQuery.ALL;
						}

					}, filesToImport);
			io.setOverwriteResources(true);
			io.setCreateContainerStructure(false);
			io.run(monitor);
			project.refreshLocal(IProject.DEPTH_INFINITE, monitor);
			return project;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
