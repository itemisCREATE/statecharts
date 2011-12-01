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

/**
 * 
 * @author muelder
 * 
 */
public interface IJavaFeatureConstants {

	public static final String LIBRARY_NAME = "Java Generator";

	public static final String NAMING_FEATURE = "Naming";

	public static final String BASE_PACKAGE = "basePackage";

	public static final String IMPLEMENTATION_SUFFIX = "implementationSuffix";
	
	public static final String[] JAVA_KEYWORDS = { "abstract", "assert",
		"boolean", "break", "byte", "case", "catch", "char", "class",
		"const", "continue", "default", "do", "double", "else", "enum",
		"extens", "final", "finally", "float", "for", "goto", "if",
		"implements", "import", "instanceof", "int", "interface", "long",
		"native", "new", "package", "private", "protected", "public",
		"return", "short", "static", "strictfp", "super", "switch",
		"synchronized", "this", "throw", "throws", "transient", "try",
		"void", "volatile", "while" };
}
