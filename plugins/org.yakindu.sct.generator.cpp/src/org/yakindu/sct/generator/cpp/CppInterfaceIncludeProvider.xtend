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
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import java.util.List
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.IncludeProvider
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

class CppInterfaceIncludeProvider implements IncludeProvider {

	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions

	override getIncludes(ExecutionFlow it, List<CharSequence> includes,
		extension IGenArtifactConfigurations artifactConfigs) {
		includes += '''#include "«(statemachineInterface.h).relativeTo(module.h)»"'''
		if (timed)
			includes += '''#include "«(timedStatemachineInterface.h).relativeTo(module.h)»"'''
		includes
	}

}
