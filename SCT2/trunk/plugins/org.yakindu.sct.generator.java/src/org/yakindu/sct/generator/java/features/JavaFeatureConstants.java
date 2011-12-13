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
package org.yakindu.sct.generator.java.features;

import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.LICENSE_HEADER;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.LICENSE_TEXT;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author muehlbrandt
 */
public final class JavaFeatureConstants implements IJavaFeatureConstants {
	
	public static final String getNamingFeature() {
		return NAMING_FEATURE;
	}
	
	public static final String getBasePackage() {
		return BASE_PACKAGE;
	}
	
	public static final String getImplementationSuffix() {
		return IMPLEMENTATION_SUFFIX;
	}
	
	public static final String getLicenseHeader() {
		return LICENSE_HEADER;
	}
	
	public static final String getLicenseText() {
		return LICENSE_TEXT;
	}
	
	public static final String getGeneralFeature() {
		return GENERAL_FEATURES;
	}
	
	public static final String getEventBasedStatemachine() {
		return CREATE_EVENTBASEDSTATEMACHINE;
	}
	
	public static final String getRuntimeService() {
		return RUNTIME_SERVICE;
	}
	
	public static final String getTimerService() {
		return TIMER_SERVICE;
	}
	
	public static final String getInterfaceObserverSupport() {
		return INTERFACE_OBSERVER_SUPPORT;
	}
	
	public static final String getValidStatemachineName(String name) {
		//remove whitespaces;
		String newName = name.replace(" ", "").toLowerCase();
		for (String keyword : Arrays.asList(JAVA_KEYWORDS)) {				
			Pattern pattern= Pattern.compile("^" +keyword+"$");
			Matcher matcher = pattern.matcher(name);
			if  (matcher.find()) {
				newName += "Statemachine";
			}
		}
		return newName;
	}
}