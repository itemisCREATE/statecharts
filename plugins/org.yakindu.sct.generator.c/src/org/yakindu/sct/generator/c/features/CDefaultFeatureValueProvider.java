/**
 * Copyright (c) 2011, 2015 Committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Mülder    - Initial contribution and API
 *  Markus Mühlbrandt - Added support for 'IdentifierSettings' feature
 *  Alexander Nyßen   - Added support for 'Tracing' feature; general refactorings
 */
package org.yakindu.sct.generator.c.features;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.generator.core.library.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.collect.Iterables;

/**
 * Provides default values and support for validating parameter values of C code
 * generator generator model.
 * 
 * @author Andreas Mülder
 * @author Markus Mühlbrandt
 * @author Alexander Nyßen
 */
public class CDefaultFeatureValueProvider extends AbstractDefaultFeatureValueProvider {

	private static final String VALID_IDENTIFIER_REGEX = "[_a-zA-Z][_a-zA-Z0-9]*";
	public static final String REQUIRED_TRUE_PARAMETER = "'%s' must at least define one parameter as 'true'.";

	@Override
	public boolean isProviderFor(FeatureTypeLibrary library) {
		return ICFeatureConstants.LIBRARY_NAME.equals(library.getName());
	}

	@Override
	protected void setDefaultValue(FeatureType featureType, FeatureParameterValue parameterValue,
			EObject contextElement) {

		GeneratorEntry entry = (GeneratorEntry) contextElement;
		Statechart statechart = (Statechart) entry.getElementRef();
		String parameterName = parameterValue.getParameter().getName();

		if (ICFeatureConstants.PARAMETER_NAMING_MODULE_NAME.equals(parameterName)) {
			parameterValue.setValue(asIdentifier(statechart.getName(), "_"));
		} else if (ICFeatureConstants.PARAMETER_NAMING_STATEMACHINE_PREFIX.equals(parameterName)) {
			parameterValue.setValue(StringExtensions.toFirstLower(asIdentifier(statechart.getName(), "_")));
		} else if (ICFeatureConstants.PARAMETER_NAMING_MAX_IDENTIFIER_LENGTH.equals(parameterName)) {
			parameterValue.setValue(31);
		} else if (ICFeatureConstants.PARAMETER_NAMING_SEPARATOR.equals(parameterName)) {
			parameterValue.setValue("_");
		} else if (ICFeatureConstants.PARAMETER_TRACING_ENTER_STATE.equals(parameterName)) {
			parameterValue.setValue(true);
		} else if (ICFeatureConstants.PARAMETER_TRACING_EXIT_STATE.equals(parameterName)) {
			parameterValue.setValue(true);
		} else if (ICFeatureConstants.PARAMETER_INCLUDES_USE_RELATIVE_PATHS.equals(parameterName)) {
			parameterValue.setValue(true);
		} else if (ICFeatureConstants.PARAMETER_IN_EVENT_QUEUE.equals(parameterName)) {
			parameterValue.setValue(false);
		} else if (ICFeatureConstants.PARAMETER_USER_ALLOCATED_QUEUE.equals(parameterName)) {
			parameterValue.setValue(false);
		} else if(ICFeatureConstants.PARAMETER_OUT_EVENT_OBSERVABLES.equals(parameterName)) {
			parameterValue.setValue(true);
		} else if(ICFeatureConstants.PARAMETER_OUT_EVENT_GETTERS.equals(parameterName)) {
			parameterValue.setValue(false);
		} else {
			throw new IllegalArgumentException("Unsupported parameter '" + parameterName + "'.");
		}
	}

	@Override
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
		}
		// No specific validation is required for 'enterState' and 'exitState'
		// parameters of 'Tracing' feature, as they are boolean.
		return Status.OK_STATUS;
	}
	
	public IStatus validateConfiguration(FeatureConfiguration configuration) {
		String outEventAPI = configuration.getType().getName();
		if (!ICFeatureConstants.FEATURE_OUT_EVENT_API.equals(outEventAPI)) {
			return Status.OK_STATUS;
		}
		FeatureParameterValue observablesValue = configuration.getParameterValue(ICFeatureConstants.PARAMETER_OUT_EVENT_OBSERVABLES);
		if (observablesValue == null || observablesValue.getBooleanValue()) {
			return Status.OK_STATUS; // default is true
		}
		Iterable<FeatureParameterValue> trueValues = Iterables.filter(configuration.getParameterValues(),
				p -> p.getBooleanValue());
		if (trueValues.iterator().hasNext()) {
			return Status.OK_STATUS;
		}
		return error(String.format(REQUIRED_TRUE_PARAMETER, outEventAPI));
	}

	private String asIdentifier(String it, String separator) {
		return it.replaceAll(INVALID_IDENTIFIER_REGEX, separator);
	}
}
