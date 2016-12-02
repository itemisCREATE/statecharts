/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.yakindu.sct.generator.c.gtest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.yakindu.sct.generator.builder.EclipseContextGeneratorExecutorLookup;
import org.yakindu.sct.generator.core.execution.IGeneratorEntryExecutor;
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.test.models.SCTUnitTestModels;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.inject.util.Modules;

/**
 * @author Andreas Unger - Initial contribution and API
 * @author Markus Mühlbrandt
 * 
 */
public class GTestHelper {

	private final Object owner;

	public GTestHelper(Object owner) {
		this.owner = owner;
	}

	public void compile() {
		copyFilesFromBundleToFolder();
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(getTargetPath());
		File directory = resource.getLocation().toFile();
		List<String> command = createCommand();

		getCommandExecutor().execute(command, directory);
	}

	public void generate() {

		IPath targetPath = getTargetPath();

		// copy model to JUnit workspace
		copyFileFromBundleToFolder(getModelBundle(), getModelPath(), targetPath);

		String sgenFileName = getTestProgram() + ".sgen";
		copyFileFromBundleToFolder(getTestBundle(), sgenFileName, targetPath);

		IPath path = new Path(sgenFileName);
		Resource sgenResource = loadResource(getWorkspaceFileFor(path));
		GeneratorModel model = (GeneratorModel) sgenResource.getContents().get(0);
		model.getEntries().get(0).setElementRef(getStatechart());

		performFullBuild();

		new EclipseContextGeneratorExecutorLookup() {
			@Override
			protected Module getContextModule(GeneratorEntry entry, IGeneratorDescriptor description) {
				return Modules.override(super.getContextModule(entry, description)).with(new Module() {
					@Override
					public void configure(Binder binder) {
						binder.bind(boolean.class).annotatedWith(Names.named(IGeneratorEntryExecutor.SKIP_VALIDATION))
								.toInstance(true);
					}
				});
			}

		}.execute(model);
	}

	protected GCCCommandExecutor getCommandExecutor() {
		return new GCCCommandExecutor();
	}

