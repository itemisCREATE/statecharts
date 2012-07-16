package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.eclipse.xtext.generator.IFileSystemAccess

class StatemachineC {
	
	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension Base
	@Inject extension FlowCode
	
	
	def generateStatemachineC(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa) {
		 fsa.generateFile(flow.module.c, flow.statemachineCContent )
	}
	
	
	
	def statemachineCContent(ExecutionFlow it) '''
		#include "«module.h»"
		#include <stdlib.h>
		#include <string.h>


		// function prototypes
		// function implementations

		«initFunction»
		
		«enterFunction»
		
		«exitFunction»
	'''
	
	
	def initFunction(ExecutionFlow it) '''
		void «type.toFirstLower»_init(«type»* handle)
		{
			int i;

			for (i = 0; i < «type.toUpperCase»_MAX_ORTHOGONAL_STATES; ++i)
				handle->stateConfVector[i] = last_state;
			
			«IF ! historyVector.empty»
			for (i = 0; i < «type.toUpperCase»_MAX_HISTORY_STATES; ++i)
				handle->historyVector[i] = last_state;
			«ENDIF»
			
			handle->stateConfVectorPosition = 0;

			// TODO: initialize all events ...
			// TODO: initialize all variables ... (set default values - here or inenter sequence ?!?)

		}
	'''
	
	def enterFunction(ExecutionFlow it) '''
		void «type.toFirstLower»_enter(«type»* handle)
		{
			«enterSequence.code»
		}
	'''
	
	def exitFunction(ExecutionFlow it) '''
		void «type.toFirstLower»_exit(«type»* handle)
		{
			«exitSequence.code»
		}
	'''
	
}