/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.library.impl;

import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.DEBUG_FEATURE;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.DEBUG_FEATURE_DUMP_SEXEC;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_API_TARGET_FOLDER;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_LIBRARY_TARGET_FOLDER;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_TARGET_FOLDER;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_TARGET_PROJECT;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_SKIP_LIBRARY_FILES;

import org.eclipse.core.runtime.Path;
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

/**
 * @author Johannes Dicks - Initial contribution and API
 */
public class DefaultCoreLibraryHelper implements ICoreLibraryHelper {

	@Override
	public FeatureParameterValue getTargetFolderValue(GeneratorEntry entry) {
		return entry.getFeatureParameterValue(OUTLET_FEATURE, OUTLET_FEATURE_TARGET_FOLDER);
	}

	@Override
	public FeatureParameterValue getLibraryTargetFolderValue(GeneratorEntry entry) {
		return entry.getFeatureParameterValue(OUTLET_FEATURE, OUTLET_FEATURE_LIBRARY_TARGET_FOLDER);
	}

	@Override
	public FeatureParameterValue getApiTargetFolderValue(GeneratorEntry entry) {
		return entry.getFeatureParameterValue(OUTLET_FEATURE, OUTLET_FEATURE_API_TARGET_FOLDER);
	}

	@Override
	public FeatureParameterValue getTargetProjectValue(GeneratorEntry entry) {
		return entry.getFeatureParameterValue(OUTLET_FEATURE, OUTLET_FEATURE_TARGET_PROJECT);
	}

	@Override
	public String getRelativeTargetFolder(GeneratorEntry entry) {
		String projectFolderName = getTargetProjectValue(entry).getStringValue();
		String targetFolderValue = getTargetFolderValue(entry).getStringValue();
		return projectFolderName + Path.SEPARATOR + targetFolderValue;
	}

	@Override
	public String getRelativeLibraryFolder(GeneratorEntry entry) {
		String projectFolderName = getTargetProjectValue(entry).getStringValue();
		String libraryFolderName = getLibraryTargetFolderValue(entry).getStringValue();
		return projectFolderName + Path.SEPARATOR + libraryFolderName;
	}

	@Override
	public String getRelativeApiFolder(GeneratorEntry entry) {
		String projectFolderName = getTargetProjectValue(entry).getStringValue();
		String apiFolderName = getApiTargetFolderValue(entry).getStringValue();
		return projectFolderName + Path.SEPARATOR + apiFolderName;
	}

	@Override
	public boolean serializeExecutionFlow(GeneratorEntry entry) {
		FeatureParameterValue dumpSexec = entry.getFeatureParameterValue(DEBUG_FEATURE, DEBUG_FEATURE_DUMP_SEXEC);
		if (dumpSexec == null) {
			return false;
		}
		return dumpSexec.getBooleanValue();
	}

	@Override
	public boolean getSkipLibraryFiles(GeneratorEntry entry) {
		FeatureParameterValue skipLibraryFiles = entry.getFeatureParameterValue(
				OUTLET_FEATURE, OUTLET_FEATURE_SKIP_LIBRARY_FILES);
		return skipLibraryFiles == null ? false : skipLibraryFiles.getBooleanValue();
	}
}
