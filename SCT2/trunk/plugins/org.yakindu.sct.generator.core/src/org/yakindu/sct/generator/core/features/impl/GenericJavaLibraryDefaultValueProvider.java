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

import static org.yakindu.sct.generator.core.features.impl.IGenericJavaFeatureConstants.GENERATOR_CLASS;
import static org.yakindu.sct.generator.core.features.impl.IGenericJavaFeatureConstants.GENERATOR_PROJECT;
import static org.yakindu.sct.generator.core.features.impl.IGenericJavaFeatureConstants.LIBRARY_NAME;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class GenericJavaLibraryDefaultValueProvider extends
		AbstractDefaultFeatureValueProvider {

	// (ID.)+ID
	private static final String GENERATOR_CLASS_REGEX = "([a-zA-Z_][a-zA-Z0-9_]*\\.)+[a-zA-Z_][a-zA-Z0-9_]*"; //$NON-NLS-1$

	public boolean isProviderFor(FeatureTypeLibrary library) {
		return library.getName().equals(LIBRARY_NAME);
	}

	@Override
	protected void setDefaultValue(FeatureParameterValue parameterValue,
			Statechart statechart) {
		String parameterName = parameterValue.getParameter().getName();
		if (GENERATOR_PROJECT.equals(parameterName)) {
			parameterValue.setValue(getProject(statechart).getName());
		} else if (GENERATOR_CLASS.equals(parameterName)) {
			parameterValue.setValue("org.yakindu.sct.generator.Generator");
		}
	}

	public IStatus validateParameterValue(FeatureParameterValue parameterValue) {
		String parameterName = parameterValue.getParameter().getName();
		String value = parameterValue.getStringValue();
		if (GENERATOR_PROJECT.equals(parameterName) && !projectExists(value)) {
			return error(String.format("The Project %s does not exist", value));
		}
		if (GENERATOR_CLASS.equals(parameterName)
				&& !value.matches(GENERATOR_CLASS_REGEX)) {
			return error("Generator class must be a full qualified class name");
		}
		return Status.OK_STATUS;
	}
}
