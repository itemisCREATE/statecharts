/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Keywords {

	private static Set<String> JAVA_KEYWORD_SET = new HashSet<>();
	private static Set<String> STATEMACHICHNE_KEYWORD_SET = new HashSet<>();
	private static Set<String> STATEMACHINE_INTERFACE_KEYWORD_SET = new HashSet<>();
	private static Set<String> STATEMACHINE_METHOD_SET = new HashSet<>();

	public static final String[] JAVA_KEYWORDS = { "abstract", "assert", "boolean", "break", "byte", "case", "catch",
			"char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "false",
			"final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface",
			"long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static",
			"strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try",
			"void", "volatile", "while" };

	public static final String[] STATEMACHINE_IDENTIFIERS = { "initialized", "stateVector", "nextStateIndex", "timer",
			"getTimer", "setTimer", "timeEvents", "operationCallback" };

	public static final String[] STATEMACHINE_INTERFACE_IDENTIFIERS = { "listeners", "operationCallback" };

	public static final String[] STATEMACHINE_METHODS = { "getTimer", "setTimer", "getClass" };

	public static final Set<String> javaKeywords() {
		if (JAVA_KEYWORD_SET.isEmpty()) {
			JAVA_KEYWORD_SET.addAll(Arrays.asList(JAVA_KEYWORDS));
			JAVA_KEYWORD_SET = Collections.unmodifiableSet(JAVA_KEYWORD_SET);
		}
		return JAVA_KEYWORD_SET;
	}

	public static final Set<String> statemachineIdentifiers() {
		if (STATEMACHICHNE_KEYWORD_SET.isEmpty()) {
			STATEMACHICHNE_KEYWORD_SET.addAll(Arrays.asList(STATEMACHINE_IDENTIFIERS));
			STATEMACHICHNE_KEYWORD_SET = Collections.unmodifiableSet(STATEMACHICHNE_KEYWORD_SET);
		}
		return STATEMACHICHNE_KEYWORD_SET;
	}

	public static final Set<String> statemachineInterfaceIdentifiers() {
		if (STATEMACHINE_INTERFACE_KEYWORD_SET.isEmpty()) {
			STATEMACHINE_INTERFACE_KEYWORD_SET.addAll(Arrays.asList(STATEMACHINE_INTERFACE_IDENTIFIERS));
			STATEMACHINE_INTERFACE_KEYWORD_SET = Collections.unmodifiableSet(STATEMACHINE_INTERFACE_KEYWORD_SET);
		}
		return STATEMACHINE_INTERFACE_KEYWORD_SET;
	}
	
	public static final Set<String> statemachineMethods() {
		if (STATEMACHINE_METHOD_SET.isEmpty()) {
			STATEMACHINE_METHOD_SET.addAll(Arrays.asList(STATEMACHINE_METHODS));
			STATEMACHINE_METHOD_SET = Collections.unmodifiableSet(STATEMACHINE_METHOD_SET);
		}
		return STATEMACHINE_METHOD_SET;
	}
}
