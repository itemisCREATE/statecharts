package org.yakindu.sct.generator.cpp.providers.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.providers.ISourceProvider
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate

class UsingNamespaceProvider implements ISourceProvider {
	@Inject extension EventNaming
	@Inject extension EventDrivenPredicate
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		if(!needsEventNamespace) return ''''''
		'''using namespace «eventNamespaceName»;'''
	}
}