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

import static org.yakindu.sct.generator.core.features.IXpandFeatureConstants.LIBRARY_NAME;
import static org.yakindu.sct.generator.core.features.IXpandFeatureConstants.TEMPLATE_FEATURE_TEMPLATE_PATH;
import static org.yakindu.sct.generator.core.features.IXpandFeatureConstants.TEMPLATE_FEATURE_TEMPLATE_PROJECT;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class XpandLibraryDefaultFeatureValueProvider extends
		AbstractDefaultFeatureValueProvider {

	// (ID::)+ID
	private static final String XPAND_TEMPLATE_PATH_REGEX = "([a-zA-Z_][a-zA-Z0-9_]*::)+[a-zA-Z_][a-zA-Z0-9_]*"; //$NON-NLS-1$

	public boolean isProviderFor(final FeatureTypeLibrary library) {
		return LIBRARY_NAME.equals(library.getName());
	}

	@Override
	protected void setDefaultValue(final FeatureParameterValue parameterValue,
			final EObject contextElement) {
		String parameterName = parameterValue.getParameter().getName();
		if (TEMPLATE_FEATURE_TEMPLATE_PATH.equals(parameterName)) {
			parameterValue
					.setValue("org::yakindu::sct::generator::xpand::Main::main");
		}
		if (TEMPLATE_FEATURE_TEMPLATE_PROJECT.equals(parameterName)) {
			parameterValue.setValue(getProject(contextElement).getName());
		}
	}

	public IStatus validateParameterValue(FeatureParameterValue parameterValue) {
		String parameterName = parameterValue.getParameter().getName();
		String value = parameterValue.getStringValue();
		if (TEMPLATE_FEATURE_TEMPLATE_PATH.equals(parameterName)
				&& !parameterValue.getStringValue()
						.matches(XPAND_TEMPLATE_PATH_REGEX)) {
			return error("Xpand Template Path Syntax Error");
		}
		if (TEMPLATE_FEATURE_TEMPLATE_PROJECT.equals(parameterName)
				&& !projectExists(value)) {
			return error(String.format("The Project %s does not exist", value));
		}
		return Status.OK_STATUS;
	}

}
