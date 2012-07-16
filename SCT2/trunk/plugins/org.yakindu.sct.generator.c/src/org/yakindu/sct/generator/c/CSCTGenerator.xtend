package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart

/**
 * This is the C code generators main class. 
 * 
 * @author Axel Terfloth
 */
class CSCTGenerator implements IExecutionFlowGenerator {
	 
	@Inject extension Types
	@Inject extension Statemachine
	@Inject extension StatemachineC
	@Inject extension StatemachineRequired
 	

	
	override generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {

		flow.generateTypesH(flow.sourceElement as Statechart, fsa)
		
//		flow.generateTimerH(flow.sourceElement as Statechart, fsa)
//		flow.generateTimerC(flow.sourceElement as Statechart, fsa)

		flow.generateStatemachineH(flow.sourceElement as Statechart, fsa)
		flow.generateStatemachineClientH(flow.sourceElement as Statechart, fsa)

		flow.generateStatemachineC(flow.sourceElement as Statechart, fsa)

	}

	
}