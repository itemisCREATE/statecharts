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

import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

/**
 * Convenience...
 * 
 * @author Johannes Dicks - Initial contribution and API
 *
 */
public class BaseSGenFeatureHelper {

	public FeatureParameterValue getFeatureParameter(GeneratorEntry entry, String featureName, String paramName) {
		FeatureConfiguration feature = entry.getFeatureConfiguration(featureName);

		if (feature != null) {
			FeatureParameterValue parameterValue = feature.getParameterValue(paramName);

			if (parameterValue != null) {
				//return configured value
				return parameterValue;
			} else {
				//return default value
				return LibraryExtensions.getDefaultValue(entry,feature.getType(),paramName);
			}
		}

		return null;
	}

}
