/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.library.impl;

import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.DEBUG_FEATURE_DUMP_SEXEC;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.LIBRARY_NAME;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.LICENSE_TEXT;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_API_TARGET_FOLDER;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_LIBRARY_TARGET_FOLDER;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_TARGET_FOLDER;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_TARGET_PROJECT;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.generator.core.library.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;

/**
 * 
 * @author Holger Willebrandt - Initial contribution and API
 * @author Alexander Nyßen - Additions for issue #191.
 */
public class CoreLibraryDefaultFeatureValueProvider extends AbstractDefaultFeatureValueProvider {
 
	public boolean isProviderFor(FeatureTypeLibrary library) {
		return LIBRARY_NAME.equals(library.getName());
	}

	@Override
	protected void setDefaultValue(FeatureType featureType, FeatureParameterValue parameterValue,
			EObject contextElement) {
		String parameterName = parameterValue.getParameter().getName();
		if (OUTLET_FEATURE_TARGET_FOLDER.equals(parameterName)) {
			parameterValue.setValue("src-gen");
		} else if (OUTLET_FEATURE_LIBRARY_TARGET_FOLDER.equals(parameterName)) {
			parameterValue.setValue("src");
		} else if (OUTLET_FEATURE_TARGET_PROJECT.equals(parameterName)) {
			parameterValue.setValue(getProjectName(contextElement));
		} else if (LICENSE_TEXT.equals(parameterName)) {
			parameterValue.setValue("Enter license text here");
		} else if (DEBUG_FEATURE_DUMP_SEXEC.equals(parameterName)) {
			parameterValue.setValue(false);
		}
	}

	public IStatus validateParameterValue(FeatureParameterValue parameterValue) {
		String parameterName = parameterValue.getParameter().getName();
		if (OUTLET_FEATURE_TARGET_PROJECT.equals(parameterName) && !access.projectExists(parameterValue.getStringValue()))
			return error(String.format("The Project %s does not exist.", parameterValue.getStringValue()), ERROR_CODE_PROJECT);
		if (OUTLET_FEATURE_TARGET_PROJECT.equals(parameterName) && access.projectExists(parameterValue.getStringValue())
				&& !access.projectOpened(parameterValue.getStringValue()))
			return error(String.format("The Project %s is not open.", parameterValue.getStringValue()));
		if (OUTLET_FEATURE_TARGET_FOLDER.equals(parameterName)
				|| OUTLET_FEATURE_LIBRARY_TARGET_FOLDER.equals(parameterName)
				|| OUTLET_FEATURE_API_TARGET_FOLDER.equals(parameterName)) {
			FeatureParameterValue targetProjectParam = parameterValue.getFeatureConfiguration()
					.getParameterValue(OUTLET_FEATURE_TARGET_PROJECT);
			String targetProjectName = targetProjectParam != null ? targetProjectParam.getStringValue() : null;
			if (targetProjectName != null && !access.folderExists(targetProjectName, parameterValue.getStringValue())) {
				return warning(String.format("The Folder %s does not exist in Project %s",
						parameterValue.getStringValue(), targetProjectName));
			}
		}
		return Status.OK_STATUS;
	}
}
