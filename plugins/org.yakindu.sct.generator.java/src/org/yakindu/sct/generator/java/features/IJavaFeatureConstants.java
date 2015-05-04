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

/**
 * 
 * @author muelder
 * @author terfloth
 * 
 */
public interface IJavaFeatureConstants {

	public static final String LIBRARY_NAME = "Java Generator";

	public static final String NAMING_FEATURE = "Naming";

	public static final String BASE_PACKAGE = "basePackage";

	public static final String IMPLEMENTATION_SUFFIX = "implementationSuffix";
	
	public static final String GENERAL_FEATURES = "GeneralFeatures";
	
	public static final String CREATE_EVENTBASEDSTATEMACHINE = "EventBasedStatemachine";
	
	public static final String RUNTIME_SERVICE = "RuntimeService";
	
	public static final String TIMER_SERVICE = "TimerService";
	
	public static final String INTERFACE_OBSERVER_SUPPORT = "InterfaceObserverSupport";
	
	public static final String GENERIC_INTERFACE_SUPPORT = "GenericInterfaceSupport";
	
	public static final String STATEMACHINE_FACTORY_SUPPORT = "StatemachineFactorySupport";
	
	public static final String USE_JAVA_INT_FOR_INTEGER = "UseJavaIntForInteger";
	
	/* Constants related to the RunnableWrapper feature */
	
	public static final String RUNNABLE_WRAPPER = "RunnableWrapper";
	
	public static final String NAME_PREFIX = "namePrefix";
	
	public static final String NAME_SUFFIX = "nameSuffix";
	
	
	
	
	public static final String[] JAVA_KEYWORDS = { "abstract", "assert",
		"boolean", "break", "byte", "case", "catch", "char", "class",
		"const", "continue", "default", "do", "double", "else", "enum",
		"extends", "false", "final", "finally", "float", "for", "goto", "if",
		"implements", "import", "instanceof", "int", "interface", "long",
		"native", "new", "null", "package", "private", "protected", "public",
		"return", "short", "static", "strictfp", "super", "switch",
		"synchronized", "this", "throw", "throws", "transient", "true" , "try",
		"void", "volatile", "while" };
}
