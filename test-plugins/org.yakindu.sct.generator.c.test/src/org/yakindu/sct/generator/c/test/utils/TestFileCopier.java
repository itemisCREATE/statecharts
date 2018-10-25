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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

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

	public void copyFolderFromBundleToFolder(Bundle bundle, String sourcePath, String targetPath) {
		try {
			URL folder = bundle.getEntry(sourcePath);
			File file = new File(FileLocator.resolve(folder).toURI());
			if (file.exists() && file.isDirectory()) {
				for (File f : file.listFiles()) {
					copyFileFromBundleToFolder(bundle, new Path(sourcePath).append(f.getName()), new Path(targetPath));
				}
			}
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected void copyFileFromBundle(Bundle bundle, IPath sourcePath, IPath targetPath) {
		try {
			InputStream is = FileLocator.openStream(bundle, sourcePath, false);
			createFile(targetPath, is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void createFile(IPath path, InputStream source) {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		createFile(file, source);
	}

	public void createFile(IFile file, InputStream source) {
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

	protected void ensureContainerExists(IContainer container) {
		ensureProjectExists(container);
		if (container instanceof IFolder) {
			ensureFolderExists((IFolder) container);
		}
	}
	
	protected void ensureProjectExists(IContainer container) {
		IProject project = container.getProject();
		if (project.exists()) {
			if (!project.isOpen()) {
				throw new RuntimeException("Project " + project.getName() + " closed");
			}
		} else {
			try {
				testProject = projectFactory.createTestProject(project, new NullProgressMonitor());
				project.open(new NullProgressMonitor());
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

	protected void ensureFolderExists(IFolder folder) {
		if (!folder.exists()) {
			if (!folder.getParent().exists() && folder.getParent() instanceof IFolder) {
				ensureFolderExists((IFolder) folder.getParent());
			}
			try {
				folder.create(true, true, new NullProgressMonitor());
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
			throw new RuntimeException(e);
		}
	}
}
