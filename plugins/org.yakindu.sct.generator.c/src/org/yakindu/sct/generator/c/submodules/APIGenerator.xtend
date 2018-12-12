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
import static org.yakindu.sct.generator.c.CGeneratorConstants.*

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
		for («scHandle»->«STATEVECTOR_POS» = 0;
			«scHandle»->«STATEVECTOR_POS» < «maxOrthogonalStates»;
			«scHandle»->«STATEVECTOR_POS»++)
			{
				
			switch («scHandle»->«STATEVECTOR»[«scHandle»->«STATEVECTOR_POS»])
			{
			«FOR state : states.filter[isLeaf]»
				«IF state.reactMethod !== null»
					case «state.stateName»:
					{
						«state.reactMethod.shortName»(«scHandle», «TRUE»);
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
			«INT_TYPE» i;
			
			for (i = 0; i < «maxOrthogonalStates»; ++i)
			{
				«scHandle»->«STATEVECTOR»[i] = «null_state»;
			}
			
			«IF hasHistory»
				for (i = 0; i < «maxHistoryStates»; ++i)
				{
					«scHandle»->«HISTORYVECTOR»[i] = «null_state»;
				}
			«ENDIF»
			
			«scHandle»->«STATEVECTOR_POS» = 0;
			
			«clearInEventsFctID»(«scHandle»);
			«clearOutEventsFctID»(«scHandle»);

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
				«BOOL_TYPE» result = «FALSE»;
				«INT_TYPE» i;
				
				for(i = 0; i < «maxOrthogonalStates»; i++)
				{
					result = result || «scHandle»->«STATEVECTOR»[i] != «null_state»;
				}
				
				return result;
			}
		'''
	}

	def declareIsActive(ExecutionFlow it) {
		'''«isActiveSignature»;'''
	}
	
	def protected CharSequence isActiveSignature(ExecutionFlow it) {
		'''«BOOL_TYPE» «isActiveFctID»(const «scHandleDecl»)'''
	}

	def isStateActive(ExecutionFlow it) {
		'''
			«isStateActiveSignature»
			{
				«BOOL_TYPE» result = «FALSE»;
				switch (state)
				{
					«FOR s : states»
						case «s.stateName» :
							result = («BOOL_TYPE») («IF s.leaf»«scHandle»->«STATEVECTOR»[«s.stateVectorDefine»] == «s.stateName»
							«ELSE»«scHandle»->«STATEVECTOR»[«s.stateVectorDefine»] >= «s.stateName»
								&& «scHandle»->«STATEVECTOR»[«s.stateVectorDefine»] <= «s.subStates.last.stateName»«ENDIF»);
							break;
					«ENDFOR»
					default:
						result = «FALSE»;
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
		'''«BOOL_TYPE» «stateActiveFctID»(const «scHandleDecl», «statesEnumType» state)'''
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
		{if (fsiv.isCompletelyCovered) {'''	return «FOR i : 0 ..<fsiv.size SEPARATOR ' && '»(«FOR fs : fsiv.get(i) SEPARATOR ' || '»«scHandle»->«STATEVECTOR»[«i»] == «IF fs.stateVector.offset == i»«fs.stateName»«ELSE»«null_state»«ENDIF»«ENDFOR»)«ENDFOR»;
				'''} else {'''   return «FALSE»;'''} }		
		+ Strings.newLine + '''}'''
	}

	def declareIsFinal(ExecutionFlow it) {
		'''«isFinalSignature»;'''
	}
	
	def protected CharSequence isFinalSignature(ExecutionFlow it) {
		'''«BOOL_TYPE» «isFinalFctID»(const «scHandleDecl»)'''
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
				if ( ((«INTPTR_TYPE»)evid) >= ((«INTPTR_TYPE»)&(«scHandle»->timeEvents))
					&&  ((«INTPTR_TYPE»)evid) < ((«INTPTR_TYPE»)&(«scHandle»->timeEvents)) + (unsigned)sizeof(«timeEventScope.type»))
					{
					*(«BOOL_TYPE»*)evid = «TRUE»;
				}		
			}
		'''
	}
	
	def declareRaiseTimeEvent(ExecutionFlow it) {
		'''«raiseTimeEventSignature»;'''
	}
	
	def protected CharSequence raiseTimeEventSignature(ExecutionFlow it) {
		'''void «raiseTimeEventFctID»(«scHandleDecl», «EVENT_TYPE» evid)'''
	}
	
}
