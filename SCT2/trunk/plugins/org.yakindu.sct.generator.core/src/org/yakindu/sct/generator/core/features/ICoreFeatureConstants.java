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
package org.yakindu.sct.generator.core.features;

/**
 * Core Feature Constants defined by this plugin
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ICoreFeatureConstants {

	public static final String LIBRARY_NAME = "Core";

	public static final String OUTLET_FEATURE = "Outlet";
	public static final String OUTLET_FEATURE_TARGET_PROJECT = "targetProject";
	public static final String OUTLET_FEATURE_TARGET_FOLDER = "targetFolder";

	public static final String DEBUG_FEATURE = "Debug";
	public static final String DEBUG_FEATURE_DUMP_SEXEC = "dumpSexec";

	public static final String FUNCTION_INLINING_FEATURE = "FunctionInlining";

	public static final String FUNCTION_INLINING_FEATURE_INLINE_REACTIONS = "inlineReactions";
	public static final String FUNCTION_INLINING_FEATURE_INLINE_ENTRY_ACTIONS = "inlineEntryActions";
	public static final String FUNCTION_INLINING_FEATURE_INLINE_ENTER_SEQUENCES = "inlineEnterSequences";
	public static final String FUNCTION_INLINING_FEATURE_INLINE_EXIT_ACTIONS = "inlineExitActions";
	public static final String FUNCTION_INLINING_FEATURE_INLINE_EXIT_SEQUENCES = "inlineExitSequences";
	public static final String FUNCTION_INLINING_FEATURE_INLINE_CHOICES = "inlineChoices";
	public static final String FUNCTION_INLINING_FEATURE_INLINE_ENTRIES = "inlineEntries";
	public static final String FUNCTION_INLINING_FEATURE_INLINE_ENTER_REGION = "inlineEnterRegion";
	public static final String FUNCTION_INLINING_FEATURE_INLINE_EXIT_REGION = "inlineExitRegion";

	public static final String LICENSE_HEADER = "LicenseHeader";
	public static final String LICENSE_TEXT = "licenseText";
}
