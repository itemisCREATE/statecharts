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
package org.yakindu.sct.generator.core.library;

import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.ImplementedBy;

/**
 * Provides convenience access to SGen outlet features.
 * 
 * @author Johannes Dicks - Initial contribution and API
 *
 */
@ImplementedBy(OutletFeatureHelperImpl.class)
public interface IOutletFeatureHelper {
	/**
	 * The targetFolder value defined in SGen.
	 * @param entry
	 * @return the target folder value
	 */
	FeatureParameterValue getTargetFolderValue(GeneratorEntry entry);
	/**
	 * The libraryFolder value defined in SGen.
	 * @param entry
	 * @return the library target folder value
	 */
	FeatureParameterValue getLibraryTargetFolderValue(GeneratorEntry entry);
	/**
	 * The project value defined in SGen.
	 * @param entry
	 * @return the project value
	 */
	FeatureParameterValue getTargetProjectValue(GeneratorEntry entry);
	/**
	 * Convenience to combine targetProject & targetFolder values defined in SGen.
	 * @param entry
	 * @return a string representing the relative output path 'targetProject/targetFolder'
	 */
	String getRelativeTargetFolder(GeneratorEntry entry);
	/**
	 * Convenience to combine targetProject & libraryTargetFolder values defined in SGen.
	 * @param entry
	 * @return a string representing the relative output path 'targetProject/libraryTargetFolder'
	 */
	String getRelativeLibraryFolder(GeneratorEntry entry);
}