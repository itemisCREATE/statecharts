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

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * @author Johannes Dicks - Initial contribution and API
 * 
 */
@Singleton
public class SCTEclipseResourceFileSystemAccess extends EclipseResourceFileSystemAccess2 implements ISCTFileSystemAccess {

	@Inject
	private IWorkspace ws;

	public SCTEclipseResourceFileSystemAccess() {
		setMonitor(new NullProgressMonitor());
	}

	public void setContext(String projectName) {
		IProject project = ws.getRoot().getProject(projectName);
		super.setProject(project);
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
	
	protected boolean isRootPath(String path) {
		return (".".equals(path) || "/".equals(path) || "./".equals(path) || "".equals(path));
	}

}
