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
package org.yakindu.sct.generator.builder.efs;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.util.StringInputStream;
import org.yakindu.sct.generator.core.features.ICoreFeatureConstants;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;
import org.yakindu.sct.generator.core.library.IOutletFeatureHelper;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Inject;

/**
 * 
 * @author Johannes Dicks - Initial contribution and API
 * 
 */
public class EFSResourceFileSystemAccess extends AbstractFileSystemAccess2 implements ISCTFileSystemAccess {

	private IProject project;
	@Inject
	IOutletFeatureHelper outletFeatureHelper;

	public void refreshTargetProject(GeneratorEntry entry) {
		if (Platform.isRunning()) {

			try {
				IProject project = getTargetProject(entry);
				if (project != null && project.isAccessible())
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * Returns an IProject for the configured target project. The
	 * {@link IProject} is returned even if the project does not exist yet.
	 * 
	 * @param entry
	 * @return
	 */
	public IProject getTargetProject(GeneratorEntry entry) {
		String stringValue = outletFeatureHelper.getTargetProjectValue(entry).getStringValue();
		if (Platform.isRunning()) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(stringValue);
			return project;
		} else
			throw new IllegalStateException("Eclipse Platform not running.");
	}

	/**
	 */
	public String getEncoding(IFile file) throws CoreException {
		return file.getCharset(true);
	}

	/**
	 * Copy of
	 * {@link org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2#getContainer}
	 * 
	 * @param outputConfig
	 * @return
	 * @see {@link org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2}
	 */
	public IContainer getContainer(OutputConfiguration outputConfig, IProject project) {
		String path = outputConfig.getOutputDirectory();
		if (isRootPath(path) || project == null) {
			return project;
		}
		return project.getFolder(new Path(path));
	}

	public boolean isRootPath(String path) {
		return (".".equals(path) || "/".equals(path) || "./".equals(path) || "".equals(path));
	}

	public void createContainer(IContainer container) {
		try {
			ensureExists(container);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}

	}

	public IFile getFile(String fileName, OutputConfiguration config, IProject iProject) {
		IContainer container = getContainer(config, iProject);
		if (container != null) {
			IFile result = container.getFile(new Path(fileName));
			refreshFileSilently(result, new NullProgressMonitor());
			return result;
		}
		return null;
	}

	private void refreshFileSilently(IFile result, NullProgressMonitor nullProgressMonitor) {
		try {
			result.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
		} catch (CoreException c) {
			// ignore
		}
	}

	public boolean hasContentsChanged(IFile file, StringInputStream newContent) {
		boolean contentChanged = false;
		BufferedInputStream oldContent = null;
		try {
			oldContent = new BufferedInputStream(file.getContents());
			int newByte = newContent.read();
			int oldByte = oldContent.read();
			while (newByte != -1 && oldByte != -1 && newByte == oldByte) {
				newByte = newContent.read();
				oldByte = oldContent.read();
			}
			contentChanged = newByte != oldByte;
		} catch (CoreException e) {
			contentChanged = true;
		} catch (IOException e) {
			contentChanged = true;
		} finally {
			if (oldContent != null) {
				try {
					oldContent.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
		return contentChanged;
	}

	public void setDerived(IFile file, boolean isDerived) throws CoreException {
		file.setDerived(isDerived, new NullProgressMonitor());
	}

	public void ensureParentExists(IFile file) throws CoreException {
		if (!file.exists()) {
			ensureExists(file.getParent());
		}

	}

	public StringInputStream getInputStream(String contentsAsString, String encoding) {
		try {
			return new StringInputStream(contentsAsString, encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeIOException(e);
		}
	}

	protected void ensureExists(IContainer container) throws CoreException {
		if (container.exists())
			return;
		if (container instanceof IFolder) {
			ensureExists(container.getParent());
			((IFolder) container).create(true, true, new NullProgressMonitor());
		}
	}

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

		IContainer container = getContainer(outputConfig, getProject());

		if (container == null || !container.exists()) {
			if (outputConfig.isCreateOutputDirectory()) {
				createContainer(container);

			} else {
				return;
			}
		}

		IFile file = getFile(fileName, getOutputConfig(outputName), getProject());
		CharSequence postProcessedContent = postProcess(fileName, outputName, contents);
		String contentsAsString = postProcessedContent.toString();
		if (file.exists()) {
			if (outputConfig.isOverrideExistingResources()) {
				try {
					StringInputStream newContent = getInputStream(contentsAsString, getEncoding(file));
					if (hasContentsChanged(file, newContent)) {
						newContent.reset();
						file.setContents(newContent, true, true, null);
						if (file.isDerived() != outputConfig.isSetDerivedProperty()) {
							setDerived(file, outputConfig.isSetDerivedProperty());
						}
					}
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			}
		} else {
			try {
				ensureParentExists(file);
				file.create(getInputStream(contentsAsString, getEncoding(file)), true, null);
				if (outputConfig.isSetDerivedProperty()) {
					setDerived(file, true);
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
		URI uri = super.getURI(path);
		if (uri == null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromPortableString(path));
			if (file != null) {
				uri = URI.createFileURI(file.getLocationURI().getPath());
			}
		}
		return uri;
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
		if (isRootPath(outputDir) && isRootPath(path)) {
			return URI.createFileURI(getProject().getLocationURI().getPath());
		}
		IFile file = getProject().getFile(outputDir + File.separator + path);
		if (file != null) {
			return URI.createFileURI(file.getLocationURI().getPath());
		}
		return super.getURI(path);
	}
}
