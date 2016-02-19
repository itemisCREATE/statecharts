/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.yakindu.sct.generator.core.impl.AbstractSExecModelGenerator;
import org.yakindu.sct.model.sgen.GeneratorEntry;

/**
 * Base class for generators that are executed inside the workspace
 * 
 * @author holger willebrandt - Initial contribution and API
 * @author Johannes Dicks - refactored because of EFS decoupling
 */ 
public abstract class AbstractWorkspaceGenerator extends AbstractSExecModelGenerator {
	
	/**
	 * 
	 * @param entry
	 * @deprecated Will be removed in future. Refreshing the project is moved to concrete file system access implementations 
	 */
	@Deprecated
	public final void refreshTargetProject(GeneratorEntry entry) {
		/**
		 * This functionality will be provided by concrete file system accesses from now.
		 */
	}

	public final File getTargetProject(GeneratorEntry entry) {
		URI uri = sctFsa.getURI(outletFeatureHelper.getTargetProjectValue(entry).getStringValue());
		return new File(uri.toFileString());
	}

	public final File getTargetFolder(GeneratorEntry entry) {
		URI uri = sctFsa.getURI(outletFeatureHelper.getRelativeTargetFolder(entry));
		return new File(uri.toFileString());
	}
	
	public final File getLibraryTargetFolder(GeneratorEntry entry) {
		URI uri = sctFsa.getURI(outletFeatureHelper.getRelativeLibraryFolder(entry));
		return new File(uri.toFileString());
	}
	
	public final void writeToConsole(String line){
		log.writeToConsole(line);
	}
	public final void writeToConsole(Throwable e){
		log.writeToConsole(e);
	}
}
