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
package org.yakindu.sct.generator.c

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.util.Strings
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

class StatemachineSource implements IContentTemplate {
	
	@Inject protected extension Naming
	@Inject protected extension GenmodelEntries
	@Inject protected extension Navigation
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension FlowCode
	@Inject protected extension ConstantInitializationResolver
	@Inject protected extension StateVectorExtensions
	
	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) { 
		initializeNamingService
	'''
		«entry.licenseText»
		
		#include <stdlib.h>
		#include <string.h>
		#include "«(typesModule.h).relativeTo(module.c)»"
		#include "«(module.h).relativeTo(module.c)»"
		«IF timed || !it.operations.empty»
			#include "«(module.client.h).relativeTo(module.c)»"
		«ENDIF»
		/*! \file Implementation of the state machine '«name»'
		*/
		
		«functionPrototypes»
		
		«constantDefinitions»
		
		«functions»
	'''
	}
	
	def functions(ExecutionFlow it) '''
		«initFunction»
		
		«enterFunction»
		
		«exitFunction»
		
		«activeFunction»
		
		«finalFunction»
		
		«clearInEventsFunction»
		
		«clearOutEventsFunction»
		
		«runCycleFunction»
		
		«raiseTimeEventFunction»

		«isStateActiveFunction»
		
		«interfaceFunctions»
		
		«functionImplementations»
	'''
	
	def initFunction(ExecutionFlow it) '''
		void «functionPrefix»init(«scHandleDecl»)
		{
			«initFunctionBody(it)»
		}
	'''
	
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
	
	
	def enterFunction(ExecutionFlow it) '''
		void «functionPrefix»enter(«scHandleDecl»)
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
		static void «clearInEventsFctID»(«scHandleDecl»)
		{
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
		static void «clearOutEventsFctID»(«scHandleDecl»)
		{
			«FOR scope : it.scopes»
				«FOR event : scope.outgoingEvents»
				«event.access» = bool_false;
				«ENDFOR»
			«ENDFOR»
		}
	'''
	
	def runCycleFunction(ExecutionFlow it) '''
		void «functionPrefix»runCycle(«scHandleDecl»)
		{
			
			«clearOutEventsFctID»(«scHandle»);
			«runCycleForLoop(it)»
			«clearInEventsFctID»(«scHandle»);
		}
	'''
	
	protected def CharSequence runCycleForLoop(ExecutionFlow it)
		'''
		for («scHandle»->stateConfVectorPosition = 0;
			«scHandle»->stateConfVectorPosition < «type.toUpperCase»_MAX_ORTHOGONAL_STATES;
			«scHandle»->stateConfVectorPosition++)
			{
				
			switch («scHandle»->stateConfVector[handle->stateConfVectorPosition])
			{
			«FOR state : states»
				«IF state.reactSequence !== null»
				case «state.shortName»:
				{
					«state.reactSequence.shortName»(«scHandle»);
					break;
				}
				«ENDIF»
			«ENDFOR»
			default:
				break;
			}
		}
		
		'''
	
	
	def raiseTimeEventFunction(ExecutionFlow it) '''
		«IF timed»
			void «raiseTimeEventFctID»(const «type»* handle, sc_eventid evid)
			{
				if ( ((sc_intptr_t)evid) >= ((sc_intptr_t)&(«scHandle»->timeEvents))
					&&  ((sc_intptr_t)evid) < ((sc_intptr_t)&(«scHandle»->timeEvents)) + sizeof(«timeEventScope.type»))
					{
					*(sc_boolean*)evid = bool_true;
				}		
			}
		«ENDIF»
	'''
	
	def isStateActiveFunction(ExecutionFlow it) '''
		sc_boolean «stateActiveFctID»(const «scHandleDecl», «statesEnumType» state)
		{
			sc_boolean result = bool_false;
			switch (state)
			{
				«FOR s : states»
				case «s.shortName» :
					result = (sc_boolean) («IF s.leaf»«scHandle»->stateConfVector[«s.stateVectorDefine»] == «s.shortName»
					«ELSE»«scHandle»->stateConfVector[«s.stateVectorDefine»] >= «s.shortName»
						&& «scHandle»->stateConfVector[«s.stateVectorDefine»] <= «s.subStates.last.shortName»«ENDIF»);
					break;
				«ENDFOR»
				default:
					result = bool_false;
					break;
			}
			return result;
		}
	'''
	
	def isActiveFunction(ExecutionFlow it) '''
		sc_boolean «isActiveFctID»(const «scHandleDecl»)
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
	
	def protected isFinalFunction(ExecutionFlow it) {
		val finalStateImpactVector = flow.finalStateImpactVector

		'''
			«IF !finalStateImpactVector.isCompletelyCovered»
			/* 
			 * Always returns 'false' since this state machine can never become final.
			 */
			«ENDIF»
			sc_boolean «isFinalFctID»(const «scHandleDecl»)
			{
		''' +
		// only if the impact vector is completely covered by final states the state machine
		// can become final
		{if (finalStateImpactVector.isCompletelyCovered) {'''	return «FOR i : 0 ..<finalStateImpactVector.size SEPARATOR ' && '»(«FOR fs : finalStateImpactVector.get(i) SEPARATOR ' || '»«scHandle»->stateConfVector[«i»] == «IF fs.stateVector.offset == i»«fs.shortName»«ELSE»«null_state»«ENDIF»«ENDFOR»)«ENDFOR»;
		'''} else {'''   return bool_false;'''} }		
		+ Strings.newLine + '''}'''
	}
	
	
	
	/* ===================================================================================
	 * Implementation of interface element accessor functions
	 */
	
	def interfaceFunctions(ExecutionFlow it) '''
		«FOR scope : interfaceScopes»
			«FOR event : scope.incomingEvents»
				void «event.asRaiser»(«scHandleDecl»«event.valueParams»)
				{
					«IF event.hasValue»
					«event.valueAccess» = value;
					«ENDIF»
					«event.access» = bool_true;
				}
			«ENDFOR»
			
			«FOR event : scope.outgoingEvents»
				sc_boolean «event.asRaised»(const «scHandleDecl»)
				{
					return «event.access»;
				}
				«IF event.hasValue» 
					«event.typeSpecifier.targetLanguageName» «event.asGetter»(const «scHandleDecl»)
					{
						return «event.valueAccess»;
					}
				«ENDIF»
			«ENDFOR»
			
			«FOR variable : scope.variableDefinitions»
				«IF variable.const»const «ENDIF»«variable.typeSpecifier.targetLanguageName» «variable.asGetter»(const «scHandleDecl»)
				{
					return «variable.access»;
				}
				«IF !variable.readonly && !variable.const»
				void «variable.asSetter»(«scHandleDecl», «variable.typeSpecifier.targetLanguageName» value)
				{
					«variable.access» = value;
				}
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''
	
	/* ===================================================================================
	 * Handling decralartion of function prototypes
	 */
	 
	/** */
	def functionPrototypes(ExecutionFlow it) '''
		/* prototypes of all internal functions */
		«checkFunctions.toPrototypes»
		«effectFunctions.toPrototypes»
		«entryActionFunctions.toPrototypes»
		«exitActionFunctions.toPrototypes»
		«enterSequenceFunctions.toPrototypes»
		«exitSequenceFunctions.toPrototypes»
		«reactFunctions.toPrototypes»
		static void «clearInEventsFctID»(«scHandleDecl»);
		static void «clearOutEventsFctID»(«scHandleDecl»);
	'''
	
	def constantDefinitions(ExecutionFlow it) '''
		«FOR scope : scopes.filter(typeof(StatechartScope))»
			«FOR d : scope.declarations.filter(typeof(VariableDefinition)).filter[const]»
				«IF d.type.name != 'void'»const «d.typeSpecifier.targetLanguageName» «d.access» = «d.initialValue.resolveConstants»;«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''
	
	def toPrototypes(List<Step> steps) '''
		«FOR s : steps»
			«s.functionPrototype»
		«ENDFOR»
	'''
	
	def dispatch functionPrototype(Check it) '''
		static sc_boolean «shortName»(const «scHandleDecl»);
	'''
	
	def dispatch functionPrototype(Step it) '''
		static void «shortName»(«scHandleDecl»);
	'''	
	
	
	
	/* ===================================================================================
	 * Handling implementation of internal functions
	 */
	 
	/** */
	def functionImplementations(ExecutionFlow it) '''
		/* implementations of all internal functions */
		
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
		static sc_boolean «shortName»(const «scHandleDecl»)
		{
			return «code»;
		}
		
	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		static void «shortName»(«scHandleDecl»)
		{
			«code»
		}
		
	'''
	
	
}