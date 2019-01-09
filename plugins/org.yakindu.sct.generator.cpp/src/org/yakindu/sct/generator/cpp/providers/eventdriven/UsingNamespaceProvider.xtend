package org.yakindu.sct.generator.cpp.providers.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.files.StatemachineImplementation
import org.yakindu.sct.generator.cpp.providers.GeneratorContribution
import org.yakindu.sct.generator.cpp.providers.ISourceFragment
import org.yakindu.sct.model.sexec.ExecutionFlow

@GeneratorContribution(StatemachineImplementation.SOURCE_TARGET)
class UsingNamespaceProvider implements ISourceFragment {
	@Inject extension EventNaming
	@Inject extension EventDrivenPredicate
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		if(!needsEventNamespace) return ''''''
		'''using namespace «eventNamespaceName»;'''
	}
	
	override isNeeded(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		needsEventNamespace
	}
	
	override orderPriority(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		-10
	}
	
}