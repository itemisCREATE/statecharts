/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.submodules

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtext.util.Strings
import org.yakindu.sct.generator.c.FlowCode
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService

/**
 * @author rbeckmann
 * @author Axel Terfloth - terfloth@itemis.de 
 * 
 */

@Singleton // Guice
class APIGenerator {
	@Inject protected extension FlowCode
	@Inject protected extension INamingService
	@Inject protected extension Naming
	@Inject protected extension SExecExtensions
	@Inject protected extension StateVectorExtensions

	def runCycle(ExecutionFlow it) {
		'''
			«runCycleSignature»
			{
				«clearOutEventsFctID»(«scHandle»);
				«runCycleForLoop(it)»
				«clearInEventsFctID»(«scHandle»);
			}
		'''
	}

	protected def CharSequence runCycleForLoop(ExecutionFlow it) '''
		for («scHandle»->stateConfVectorPosition = 0;
			«scHandle»->stateConfVectorPosition < «type.toUpperCase»_MAX_ORTHOGONAL_STATES;
			«scHandle»->stateConfVectorPosition++)
			{
				
			switch («scHandle»->stateConfVector[handle->stateConfVectorPosition])
			{
			«FOR state : states.filter[isLeaf]»
				«IF state.reactMethod !== null»
					case «state.stateName»:
					{
						«state.reactMethod.shortName»(«scHandle», bool_true);
						break;
					}
				«ENDIF»
			«ENDFOR»
			default:
				break;
			}
		}
		
	'''


	def declareRunCycle(ExecutionFlow it) {
		'''«runCycleSignature»;'''
	}

	def protected CharSequence runCycleSignature(ExecutionFlow it) {
		'''void «runCycleFctID»(«scHandleDecl»)'''
	}

	def init(ExecutionFlow it) {
		'''
			«initSignature»
			{
				«initFunctionBody(it)»
			}
		'''
	}
	
	protected def CharSequence initFunctionBody(ExecutionFlow it) {
		'''
				sc_integer i;
			
				for (i = 0; i < «type.toUpperCase»_MAX_ORTHOGONAL_STATES; ++i)
				{
					«scHandle»->stateConfVector[i] = «null_state»;
				}
				
				«IF hasHistory»
					for (i = 0; i < «type.toUpperCase»_MAX_HISTORY_STATES; ++i)
					{
						«scHandle»->historyVector[i] = «null_state»;
					}
				«ENDIF»
				
				«scHandle»->stateConfVectorPosition = 0;
			
				«clearInEventsFctID»(handle);
				«clearOutEventsFctID»(handle);
			
				«initSequence.code»
			'''
	}
	
	def protected CharSequence initSignature(ExecutionFlow it) {
		'''void «initFctID»(«scHandleDecl»)'''
	}

	def declareInit(ExecutionFlow it) {
		'''«initSignature»;'''
	}

	def enter(ExecutionFlow it) {
		'''
			«enterSignature»
			{
				«enterSequences.defaultSequence.code»
			}
		'''
	}

	def declareEnter(ExecutionFlow it) {
		'''«enterSignature»;'''
	}
	
	def protected CharSequence enterSignature(ExecutionFlow it) {
		'''void «enterFctID»(«scHandleDecl»)'''
	}

	def isActive(ExecutionFlow it) {
		'''
			«isActiveSignature»
			{
				sc_boolean result = bool_false;
				int i;
				
				for(i = 0; i < «type.toUpperCase»_MAX_ORTHOGONAL_STATES; i++)
				{
					result = result || «scHandle»->stateConfVector[i] != «null_state»;
				}
				
				return result;
			}
		'''
	}

	def declareIsActive(ExecutionFlow it) {
		'''«isActiveSignature»;'''
	}
	
	def protected CharSequence isActiveSignature(ExecutionFlow it) {
		'''sc_boolean «isActiveFctID»(const «scHandleDecl»)'''
	}

	def isStateActive(ExecutionFlow it) {
		'''
			«isStateActiveSignature»
			{
				sc_boolean result = bool_false;
				switch (state)
				{
					«FOR s : states»
						case «s.stateName» :
							result = (sc_boolean) («IF s.leaf»«scHandle»->stateConfVector[«s.stateVectorDefine»] == «s.stateName»
							«ELSE»«scHandle»->stateConfVector[«s.stateVectorDefine»] >= «s.stateName»
								&& «scHandle»->stateConfVector[«s.stateVectorDefine»] <= «s.subStates.last.stateName»«ENDIF»);
							break;
					«ENDFOR»
					default:
						result = bool_false;
						break;
				}
				return result;
			}
			'''
	}

	def declareIsStateActive(ExecutionFlow it) {
		'''«isStateActiveSignature»;'''
	}
	
	def protected CharSequence isStateActiveSignature(ExecutionFlow it) {
		'''sc_boolean «stateActiveFctID»(const «scHandleDecl», «statesEnumType» state)'''
	}

	def isFinal(ExecutionFlow it) {
		val fsiv = flow.finalStateImpactVector

		'''
			«IF !fsiv.isCompletelyCovered»
				/* 
				 * Always returns 'false' since this state machine can never become final.
				 */
			«ENDIF»
			«isFinalSignature»
			{
		''' +
		// only if the impact vector is completely covered by final states the state machine
		// can become final
		{if (fsiv.isCompletelyCovered) {'''	return «FOR i : 0 ..<fsiv.size SEPARATOR ' && '»(«FOR fs : fsiv.get(i) SEPARATOR ' || '»«scHandle»->stateConfVector[«i»] == «IF fs.stateVector.offset == i»«fs.stateName»«ELSE»«null_state»«ENDIF»«ENDFOR»)«ENDFOR»;
				'''} else {'''   return bool_false;'''} }		
		+ Strings.newLine + '''}'''
	}

	def declareIsFinal(ExecutionFlow it) {
		'''«isFinalSignature»;'''
	}
	
	def protected CharSequence isFinalSignature(ExecutionFlow it) {
		'''sc_boolean «isFinalFctID»(const «scHandleDecl»)'''
	}
	
	def exit(ExecutionFlow it) {
		'''
			«exitSignature»
			{
				«exitSequence.code»
			}
		'''
	}
	
	def declareExit(ExecutionFlow it) {
		'''«exitSignature»;'''
	}
	
	def protected CharSequence exitSignature(ExecutionFlow it) {
		'''void «exitFctID»(«scHandleDecl»)'''
	}
	
	def raiseTimeEvent(ExecutionFlow it) {
		'''
			«raiseTimeEventSignature»
			{
				if ( ((sc_intptr_t)evid) >= ((sc_intptr_t)&(«scHandle»->timeEvents))
					&&  ((sc_intptr_t)evid) < ((sc_intptr_t)&(«scHandle»->timeEvents)) + sizeof(«timeEventScope.type»))
					{
					*(sc_boolean*)evid = bool_true;
				}		
			}
		'''
	}
	
	def declareRaiseTimeEvent(ExecutionFlow it) {
		'''«raiseTimeEventSignature»;'''
	}
	
	def protected CharSequence raiseTimeEventSignature(ExecutionFlow it) {
		'''void «raiseTimeEventFctID»(«scHandleDecl», sc_eventid evid)'''
	}
	
}
