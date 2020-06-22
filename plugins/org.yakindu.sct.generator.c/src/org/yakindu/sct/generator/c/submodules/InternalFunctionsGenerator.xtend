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
import java.util.List
import org.yakindu.sct.generator.c.ConstantInitializationResolver
import org.yakindu.sct.generator.c.FlowCode
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService

import static org.yakindu.sct.generator.c.CGeneratorConstants.BOOL_TYPE
import org.yakindu.sct.generator.c.types.CLiterals
import org.eclipse.emf.ecore.EObject
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.CheckRef
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Parameter
import org.yakindu.sct.model.sexec.LocalVariableDefinition
import org.yakindu.base.types.ComplexType
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.sct.model.sexec.extensions.ShadowEventExtensions
import org.yakindu.sct.generator.c.extensions.EventNaming
import org.yakindu.sct.generator.c.TraceCode
import org.yakindu.sct.model.stext.stext.EventDefinition

/**
 * @author rbeckmann
 * @author axel terfloth
 */
@Singleton // Guice
class InternalFunctionsGenerator {
	@Inject protected extension Naming
	@Inject protected extension GenmodelEntries
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension FlowCode
	@Inject protected extension ConstantInitializationResolver
	@Inject protected extension StateVectorExtensions
	@Inject protected extension ExpressionsChecker
	@Inject protected extension CLiterals
	@Inject protected extension GeneratorPredicate
	@Inject protected extension ShadowEventExtensions
	@Inject protected extension EventNaming
	
	@Inject protected extension	TraceCode 
	@Inject protected extension	EventCode 
	

	def observerCallbacksImplementations(ExecutionFlow it) '''
		«FOR e : shadowEvents»
			static void «e.observerCallbackFctID»(«scHandleDecl», «IF e.typeSpecifier === null»void*«ELSE»«e.typeSpecifier.targetLanguageName»*«ENDIF» value)
			{
				«e.traceCode( if (e.hasValue) "&value" else "sc_null" )»
				«interfaceIncomingEventRaiserBody(e as EventDefinition)»
				
				«IF ! e.hasValue»
					«unusedParam("value")»
				«ENDIF»
			}
			
		«ENDFOR»
	'''

//	def observerCallbacksImplementations(ExecutionFlow it) '''
//		«FOR e : shadowEvents»
//			static void «e.observerCallbackFctID»(«scHandleDecl», «IF e.typeSpecifier === null»void*«ELSE»«e.typeSpecifier.targetLanguageName»*«ENDIF» value)
//			{
//				«IF e.typeSpecifier === null»
//				«addToQueueFctID»(&«scHandle»->«inEventQueue», «e.eventEnumMemberName»);
//				«unusedParam("value")»
//				«ELSE»
//				«addToQueueValueFctID»(&«scHandle»->«inEventQueue», «e.eventEnumMemberName», value);
//				«ENDIF»
//				«runCycleFctID»(«scHandle»);
//			}
//			
//		«ENDFOR»
//	'''

	def observerCallbacksPrototypes(ExecutionFlow it) '''
		«FOR e : shadowEvents»
			static void «e.observerCallbackFctID»(«scHandleDecl», «IF e.typeSpecifier === null»void*«ELSE»«e.typeSpecifier.targetLanguageName»*«ENDIF» value);
		«ENDFOR»
	'''

	def clearInEventsFunction(ExecutionFlow it) '''
		static void «clearInEventsFctID»(«scHandleDecl»)
		{
			«var clearedEvents = 0»
			«FOR scope : it.scopes»
				«FOR event : scope.incomingEvents»
					«NOOUT(clearedEvents+=1)»
					«event.access» = «FALSE_LITERAL»;
				«ENDFOR»
			«ENDFOR»
			«IF hasInternalScope»
				«FOR event : internalScope.events»
					«NOOUT(clearedEvents+=1)»
					«event.access» = «FALSE_LITERAL»;
				«ENDFOR»
			«ENDIF»
			«IF timed»
				«FOR event : timeEventScope.events»
					«NOOUT(clearedEvents+=1)»
					«event.access» = «FALSE_LITERAL»;
				«ENDFOR»
			«ENDIF»
			«IF clearedEvents == 0»
				«unusedParam(scHandle)»
			«ENDIF»
		}
	'''
	
	def <T> NOOUT(T p) ''''''
	
	def clearOutEventsFunction(ExecutionFlow it) {
		var clearedEvents = 0
		'''
			static void «clearOutEventsFctID»(«scHandleDecl»)
			{
				«FOR scope : it.scopes»
					«FOR event : scope.outgoingEvents»
						«NOOUT(clearedEvents+=1)»
						«event.access» = «FALSE_LITERAL»;
					«ENDFOR»
				«ENDFOR»
				«IF clearedEvents == 0»
					«unusedParam(scHandle)»
				«ENDIF»
			}
		'''	
	}
	
	def defines(ExecutionFlow it) '''
		#ifndef SC_UNUSED
		#define SC_UNUSED(P) (void)(P)
		#endif
	'''

	
	
	def functionPrototypes(ExecutionFlow it) '''
		/* prototypes of all internal functions */
		«checkFunctions.toPrototypes»
		«effectFunctions.toPrototypes»
		«entryActionFunctions.toPrototypes»
		«exitActionFunctions.toPrototypes»
		«enterSequenceFunctions.toPrototypes»
		«exitSequenceFunctions.toPrototypes»
		«reactFunctions.filter[ f | ! (f.eContainer instanceof ExecutionState)].toList.toPrototypes»
	'''
	
	
	
	
	def toPrototypes(List<Step> steps) '''
		«FOR s : steps»
			«s.functionPrototype»
		«ENDFOR»
	'''
	
	def dispatch functionPrototype(Check it) '''
		static «BOOL_TYPE» «shortName»(const «scHandleDecl»);
	'''
	
	def dispatch functionPrototype(Step it) '''
		static void «shortName»(«scHandleDecl»);
	'''	
	
	def functionImplementations(ExecutionFlow it) '''
		/* implementations of all internal functions */
		
		«checkFunctions.toImplementation»
		«effectFunctions.toImplementation»
		«entryActionFunctions.toImplementation»
		«exitActionFunctions.toImplementation»
		«enterSequenceFunctions.toImplementation»
		«exitSequenceFunctions.toImplementation»
		«reactFunctions.filter[ f | ! (f.eContainer instanceof ExecutionState)].toList.toImplementation»
	'''


	
	def toImplementation(List<Step> steps) '''
		«FOR s : steps»
			«s.functionImplementation»
		«ENDFOR»
	'''
	
	def dispatch functionImplementation(Check it) '''
		«stepComment»
		static «BOOL_TYPE» «shortName»(const «scHandleDecl»)
		{
			return «code»;
		}
		
	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		static void «shortName»(«scHandleDecl»)
		{
			«code»
			«IF !it.requiresHandles»
				«unusedParam(scHandle)»
			«ENDIF»
		}
		
	'''
}
