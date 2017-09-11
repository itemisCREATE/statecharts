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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.base.types.validation.TypeValidator;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor;
import org.yakindu.sct.generator.core.extensions.ILibraryDescriptor;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.generator.core.library.IDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.DeprecatableElement;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.ParameterTypes;
import org.yakindu.sct.model.sgen.PropertyDefinition;
import org.yakindu.sct.model.sgen.SGenPackage;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenJavaValidator extends AbstractSGenJavaValidator {

	// Error messages
	public static final String MISSING_REQUIRED_PARAMETER = "Missing required parameter.";
	public static final String MISSING_REQUIRED_FEATURE = "Missing required feature.";
	public static final String DUPLICATE_PARAMETER = "Duplicate parameter.";
	public static final String DUPLICATE_FEATURE = "Duplicate feature.";
	public static final String UNKOWN_GENERATOR = "Unknown generator.";
	public static final String UNKNOWN_CONTENT_TYPE = "Unknown content type '";
	public static final String DEPRECATED = "Element is depricated.";
	public static final String EMPTY_SGEN = ".sgen file does not contain any entries.";
	// Failure codes
	public static final String CODE_REQUIRED_FEATURE = "code_req_feature.";

	@Inject
	private Injector injector;
	@Inject
	private ITypeSystemInferrer inferrer;
	@Inject
	protected TypeValidator typeValidator;
	@Inject
	protected ITypeSystem typesystem;

	@Check(CheckType.FAST)
	public void checkInitialValue(PropertyDefinition property) {
		if (property.getType() == null || property.getType().eIsProxy())
			return;
		InferenceResult expressionResult = inferrer.infer(property.getInitialValue(), this);
		typeValidator.assertAssignable(InferenceResult.from(property.getType()), expressionResult, null, this);
	}

	@Check
	public void checkContentType(GeneratorEntry entry) {
		GeneratorModel generatorModel = EcoreUtil2.getContainerOfType(entry, GeneratorModel.class);
		IGeneratorDescriptor descriptor = GeneratorExtensions.getGeneratorDescriptor(generatorModel.getGeneratorId());
		if (descriptor == null)
			return;
		String contentType = entry.getContentType();
		if (contentType == null || contentType.trim().length() == 0) {
			return;
		}
		if (!contentType.equals(descriptor.getContentType())) {
			error(UNKNOWN_CONTENT_TYPE + contentType + "'", SGenPackage.Literals.GENERATOR_ENTRY__CONTENT_TYPE);
		}
	}

	@Check
	public void checkParameterValueType(final FeatureParameterValue parameterValue) {
		if (parameterValue == null || parameterValue.getExpression() == null)
			return;
		InferenceResult valueResult = inferrer.infer(parameterValue.getExpression());
		ParameterTypes parameterType = parameterValue.getParameter().getParameterType();
		typeValidator.assertAssignable(InferenceResult.from(mapType(parameterType)), valueResult, null, this);
	}

	public Type mapType(ParameterTypes type) {
		switch (type) {
		case BOOLEAN:
			return typesystem.getType(ITypeSystem.BOOLEAN);
		case INTEGER:
			return typesystem.getType(ITypeSystem.INTEGER);
		case FLOAT:
			return typesystem.getType(ITypeSystem.REAL);
		case STRING:
			return typesystem.getType(ITypeSystem.STRING);
		default:
			return typesystem.getType(ITypeSystem.ANY);
		}
	}

	@Check
	public void checkParameterValue(final FeatureParameterValue value) {
		if (value.getExpression() == null || value.getExpression() == null)
			return;
		GeneratorModel model = (GeneratorModel) EcoreUtil2.getRootContainer(value);

		IGeneratorDescriptor generatorDescriptor = GeneratorExtensions.getGeneratorDescriptor(model.getGeneratorId());

		IDefaultFeatureValueProvider provider = LibraryExtensions.getDefaultFeatureValueProvider(
				generatorDescriptor.getLibraryIDs(), value.getParameter().getFeatureType().getLibrary());
		injector.injectMembers(provider);
		IStatus status = provider.validateParameterValue(value);
		createMarker(status);
	}

	private void createMarker(IStatus status) {
		switch (status.getSeverity()) {
		case IStatus.ERROR:
			super.error(status.getMessage(), SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
			break;
		case IStatus.WARNING:
			super.warning(status.getMessage(), SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
		}
	}

	@Check
	public void checkGeneratorExists(GeneratorModel model) {
		IGeneratorDescriptor descriptor = GeneratorExtensions.getGeneratorDescriptor(model.getGeneratorId());
		if (descriptor == null) {
			error(String.format(UNKOWN_GENERATOR + " %s!", model.getGeneratorId()),
					SGenPackage.Literals.GENERATOR_MODEL__GENERATOR_ID);
		}
	}

	@Check
	public void checkEntriesExist(GeneratorModel model) {
		if (model.getEntries() == null || model.getEntries().isEmpty()) {
			warning(EMPTY_SGEN, null);
		}
	}

	@Check
	public void checkDuplicateGeneratorEntryFeature(final FeatureConfiguration config) {
		GeneratorEntry entry = (GeneratorEntry) config.eContainer();
		Iterable<FeatureConfiguration> filter = Iterables.filter(entry.getFeatures(),
				new Predicate<FeatureConfiguration>() {
					public boolean apply(FeatureConfiguration input) {
						return (input.getType().getName().equals(config.getType().getName()));
					}
				});
		if (Iterables.size(filter) > 1) {
			error(DUPLICATE_FEATURE, SGenPackage.Literals.FEATURE_CONFIGURATION__TYPE);
		}

	}

	@Check
	public void checkDuplicateFeatureParameter(final FeatureParameterValue value) {
		FeatureConfiguration entry = (FeatureConfiguration) value.eContainer();
		Iterable<FeatureParameterValue> filter = Iterables.filter(entry.getParameterValues(),
				new Predicate<FeatureParameterValue>() {
					public boolean apply(FeatureParameterValue input) {
						return (input.getParameter().getName().equals(value.getParameter().getName()));
					}
				});
		if (Iterables.size(filter) > 1) {
			error(DUPLICATE_PARAMETER, SGenPackage.Literals.FEATURE_PARAMETER_VALUE__PARAMETER);
		}
	}

	@Check
	public void checkRequiredFeatures(GeneratorEntry entry) {
		GeneratorModel model = (GeneratorModel) EcoreUtil2.getRootContainer(entry);

		IGeneratorDescriptor generatorDescriptor = GeneratorExtensions.getGeneratorDescriptor(model.getGeneratorId());

		Iterable<ILibraryDescriptor> libraryDescriptors = LibraryExtensions
				.getLibraryDescriptors(generatorDescriptor.getLibraryIDs());

		Iterable<FeatureType> requiredFeatures = filter(
				concat(transform(transform(libraryDescriptors, getFeatureTypeLibrary()), getFeatureTypes())),
				isRequired());
		List<String> configuredTypes = Lists.newArrayList();
		for (FeatureConfiguration featureConfiguration : entry.getFeatures()) {
			configuredTypes.add(featureConfiguration.getType().getName());
		}
		for (FeatureType featureType : requiredFeatures) {
			if (!configuredTypes.contains(featureType.getName()))
				error(String.format(MISSING_REQUIRED_FEATURE + " %s", featureType.getName()),
						SGenPackage.Literals.GENERATOR_ENTRY__ELEMENT_REF, CODE_REQUIRED_FEATURE,
						featureType.getName());
		}
	}

	@Check
	public void checkDeprecatedFeatures(GeneratorEntry entry) {
		Iterable<FeatureConfiguration> features = entry.getFeatures();
		Iterable<FeatureType> deprecatedFeatures = filter(transform(features, getFeatureType()), isDeprecated());
		for (FeatureType feature : deprecatedFeatures) {
			warning(String.format(DEPRECATED + " %s : %s", feature.getName(), feature.getComment()),
					SGenPackage.Literals.GENERATOR_ENTRY__ELEMENT_REF, feature.getName());
		}
	}

	@Check
	public void checkRequiredParameters(FeatureConfiguration configuration) {
		GeneratorModel model = (GeneratorModel) EcoreUtil2.getRootContainer(configuration);

		IGeneratorDescriptor generatorDescriptor = GeneratorExtensions.getGeneratorDescriptor(model.getGeneratorId());

		Iterable<ILibraryDescriptor> libraryDescriptors = LibraryExtensions
				.getLibraryDescriptors(generatorDescriptor.getLibraryIDs());

		Iterable<String> requiredParameters = transform(filter(concat(transform(
				filter(concat(transform(transform(libraryDescriptors, getFeatureTypeLibrary()), getFeatureTypes())),
						hasName(configuration.getType().getName())),
				getParameter())), isRequiredParamter()), getName());

		List<String> configuredParameters = Lists.newArrayList();

		for (FeatureParameterValue featureParameterValue : configuration.getParameterValues()) {
			configuredParameters.add(featureParameterValue.getParameter().getName());
		}
		for (String string : requiredParameters) {
			if (!configuredParameters.contains(string))
				error(String.format(MISSING_REQUIRED_PARAMETER + " %s", string),
						SGenPackage.Literals.FEATURE_CONFIGURATION__TYPE);
		}
	}

	@Check
	public void checkDeprecatedParameters(GeneratorEntry entry) {
		Iterable<FeatureParameter> deprecatedParameters = filter(
				concat(transform(transform(entry.getFeatures(), getFeatureType()), getParameter())), isDeprecated());
		for (FeatureParameter parameter : deprecatedParameters) {
			warning(String.format(DEPRECATED + " %s : %s", parameter.getName(), parameter.getComment()),
					SGenPackage.Literals.GENERATOR_ENTRY__ELEMENT_REF, parameter.getName());
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

	private Predicate<DeprecatableElement> isDeprecated() {
		return new Predicate<DeprecatableElement>() {
			public boolean apply(DeprecatableElement input) {
				return input.isDeprecated();
			}
		};
	}

	private Function<FeatureType, Iterable<FeatureParameter>> getParameter() {
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

	private static Function<ILibraryDescriptor, FeatureTypeLibrary> getFeatureTypeLibrary() {
		return new Function<ILibraryDescriptor, FeatureTypeLibrary>() {

			public FeatureTypeLibrary apply(ILibraryDescriptor from) {
				return (FeatureTypeLibrary) new ResourceSetImpl().getResource(from.getURI(), true).getContents().get(0);
			}
		};
	}

	private static Function<FeatureConfiguration, FeatureType> getFeatureType() {
		return new Function<FeatureConfiguration, FeatureType>() {
			public FeatureType apply(FeatureConfiguration input) {
				return input.getType();
			}
		};
	}
}
