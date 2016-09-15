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
package org.yakindu.sct.generator.core.filesystem;

import java.io.File;

import org.eclipse.xtext.generator.JavaIoFileSystemAccess;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Johannes Dicks - Initial contribution and API
 *
 */
public class SCTJavaIoFileSystemAccess extends JavaIoFileSystemAccess implements ISCTFileSystemAccess {

	public static final String BASE_DIR = "filesystemAccess.absolute.baseDir";

	@Inject
	@Named(BASE_DIR)
	protected String absoluteBaseDir;

	private String projectName;

	public void setContext(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public void setOutputPath(String outputName, String path) {
		super.setOutputPath(outputName, absoluteBaseDir + File.separator + projectName + File.separator + path);
	}

}
