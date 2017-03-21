/**
 * Copyright (c) 2011, 2015 Committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Holger Willebrandt - Initial API and implementation
 *  Markus Mühlbrandt  - Added 'IdentifierSettings' feature and related parameters
 *  Alexander Nyßen    - Added 'Tracing' feature and renamed constants
 * 
 */
package org.yakindu.sct.generator.c.features;

/**
 * Defines constants to refer to features and parameters within C code generator
 * generator model.
 * 
 * @author Holger Willebrandt
 * @author Markus Mühlbrandt
 * @author Alexander Nyßen
 */
public interface ICFeatureConstants {

	public static final String LIBRARY_NAME = "C Generator";

	// TODO: Change value of FEATURE_NAMING to 'Naming' and extract it to a
	// general code generator feature (see issue #267).
	public static final String FEATURE_NAMING = "IdentifierSettings";

	public static final String PARAMETER_NAMING_MODULE_NAME = "moduleName";

	public static final String PARAMETER_NAMING_STATEMACHINE_PREFIX = "statemachinePrefix";

	public static final String PARAMETER_NAMING_MAX_IDENTIFIER_LENGTH = "maxIdentifierLength";

	public static final String PARAMETER_NAMING_SEPARATOR = "separator";

	public static final String FEATURE_TRACING = "Tracing";

	public static final String PARAMETER_TRACING_ENTER_STATE = "enterState";
	
	public static final String PARAMETER_TRACING_EXIT_STATE = "exitState";
	
	public static final String FEATURE_INCLUDES = "Includes";
	
	public static final String PARAMETER_INCLUDES_USE_RELATIVE_PATHS = "useRelativePaths";
}
