package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.Check
import java.util.List
import org.yakindu.sct.model.sexec.Step

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

		/*! \file Implementation of the state machine '«name»'
		*/
		
		«functionPrototypes»
		
		// function implementations

		«initFunction»
		
		«enterFunction»
		
		«exitFunction»
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
	
	def functionPrototypes(ExecutionFlow it) '''
		// prototypes of all internal functions
		
		«checkFunctionPrototypes»
		«effectFunctionPrototypes»
		«entryActionFunctionPrototypes»
		«exitActionFunctionPrototypes»
		«enterSequenceFunctionPrototypes»
		«exitSequenceFunctionPrototypes»
		«reactFunctionPrototypes»
		
	'''
	 
	 
	def checkFunctionPrototypes(ExecutionFlow it) '''
		«referencedChecks.checkFunctionPrototypes»
		«FOR s : states»«s.referencedChecks.checkFunctionPrototypes»«ENDFOR»
		«FOR n : nodes»«n.referencedChecks.checkFunctionPrototypes»«ENDFOR»
	'''
	
	def checkFunctionPrototypes(Iterable<Check> it) '''
		«FOR c : it»«c.checkFunctionPrototype»«ENDFOR»
	'''
	
	def checkFunctionPrototype(Check it) '''
		static sc_boolean «asCheckFunction»(«scHandleDecl»);
	'''
	
	
	
	def effectFunctionPrototypes(ExecutionFlow it) '''
		«referencedEffects.effectFunctionPrototypes»
		«FOR s : states»«s.referencedEffects.effectFunctionPrototypes»«ENDFOR»
		«FOR n : nodes»«n.referencedEffects.effectFunctionPrototypes»«ENDFOR»
	'''
	
	def effectFunctionPrototypes(Iterable<Step> it) '''
		«FOR c : it»«c.effectFunctionPrototype»«ENDFOR»
	'''
	
	def effectFunctionPrototype(Step it) '''
		static sc_boolean «asEffectFunction»(«scHandleDecl»);
	'''
	
	
	
	def entryActionFunctionPrototypes(ExecutionFlow it) '''
		«if (entryAction.called) entryAction.entryActionFunctionPrototype»
		«FOR s : states»«if (s.entryAction.called) s.entryAction.entryActionFunctionPrototype»«ENDFOR»
	'''
	
	def entryActionFunctionPrototype(Step it) '''
		static void «asEntryActionFunction»(«scHandleDecl»);
	'''
	
	
	def exitActionFunctionPrototypes(ExecutionFlow it) '''
		«if (exitAction.called) exitAction.exitActionFunctionPrototype»
		«FOR s : states»«if (s.exitAction.called) s.exitAction.exitActionFunctionPrototype»«ENDFOR»
	'''
	
	def exitActionFunctionPrototype(Step it) '''
		static void «asExitActionFunction»(«scHandleDecl»);
	'''
	
	
	def enterSequenceFunctionPrototypes(ExecutionFlow it) '''
		«if (enterSequence.called) enterSequence.enterSequenceFunctionPrototype»
		«FOR s : states»«if (s.enterSequence.called) s.enterSequence.enterSequenceFunctionPrototype»«ENDFOR»
		«FOR r : regions»
			«if (r.enterSequence.called) r.enterSequence.enterSequenceFunctionPrototype»
			«if (r.deepEnterSequence.called) r.enterSequence.deepEnterSequenceFunctionPrototype»
			«if (r.shallowEnterSequence.called) r.enterSequence.shallowEnterSequenceFunctionPrototype»
		«ENDFOR»
	'''
	
	def enterSequenceFunctionPrototype(Step it) '''
		static void «asEnterSequenceFunction»(«scHandleDecl»);
	'''
	
	def deepEnterSequenceFunctionPrototype(Step it) '''
		static void «asDeepEnterSequenceFunction»(«scHandleDecl»);
	'''
	
	def shallowEnterSequenceFunctionPrototype(Step it) '''
		static void «asShallowEnterSequenceFunction»(«scHandleDecl»);
	'''
	
	
	def exitSequenceFunctionPrototypes(ExecutionFlow it) '''
		«if (enterSequence.called) exitSequence.exitSequenceFunctionPrototype»
		«FOR s : states»«if (s.exitSequence.called) s.exitSequence.exitSequenceFunctionPrototype»«ENDFOR»
		«FOR r : regions»«if (r.exitSequence.called) r.exitSequence.exitSequenceFunctionPrototype»«ENDFOR»
	'''
	
	def exitSequenceFunctionPrototype(Step it) '''
		static void «asExitSequenceFunction»(«scHandleDecl»);
	'''
	
	def reactFunctionPrototypes(ExecutionFlow it) '''
		«if (reactSequence.called) reactSequence.reactFunctionPrototype»
		«FOR s : states»«if (s.reactSequence.called) s.reactSequence.reactFunctionPrototype»«ENDFOR»
		«FOR n : nodes»«if (n.reactSequence.called) n.reactSequence.reactFunctionPrototype»«ENDFOR»
	'''
	
	def reactFunctionPrototype(Step it) '''
		static void «asReactFunction»(«scHandleDecl»);
	'''	
}