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

import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.generator.core.library.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorEntry;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author terfloth - extensions
 * 
 */
public class JavaFeatureValueProvider extends AbstractDefaultFeatureValueProvider {

	private static final String PACKAGE_NAME_REGEX = "([a-zA-Z_][a-zA-Z0-9_\\.]*)+[a-zA-Z_][a-zA-Z0-9_]*";
	private static final String TYPE_NAME_REGEX = "[a-zA-Z_$][a-zA-Z0-9_$]*";

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
}
