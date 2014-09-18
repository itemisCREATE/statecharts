/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp.features;

/**
 * 
 * @author Markus Muehlbrandt - Initial contribution and API
 * 
 */
public interface CPPFeatureConstants {
	
	public static enum Visibility {
		PRIVATE,
		PROTECTED
	}
	
	public static final String LIBRARY_NAME = "CPP Generator";
	
	public static final String FEATURE_GENERATOR_OPTIONS = "GeneratorOptions";
	
	public static final String PARAMETER_INNER_FUNCTION_VISIBILITY = "innerFunctionVisibility";
}
