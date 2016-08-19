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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * @author Johannes Dicks - Initial contribution and API
 * 
 */
@Singleton
public class EFSResourceFileSystemAccess extends EclipseResourceFileSystemAccess2 implements ISCTFileSystemAccess {

	@Inject
	private IWorkspace ws;

	public EFSResourceFileSystemAccess() {
		setMonitor(new NullProgressMonitor());
	}

	@Override
	public void setContext(String projectName) {
		IProject project = ws.getRoot().getProject(projectName);
		super.setContext(project);
	}

}
