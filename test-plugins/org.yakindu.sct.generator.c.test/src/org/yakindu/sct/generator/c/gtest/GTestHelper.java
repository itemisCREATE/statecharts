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
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.yakindu.sct.generator.core.GeneratorExecutor;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.test.models.SCTUnitTestModels;


/**
 * @author Andreas Unger - Initial contribution and API
 * @author Markus Mühlbrandt
 * 
 */
public class GTestHelper {

	private final Object owner;

	/**
	 * 
	 */
	public GTestHelper(Object owner) {
		this.owner = owner;
	}

	public void compile() {
		try {
			copyFilesFromBundleToFolder();
			IResource resource = ResourcesPlugin.getWorkspace().getRoot()
					.findMember(getTargetPath());
			File directory = resource.getLocation().toFile();
			List<String> command = createCommand();

			ProcessBuilder processBuilder = new ProcessBuilder(command)
					.directory(directory);
			Process process = processBuilder.redirectErrorStream(true).start();
			String message = readProcessInputStream(process);
			
			boolean wait = true;
			int exitCode = 0;
			
			do {
				wait = false;

				// waiting for the processes termination
				try {
					process.waitFor();
				} catch ( InterruptedException e ) { /* we ignore if waiting was interrupted ... */ }

				// if we get an exit code then we know that the process is finished
				try {
					exitCode = process.exitValue();
				} catch ( IllegalThreadStateException e ) {
					wait = true; // if we get an exception then the process has not finished ...
				}
			} while (wait);

			if (exitCode != 0) {
				throw new RuntimeException("Compilation failed (exit status "
						+ process.exitValue() + "):\n" + message);
			}
		} catch (Error e) {
			throw e;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				ResourcesPlugin
						.getWorkspace()
						.getRoot()
						.refreshLocal(IResource.DEPTH_INFINITE,
								new NullProgressMonitor());
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void generate() {

		IPath targetPath = getTargetPath();

		// copy model to JUnit workspace
		copyFileFromBundleToFolder(getModelBundle(), getModelPath(), targetPath);

		String sgenFileName = getTestProgram() + ".sgen";
		copyFileFromBundleToFolder(getTestBundle(), sgenFileName, targetPath);

		IPath path = new Path(sgenFileName);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		Resource sgenResource = loadResource(file);
		GeneratorModel model = (GeneratorModel) sgenResource.getContents().get(
				0);
		model.getEntries().get(0).setElementRef(getStatechart());
		new GeneratorExecutor().executeGenerator(model);
	}

	protected Statechart getStatechart() {
		IPath path = new Path(getTargetPath().toString() + "/"
				+ getModelPath().lastSegment());
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		Resource resource = loadResource(file);
		return (Statechart) resource.getContents().get(0);
	}

	protected Resource loadResource(IFile file) {
		Resource resource = null;
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
		resource = new ResourceSetImpl().getResource(uri, true);
		return resource;
	}

	protected Bundle getModelBundle() {
		return FrameworkUtil.getBundle(SCTUnitTestModels.class);
	}

	private void copyFilesFromBundleToFolder() {
		IPath targetPath = getTargetPath();
		List<String> testDataFiles = new ArrayList<String>();
		getTestDataFiles(testDataFiles);
		for (String file : testDataFiles) {
			copyFileFromBundleToFolder(getTestBundle(), file, targetPath);
		}
	}

	private String readProcessInputStream(Process process) throws IOException {
		Reader reader = new InputStreamReader(process.getInputStream());
		char[] buffer = new char[4096];
		int count;
		StringBuilder message = new StringBuilder();
		while ((count = reader.read(buffer)) != -1) {
			message.append(buffer, 0, count);
		}
		return message.toString();
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
		if (gTestDirectory != null) command.add("-I" + gTestDirectory + "/include");
		for (String include : includes) {
			command.add("-I" + include);
		}
		if (gTestDirectory != null) command.add("-L" + gTestDirectory);
		for (String sourceFile : sourceFiles) {
			command.add(sourceFile);
		}
		command.add("-lgtest");
		command.add("-lgtest_main");
		command.add("-lstdc++");
		command.add("-pthread");
//		command.add("-pg");
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
//		if (gTestDirectory == null) {
//			throw new RuntimeException("GTEST_DIR environment variable not set");
//		}
		return gTestDirectory;
	}

	protected String getFileName(String path) {
		return new Path(path).lastSegment();
	}

	protected IPath getTargetPath() {
		return new Path(getTestProgram()).removeLastSegments(1);
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

	protected void copyFileFromBundleToFolder(Bundle bundle, String sourcePath,
			String targetPath) {
		copyFileFromBundleToFolder(bundle, new Path(sourcePath), new Path(
				targetPath));
	}

	protected void copyFileFromBundleToFolder(Bundle bundle, String sourcePath,
			IPath targetPath) {
		copyFileFromBundleToFolder(bundle, new Path(sourcePath), targetPath);
	}

	protected void copyFileFromBundleToFolder(Bundle bundle, IPath sourcePath,
			IPath targetPath) {
		String fileName = sourcePath.lastSegment();
		copyFileFromBundle(bundle, sourcePath, targetPath.append(fileName));
	}

	protected void copyFileFromBundle(Bundle bundle, String sourcePath,
			String targetPath) {
		copyFileFromBundle(bundle, sourcePath, new Path(targetPath));
	}

	protected void copyFileFromBundle(Bundle bundle, String sourcePath,
			IPath targetPath) {
		copyFileFromBundle(bundle, new Path(sourcePath), targetPath);
	}

	protected void copyFileFromBundle(Bundle bundle, IPath sourcePath,
			IPath targetPath) {
		try {
			InputStream is = FileLocator.openStream(bundle, sourcePath, false);
			createFile(targetPath, is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected Bundle getTestBundle() {
		return FrameworkUtil.getBundle(owner.getClass());
	}

	protected void copyFileFromBundle(String sourcePath, IFile targetFile) {
		copyFileFromBundle(new Path(sourcePath), targetFile);
	}

	protected void copyFileFromBundle(IPath sourcePath, IFile targetFile) {
		try {
			InputStream is = FileLocator.openStream(getTestBundle(),
					sourcePath, false);
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
		return ensureContainerExists(ResourcesPlugin.getWorkspace().getRoot()
				.getFolder(new Path(path)));
	}

	protected IFolder getFolder(IPath path) {
		return ensureContainerExists(ResourcesPlugin.getWorkspace().getRoot()
				.getFolder(path));
	}

	protected <T extends IContainer> T ensureContainerExists(T container) {
		IProgressMonitor monitor = new NullProgressMonitor();
		IProject project = container.getProject();
		if (project.exists()) {
			if (!project.isOpen()) {
				throw new RuntimeException("Project " + project.getName()
						+ " closed");
			}
		} else {
			try {
				project.create(monitor);
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

	private void doEnsureFolderExists(IFolder folder, IProgressMonitor monitor) {
		if (!folder.exists()) {
			if (!folder.getParent().exists()
					&& folder.getParent() instanceof IFolder) {
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
