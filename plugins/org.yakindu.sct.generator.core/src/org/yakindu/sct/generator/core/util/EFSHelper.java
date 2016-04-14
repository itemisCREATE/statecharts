/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.util;

import java.io.BufferedInputStream;
import java.io.IOException;
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
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.util.StringInputStream;
import org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator;
import org.yakindu.sct.generator.core.library.IOutletFeatureHelper;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Inject;

/**
 * Encapsulates some EFS related functionality which can be used by Generators.
 * 
 * @author Johannes Dicks - Initial contribution and API
 *
 */
public class EFSHelper {
	@Inject IOutletFeatureHelper outletFeatureHelper;
	
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
			throw new IllegalStateException("The " + AbstractXpandBasedCodeGenerator.class.getSimpleName()
					+ " needs a running eclipse.Platform");
	}
	
	/**
	 */
	public String getEncoding(IFile file) throws CoreException {
		return file.getCharset(true);
	}


	/**
	 * Copy of {@link org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2#getContainer}
	 * @param outputConfig
	 * @return
	 * @see {@link org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2}
	 */
	public IContainer getContainer(OutputConfiguration outputConfig,IProject project) {
		String path = outputConfig.getOutputDirectory();
		if (isRootPath(path) || project == null) {
			return project;
		}
		return project.getFolder(new Path(path));
	}
	
	public boolean isRootPath(String path) {
		return (".".equals(path) ||"/".equals(path) || "./".equals(path) || "".equals(path));
	}

	public void createContainer(IContainer container) {
		try {
			ensureExists(container);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		
	}

	public IFile getFile(String fileName, OutputConfiguration config, IProject iProject) {
		IContainer container = getContainer(config,iProject);
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

}
