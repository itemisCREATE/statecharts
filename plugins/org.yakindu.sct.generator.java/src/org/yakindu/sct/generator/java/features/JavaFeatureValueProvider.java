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
import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author terfloth - extensions
 * 
 */
public class JavaFeatureValueProvider extends
		AbstractDefaultFeatureValueProvider {

	private static final String PACKAGE_NAME_REGEX = "([a-zA-Z_][a-zA-Z0-9_]*\\.)+[a-zA-Z_][a-zA-Z0-9_]*";
	private static final String SUFFIX_REGEX = "[a-zA-Z0-9_]*";

	@Override
	protected void setDefaultValue(FeatureParameterValue parameterValue,
			EObject contextElement) {
		if (parameterValue.getParameter().getName().equals(BASE_PACKAGE)) {
			parameterValue.setValue("org.yakindu.sct");
					//+ JavaFeatureConstants.getValidStatemachineName(statechart.getName()));
		} else if (parameterValue.getParameter().getName()
				.equals(IMPLEMENTATION_SUFFIX)) {
			parameterValue.setValue("impl");
		} else if (parameterValue.getParameter().getName().equals(NAME_PREFIX)) {
			parameterValue.setValue("Runnable");
		} else if (parameterValue.getParameter().getName().equals(NAME_SUFFIX)) {
			parameterValue.setValue("");
		}
	}

	public boolean isProviderFor(FeatureTypeLibrary library) {
		return library.getName().equals(LIBRARY_NAME);
	}

	public IStatus validateParameterValue(FeatureParameterValue value) {
		String name = value.getParameter().getName();
		if (BASE_PACKAGE.equals(name)) {
			if (!value.getStringValue().matches(PACKAGE_NAME_REGEX)) {
				return error("Invalid package name");
			}
			// Filter out java keywords
			for (String keyword : Arrays.asList(JAVA_KEYWORDS)) {
				Pattern pattern = Pattern.compile("(?:^|\\.)" + keyword
						+ "(?:$|\\.)");
				Matcher matcher = pattern.matcher(value.getStringValue());
				while (matcher.find()) {
					return error("Java keyword '" + matcher.group()
							+ "' is not allowed in package names.");
				}
			}
		}
		if (IMPLEMENTATION_SUFFIX.equals(name)) {
			if (!value.getStringValue().matches(SUFFIX_REGEX)) {
				return error("Invalid value");
			}
			for (String keyword : Arrays.asList(JAVA_KEYWORDS)) {
				Pattern pattern = Pattern.compile("^" + keyword + "$");
				Matcher matcher = pattern.matcher(value.getStringValue());
				while (matcher.find()) {
					return error("Java keyword '" + matcher.group()
							+ "' is not allowed as suffix.");
				}
			}

		}
		return Status.OK_STATUS;
	}
}
