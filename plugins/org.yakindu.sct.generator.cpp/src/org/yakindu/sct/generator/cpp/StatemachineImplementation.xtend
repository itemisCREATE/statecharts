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
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

class StatemachineImplementation {
	
	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension FlowCode
	@Inject extension GenmodelEntriesExtension
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension INamingService
	@Inject extension ExpressionCode
	@Inject protected extension StateVectorExtensions
	
	protected GeneratorEntry entry
	
	def generateStatemachineImplemenation(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa, GeneratorEntry entry) {
		this.entry = entry
		fsa.generateFile(flow.module.cpp, flow.statemachineContent)
	}
	
	def statemachineContent(ExecutionFlow it) '''
		«entry.licenseText»
		
		#include "«module.h»"
		#include <string.h>
		/*! \file Implementation of the state machine '«name»'
		*/
		
		«constructorDefinition»
		
		«destructorDefinition»
		
		«constantDefinitions»
		
		«initFunction»
		
		«enterFunction»
		
		«exitFunction»
		
		«activeFunction»
		
		«finalFunction»
		
		«runCycleFunction»
		
		«clearInEventsFunction»
		
		«clearOutEventsFunction»

		«timedStatemachineFunctions»

		«isStateActiveFunction»
		
		«interfaceFunctions»
		
		«functionImplementations»
	'''
	
	def constructorDefinition(ExecutionFlow it) '''
		«module»::«module»() {
			
			«scopes.filter(typeof(StatechartScope)).filter[hasOperations && !entry.useStaticOPC].map['''«OCB_Instance» = null;'''].join('\n')»
			«IF hasHistory»
				
				for (int i = 0; i < «historyStatesConst»; ++i)
					historyVector[i] = «null_state»;
			«ENDIF»
			
			stateConfVectorPosition = 0;
			
			«IF timed»
				«timerInstance» = NULL;
			«ENDIF»
		}
	'''
	
	def destructorDefinition(ExecutionFlow it) '''
		«module»::~«module»() {
		}
	'''
	
	def initFunction(ExecutionFlow it) '''
		void «module»::init()
		{
			for (int i = 0; i < «orthogonalStatesConst»; ++i)
				stateConfVector[i] = «null_state»;
			
			«IF hasHistory»
			for (int i = 0; i < «historyStatesConst»; ++i)
				historyVector[i] = «null_state»;
			
			«ENDIF»
			stateConfVectorPosition = 0;
		
			clearInEvents();
			clearOutEvents();
			
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
					case «state.shortName.asEscapedIdentifier» : {
						«state.reactSequence.shortName»();
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
			
			void «module»::«raiseTimeEventFctID»(sc_eventid evid) {
				if ((evid >= &timeEvents) && (evid < &timeEvents + sizeof(timeEvents))) {
					*(sc_boolean*)evid = true;
				}
			}
		«ENDIF»
	'''
	
	def isStateActiveFunction(ExecutionFlow it) '''
		sc_boolean «module»::«stateActiveFctID»(«statesEnumType» state) {
			switch (state) {
				«FOR s : states»
				case «s.shortName.asEscapedIdentifier» : 
					return (sc_boolean) («IF s.leaf»stateConfVector[«s.stateVector.offset»] == «s.shortName.asEscapedIdentifier»
					«ELSE»stateConfVector[«s.stateVector.offset»] >= «s.shortName.asEscapedIdentifier»
						&& stateConfVector[«s.stateVector.offset»] <= «s.subStates.last.shortName.asEscapedIdentifier»«ENDIF»);
				«ENDFOR»
				default: return false;
			}
		}
	'''
	
	
	def isActiveFunction(ExecutionFlow it) '''
		sc_boolean «module»::isActive() {
			return «FOR i : 0 ..< stateVector.size SEPARATOR '||'»stateConfVector[«i»] != «null_state»«ENDFOR»;
		}
	'''
	
