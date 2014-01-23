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
package org.yakindu.sct.generator.c.features;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * Feature value provider for c code generator.
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Markus Mühlbrandt - Added additional features
 * 
 */
public class CDefaultFeatureValueProvider extends
		AbstractDefaultFeatureValueProvider {

	private static final String INVALID_IDENTIFIER_REGEX = "[^a-z&&[^A-Z&&[^0-9]]]";
	private static final String VALID_IDENTIFIER_REGEX = "[_a-zA-Z][_a-zA-Z0-9]*";

	public boolean isProviderFor(FeatureTypeLibrary library) {
		return CFeatureConstants.LIBRARY_NAME.equals(library.getName());
	}

	@Override
	protected void setDefaultValue(FeatureParameterValue parameterValue,
			EObject contextElement) {

		GeneratorEntry entry = (GeneratorEntry) contextElement;
		Statechart statechart = (Statechart) entry.getElementRef();

		if (parameterValue.getParameter().getName()
				.equals(CFeatureConstants.PARAMETER_MODULE_NAME)) {
			parameterValue.setValue(asIdentifier(statechart.getName(), "_"));
		} else if (parameterValue.getParameter().getName()
				.equals(CFeatureConstants.PARAMETER_FUNCTION_PREFIX)) {
			parameterValue.setValue(StringExtensions.toFirstLower(asIdentifier(
					statechart.getName(), "_")));
		} else if (parameterValue.getParameter().getName()
				.equals(CFeatureConstants.PARAMETER_MAX_IDENTIFIER_LENGTH)) {
			parameterValue.setValue("31");
		} else if (parameterValue.getParameter().getName()
				.equals(CFeatureConstants.PARAMETER_SEPARATOR)) {
			parameterValue.setValue("_");
		}
	}

	/**
	 * Executes some validations on the given {@link FeatureParameterValue}
	 */
	public IStatus validateParameterValue(FeatureParameterValue parameter) {
		String parameterName = parameter.getParameter().getName();
		if (CFeatureConstants.PARAMETER_MODULE_NAME.equals(parameterName)) {
			if (!parameter.getStringValue().matches(VALID_IDENTIFIER_REGEX)) {
				return error("Invalid module name");
			}
		} else if (CFeatureConstants.PARAMETER_FUNCTION_PREFIX.equals(parameterName)) {
			if (!parameter.getStringValue().matches(VALID_IDENTIFIER_REGEX)) {
				return error("Invalid function prefix name");
			}
		} else if (CFeatureConstants.PARAMETER_SEPARATOR.equals(parameterName)) {
			if (!parameter.getStringValue().matches(VALID_IDENTIFIER_REGEX)) {
				return error("Invalid separator");
			}
		}
		return Status.OK_STATUS;
	}

	private String asIdentifier(String it, String separator) {
		return it.replaceAll(INVALID_IDENTIFIER_REGEX, separator);
	}
}
