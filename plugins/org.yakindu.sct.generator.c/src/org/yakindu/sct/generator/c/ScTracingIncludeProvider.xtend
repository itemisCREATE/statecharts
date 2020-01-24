package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow

class ScTracingIncludeProvider implements IncludeProvider {
	
	@Inject protected extension Naming cNaming
	
	override getIncludes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		newArrayList('''#include "«(tracingModule.h).relativeTo(module.h)»"''')
	}
	
}