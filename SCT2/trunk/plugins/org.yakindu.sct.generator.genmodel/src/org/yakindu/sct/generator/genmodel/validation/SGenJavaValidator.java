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

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;

import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions.LibraryDescriptor;
import org.yakindu.sct.generator.core.features.IDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.BoolLiteral;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.IntLiteral;
import org.yakindu.sct.model.sgen.Literal;
import org.yakindu.sct.model.sgen.ParameterTypes;
import org.yakindu.sct.model.sgen.RealLiteral;
import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.sgen.StringLiteral;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenJavaValidator extends AbstractSGenJavaValidator {

	@Check
	public void checkContentType(GeneratorEntry entry) {
		GeneratorModel generatorModel = EcoreUtil2.getContainerOfType(entry,
				GeneratorModel.class);
		GeneratorDescriptor descriptor = GeneratorExtensions
				.getGeneratorDescriptorForId(generatorModel.getGeneratorId());
		String contentType = entry.getContentType();
		if (contentType == null || contentType.trim().length() == 0) {
			return;
		}
		if (!contentType.equals(descriptor.getContentType())) {
			error("Unknown content type '" + contentType + "'",
					SGenPackage.Literals.GENERATOR_ENTRY__CONTENT_TYPE);
		}
	}

	@Check
	public void checkParameterValueType(
			final FeatureParameterValue parameterValue) {
		if (parameterValue == null || parameterValue.getExpression() == null)
			return;
		Literal value = parameterValue.getExpression();
		ParameterTypes parameterType = parameterValue.getParameter()
				.getParameterType();
		switch (parameterType) {
		case BOOLEAN:
			if (!(value instanceof BoolLiteral))
				error("Incompatible type, Boolean expected",
						SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
			break;
		case INTEGER:
			if (!(value instanceof IntLiteral))
				error("Incompatible type, Integer expected",
						SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
			break;
		case FLOAT:
			if (!(value instanceof RealLiteral))
				error("Incompatible type, Float expected",
						SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
			break;
		case STRING:
			if (!(value instanceof StringLiteral))
				error("Incompatible type, String expected",
						SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
			break;
		}
	}

	@Check
	public void checkParameterValue(final FeatureParameterValue value) {
		if (value.getExpression() == null || value.getExpression() == null)
			return;
		GeneratorModel model = (GeneratorModel) EcoreUtil2
				.getRootContainer(value);
		IDefaultFeatureValueProvider provider = LibraryExtensions
				.getDefaultFeatureValueProvider(model.getGeneratorId(), value
						.getParameter().getFeatureType().getLibrary());
		IStatus status = provider.validateParameterValue(value);
		createMarker(status);
	}

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

	@Check
	public void checkRequiredFeatures(GeneratorEntry entry) {
		GeneratorModel model = (GeneratorModel) EcoreUtil2
				.getRootContainer(entry);
		Iterable<LibraryDescriptor> libraryDescriptors = LibraryExtensions
				.getLibraryDescriptor(model.getGeneratorId());
		Iterable<FeatureType> requiredFeatures = filter(
				concat(transform(
						transform(libraryDescriptors, getFeatureTypeLibrary()),
						getFeatureTypes())), isRequired());
		List<String> configuredTypes = Lists.newArrayList();
		for (FeatureConfiguration featureConfiguration : entry.getFeatures()) {
			configuredTypes.add(featureConfiguration.getType().getName());
		}
		for (FeatureType featureType : requiredFeatures) {
			if (!configuredTypes.contains(featureType.getName()))
				error(String.format("Missing required feature %s",
						featureType.getName()),
						SGenPackage.Literals.GENERATOR_ENTRY__ELEMENT_REF);
		}
	}

	@Check
	public void checkRequiredParameters(FeatureConfiguration configuration) {
		GeneratorModel model = (GeneratorModel) EcoreUtil2
				.getRootContainer(configuration);
		Iterable<LibraryDescriptor> libraryDescriptors = LibraryExtensions
				.getLibraryDescriptor(model.getGeneratorId());

		Iterable<String> requiredParameters = transform(
				filter(concat(transform(
						filter(concat(transform(
								transform(libraryDescriptors,
										getFeatureTypeLibrary()),
								getFeatureTypes())), hasName(configuration
								.getType().getName())), getParmeter())),
						isRequiredParamter()), getName());

		List<String> configuredParameters = Lists.newArrayList();

		for (FeatureParameterValue featureParameterValue : configuration
				.getParameterValues()) {
			configuredParameters.add(featureParameterValue.getParameter()
					.getName());
		}
		for (String string : requiredParameters) {
			if (!configuredParameters.contains(string))
				error(String.format("Missing required Parameter %s", string),
						SGenPackage.Literals.FEATURE_CONFIGURATION__TYPE);
		}
	}

	private Function<NamedElement, String> getName() {
		return new Function<NamedElement, String>() {

			public String apply(NamedElement from) {
				return from.getName();
			}
		};
	}

	private Predicate<FeatureParameter> isRequiredParamter() {
		return new Predicate<FeatureParameter>() {

			public boolean apply(FeatureParameter input) {
				return !input.isOptional();
			}
		};
	}

	private Function<FeatureType, Iterable<FeatureParameter>> getParmeter() {
		return new Function<FeatureType, Iterable<FeatureParameter>>() {

			public Iterable<FeatureParameter> apply(FeatureType from) {
				return from.getParameters();
			}
		};
	}

	private Predicate<NamedElement> hasName(final String name) {
		return new Predicate<NamedElement>() {

			public boolean apply(NamedElement input) {
				if (name == null) {
					return (input == null);
				}
				return name.equals(input.getName());
			}
		};
	}

	private static Predicate<FeatureType> isRequired() {
		return new Predicate<FeatureType>() {

			public boolean apply(FeatureType input) {
				return !input.isOptional();
			}
		};
	}

	private static Function<FeatureTypeLibrary, Iterable<FeatureType>> getFeatureTypes() {
		return new Function<FeatureTypeLibrary, Iterable<FeatureType>>() {

			public Iterable<FeatureType> apply(FeatureTypeLibrary from) {
				return from.getTypes();
			}
		};
	}

	private static Function<LibraryDescriptor, FeatureTypeLibrary> getFeatureTypeLibrary() {
		return new Function<LibraryExtensions.LibraryDescriptor, FeatureTypeLibrary>() {

			public FeatureTypeLibrary apply(LibraryDescriptor from) {
				return (FeatureTypeLibrary) new ResourceSetImpl()
						.getResource(from.getURI(), true).getContents().get(0);
			}
		};
	}
}
