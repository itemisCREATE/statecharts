/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.c.GenmodelEntries
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.generator.c.FlowCode

class StatemachineImplementation {
	
	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension FlowCode
	@Inject extension GenmodelEntries
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension SExecExtensions
	
	def generateStatemachineImplemenation(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa, GeneratorEntry entry) {
		 fsa.generateFile(flow.module.cpp, flow.statemachineContent(entry) )
	}
	
	def statemachineContent(ExecutionFlow it, GeneratorEntry entry) '''
		«entry.licenseText»
		
		#include "«module.hpp»"
		/*! \file Implementation of the state machine '«name»'
		*/
		
		«initFunction»
		
		«enterFunction»
		
		«exitFunction»
		
		«clearInEventsFunction»
		
		«clearOutEventsFunction»
		
		«runCycleFunction»

		«raiseTimeEventFunction»

		«isActiveFunction»
		
		«interfaceFunctions»
				
		«functionImplementations»
	'''
	
	
	def initFunction(ExecutionFlow it) '''
		void init()
		{
			int i;

			for (i = 0; i < «orthogonalStatesConst»; ++i)
				stateConfVector[i] = «last_state»;
			
			«IF hasHistory»
			for (i = 0; i < «historyStatesConst»; ++i)
				historyVector[i] = «last_state»;
			«ENDIF»
			
			stateConfVectorPosition = 0;
		
			clearInEvents();
			clearOutEvents();
		
			// TODO: initialize all events ...

			«initSequence.code»

		}
	'''
	
	def enterFunction(ExecutionFlow it) '''
		void «type.toFirstLower»_enter(«scHandleDecl»)
		{
			«enterSequences.defaultSequence.code»
		}
	'''
	
	def exitFunction(ExecutionFlow it) '''
		void «type.toFirstLower»_exit(«scHandleDecl»)
		{
			«exitSequence.code»
		}
	'''
	
	def clearInEventsFunction(ExecutionFlow it) '''
		static void clearInEvents(«scHandleDecl») {
			«FOR scope : it.scopes»
				«FOR event : scope.incomingEvents»
				«event.access» = bool_false;
				«ENDFOR»
			«ENDFOR»
			«IF hasLocalScope»
				«FOR event : internalScope.events»
				«event.access» = bool_false; 
				«ENDFOR»
			«ENDIF»
			«IF timed»
				«FOR event : timeEventScope.events»
				«event.access» = bool_false; 
				«ENDFOR»
			«ENDIF»
		}
	'''
	
	def clearOutEventsFunction(ExecutionFlow it) '''
		static void clearOutEvents(«scHandleDecl») {
			«FOR scope : it.scopes»
				«FOR event : scope.outgoingEvents»
				«event.access» = bool_false;
				«ENDFOR»
			«ENDFOR»
		}
	'''
	
	def runCycleFunction(ExecutionFlow it) '''
		void «type.toFirstLower»_runCycle(«scHandleDecl») {
			
			clearOutEvents(«scHandle»);
			
			for («scHandle»->stateConfVectorPosition = 0;
				«scHandle»->stateConfVectorPosition < «type.toUpperCase»_MAX_ORTHOGONAL_STATES;
				«scHandle»->stateConfVectorPosition++) {
					
				switch («scHandle»->stateConfVector[handle->stateConfVectorPosition]) {
				«FOR state : states»
					«IF state.reactSequence!=null»
					case «state.name.asEscapedIdentifier» : {
						«state.reactSequence.functionName»(«scHandle»);
						break;
					}
					«ENDIF»
				«ENDFOR»
				default:
					break;
				}
			}
			
			clearInEvents(«scHandle»);
		}
	'''
	
	def raiseTimeEventFunction(ExecutionFlow it) '''
		«IF timed»
			void «nameOfRaiseTimeEventFunction»(«type»* handle, sc_eventid evid) {
				if ( ((intptr_t)evid) >= ((intptr_t)&(«scHandle»->timeEvents))
					&&  ((intptr_t)evid) < ((intptr_t)&(«scHandle»->timeEvents)) + sizeof(«timeEventScope.type»)) {
					*(sc_boolean*)evid = bool_true;
				}		
			}
		«ENDIF»
	'''
	
	def isActiveFunction(ExecutionFlow it) '''
		sc_boolean «nameOfIsActiveFunction»(«scHandleDecl», «statesEnumType» state) {
			switch (state) {
				«FOR s : states»
				case «s.name.asIdentifier» : 
					return (sc_boolean) («IF s.leaf»«scHandle»->stateConfVector[«s.stateVector.offset»] == «s.name.asIdentifier»
					«ELSE»«scHandle»->stateConfVector[«s.stateVector.offset»] >= «s.name.asIdentifier»
						&& «scHandle»->stateConfVector[«s.stateVector.offset»] <= «s.subStates.last.name.asIdentifier»«ENDIF»);
				«ENDFOR»
				default: return bool_false;
			}
		}
	'''
	
	/* ===================================================================================
	 * Implementation of interface element accessor functions
	 */
	
	def interfaceFunctions(ExecutionFlow it) '''
		«FOR scope : interfaceScopes»
			«FOR event : scope.incomingEvents»
				void «event.asRaiser»(«scHandleDecl»«event.valueParams») {
					«IF event.hasValue»
					«event.valueAccess» = value;
					«ENDIF»
					«event.access» = bool_true;
				}
			«ENDFOR»
			
			«FOR event : scope.outgoingEvents»
				sc_boolean «event.asRaised»(«scHandleDecl») {
					return «event.access»;
				}
				«IF event.hasValue» 
					«event.type.targetLanguageName» «event.asGetter»(«scHandleDecl») {
						//TODO: Check if event is not raised
						return «event.valueAccess»;
					}
				«ENDIF»
			«ENDFOR»
			
			«FOR variable : scope.variableDefinitions»
				«variable.type.targetLanguageName» «variable.asGetter»(«scHandleDecl») {
					return «variable.access»;
				}
				«IF !variable.readonly »
				void «variable.asSetter»(«scHandleDecl», «variable.type.targetLanguageName» value) {
					«variable.access» = value;
				}
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
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
		sc_boolean «execution_flow.module»::«asCheckFunction»(«scHandleDecl») {
			return «code»;
		}
		
	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		void «execution_flow.module»::«functionName»(«scHandleDecl») {
			«code»
		}
		
	'''
	
	
}