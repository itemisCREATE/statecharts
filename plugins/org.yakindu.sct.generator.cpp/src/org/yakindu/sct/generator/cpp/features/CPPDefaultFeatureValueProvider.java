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
package org.yakindu.sct.generator.cpp.features;

import java.util.Arrays;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.generator.c.features.ICFeatureConstants;
import org.yakindu.sct.generator.core.library.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.generator.cpp.features.CPPFeatureConstants.Visibility;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CPPDefaultFeatureValueProvider extends AbstractDefaultFeatureValueProvider {

	private static final String INVALID_IDENTIFIER_REGEX = "[^a-z&&[^A-Z&&[^0-9]]]";
	private static final String VALID_IDENTIFIER_REGEX = "[_a-zA-Z][_a-zA-Z0-9]*";

	public boolean isProviderFor(FeatureTypeLibrary library) {
		return CPPFeatureConstants.LIBRARY_NAME.equals(library.getName());
	}

	@Override
	protected void setDefaultValue(FeatureType featureType, FeatureParameterValue parameterValue,
			EObject contextElement) {
		GeneratorEntry entry = (GeneratorEntry) contextElement;
		Statechart statechart = (Statechart) entry.getElementRef();

		if (parameterValue.getParameter().getName().equals(ICFeatureConstants.PARAMETER_NAMING_MODULE_NAME)) {
			parameterValue.setValue(asIdentifier(statechart.getName(), "_"));
		} else if (parameterValue.getParameter().getName()
				.equals(ICFeatureConstants.PARAMETER_NAMING_STATEMACHINE_PREFIX)) {
			parameterValue.setValue(StringExtensions.toFirstLower(asIdentifier(statechart.getName(), "_")));
		} else if (parameterValue.getParameter().getName()
				.equals(ICFeatureConstants.PARAMETER_NAMING_MAX_IDENTIFIER_LENGTH)) {
			parameterValue.setValue("31");
		} else if (parameterValue.getParameter().getName().equals(ICFeatureConstants.PARAMETER_NAMING_SEPARATOR)) {
			parameterValue.setValue("_");
		} else if (parameterValue.getParameter().getName()
				.equals(CPPFeatureConstants.PARAMETER_INNER_FUNCTION_VISIBILITY)) {
			parameterValue.setValue(Visibility.PRIVATE.toString().toLowerCase());
		} else if (parameterValue.getParameter().getName().equals(CPPFeatureConstants.PARAMETER_STATIC_OPC)) {
			parameterValue.setValue(false);
		} else if (parameterValue.getParameter().getName().equals(CPPFeatureConstants.PARAMETER_INCLUDES_USE_RELATIVE_PATHS)) {
			parameterValue.setValue(true);
		}
	}

	public IStatus validateParameterValue(FeatureParameterValue parameter) {
		String parameterName = parameter.getParameter().getName();
		if (ICFeatureConstants.PARAMETER_NAMING_MODULE_NAME.equals(parameterName)) {
			if (!parameter.getStringValue().matches(VALID_IDENTIFIER_REGEX)) {
				return error("Invalid module name");
			}
		} else if (ICFeatureConstants.PARAMETER_NAMING_STATEMACHINE_PREFIX.equals(parameterName)) {
			if (!parameter.getStringValue().matches(VALID_IDENTIFIER_REGEX)) {
				return error("Invalid function prefix name");
			}
		} else if (ICFeatureConstants.PARAMETER_NAMING_SEPARATOR.equals(parameterName)) {
			if (!parameter.getStringValue().matches(VALID_IDENTIFIER_REGEX)) {
				return error("Invalid separator");
			}
		} else if (CPPFeatureConstants.PARAMETER_INNER_FUNCTION_VISIBILITY.equals(parameterName)) {
			boolean found = false;
			for (Visibility visibility : Arrays.asList(Visibility.values())) {
				if (visibility.toString().toLowerCase().equals(parameter.getStringValue())) {
					found = true;
					break;
				}
			}
			if (!found) {
				return error("Visibility could only be private or protected");
			}
		}
		return Status.OK_STATUS;
	}

	private String asIdentifier(String it, String separator) {
		return it.replaceAll(INVALID_IDENTIFIER_REGEX, separator);
	}
}
