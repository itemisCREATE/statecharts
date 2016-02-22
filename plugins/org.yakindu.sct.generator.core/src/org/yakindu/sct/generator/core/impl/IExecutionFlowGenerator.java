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
package org.yakindu.sct.generator.core.impl;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;

public interface IExecutionFlowGenerator {

	String TARGET_FOLDER_OUTPUT = IFileSystemAccess.DEFAULT_OUTPUT;
	String LIBRARY_TARGET_FOLDER_OUTPUT = "LIBRARY_TARGET_FOLDER";

	/**
	 * 
	 * @param flow
	 *            The {@link ExecutionFlow} to generate.
	 * @param entry
	 *            The {@link GeneratorEntry} that contains the configuration for
	 *            the generation.
	 * @param sctFsa
	 *            A file system access that should be used for the generated
	 *            artifacts. In case a separate libraryTargetFolder is specified
	 *            in the Outlet feature of the generator entry, the file system
	 *            access will not only provide a configuration for
	 *            {@link #TARGET_FOLDER_OUTPUT}, but also for
	 *            {@link #LIBRARY_TARGET_FOLDER_OUTPUT}.
	 * 
	 */
	abstract void generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa);
}
