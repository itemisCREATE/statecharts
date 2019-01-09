package org.yakindu.sct.generator.cpp.providers

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.core.submodules.lifecycle.Enter
import org.yakindu.sct.generator.core.submodules.lifecycle.Exit
import org.yakindu.sct.generator.core.submodules.lifecycle.Init
import org.yakindu.sct.generator.core.submodules.lifecycle.IsActive
import org.yakindu.sct.generator.core.submodules.lifecycle.IsFinal
import org.yakindu.sct.generator.core.submodules.lifecycle.IsStateActive
import org.yakindu.sct.generator.core.submodules.lifecycle.RunCycle
import org.yakindu.sct.generator.cpp.files.StatemachineImplementation
import org.yakindu.sct.generator.cpp.submodules.InterfaceFunctions
import org.yakindu.sct.generator.cpp.submodules.InternalFunctions
import org.yakindu.sct.generator.cpp.submodules.TimingFunctions
import org.yakindu.sct.model.sexec.ExecutionFlow

@GeneratorContribution(StatemachineImplementation.SOURCE_TARGET)
class DefaultFunctionProvider implements ISourceFragment {
	@Inject protected extension Init
	@Inject protected extension Enter
	@Inject protected extension RunCycle
	@Inject protected extension IsActive
	@Inject protected extension IsFinal
	@Inject protected extension Exit
	@Inject protected extension IsStateActive
	
	@Inject protected extension InternalFunctions
	@Inject protected extension InterfaceFunctions
	@Inject protected extension TimingFunctions
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		'''
		«init»
		
		«enter»
		
		«exit»
		
		«isActive»
		
		«isFinal»
		
		«runCycle»
		
		«clearInEventsFunction»
		
		«clearOutEventsFunction»

		«timedStatemachineFunctions»

		«isStateActive»
		
		«interfaceFunctions»
		
		«functionImplementations»
		'''
	}
	
}