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
package org.yakindu.sct.generator.csharp.features;

/**
 * 
 * @author muelder
 * @author terfloth
 * 
 */
public interface ICSharpFeatureConstants {

	public static final String LIBRARY_NAME = "C# Generator";

	public static final String NAMING_FEATURE = "Naming";
	
	public static final String NAMESPACE_NAME = "namespaceName";

	public static final String IMPLEMENTATION_SUFFIX = "implementationSuffix";
	
	public static final String GENERAL_FEATURES = "GeneralFeatures";
	
	public static final String CREATE_EVENTBASEDSTATEMACHINE = "EventBasedStatemachine";
	
	public static final String RUNTIME_SERVICE = "RuntimeService";
	
	public static final String TIMER_SERVICE = "TimerService";
	
	public static final String INTERFACE_OBSERVER_SUPPORT = "InterfaceObserverSupport";
	
	public static final String GENERIC_INTERFACE_SUPPORT = "GenericInterfaceSupport";
	
	public static final String STATEMACHINE_FACTORY_SUPPORT = "StatemachineFactorySupport";
	
	public static final String USE_CSHARP_INT_FOR_INTEGER = "UseCSharpIntForInteger";
	
	/* Constants related to the RunnableWrapper feature */
	
	public static final String RUNNABLE_WRAPPER = "RunnableWrapper";
	
	public static final String NAME_PREFIX = "namePrefix";
	
	public static final String NAME_SUFFIX = "nameSuffix";
	
	
	
	
	public static final String[] CSHARP_KEYWORDS = { 
			"abstract", "as", "base", "bool", "break", "byte", 
			"case", "catch", "char", "checked", "class", "const", 
			"continue", "default", "delegate", "do", "double", "else", 
			"enum", "event", "explicit", "extern", "false", "finally", 
			"fixed", "float", "for", "foreach", "goto", "if", 
			"implicit", "in", "int", "interface", "internal", "is", 
			"lock", "long", "namespace", "new", "null", "object", 
			"operator", "out", "override", "params", "private", "protected", 
			"public", "readonly", "ref", "return", "sbyte", "sealed", 
			"short", "sizeof", "stackalloc", "static", "string", "struct", 
			"switch", "this", "throw", "true", "try", "typeof", 
			"uint", "ulong", "unchecked", "unsafe", "ushort", "using", 
			"virtual", "void", "volatile", "while" };
}
