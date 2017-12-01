package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IncludeProvider
import org.yakindu.sct.generator.cpp.StandardCppIncludeProvider
import org.yakindu.sct.model.sexec.ExecutionFlow
import java.util.List
import org.yakindu.sct.generator.c.IGenArtifactConfigurations

/**
 * @author robert rudi
 * Combines the standard includes for C++ with the includes for the C++ event driven case.
 */
class EventDrivenCppIncludeProvider extends StandardCppIncludeProvider implements IncludeProvider {
	@Inject protected EventDrivenCppIncludeProviderModule eventDrivenIncludes
	
	override getIncludes(ExecutionFlow it, List<CharSequence> includes, extension IGenArtifactConfigurations artifactConfigs) {
		super.getIncludes(it, includes, artifactConfigs)
		eventDrivenIncludes.getIncludes(it, includes, artifactConfigs)
		includes
	}
	
}