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
package org.yakindu.sct.generator.core.library;

import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE;

import org.eclipse.core.runtime.Path;
import org.yakindu.sct.generator.core.features.ICoreFeatureConstants;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

/**
 * @author Johannes Dicks - Initial contribution and API
 */
public class OutletFeatureHelperImpl extends BaseSGenFeatureHelper implements IOutletFeatureHelper {

	@Override
	public FeatureParameterValue getTargetFolderValue(GeneratorEntry entry) {
		return getFeatureParameter(entry, OUTLET_FEATURE, ICoreFeatureConstants.OUTLET_FEATURE_TARGET_FOLDER);
	}

	@Override
	public FeatureParameterValue getLibraryTargetFolderValue(GeneratorEntry entry) {
		return getFeatureParameter(entry, OUTLET_FEATURE, ICoreFeatureConstants.OUTLET_FEATURE_LIBRARY_TARGET_FOLDER);
	}

	@Override
	public FeatureParameterValue getTargetProjectValue(GeneratorEntry entry) {
		return getFeatureParameter(entry, OUTLET_FEATURE, ICoreFeatureConstants.OUTLET_FEATURE_TARGET_PROJECT);
	}

	@Override
	public String getRelativeTargetFolder(GeneratorEntry entry) {
		String projectFolderName = getTargetProjectValue(entry).getExpression().toString();
		String targetFolderValue = getTargetFolderValue(entry).getExpression().toString();
		return projectFolderName + Path.SEPARATOR + targetFolderValue;
	}

	@Override
	public String getRelativeLibraryFolder(GeneratorEntry entry) {
		String projectFolderName = getTargetProjectValue(entry).getStringValue();
		String libraryFolderName = getLibraryTargetFolderValue(entry).getExpression().toString();
		return projectFolderName + Path.SEPARATOR
				+ libraryFolderName;
	}
}
