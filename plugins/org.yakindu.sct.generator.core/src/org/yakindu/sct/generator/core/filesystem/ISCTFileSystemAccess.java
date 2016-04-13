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

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;

/**
 * Is meant to be some kind of bridge between file system
 * mappings within SCT (SGEN) & the xtext.generator.IFileSystemAccess.
 *
 * The SCT M2T generators use the minimal functionality provided by the
 * basic interface xtext.generator.IFileSystemAccess during transformation.
 * 
 * @see {@link org.eclipse.xtext.generator.IFileSystemAccess}
 * 
 * @author Johannes Dicks - Initial contribution and API
 *
 */
public interface ISCTFileSystemAccess {

	/**
	 * Provides an absolute URI for further processing.
	 * 
	 * @param string
	 * @return
	 */
	URI getURI(String path);
	
	URI getURI(String path, String outputName);

	/**
	 * Add an output path for an output name.
	 * 
	 * @param outletFeatureTargetProject
	 * @param stringValue
	 */
	void setOutputPath(String outputName, String relativePath);
	
	/**
	 * Set the default output path.
	 * 
	 * @param relativePath
	 * @see IFileSystemAccess#DEFAULT_OUTPUT
	 */
	void setOutputPath(String relativePath);
	
	
	Map<String, OutputConfiguration> getOutputConfigurations();
	/**
	 * For convenience... and compatibility reasons, might be removed in further
	 * versions
	 * @return
	 */
	IFileSystemAccess getIFileSystemAccess();

	/**
	 * A hook to execute actions after generation.
	 */
	void afterGeneration();

}
