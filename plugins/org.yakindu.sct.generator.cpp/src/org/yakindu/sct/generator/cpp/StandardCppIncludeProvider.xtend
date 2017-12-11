package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import java.util.List
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.IncludeProvider
import org.yakindu.sct.generator.c.StandardIncludeProvider
import org.yakindu.sct.model.sexec.ExecutionFlow

class StandardCppIncludeProvider extends StandardIncludeProvider implements IncludeProvider {

	@Inject protected extension CppNaming
	@Inject protected extension Navigation

	override getIncludes(ExecutionFlow it, List<CharSequence> includes,
		extension IGenArtifactConfigurations artifactConfigs) {
		super.getIncludes(it, includes, artifactConfigs)
		includes += '''#include "«(statemachineInterface.h).relativeTo(module.h)»"'''
		if (timed)
			includes += '''#include "«(timedStatemachineInterface.h).relativeTo(module.h)»"'''
		includes

	}

}
