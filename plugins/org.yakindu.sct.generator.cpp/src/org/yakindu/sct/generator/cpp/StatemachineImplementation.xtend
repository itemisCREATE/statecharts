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
import org.yakindu.sct.generator.c.GenmodelEntriesimport org.yakindu.sct.model.stext.stext.StatechartScope

class StatemachineImplementation {
	
	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension FlowCode
	@Inject extension GenmodelEntries
	@Inject extension ICodegenTypeSystemAccess
	
	def generateStatemachineImplemenation(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa, GeneratorEntry entry) {
		 fsa.generateFile(flow.module.cpp, flow.statemachineContent(entry) )
	}
	
	def statemachineContent(ExecutionFlow it, GeneratorEntry entry) '''
		«entry.licenseText»
		
		#include "«module.h»"
		/*! \file Implementation of the state machine '«name»'
		*/
		
		«constructorDecl»
		
		«destructorDecl»
		
		«initFunction»
		
		«enterFunction»
		
		«exitFunction»
		
		«runCycleFunction»
		
		«clearInEventsFunction»
		
		«clearOutEventsFunction»

		«timedStatemachineFunctions»

		«isActiveFunction»
		
		«interfaceFunctions»
				
		«functionImplementations»
	'''
	
	def constructorDecl(ExecutionFlow it) '''
		«module»::«module»() {
			
			«FOR s : scopes.filter(typeof(StatechartScope))»
			«s.instance» = new «s.interfaceName»();
		«ENDFOR»
		«IF hasHistory»
			
			for (i = 0; i < «historyStatesConst»; ++i)
				historyVector[i] = «last_state»;
			«ENDIF»
			
			stateConfVectorPosition = 0;
			
			«IF timed»
				«timerInstance» = NULL;
			«ENDIF»
		}
	'''
	
	def destructorDecl(ExecutionFlow it) '''
		«module»::~«module»() {
		}
	'''
	
	def initFunction(ExecutionFlow it) '''
		void «module»::init()
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
		void «module»::enter()
		{
			«enterSequences.defaultSequence.code»
		}
	'''
	
	def exitFunction(ExecutionFlow it) '''
		void «module»::exit()
		{
			«exitSequence.code»
		}
	'''
	
	def clearInEventsFunction(ExecutionFlow it) '''
		void «module»::clearInEvents() {
			«FOR scope : it.scopes»
				«FOR event : scope.incomingEvents»
				«event.access» = false;
				«ENDFOR»
			«ENDFOR»
			«IF hasLocalScope»
				«FOR event : internalScope.events»
				«event.access» = false; 
				«ENDFOR»
			«ENDIF»
			«IF timed»
				«FOR event : timeEventScope.events»
				«event.access» = false; 
				«ENDFOR»
			«ENDIF»
		}
	'''
	
	def clearOutEventsFunction(ExecutionFlow it) '''
		void «module»::clearOutEvents() {
			«FOR scope : it.scopes»
				«FOR event : scope.outgoingEvents»
				«event.access» = false;
				«ENDFOR»
			«ENDFOR»
		}
	'''
	
	def runCycleFunction(ExecutionFlow it) '''
		void «module»::runCycle() {
			
			clearOutEvents();
			
			for (stateConfVectorPosition = 0;
				stateConfVectorPosition < «orthogonalStatesConst»;
				stateConfVectorPosition++) {
					
				switch (stateConfVector[stateConfVectorPosition]) {
				«FOR state : states»
					«IF state.reactSequence!=null»
					case «state.name.asEscapedIdentifier» : {
						«state.reactSequence.functionName»();
						break;
					}
					«ENDIF»
				«ENDFOR»
				default:
					break;
				}
			}
			
			clearInEvents();
		}
	'''
	
	def timedStatemachineFunctions(ExecutionFlow it) '''
		«IF timed»
			
			void «module»::setTimer(«timerInterface»* timer){
				this->«timerInstance» = timer;
			}
			
			«timerInterface»* «module»::getTimer(){
				return «timerInstance»;
			}
			
			void «module»::«nameOfRaiseTimeEventFunction»(sc_eventid evid) {
				if ((evid >= &timeEvents) && (evid < &timeEvents + sizeof(timeEvents))) {
					*(sc_boolean*)evid = true;
				}
			}
		«ENDIF»
	'''
	
	def isActiveFunction(ExecutionFlow it) '''
		sc_boolean «module»::«nameOfIsActiveFunction»(«statesEnumType» state) {
			switch (state) {
				«FOR s : states»
				case «s.name.asIdentifier» : 
					return (sc_boolean) («IF s.leaf»stateConfVector[«s.stateVector.offset»] == «s.name.asIdentifier»
					«ELSE»stateConfVector[«s.stateVector.offset»] >= «s.name.asIdentifier»
						&& stateConfVector[«s.stateVector.offset»] <= «s.subStates.last.name.asIdentifier»«ENDIF»);
				«ENDFOR»
				default: return false;
			}
		}
	'''
	
	/* ===================================================================================
	 * Implementation of interface element accessor functions
	 */
	
	def interfaceFunctions(ExecutionFlow it) '''
		«FOR scope : statechartScopes»
			«FOR event : scope.incomingEvents»
				void «module»::«scope.interfaceName»::«event.asRaiser»(«event.valueParams») {
					«IF event.hasValue»
					«event.localValueAccess» = value;
					«ENDIF»
					«event.localAccess» = true;
				}
			«ENDFOR»
			
			«FOR event : scope.outgoingEvents»
				sc_boolean «module»::«scope.interfaceName»::«event.asRaised»() {
					return «event.localAccess»;
				}
				«IF event.hasValue» 
					«event.type.targetLanguageName» «module»::«scope.interfaceName»::«event.asGetter»() {
						//TODO: Check if event is not raised
						return «event.localValueAccess»;
					}
				«ENDIF»
			«ENDFOR»
			
			«FOR event : scope.localEvents»
				void «module»::«scope.interfaceName»::«event.asRaiser»(«event.valueParams») {
					«IF event.hasValue»
					«event.localValueAccess» = value;
					«ENDIF»
					«event.localAccess» = true;
				}
				
				sc_boolean «module»::«scope.interfaceName»::«event.asRaised»() {
					return «event.localAccess»;
				}
				«IF event.hasValue» 
					«event.type.targetLanguageName» «module»::«scope.interfaceName»::«event.asGetter»() {
						//TODO: Check if event is not raised
						return «event.localValueAccess»;
					}
				«ENDIF»
			«ENDFOR»
			
			«FOR variable : scope.variableDefinitions»
				«variable.type.targetLanguageName» «module»::«scope.interfaceName»::«variable.asGetter»() {
					return «variable.localAccess»;
				}
				«IF !variable.readonly »
				void «module»::«scope.interfaceName»::«variable.asSetter»(«variable.type.targetLanguageName» value) {
					«variable.localAccess» = value;
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
		sc_boolean «execution_flow.module»::«asCheckFunction»() {
			return «code»;
		}
		
	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		void «execution_flow.module»::«functionName»() {
			«code»
		}
		
	'''
}