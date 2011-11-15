/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.features.impl;

import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.LIBRARY_NAME;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE_TARGET_FOLDER;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE_TARGET_PROJECT;

import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class CoreLibraryDefaultFeatureValueProvider extends
		AbstractDefaultFeatureValueProvider {


	public boolean isProviderFor(FeatureTypeLibrary library) {
		return LIBRARY_NAME.equals(library.getName());
	}

	@Override
	protected void setDefaultValue(FeatureParameterValue parameterValue,
			Statechart statechart) {
		String parameterName = parameterValue.getParameter().getName();
		if (OUTLET_FEATURE_TARGET_FOLDER.equals(parameterName)) {
			parameterValue.setValue("src-gen");
		} else if (OUTLET_FEATURE_TARGET_PROJECT.equals(parameterName)) {
			parameterValue.setValue(getProject(statechart).getName());
		}
	}

}
