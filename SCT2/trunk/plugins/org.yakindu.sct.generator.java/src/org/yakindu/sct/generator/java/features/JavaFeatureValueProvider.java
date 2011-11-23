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
package org.yakindu.sct.generator.java.features;

import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.BASE_PACKAGE;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.IMPLEMENTATION_SUFFIX;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.LIBRARY_NAME;

import org.eclipse.core.runtime.IStatus;
import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class JavaFeatureValueProvider extends
		AbstractDefaultFeatureValueProvider {

	@Override
	protected void setDefaultValue(FeatureParameterValue parameterValue,
			Statechart statechart) {
		if (parameterValue.getParameter().getName().equals(BASE_PACKAGE)) {
			parameterValue.setValue("org.yakindu.sct." + statechart.getName());
		} else if (parameterValue.getParameter().getName()
				.equals(IMPLEMENTATION_SUFFIX)) {
			parameterValue.setValue("impl");
		}
	}

	public boolean isProviderFor(FeatureTypeLibrary library) {
		return library.getName().equals(LIBRARY_NAME);
	}

	public IStatus validateParameterValue(FeatureParameterValue value) {
		return super.error("falsch");
	}

}
