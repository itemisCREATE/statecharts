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
package org.yakindu.sct.types.generator.java;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class Keywords {

	public static Set<String> JAVA_KEYWORD_SET = ImmutableSet.of("abstract", "assert", "boolean", "break", "byte",
			"case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends",
			"false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int",
			"interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return",
			"short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient",
			"true", "try", "void", "volatile", "while");

	public static Set<String> STATEMACHICHNE_KEYWORD_SET = ImmutableSet.of("initialized", "stateVector",
			"nextStateIndex", "timer", "getTimer", "setTimer", "timeEvents", "operationCallback");

	public static Set<String> STATEMACHINE_INTERFACE_KEYWORD_SET = ImmutableSet.of("listeners", "operationCallback");

	public static Set<String> STATEMACHINE_METHOD_SET = ImmutableSet.of("getTimer", "setTimer", "getClass");

}
