package org.yakindu.sct.generator.cpp.eventdriven

import java.util.List
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.IncludeProvider
import org.yakindu.sct.model.sexec.ExecutionFlow

final class EventDrivenCppIncludeProviderModule implements IncludeProvider {

	override getIncludes(ExecutionFlow it, List<CharSequence> includes, extension IGenArtifactConfigurations artifactConfigs) {
		includes += "#include <deque>"
		includes
	}
	
}