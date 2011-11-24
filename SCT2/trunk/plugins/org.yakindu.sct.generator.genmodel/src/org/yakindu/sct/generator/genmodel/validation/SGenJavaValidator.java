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
package org.yakindu.sct.generator.genmodel.validation;

import java.util.NoSuchElementException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.ParameterTypes;
import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.sgen.impl.FeatureParameterValueImpl;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SGenJavaValidator extends AbstractSGenJavaValidator {

	@Inject
	private IExpressionInterpreter interpreter;

	@Check
	public void checkParameterValueType(
			final FeatureParameterValue parameterValue) {
		if (parameterValue == null || parameterValue.getExpression() == null)
			return;
		// TODO: Dirty
		((FeatureParameterValueImpl) parameterValue)
				.setInterpreter(interpreter);
		Object value = parameterValue.getValue();
		ParameterTypes parameterType = parameterValue.getParameter()
				.getParameterType();
		switch (parameterType) {
		case BOOLEAN:
			if (!(value instanceof Boolean))
				error("Incompatible type, Boolean expteced",
						SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
			break;
		case INTEGER:
			if (!(value instanceof Integer))
				error("Incompatible type, Integer expteced",
						SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
			break;
		case FLOAT:
			if (!(value instanceof Float))
				error("Incompatible type, Float expteced",
						SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
			break;
		case STRING:
			if (!(value instanceof String))
				error("Incompatible type, String expteced",
						SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
			break;
		}
	}

	// @Check
	// public void checkParameterValue(final FeatureParameterValue value) {
	// if (value.getValue() == null)
	// return;
	// GeneratorModel model = (GeneratorModel) EcoreUtil2
	// .getRootContainer(value);
	// IDefaultFeatureValueProvider provider = LibraryExtensions
	// .getDefaultFeatureValueProvider(model.getGeneratorId(), value
	// .getParameter().getFeatureType().getLibrary());
	// IStatus status = provider.validateParameterValue(value);
	// createMarker(status);
	// }

	private void createMarker(IStatus status) {
		switch (status.getSeverity()) {
		case IStatus.ERROR:
			super.error(status.getMessage(),
					SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
			break;
		case IStatus.WARNING:
			super.warning(status.getMessage(),
					SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
		}
	}
	
	@Check
	public void checkGeneratorExists(GeneratorModel model) {
		try {
			GeneratorExtensions.getGeneratorDescriptorForId(model
					.getGeneratorId());
		} catch (NoSuchElementException e) {
			error(String.format("Unkown Generator %s!", model.getGeneratorId()),
					SGenPackage.Literals.GENERATOR_MODEL__GENERATOR_ID);
		}
	}

	@Check
	public void checkDuplicateGeneratorEntryFeature(
			final FeatureConfiguration config) {
		GeneratorEntry entry = (GeneratorEntry) config.eContainer();
		Iterable<FeatureConfiguration> filter = Iterables.filter(
				entry.getFeatures(), new Predicate<FeatureConfiguration>() {
					public boolean apply(FeatureConfiguration input) {
						return (input.getType().getName().equals(config
								.getType().getName()));
					}
				});
		if (Iterables.size(filter) > 1) {
			error("Duplicate feature!",
					SGenPackage.Literals.FEATURE_CONFIGURATION__TYPE);
		}

	}

	@Check
	public void checkDuplicateFeatureParameter(final FeatureParameterValue value) {
		FeatureConfiguration entry = (FeatureConfiguration) value.eContainer();
		Iterable<FeatureParameterValue> filter = Iterables.filter(
				entry.getParameterValues(),
				new Predicate<FeatureParameterValue>() {
					public boolean apply(FeatureParameterValue input) {
						return (input.getParameter().getName().equals(value
								.getParameter().getName()));
					}
				});
		if (Iterables.size(filter) > 1) {
			error("Duplicate parameter!",
					SGenPackage.Literals.FEATURE_PARAMETER_VALUE__PARAMETER);
		}
	}
}
