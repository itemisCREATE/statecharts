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
package org.yakindu.sct.generator.genmodel.ui.ws;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.yakindu.sct.generator.core.filesystem.ISCTWorkspaceAccess;

public class DefaultSCTWorkspaceAccess implements ISCTWorkspaceAccess {
	
	@Override
	public boolean projectExists(String value) {
		try {
			return ResourcesPlugin.getWorkspace().getRoot().getProject(value).exists();
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	@Override
	public boolean projectOpened(String value) {
		try {
			return ResourcesPlugin.getWorkspace().getRoot().getProject(value).isOpen();
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	@Override
	public boolean folderExists(String projectName, String folderPath) {
		try {
			IPath workspaceRelativePath = Path.fromPortableString(projectName).append(folderPath);
			return ResourcesPlugin.getWorkspace().getRoot().exists(workspaceRelativePath);
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	@Override
	public boolean fileExists(String projectName, String folderPath) {
		try {
			return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getFile(new Path(folderPath))
					.exists();
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	@Override
	public void refreshProject(String projectName) {
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (project != null && project.isAccessible())
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}
	
}
