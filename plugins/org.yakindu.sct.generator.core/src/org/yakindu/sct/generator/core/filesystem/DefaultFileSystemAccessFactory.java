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

import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.API_TARGET_FOLDER_OUTPUT;
import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.LIBRARY_TARGET_FOLDER_OUTPUT;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_TARGET_PROJECT;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DefaultFileSystemAccessFactory {

	@Inject
	private Provider<ISCTFileSystemAccess> fileSystemProvider;
	@Inject
	private ICoreLibraryHelper helper;

	public ISCTFileSystemAccess create(GeneratorEntry entry) {
		ISCTFileSystemAccess result = fileSystemProvider.get();
		initTargetProject(result, entry);
		initDefaultOutput(result, entry);
		initLibraryTargetFolder(result, entry);
		initApiTargetFolder(result, entry);
		return result;
	}

	protected void initTargetProject(ISCTFileSystemAccess access, GeneratorEntry entry) {
		access.setOutputPath(OUTLET_FEATURE_TARGET_PROJECT, helper.getTargetProjectValue(entry).getStringValue());
	}

	protected void initDefaultOutput(ISCTFileSystemAccess access, GeneratorEntry entry) {
		access.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT,
				helper.getTargetFolderValue(entry).getExpression().toString());
		access.getOutputConfigurations().get(IFileSystemAccess.DEFAULT_OUTPUT).setCreateOutputDirectory(true);
	}

	protected void initLibraryTargetFolder(ISCTFileSystemAccess access, GeneratorEntry entry) {
		FeatureParameterValue libraryTargetFolderValue = helper.getLibraryTargetFolderValue(entry);
		if (libraryTargetFolderValue != null) {
			access.setOutputPath(LIBRARY_TARGET_FOLDER_OUTPUT, libraryTargetFolderValue.getStringValue());
			OutputConfiguration output = access.getOutputConfigurations().get(LIBRARY_TARGET_FOLDER_OUTPUT);
			output.setCreateOutputDirectory(true);
			output.setCanClearOutputDirectory(false);
			output.setOverrideExistingResources(false);
		}
	}

	protected void initApiTargetFolder(ISCTFileSystemAccess access, GeneratorEntry entry) {
		FeatureParameterValue apiTargetFolderValue = helper.getApiTargetFolderValue(entry);
		if (apiTargetFolderValue != null) {
			access.setOutputPath(API_TARGET_FOLDER_OUTPUT, apiTargetFolderValue.getStringValue());
			OutputConfiguration output = access.getOutputConfigurations().get(API_TARGET_FOLDER_OUTPUT);
			output.setCreateOutputDirectory(true);
		}
	}
}
