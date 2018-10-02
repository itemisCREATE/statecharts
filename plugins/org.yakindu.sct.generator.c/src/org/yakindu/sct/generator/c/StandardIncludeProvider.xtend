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
package org.yakindu.sct.generator.c

import com.google.inject.Inject
import java.util.List
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow

class StandardIncludeProvider implements IncludeProvider {
	@Inject protected extension Naming cNaming
	
	override getIncludes(ExecutionFlow it, List<CharSequence> includes, extension IGenArtifactConfigurations artifactConfigs) {
		includes += '''#include "«(typesModule.h).relativeTo(module.h)»"'''
		includes
	}
	
}