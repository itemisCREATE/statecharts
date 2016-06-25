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
package org.yakindu.sct.examples.ui.wizards.services;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.yakindu.sct.examples.ui.ExampleActivator;
import org.yakindu.sct.examples.ui.wizards.ExampleData;
import org.yakindu.sct.examples.ui.wizards.ExampleWizardModule;
import org.yakindu.sct.examples.ui.wizards.IExampleService;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * 
 * @author t00manysecretss
 * @author andreas muelder - let GitRepositoryExampleService implement
 *         {@link IExampleService} interface
 * 
 */
@Singleton
public class GitRepositoryExampleService implements IExampleService {

	private String userHome = System.getProperty("user.home");
	private static final String METADATA_JSON = "metadata.json";

	@Inject
	@Named(ExampleWizardModule.REPOSITORY_URL)
	private String repositoryURL;
	@Inject
	private IExampleDataReader reader;
	private java.nio.file.Path gitRepo;

	public GitRepositoryExampleService() {
		gitRepo = java.nio.file.Paths.get(userHome, "sct_examples");
	}

	@Override
	public boolean exists() {
		return Files.exists(gitRepo);
	}

	@Override
	public IStatus fetchAllExamples(IProgressMonitor monitor) {
		if (!exists()) {
			try {
				Files.createDirectories(gitRepo);
			} catch (IOException e1) {
				return new Status(IStatus.ERROR, ExampleActivator.PLUGIN_ID,
						"Unable to create folder " + gitRepo.getFileName());
			}
			return cloneRepository(monitor);
		} else {
			return updateRepository(monitor);
		}
	}

	protected IStatus updateRepository(IProgressMonitor monitor) {
		try {
			PullResult result = Git.open(gitRepo.toFile()).pull().call();
			if (!result.isSuccessful()) {
				return new Status(IStatus.ERROR, ExampleActivator.PLUGIN_ID,
						"Unable to update repository " + repositoryURL + "!");
			}
		} catch (GitAPIException | IOException e) {
			return new Status(IStatus.ERROR, ExampleActivator.PLUGIN_ID,
					"Unable to update repository " + repositoryURL + "!");
		}
		return Status.OK_STATUS;
	}

	protected IStatus cloneRepository(IProgressMonitor monitor) {
		try {
			Git.cloneRepository().setURI(repositoryURL).setDirectory(gitRepo.toFile())
					.setProgressMonitor(new GitProgressMonitor(monitor)).call();
		} catch (GitAPIException e) {
			return new Status(IStatus.ERROR, ExampleActivator.PLUGIN_ID,
					"Unable to clone repository " + repositoryURL + "!");
		}
		return Status.OK_STATUS;
	}

	@Override
	public List<ExampleData> getExamples(IProgressMonitor monitor) {
		List<java.nio.file.Path> projects = new ArrayList<>();
		findMetaData(projects, gitRepo);
		List<ExampleData> result = reader.parse(projects);
		return result;
	}

	protected void findMetaData(List<java.nio.file.Path> result, java.nio.file.Path root) {
		try (DirectoryStream<java.nio.file.Path> stream = Files.newDirectoryStream(root)) {
			for (java.nio.file.Path entry : stream) {
				if (Files.isDirectory(entry)) {
					findMetaData(result, entry);
				} else if (entry.getFileName().toString().equals(METADATA_JSON)) {
					result.add(entry);
				}
			}
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void importExample(ExampleData edata, IProgressMonitor monitor) {
		try {
			IProjectDescription pDescription = ResourcesPlugin.getWorkspace()
					.loadProjectDescription(new Path(edata.getProjectDir().getAbsolutePath()).append("/.project"));
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(edata.getProjectDir().getName());
			project.create(pDescription, monitor);
			List<File> filesToImport = findProjectFiles(edata.getProjectDir());
			ImportOperation io = new ImportOperation(project.getFullPath(), edata.getProjectDir(),
					FileSystemStructureProvider.INSTANCE, new IOverwriteQuery() {

						@Override
						public String queryOverwrite(String pathString) {
							return IOverwriteQuery.ALL;
						}

					}, filesToImport);
			io.run(monitor);
			project.open(monitor);
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected List<File> findProjectFiles(File file) {
		List<File> result = new ArrayList<File>();
		for (File f : file.listFiles()) {
			if (f.isDirectory()) {
				result.addAll(findProjectFiles(f));
			}
			result.add(f);
		}
		return result;
	}

	@Override
	public boolean isUpToDate() {
		// TODO
		return true;
	}

}