	protected void performFullBuild() {
		try {
			ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD, null);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	protected IFile getWorkspaceFileFor(IPath filePath) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getTargetProjectPath().append(filePath));
	}

	protected Statechart getStatechart() {
		IPath path = new Path(getTargetPath().toString() + "/" + getModelPath().lastSegment());
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		Resource resource = loadResource(file);
		return (Statechart) resource.getContents().get(0);
	}

	protected Resource loadResource(IFile file) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Resource resource = new ResourceSetImpl().getResource(uri, true);
		return resource;
	}

	protected Bundle getModelBundle() {
		Bundle bundle = getAnnotatedTestBundle();
		if (bundle == null) {
			return FrameworkUtil.getBundle(SCTUnitTestModels.class);
		}
		return bundle;
	}

	private void copyFilesFromBundleToFolder() {
		IPath targetPath = getTargetPath();
		List<String> testDataFiles = new ArrayList<String>();
		getTestDataFiles(testDataFiles);
		for (String file : testDataFiles) {
			copyFileFromBundleToFolder(getTestBundle(), file, targetPath);
		}
	}

	protected List<String> createCommand() {
		String gTestDirectory = getGTestDirectory();

		List<String> includes = new ArrayList<String>();
		getIncludes(includes);

		List<String> sourceFiles = new ArrayList<String>();
		getSourceFiles(sourceFiles);

		List<String> command = new ArrayList<String>();
		command.add(getCompilerCommand());
		command.add("-o");
		command.add(getFileName(getTestProgram()));
		command.add("-O2");
		if (gTestDirectory != null)
			command.add("-I" + gTestDirectory + "/include");
		for (String include : includes) {
			command.add("-I" + include);
		}
		if (gTestDirectory != null)
			command.add("-L" + gTestDirectory);
		for (String sourceFile : sourceFiles) {
			command.add(sourceFile);
		}
		command.add("-lgtest");
		command.add("-lgtest_main");
		command.add("-lstdc++");
		command.add("-pthread");
		// command.add("-pg");
		return command;
	}

	/**
	 * @return
	 */
	protected String getCompilerCommand() {
		return "gcc";
	}

	/**
	 * @return
	 */
	private String getGTestDirectory() {
		String gTestDirectory = System.getenv("GTEST_DIR");
		// if (gTestDirectory == null) {
		// throw new RuntimeException("GTEST_DIR environment variable not set");
		// }
		// System.out.println("GTEST_DIR = " + gTestDirectory);
		return gTestDirectory;
	}

	protected String getFileName(String path) {
		return new Path(path).lastSegment();
	}

	protected IPath getTargetPath() {
		return getTargetProjectPath().append(new Path(getTestProgram()).removeLastSegments(1));
	}

	protected IPath getModelPath() {
		return new Path(getModelAnnotation());
	}

	protected void getIncludes(Collection<String> includes) {
	}

	protected void getSourceFiles(Collection<String> files) {
		files.add(getFileName(getTestSourceFile()));
	}

	protected String getTestSourceFile() {
		return owner.getClass().getAnnotation(GTest.class).sourceFile();
	}

	protected void getTestDataFiles(Collection<String> files) {
		files.add(getTestSourceFile());
	}

	protected String getTestProgram() {
		return owner.getClass().getAnnotation(GTest.class).program();
	}

	protected String getModelAnnotation() {
		return owner.getClass().getAnnotation(GTest.class).model();
	}

	protected String getTestBundleAnnotation() {
		return owner.getClass().getAnnotation(GTest.class).testBundle();
	}

	protected IPath getTargetProjectPath() {
		return new Path(getTestBundleAnnotation());
	}

	protected void copyFileFromBundleToFolder(Bundle bundle, String sourcePath, String targetPath) {
		copyFileFromBundleToFolder(bundle, new Path(sourcePath), new Path(targetPath));
	}

	protected void copyFileFromBundleToFolder(Bundle bundle, String sourcePath, IPath targetPath) {
		copyFileFromBundleToFolder(bundle, new Path(sourcePath), targetPath);
	}

	protected void copyFileFromBundleToFolder(Bundle bundle, IPath sourcePath, IPath targetPath) {
		String fileName = sourcePath.lastSegment();
		copyFileFromBundle(bundle, sourcePath, targetPath.append(fileName));
	}

	protected void copyFileFromBundle(Bundle bundle, String sourcePath, String targetPath) {
		copyFileFromBundle(bundle, sourcePath, new Path(targetPath));
	}

	protected void copyFileFromBundle(Bundle bundle, String sourcePath, IPath targetPath) {
		copyFileFromBundle(bundle, new Path(sourcePath), targetPath);
	}

	protected void copyFileFromBundle(Bundle bundle, IPath sourcePath, IPath targetPath) {
		try {
			InputStream is = FileLocator.openStream(bundle, sourcePath, false);
			createFile(targetPath, is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected Bundle getTestBundle() {
		Bundle bundle = getAnnotatedTestBundle();
		if (bundle == null) {
			return FrameworkUtil.getBundle(owner.getClass());
		}
		return bundle;
	}

	protected Bundle getAnnotatedTestBundle() {
		String testProject = getTestBundleAnnotation();
		if (!testProject.isEmpty()) {
			Bundle testBundle = Platform.getBundle(testProject);
			if (testBundle != null) {
				return testBundle;
			}
		}
		return null;
	}

	protected void copyFileFromBundle(String sourcePath, IFile targetFile) {
		copyFileFromBundle(new Path(sourcePath), targetFile);
	}

	protected void copyFileFromBundle(IPath sourcePath, IFile targetFile) {
		try {
			InputStream is = FileLocator.openStream(getTestBundle(), sourcePath, false);
			createFile(targetFile, is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected void createFile(String path, InputStream source) {
		createFile(new Path(path), source);
	}

	protected void createFile(IPath path, InputStream source) {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		createFile(file, source);
	}

	protected void createFile(IFile file, InputStream source) {
		ensureContainerExists(file.getParent());
		try {
			if (file.exists()) {
				file.setContents(source, true, false, new NullProgressMonitor());
			} else {
				file.create(source, true, new NullProgressMonitor());
			}
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	protected IFolder getFolder(String path) {
		return ensureContainerExists(ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(path)));
	}

	protected IFolder getFolder(IPath path) {
		return ensureContainerExists(ResourcesPlugin.getWorkspace().getRoot().getFolder(path));
	}

	protected <T extends IContainer> T ensureContainerExists(T container) {
		IProgressMonitor monitor = new NullProgressMonitor();
		IProject project = container.getProject();
		if (project.exists()) {
			if (!project.isOpen()) {
				throw new RuntimeException("Project " + project.getName() + " closed");
			}
		} else {
			try {
				createTestProject(project, monitor);
				project.open(monitor);
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
		if (container instanceof IFolder) {
			doEnsureFolderExists((IFolder) container, monitor);
		}
		return container;
	}

	protected void createTestProject(IProject projectHandle, IProgressMonitor monitor) throws CoreException {
		projectHandle.create(monitor);
	}

	private void doEnsureFolderExists(IFolder folder, IProgressMonitor monitor) {
		if (!folder.exists()) {
			if (!folder.getParent().exists() && folder.getParent() instanceof IFolder) {
				doEnsureFolderExists((IFolder) folder.getParent(), monitor);
			}
			try {
				folder.create(true, true, monitor);
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
