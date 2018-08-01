/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c.test.utils;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;

public class TestFileCopier {

	private IProject testProject;
	private ITestProjectFactory projectFactory;

	public interface ITestProjectFactory {
		IProject createTestProject(IProject projectHandle, IProgressMonitor monitor) throws CoreException;
	}
	
	public TestFileCopier(ITestProjectFactory projectFactory) {
		this.projectFactory = projectFactory;
	}

	public void copyFileFromBundleToFolder(Bundle bundle, String sourcePath, String targetPath) {
		copyFileFromBundleToFolder(bundle, new Path(sourcePath), new Path(targetPath));
	}

	public void copyFileFromBundleToFolder(Bundle bundle, String sourcePath, IPath targetPath) {
		copyFileFromBundleToFolder(bundle, new Path(sourcePath), targetPath);
	}

	public void copyFileFromBundleToFolder(Bundle bundle, IPath sourcePath, IPath targetPath) {
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
				testProject = projectFactory.createTestProject(project, monitor);
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
	
	public void cleanUp() {
		try {
			if (testProject != null) {
				testProject.delete(true, new NullProgressMonitor());
				testProject = null;
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}
