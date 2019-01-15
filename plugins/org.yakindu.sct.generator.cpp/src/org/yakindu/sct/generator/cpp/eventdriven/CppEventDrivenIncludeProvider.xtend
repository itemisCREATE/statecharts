/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import java.util.List
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.IncludeProvider
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

/**
 * @author robert rudi
 * 
 * Adds required include for the C++ event driven case.
 */
class CppEventDrivenIncludeProvider implements IncludeProvider {
	
	@Inject protected extension EventDrivenPredicate
	
	override getIncludes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		val List<CharSequence> includes = newArrayList
		if (needsQueues) {
			includes += "#include <deque>"
		}
		includes
	}
	
}