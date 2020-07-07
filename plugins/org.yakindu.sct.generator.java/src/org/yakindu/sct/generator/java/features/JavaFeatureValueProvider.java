/**
 * Copyright (c) 2011-2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java.features;

import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.API_PACKAGE;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.BASE_PACKAGE;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.BASE_PACKAGE_DEFAULT;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.FEATURE_RUNNABLE_WRAPPER;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.FEATURE_SYCHRONIZED_WRAPPER;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.JAVA_KEYWORDS;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.LIBRARY_NAME;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.LIBRARY_PACKAGE;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.LIBRARY_PACKAGE_DEFAULT;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.RUNNABLE_WRAPPER_NAME_PREFIX_DEFAULT;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.RUNNABLE_WRAPPER_NAME_SUFFIX_DEFAULT;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.SYCHRONIZED_WRAPPER_NAME_PREFIX_DEFAULT;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.SYCHRONIZED_WRAPPER_NAME_SUFFIX_DEFAULT;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.TYPE_NAME;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.VALUE_NAME_PREFIX;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.VALUE_NAME_SUFFIX;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.generator.core.library.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.generator.java.GenmodelEntries;
import org.yakindu.sct.generator.java.util.StringHelper;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author terfloth - extensions
 * 
 */
public class JavaFeatureValueProvider extends AbstractDefaultFeatureValueProvider {

	private static final String PACKAGE_NAME_REGEX = "([a-zA-Z_][a-zA-Z0-9_\\.]*)+[a-zA-Z_][a-zA-Z0-9_]*";
	private static final String TYPE_NAME_REGEX = "[a-zA-Z_$][a-zA-Z0-9_$]*";

	@Inject private GenmodelEntries entries;
	@Inject private StringHelper helper;
	
	@Override
	protected void setDefaultValue(FeatureType featureType, FeatureParameterValue parameterValue,
			EObject contextElement) {
		if (parameterValue.getParameter().getName().equals(BASE_PACKAGE)) {
			parameterValue.setValue(BASE_PACKAGE_DEFAULT);
		} else if (parameterValue.getParameter().getName().equals(LIBRARY_PACKAGE)) {
			parameterValue.setValue(LIBRARY_PACKAGE_DEFAULT);
		} else if (parameterValue.getParameter().getName().equals(TYPE_NAME)) {
			if (contextElement instanceof GeneratorEntry) {
				EObject element = ((GeneratorEntry) contextElement).getElementRef();
				if (element instanceof NamedElement) {
					parameterValue.setValue(((NamedElement) element).getName());
				}
			}
		} else if (featureType.getName().equals(FEATURE_RUNNABLE_WRAPPER)) {
			if (parameterValue.getParameter().getName().equals(VALUE_NAME_PREFIX)) {
				parameterValue.setValue(RUNNABLE_WRAPPER_NAME_PREFIX_DEFAULT);
			} else if (parameterValue.getParameter().getName().equals(VALUE_NAME_SUFFIX)) {
				parameterValue.setValue(RUNNABLE_WRAPPER_NAME_SUFFIX_DEFAULT);
			}
		} else if (featureType.getName().equals(FEATURE_SYCHRONIZED_WRAPPER)) {
			if (parameterValue.getParameter().getName().equals(VALUE_NAME_PREFIX)) {
				parameterValue.setValue(SYCHRONIZED_WRAPPER_NAME_PREFIX_DEFAULT);
			} else if (parameterValue.getParameter().getName().equals(VALUE_NAME_SUFFIX)) {
				parameterValue.setValue(SYCHRONIZED_WRAPPER_NAME_SUFFIX_DEFAULT);
			}
		}
	}

	public boolean isProviderFor(FeatureTypeLibrary library) {
		return library.getName().equals(LIBRARY_NAME);
	}

	public IStatus validateParameterValue(FeatureParameterValue value) {
		String name = value.getParameter().getName();
		if (BASE_PACKAGE.equals(name) || LIBRARY_PACKAGE.equals(name) || API_PACKAGE.equals(name)) {
			if (value.getStringValue().isEmpty()) {
				return Status.OK_STATUS;
			}
			if (!value.getStringValue().matches(PACKAGE_NAME_REGEX)) {
				return error("Invalid package name");
			}
			// Filter out java keywords
			for (String keyword : Arrays.asList(JAVA_KEYWORDS)) {
				Pattern pattern = Pattern.compile("(?:^|\\.)" + keyword + "(?:$|\\.)");
				Matcher matcher = pattern.matcher(value.getStringValue());
				while (matcher.find()) {
					return error("Java keyword '" + matcher.group() + "' is not allowed in package names.");
				}
			}
		}
		if (TYPE_NAME.equals(name)) {
			if (!value.getStringValue().matches(TYPE_NAME_REGEX)) {
				return error("Invalid value");
			}
			for (String keyword : Arrays.asList(JAVA_KEYWORDS)) {
				Pattern pattern = Pattern.compile("^" + keyword + "$");
				Matcher matcher = pattern.matcher(value.getStringValue());
				while (matcher.find()) {
					return error("Java keyword '" + matcher.group() + "' is not allowed as type name.");
				}
			}

		}
		return Status.OK_STATUS;
	}
	
	@Override
	public IStatus validateGeneratorEntry(GeneratorEntry entry) {
		if (generatesToDefaultPackage(entry)) {
			return warning("Generation into default package is discouraged. Use a statechart namespace, or set the Naming.basePackage parameter.");
		}
		if (generatesLowerCaseType(entry)) {
			return warning("Generation of types starting with a lowercase letter is discouraged. Rename the statechart, or set the Naming.typeName parameter.");
		}
		return Status.OK_STATUS;
	}

	private boolean generatesLowerCaseType(GeneratorEntry entry) {
		Statechart statechart = entries.getStatechart(entry);
		if (statechart == null) 
			return false;
		
		String sctName = statechart.getName();
		String typeName = entries.getTypeName(entry);

		return (typeName == null && helper.isLowercase(sctName)) || (typeName != null && helper.isLowercase(typeName));
	}
	
	private boolean generatesToDefaultPackage(GeneratorEntry entry) {
		return entries.getBasePackage(entry).isEmpty();
	}
}
