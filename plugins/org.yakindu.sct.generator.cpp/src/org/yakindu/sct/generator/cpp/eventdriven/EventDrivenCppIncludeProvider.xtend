package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import java.util.List
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.IncludeProvider
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

/**
 * @author robert rudi
 * Combines the standard includes for C++ with the includes for the C++ event driven case.
 */
class EventDrivenCppIncludeProvider implements IncludeProvider {
	
	@Inject protected extension SExecExtensions
	
	override getIncludes(ExecutionFlow it, List<CharSequence> includes, extension IGenArtifactConfigurations artifactConfigs) {
		if(hasLocalEvents) {
			includes += "#include <deque>"
		}
		includes
	}
	
}