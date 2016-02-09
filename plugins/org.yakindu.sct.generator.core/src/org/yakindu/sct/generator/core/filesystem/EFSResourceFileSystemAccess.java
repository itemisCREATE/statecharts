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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.StringInputStream;
import org.yakindu.sct.generator.core.features.ICoreFeatureConstants;
import org.yakindu.sct.generator.core.library.OutletFeatureHelperImpl;
import org.yakindu.sct.generator.core.util.ClasspathChanger;
import org.yakindu.sct.model.sgen.GeneratorEntry;

public class EFSResourceFileSystemAccess extends EclipseResourceFileSystemAccess2 implements SCTFileSystemAccess {

	/**
	 * Returns an IProject for the configured target project. The
	 * {@link IProject} is returned even if the project does not exist yet.
	 * 
	 * @param entry
	 * @return
	 */
	public static IProject getTargetProject(GeneratorEntry entry) {
		String stringValue = new OutletFeatureHelperImpl().getTargetProjectValue(entry).getStringValue();
		if (Platform.isRunning()) {

			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(stringValue);

			return project;
		} else
			throw new IllegalStateException("The " + EFSResourceFileSystemAccess.class.getSimpleName()
					+ " needs a running " + Platform.class.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.generator.AbstractFileSystemAccess#setOutputPath(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	public void setOutputPath(String outputName, String path) {
		super.setOutputPath(outputName, path);
		// FIXME !!! ??? setting the targetProject has to be done firstly
		trySetTargetProject(outputName, path);
		// otherwise java classpath extension will fail, MSG?
//		if (isOutputFolder(outputName)) {
			IProject project = getProject();
			if (isValidProject(project)) {
				// FIXME !!! classpathchanger!?
				if (hasJavaNature(project) && hasClasspath(project)) {
					new ClasspathChanger().addFolderToClassPath(project, path);
				}
			}
//		}
	}
//FIXME !!! ???
//	protected boolean isOutputFolder(String outputName) {
//		return outputName.equals(IFileSystemAccess.DEFAULT_OUTPUT)
//				|| outputName.equals(ICoreFeatureConstants.OUTLET_FEATURE_LIBRARY_TARGET_FOLDER)
//				|| outputName.equals(ICoreFeatureConstants.OUTLET_FEATURE_TARGET_FOLDER);
//	}

	protected void trySetTargetProject(String outputName, String path) {
		if (outputName.equals(ICoreFeatureConstants.OUTLET_FEATURE_TARGET_PROJECT)) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(path);
			if (!project.exists()) {
				createProject(project);
			}
			setProject(project);
		}
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

		IContainer container = getContainer(outputConfig);

		if (!container.exists()) {
			if (outputConfig.isCreateOutputDirectory()) {
				try {
					createContainer(container);
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			} else {
				return;
			}
		}

		IFile file = getFile(fileName, outputName);
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
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromPortableString(path));
		if (file != null) {
			return URI.createFileURI(file.getLocationURI().getPath());
		}
		return super.getURI(path);
	}
}
