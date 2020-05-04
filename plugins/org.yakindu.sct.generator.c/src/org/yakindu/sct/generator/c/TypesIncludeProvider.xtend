package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow

class TypesIncludeProvider implements IncludeProvider {

	@Inject protected extension Naming

	override getIncludes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		newArrayList('''#include "«(typeModule.h).relativeTo(module.h)»"''')
	}

}
