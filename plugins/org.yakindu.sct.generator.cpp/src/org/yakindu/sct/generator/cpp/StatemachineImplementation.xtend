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
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static org.eclipse.xtext.util.Strings.*
import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Method

class StatemachineImplementation implements IContentTemplate {
	
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension SgraphExtensions
	@Inject protected extension FlowCode
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension CppExpressionsGenerator
	@Inject protected extension StateVectorExtensions
	@Inject protected extension EventCode
	@Inject protected extension ExpressionsChecker
	
	protected GeneratorEntry entry
	
	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		this.entry = entry
		val namespace = statechartNamespace
	'''	
		«entry.licenseText»
		
		#include "«module.h»"
		#include <string.h>
		«IF modOnReal»#include <math.h>«ENDIF»
		
		/*! \file Implementation of the state machine '«name»'
		*/
		
		«IF !namespace.nullOrEmpty»
		«FOR ns : namespace»
		namespace «ns» {
		«ENDFOR»
		«ENDIF»
		
		«usingNamespaces»
		
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
		
		«additionalFunctions»
		
		«IF !namespace.nullOrEmpty»
		«FOR ns : namespace»
		}
		«ENDFOR»
		«ENDIF»
	'''
	}
	

		
	
	def protected usingNamespaces(ExecutionFlow it) {
		''''''
	}
	
	def additionalFunctions(ExecutionFlow it) {
		/* Hook for child classes */
		''''''
	}
	

	def constructorDefinition(ExecutionFlow it){
	'''
		«module»::«module»():
			«initialisationList»
		{
			«constructorBody(it)»
		}
	'''
	}
	
	def protected initialisationList(ExecutionFlow it) {
		'''
			«IF timed»«timerInstance»(«NULL_STRING»),«ENDIF»
			«IF entry.tracingUsed»«tracingInstance»(0),«ENDIF»
			«STATEVECTOR_POS»(0)«FOR s : getInterfaces»,
			«s.instance»()«IF s.hasOperations && !entry.useStaticOPC»,
			«s.OCB_Instance»(«NULL_STRING»)«ENDIF»«ENDFOR»
		'''
	}
	
	def protected initialisationListCopy(ExecutionFlow it) {
		'''
			«IF timed»«timerInstance»(rhs.«timerInstance»),«ENDIF»
			«STATEVECTOR_POS»(rhs.«STATEVECTOR_POS»)«FOR s : getInterfaces»,
			«s.instance»(rhs.«s.instance»)«IF s.hasOperations && !entry.useStaticOPC»,
			«s.OCB_Instance»(rhs.«s.OCB_Instance»)«ENDIF»«ENDFOR»
		'''	
	}
	
	protected def CharSequence constructorBody(ExecutionFlow it)
		'''
		«IF hasHistory»
			for («USHORT_TYPE» i = 0; i < «historyStatesConst»; ++i)
				«HISTORYVECTOR»[i] = «null_state»;
				
		«ENDIF»
		'''
	
	
	def destructorDefinition(ExecutionFlow it) '''
		«module»::~«module»()
		{
		}
	'''
	
	def initFunction(ExecutionFlow it) '''
		«IF entry.checkUnimplementedOCBs»«ERROR_TYPE»«ELSE»void«ENDIF» «module»::«initFctID»()
		{
			«IF entry.checkUnimplementedOCBs»
			«ERROR_TYPE» errorCode = 0;
			
			«unimplementedOCBErrors»«ENDIF»
			for («USHORT_TYPE» i = 0; i < «orthogonalStatesConst»; ++i)
				«STATEVECTOR»[i] = «null_state»;
			
			«IF hasHistory»
			for (sc_ushort i = 0; i < «historyStatesConst»; ++i)
				«HISTORYVECTOR»[i] = «null_state»;
			
			«ENDIF»
			«STATEVECTOR_POS» = 0;
		
			«clearInEventsFctID»();
			«clearOutEventsFctID»();
			
			«initSequence.code»
			«IF entry.checkUnimplementedOCBs»
			return errorCode;
			«ENDIF»
		}
	'''
	
	def enterFunction(ExecutionFlow it) '''
		void «module»::«enterFctID»()
		{
			«enterSequences.defaultSequence.code»
		}
	'''
	
	def exitFunction(ExecutionFlow it) '''
		void «module»::«exitFctID»()
		{
			«exitSequence.code»
		}
	'''
	
	def clearInEventsFunction(ExecutionFlow it) '''
		void «module»::«clearInEventsFctID»()
		{
			«FOR scope : it.scopes»
				«FOR event : scope.incomingEvents»
				«event.access» = false;
				«ENDFOR»
			«ENDFOR»
			«IF hasInternalScope»
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
		void «module»::«clearOutEventsFctID»()
		{
			«FOR scope : it.scopes»
				«FOR event : scope.outgoingEvents»
				«event.access» = false;
				«ENDFOR»
			«ENDFOR»
		}
	'''
	
	def runCycleFunction(ExecutionFlow it) '''
		void «module»::«runCycleFctID»()
		{
			
			«clearOutEventsFctID»();
			«runCycleFunctionForLoop»			
			«clearInEventsFctID»();
		}
	'''
	
	def runCycleFunctionForLoop(ExecutionFlow it) {
		'''
		for («STATEVECTOR_POS» = 0;
			«STATEVECTOR_POS» < «orthogonalStatesConst»;
			«STATEVECTOR_POS»++)
			{
				
			switch («STATEVECTOR»[«STATEVECTOR_POS»])
			{
			«FOR state : states.filter[isLeaf]»
				«IF state.reactMethod !== null»
				case «state.shortName.asEscapedIdentifier» :
				{
					«state.reactMethod.shortName»(true);
					break;
				}
				«ENDIF»
			«ENDFOR»
			default:
				break;
			}
		}
		'''
	}
	
	def timedStatemachineFunctions(ExecutionFlow it) '''
		«IF timed»
			
			void «module»::«SET_TIMER»(«timerInterface»* timerInterface)
			{
				this->«timerInstance» = timerInterface;
			}
			
			«timerInterface»* «module»::«GET_TIMER»()
			{
				return «timerInstance»;
			}
			
			«raiseTimeEventFunction»
		«ENDIF»
	'''
	
	def raiseTimeEventFunction(ExecutionFlow it) '''
		void «module»::«raiseTimeEventFctID»(«EVENT_TYPE» evid)
		{
			if ((evid >= («EVENT_TYPE»)«timeEventsInstance») && (evid < («EVENT_TYPE»)(&«timeEventsInstance»[«timeEventsCountConst»])))
			{
				*(«BOOL_TYPE»*)evid = true;
			}				
		}
	'''
	
	def isStateActiveFunction(ExecutionFlow it) '''
		«BOOL_TYPE» «module»::«stateActiveFctID»(«statesEnumType» state) const
		{
			switch (state)
			{
				«FOR s : states»
				case «s.shortName.asEscapedIdentifier» : 
					return («BOOL_TYPE») («IF s.leaf»«STATEVECTOR»[«s.stateVectorDefine»] == «s.shortName.asEscapedIdentifier»
					«ELSE»«STATEVECTOR»[«s.stateVectorDefine»] >= «s.shortName.asEscapedIdentifier»
						&& «STATEVECTOR»[«s.stateVectorDefine»] <= «s.subStates.last.shortName.asEscapedIdentifier»«ENDIF»);
				«ENDFOR»
				default: return false;
			}
		}
	'''
	
	
	def isActiveFunction(ExecutionFlow it) '''
		«BOOL_TYPE» «module»::«isActiveFctID»() const
		{
			return «FOR i : 0 ..< stateVector.size SEPARATOR '||'»«STATEVECTOR»[«i»] != «null_state»«ENDFOR»;
		}
	'''
	
	def protected isFinalFunction(ExecutionFlow it){
		val finalStateImpactVector = flow.finalStateImpactVector
		'''
			«IF !finalStateImpactVector.isCompletelyCovered»
			/* 
			 * Always returns 'false' since this state machine can never become final.
			 */
			«ENDIF»
			«BOOL_TYPE» «module»::«isFinalFctID»() const
			{
		''' +
		// only if the impact vector is completely covered by final states the state machine 
		// can become final
		{if (finalStateImpactVector.isCompletelyCovered) {'''	return «FOR i : 0 ..<finalStateImpactVector.size SEPARATOR ' && '»(«FOR fs : finalStateImpactVector.get(i) SEPARATOR ' || '»stateConfVector[«i»] == «IF fs.stateVector.offset == i»«fs.shortName»«ELSE»«null_state»«ENDIF»«ENDFOR»)«ENDFOR»;
		'''} else {'''   return false;'''} }		
		+ '''
		}'''
	}
	
	def constantDefinitions(ExecutionFlow it) '''
		«FOR scope : statechartScopes»
			«FOR d : scope.declarations.filter(typeof(VariableDefinition)).filter[const] AFTER newLine»
				«IF d.type.name != 'void'»const «d.typeSpecifier.targetLanguageName» «d.access» = «d.initialValue.code»;«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''
	
	def unimplementedOCBErrors(ExecutionFlow it)'''
		«FOR iface : getInterfaces.filter[hasOperations && !entry.useStaticOPC]»
			«IF iface instanceof InternalScope»
				«checkInternalOCB(iface)»			
			«ELSEIF iface instanceof InterfaceScope»
				«checkInterfaceOCB(iface)»
			«ENDIF»
		«ENDFOR»
	'''
	
	def checkInternalOCB(StatechartScope it) '''
		if (this->«OCB_Instance» == «NULL_STRING») { 
			errorCode |= «ErrorCode.OCB_INTERNAL_INIT.name»;
		}
	'''
	
	def checkInterfaceOCB(StatechartScope it) '''
		«IF defaultInterface»
			if (this->«OCB_Instance» == «NULL_STRING») { 
				errorCode |=  «ErrorCode.OCB_DEFAULT_INIT.name»;
			}
		«ELSE»
			if (this->«OCB_Instance» == «NULL_STRING») { 
				errorCode |= «ErrorCode.OCB_NAMED_INIT.name»;
			}
		«ENDIF»
	'''
	
	/* ===================================================================================
	 * Implementation of interface element access functions
	 */
	
	def interfaceFunctions(ExecutionFlow it) '''
		«FOR scope : statechartScopes»
			«IF scope instanceof InterfaceScope»
			«module»::«scope.interfaceName»* «module»::get«scope.interfaceName»()
			{
				return &«scope.instance»;
			}
			«ENDIF»
			«generateEvents(scope)»
			«generateVariables(scope)»
			«IF scope.hasOperations && !entry.useStaticOPC»
				«scope.OCB_InterfaceSetterDeclaration(true)»
				{
					«scope.OCB_Instance» = operationCallback;
				}
			«ENDIF»
		«ENDFOR»
		«IF entry.tracingUsed»
		void «module»::set«tracingModule»(«tracingModule»* tracingcallback) {
			«tracingInstance» = tracingcallback;
		}
		«ENDIF»
	'''
	
	def generateVariables(ExecutionFlow it, StatechartScope scope)
		'''
			«FOR variable : scope.variableDefinitions»
				«IF variable.const»const «ENDIF»«variable.typeSpecifier.targetLanguageName» «module»::«scope.interfaceName»::«variable.asGetter»() const
				{
					return «variable.localAccess»;
				}
				
				«IF scope.defaultInterface»
					«IF variable.const»const «ENDIF»«variable.typeSpecifier.targetLanguageName» «module»::«variable.asGetter»() const
					{
						return «variable.access»;
					}
					
				«ENDIF»
				«IF !variable.readonly && !variable.const»
					void «module»::«scope.interfaceName»::«variable.asSetter»(«variable.typeSpecifier.targetLanguageName» value)
					{
						«variable.localAccess» = value;
					}
					
					«IF scope.defaultInterface»
						void «module»::«variable.asSetter»(«variable.typeSpecifier.targetLanguageName» value)
						{
							«variable.access» = value;
						}
						
					«ENDIF»
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
		«reactFunctions.filter[ f | ! (f.eContainer instanceof ExecutionState)].toList.toImplementation»
		«reactMethods.toDefinitions»
		
	'''
	
	 def toDefinitions(List<Method> methods) '''
	 	«FOR m : methods»
	 		«m.implementation»
	 		
	 	«ENDFOR»
	 '''
	 
	 def implementation(Method it) '''
	 	«typeSpecifier.targetLanguageName» «execution_flow.module»::«shortName»(«FOR p : parameters SEPARATOR ', '»«IF p.varArgs»...«ELSE»const «p.typeSpecifier.targetLanguageName» «p.name.asIdentifier»«ENDIF»«ENDFOR») {
	 		«body.code»
	 	}
	 '''
	 
	def toImplementation(List<Step> steps) '''
		«FOR s : steps»
			«s.functionImplementation»
		«ENDFOR»
	'''
	
	def dispatch functionImplementation(Check it) '''
		«stepComment»
		«BOOL_TYPE» «execution_flow.module»::«shortName»()
		{
			return «code»;
		}
		
	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		void «execution_flow.module»::«shortName»()
		{
			«code»
		}
		
	'''
}