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