/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.generator.core.filesystem;

import java.io.File;
import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.util.StringInputStream;
import org.yakindu.sct.generator.core.features.ICoreFeatureConstants;
import org.yakindu.sct.generator.core.util.ClasspathChanger;
import org.yakindu.sct.generator.core.util.EFSHelper;

import com.google.inject.Inject;

public class EFSResourceFileSystemAccess extends AbstractFileSystemAccess2 implements ISCTFileSystemAccess {

	private IProject project;

	@Inject
	private EFSHelper efsHelper;

	@Override
	public void setOutputPath(String outputName, String path) {
		super.setOutputPath(outputName, path);
		boolean isTargetProject = trySetTargetProject(outputName, path);
		// otherwise java classpath extension will fail, MSG?
		IProject project = getProject();
		if (!isTargetProject && isValidProject(project)) {
			if (hasJavaNature(project) && hasClasspath(project)) {
				new ClasspathChanger().addFolderToClassPath(project, path);
			}
		}
	}

	protected IProject getProject() {
		return project;
	}

	protected boolean trySetTargetProject(String outputName, String path) {
		if (outputName.equals(ICoreFeatureConstants.OUTLET_FEATURE_TARGET_PROJECT)) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(path);
			if (!project.exists()) {
				createProject(project);
			}
			setProject(project);
			return true;
		}
		return false;
	}

	protected void setProject(IProject project) {
		this.project = project;
	}

	protected boolean isValidProject(IProject project) {
		return project != null && project.exists();
	}

	public boolean hasJavaNature(IProject project) {
		try {
			String[] natures = project.getDescription().getNatureIds();
			for (String s : natures) {
				if (s.equals(JavaCore.NATURE_ID))
					return true;
			}
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public boolean hasClasspath(IProject project) {
		return project.getFile(".classpath").exists();
	}

	/**
	 * The default implementation only creates a new default project. Clients
	 * may override if they want to contribute generator specific project setup
	 */
	protected void createProject(IProject project) {
		if (!project.exists()) {
			try {
				NullProgressMonitor monitor = new NullProgressMonitor();
				project.create(monitor);
				project.open(monitor);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	public void generateFile(String fileName, String outputName, CharSequence contents) {

		OutputConfiguration outputConfig = getOutputConfig(outputName);

		IContainer container = efsHelper.getContainer(outputConfig, getProject());

		if (container == null || !container.exists()) {
			if (outputConfig.isCreateOutputDirectory()) {
				efsHelper.createContainer(container);

			} else {
				return;
			}
		}

		IFile file = efsHelper.getFile(fileName, getOutputConfig(outputName), getProject());
		CharSequence postProcessedContent = postProcess(fileName, outputName, contents);
		String contentsAsString = postProcessedContent.toString();
		if (file.exists()) {
			if (outputConfig.isOverrideExistingResources()) {
				try {
					StringInputStream newContent = efsHelper.getInputStream(contentsAsString,
							efsHelper.getEncoding(file));
					if (efsHelper.hasContentsChanged(file, newContent)) {
						newContent.reset();
						file.setContents(newContent, true, true, null);
						if (file.isDerived() != outputConfig.isSetDerivedProperty()) {
							efsHelper.setDerived(file, outputConfig.isSetDerivedProperty());
						}
					}
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			}
		} else {
			try {
				efsHelper.ensureParentExists(file);
				file.create(efsHelper.getInputStream(contentsAsString, efsHelper.getEncoding(file)), true, null);
				if (outputConfig.isSetDerivedProperty()) {
					efsHelper.setDerived(file, true);
				}
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public IFileSystemAccess getIFileSystemAccess() {
		return this;
	}

	@Override
	public void afterGeneration() {
		IProject project = getProject();
		if (isValidProject(project)) {
			try {
				project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public URI getURI(String path) {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromPortableString(path));
		if (file != null) {
			return URI.createFileURI(file.getLocationURI().getPath());
		}
		return super.getURI(path);
	}

	@Override
	public void generateFile(String fileName, String outputCfgName, InputStream content) throws RuntimeIOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputStream readBinaryFile(String fileName, String outputCfgName) throws RuntimeIOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public CharSequence readTextFile(String fileName, String outputCfgName) throws RuntimeIOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public URI getURI(String path, String outputConfiguration) {
		OutputConfiguration outputConfig = getOutputConfig(outputConfiguration);
		String outputDir = outputConfig.getOutputDirectory();
		if (efsHelper.isRootPath(outputDir) && efsHelper.isRootPath(path)) {
			return URI.createFileURI(getProject().getLocationURI().getPath());
		}
		IFile file = getProject().getFile(outputDir + File.separator + path);
		if (file != null) {
			return URI.createFileURI(file.getLocationURI().getPath());
		}
		return super.getURI(path);
	}
}
