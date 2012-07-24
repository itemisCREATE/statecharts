package org.yakindu.sct.generator.c

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sexec.Execution

class StatemachineC {
	
	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension FlowCode
	
	
	def generateStatemachineC(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa) {
		 fsa.generateFile(flow.module.c, flow.statemachineCContent )
	}
	
	def test(ExecutionFlow it) {
	 	eAllContents.filter( typeof(Execution) ).last
	}
	
	def statemachineCContent(ExecutionFlow it) '''
		#include <stdlib.h>
		#include <string.h>
		#include "«typesModule.h»"
		#include "«module.h»"
		#include "«module.client.h»"

		/*! \file Implementation of the state machine '«name»'
		*/
		
		«functionPrototypes»
		
		«initFunction»
		
		«enterFunction»
		
		«exitFunction»
		
		«runCycleFunction»

		«raiseTimeEventFunction»

		«isActiveFunction»
		
		«interfaceFunctions»
				
		«functionImplementations»
	'''
	
	
	def initFunction(ExecutionFlow it) '''
		void «type.toFirstLower»_init(«scHandleDecl»)
		{
			int i;

			for (i = 0; i < «type.toUpperCase»_MAX_ORTHOGONAL_STATES; ++i)
				«scHandle»->stateConfVector[i] = last_state;
			
			«IF ! historyVector.empty»
			for (i = 0; i < «type.toUpperCase»_MAX_HISTORY_STATES; ++i)
				«scHandle»->historyVector[i] = last_state;
			«ENDIF»
			
			«scHandle»->stateConfVectorPosition = 0;

			// TODO: initialize all events ...
			// TODO: initialize all variables ... (set default values - here or inenter sequence ?!?)

		}
	'''
	
	def enterFunction(ExecutionFlow it) '''
		void «type.toFirstLower»_enter(«scHandleDecl»)
		{
			«enterSequence.code»
		}
	'''
	
	def exitFunction(ExecutionFlow it) '''
		void «type.toFirstLower»_exit(«scHandleDecl»)
		{
			«exitSequence.code»
		}
	'''
	
	def runCycleFunction(ExecutionFlow it) '''
		#warning generate runCycle
	'''
	
	def raiseTimeEventFunction(ExecutionFlow it) '''
		#warning generate raiseTimeEvent
	'''
	
	def isActiveFunction(ExecutionFlow it) '''
		#warning generate isActive
	'''
	
	/* ===================================================================================
	 * Implementation of interface element accessor functions
	 */
	
	def interfaceFunctions(ExecutionFlow it) '''
		#warning generate interface functions
	'''
	
	/* ===================================================================================
	 * Handling decralartion of function prototypes
	 */
	 
	/** */
	def functionPrototypes(ExecutionFlow it) '''
		// prototypes of all internal functions
		
		«checkFunctions.toPrototypes»
		«effectFunctions.toPrototypes»
		«entryActionFunctions.toPrototypes»
		«exitActionFunctions.toPrototypes»
		«enterSequenceFunctions.toPrototypes»
		«exitSequenceFunctions.toPrototypes»
		«reactFunctions.toPrototypes»
		
	'''
	 
	 
	def toPrototypes(List<Step> steps) '''
		«FOR s : steps»
			«s.functionPrototype»
		«ENDFOR»
	'''
	
	def dispatch functionPrototype(Check it) '''
		static sc_boolean «asCheckFunction»(«scHandleDecl»);
	'''
	
	def dispatch functionPrototype(Step it) '''
		static void «functionName»(«scHandleDecl»);
	'''	
	
	
	
	/* ===================================================================================
	 * Handling implementation of internal functions
	 */
	 
	/** */
	def functionImplementations(ExecutionFlow it) '''
		// implementations of all internal functions
		
		«checkFunctions.toImplementation»
		«effectFunctions.toImplementation»
		«entryActionFunctions.toImplementation»
		«exitActionFunctions.toImplementation»
		«enterSequenceFunctions.toImplementation»
		«exitSequenceFunctions.toImplementation»
		«reactFunctions.toImplementation»
		
	'''
	 
	def toImplementation(List<Step> steps) '''
		«FOR s : steps»
			«s.functionImplementation»
		«ENDFOR»
	'''
	
	def dispatch functionImplementation(Check it) '''
		«stepComment»
		static sc_boolean «asCheckFunction»(«scHandleDecl») {
			return «code»;
		}
		
	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		static void «functionName»(«scHandleDecl») {
			«code»
		}
		
	'''
	
	
}