	def protected isFinalFunction(ExecutionFlow it) {
		val finalStateImpactVector = flow.finalStateImpactVector
		'''
			«IF !finalStateImpactVector.isCompletelyCovered»
			/* 
			 * Always returns 'false' since this state machine can never become final.
			 */
			«ENDIF»
			sc_boolean «module»::isFinal(){
		''' +
		// only if the impact vector is completely covered by final states the state machine 
		// can become final
		{if (finalStateImpactVector.isCompletelyCovered) {'''	return «FOR i : 0 ..<finalStateImpactVector.size SEPARATOR ' && '»(«FOR fs : finalStateImpactVector.get(i) SEPARATOR ' || '»stateConfVector[«i»] == «IF fs.stateVector.offset == i»«fs.stateName.asEscapedIdentifier»«ELSE»«null_state»«ENDIF»«ENDFOR»)«ENDFOR»;
		'''} else {'''   return false;'''} }		
		+ '''
		}'''
	}
	
	
	/* ===================================================================================
	 * Implementation of interface element access functions
	 */
	 
	def constantDefinitions(ExecutionFlow it) '''
		«FOR scope : statechartScopes»
			«FOR d : scope.declarations.filter(typeof(VariableDefinition)).filter[const]»
				«IF d.type.name != 'void'»const «d.type.targetLanguageName» «d.access» = «d.initialValue.code»;«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''
	
	/* ===================================================================================
	 * Implementation of interface element access functions
	 */
	
	def interfaceFunctions(ExecutionFlow it) '''
		«FOR scope : statechartScopes»
			«IF scope instanceof InterfaceScope»
			«module»::«scope.interfaceName»* «module»::get«scope.interfaceName»() {
				return &«scope.instance»;
			}
			
			«ENDIF»
			«FOR event : scope.incomingEvents»
				void «module»::«scope.interfaceName»::«event.asRaiser»(«event.valueParams») {
					«IF event.hasValue»
					«event.localValueAccess» = value;
					«ENDIF»
					«event.localAccess» = true;
				}
				
				«IF scope.defaultInterface»
					void «module»::«event.asRaiser»(«event.valueParams») {
						«scope.instance».«event.asRaiser»(«IF event.hasValue»value«ENDIF»);
					}
					
				«ENDIF»
			«ENDFOR»
			«FOR event : scope.outgoingEvents»
				sc_boolean «module»::«scope.interfaceName»::«event.asRaised»() {
					return «event.localAccess»;
				}
				
				«IF scope.defaultInterface»
					sc_boolean «module»::«event.asRaised»() {
						return «scope.instance».«event.asRaised»();
					}
					
				«ENDIF»
				«IF event.hasValue» 
					«event.type.targetLanguageName» «module»::«scope.interfaceName»::«event.asGetter»() {
						return «event.localValueAccess»;
					}
					
					«IF scope.defaultInterface»
						«event.type.targetLanguageName» «module»::«event.asGetter»() {
							return «scope.instance».«event.asGetter»();
						}
						
					«ENDIF»
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
						return «event.localValueAccess»;
					}
					
				«ENDIF»
			«ENDFOR»
			«FOR variable : scope.variableDefinitions»
				«variable.type.targetLanguageName» «module»::«scope.interfaceName»::«variable.asGetter»() {
					return «variable.localAccess»;
				}
				
				«IF scope.defaultInterface»
					«variable.type.targetLanguageName» «module»::«variable.asGetter»() {
						return «variable.access»;
					}
					
				«ENDIF»
				«IF !variable.readonly && !variable.const»
					void «module»::«scope.interfaceName»::«variable.asSetter»(«variable.type.targetLanguageName» value) {
						«variable.localAccess» = value;
					}
					
					«IF scope.defaultInterface»
						void «module»::«variable.asSetter»(«variable.type.targetLanguageName» value) {
							«variable.access» = value;
						}
						
					«ENDIF»
				«ENDIF»
			«ENDFOR»
			«IF scope.hasOperations && !entry.useStaticOPC»
				«scope.OCB_InterfaceSetterDeclaration(true)» {
					«scope.OCB_Instance» = operationCallback;
				}
			«ENDIF»
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
		sc_boolean «execution_flow.module»::«shortName»() {
			return «code»;
		}
		
	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		void «execution_flow.module»::«shortName»() {
			«code»
		}
		
	'''
}