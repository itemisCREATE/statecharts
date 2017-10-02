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
import java.util.Map
import org.yakindu.sct.generator.c.language.CForLoopFactory
import org.yakindu.sct.generator.c.language.CustomType
import org.yakindu.sct.generator.c.language.Function
import org.yakindu.sct.generator.c.language.Modifier
import org.yakindu.sct.generator.c.language.Preprocessor.Header
import org.yakindu.sct.generator.c.language.Preprocessor.LocalHeader
import org.yakindu.sct.generator.c.language.Preprocessor.SystemHeader
import org.yakindu.sct.generator.c.language.Type
import org.yakindu.sct.generator.c.language.TypeQualifier
import org.yakindu.sct.generator.common.Comment
import org.yakindu.sct.generator.common.IFunction
import org.yakindu.sct.generator.common.Parameter
import org.yakindu.sct.generator.common.factory.FunctionFactory
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
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
	@Inject protected extension FunctionFactory
	@Inject protected extension CForLoopFactory
	
	protected Map<String, List<IFunction>> internalFunctions
	
	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) { 
		initializeNamingService
		setDefaultParameter({
			val p = new Parameter()
			p.type = new CustomType(flow.type + "*")
			p.name = scHandle
			p
		})
		buildInternalFunctions(it)
		val List<Header> includes = newArrayList
		includes.add(new SystemHeader("stdlib.h"))
		includes.add(new SystemHeader("string.h"))
		includes.add(new LocalHeader((typesModule.h).relativeTo(module.c)))
		includes.add(new LocalHeader((module.h).relativeTo(module.c)))
		if(timed || !operations.empty) {
			includes.add(new LocalHeader((module.client.h).relativeTo(module.c)))
		}
	'''
		«entry.licenseText»
		«FOR include : includes»
		«include»
		«ENDFOR»
		/*! \file Implementation of the state machine '«name»'
		*/
		
		«functionPrototypes»
		
		«constantDefinitions»
		
		«functions»
	'''
	}
	
	def buildInternalFunctions(ExecutionFlow it) {
		internalFunctions = newLinkedHashMap()
		internalFunctions.put("Check functions", checkFunctions.map[internalFunction])
		internalFunctions.put("Effect functions", effectFunctions.map[internalFunction])
		internalFunctions.put("Entry action functions", entryActionFunctions.map[internalFunction])
		internalFunctions.put("Exit action functions", exitActionFunctions.map[internalFunction])
		internalFunctions.put("Enter sequence functions", enterSequenceFunctions.map[internalFunction])
		internalFunctions.put("Exit sequence functions", exitSequenceFunctions.map[internalFunction])
		internalFunctions.put("React functions", reactFunctions.map[internalFunction])
		internalFunctions.put("Clear in events", #[clearInEventsFunction])
		internalFunctions.put("Clear out events", #[clearOutEventsFunction])
	}

	def functions(ExecutionFlow it) '''
		«initFunction»
		
		«enterFunction»

		«exitFunction»
		
		«activeFunction»
		
		«finalFunction»
		
		«runCycleFunction»
		
		«raiseTimeEventFunction»

		«isStateActiveFunction»
		
		«interfaceFunctions»
		
		«functionImplementations»
	'''
	
	def initFunction(ExecutionFlow it) {
		function(initFunctionID, initFunctionBody);	
	}
	
	protected def CharSequence initFunctionBody(ExecutionFlow it) {
		'''
		«Type.INT» i;
		
		«forloop("i = 0", '''i < «maxOrthogonalStates»''', "++i",
			'''«scHandle»->stateConfVector[i] = «null_state»;'''
		)»
		«IF hasHistory»
		
		«forloop("i = 0", '''i < «maxHistoryStates»''', "++i",
			'''«scHandle»->historyVector[i] = «null_state»;'''
		)»
		«ENDIF»
		
		«scHandle»->stateConfVectorPosition = 0;

		«clearInEventsFctID»(handle);
		«clearOutEventsFctID»(handle);

		«initSequence.code»
		'''
	}
	
	def enterFunction(ExecutionFlow it) {
		function(enterFunctionID, enterSequences.defaultSequence.code)
	}
	
	def exitFunction(ExecutionFlow it) {
		function(exitFunctionID, exitSequence.code)
	}
	
	def clearInEventsFunction(ExecutionFlow it) {
		function(clearInEventsFctID,
			'''
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
			''',
			#[],
			#[Modifier.STATIC]
		)
	}
	
	def clearOutEventsFunction(ExecutionFlow it) {
		function(clearOutEventsFctID, 
			'''
			«FOR scope : it.scopes»
				«FOR event : scope.outgoingEvents»
				«event.access» = bool_false;
				«ENDFOR»
			«ENDFOR»
			''', #[], #[Modifier.STATIC])	
	}
	
	def runCycleFunction(ExecutionFlow it) {
		function(runCycleFunctionID, 
			'''
			«clearOutEventsFctID»(«scHandle»);
			
			«runCycleForLoop(it)»
			«clearInEventsFctID»(«scHandle»);
			''')
	}
	
	protected def CharSequence runCycleForLoop(ExecutionFlow it) {
		val counter = scHandle + "->stateConfVectorPosition"
		forloop(counter, maxOrthogonalStates, 
			'''
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
			''')
	}
	
	def raiseTimeEventFunction(ExecutionFlow it) {
		if(timed) {
			val func = function(raiseTimeEventFctID,
			'''
			if ( ((sc_intptr_t)evid) >= ((sc_intptr_t)&(«scHandle»->timeEvents))
				&&  ((sc_intptr_t)evid) < ((sc_intptr_t)&(«scHandle»->timeEvents)) + sizeof(«timeEventScope.type»))
				{
				*(sc_boolean*)evid = bool_true;
			}	
			''',
			#["sc_eventid evid"]
			)
			(func.parameters.get(0) as Parameter).typeQualifier = TypeQualifier.CONST
			func
		} else {
			""
		}
	}
	
	def isStateActiveFunction(ExecutionFlow it){
		val func = function(stateActiveFctID, 
			'''
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
			'''
		)
		func.parameters += '''«statesEnumType» state'''
		(func.parameters.get(0) as Parameter).typeQualifier = TypeQualifier.CONST
		func.type = Type.BOOL
		func
	}

	def isActiveFunction(ExecutionFlow it) {
		val func = function(isActiveFctID, 
			'''
			sc_boolean result = bool_false;
			int i;
			
			for(i = 0; i < «type.toUpperCase»_MAX_ORTHOGONAL_STATES; i++)
			{
				result = result || «scHandle»->stateConfVector[i] != «null_state»;
			}
			
			return result;
			''')
		(func.parameters.get(0) as Parameter).typeQualifier = TypeQualifier.CONST
		func.type = Type.BOOL
		func
	}
	
	def protected isFinalFunction(ExecutionFlow it) {
		val finalStateImpactVector = flow.finalStateImpactVector
		
		val func = function(isFinalFctID)
		func.parameters.set(0, "const " + func.parameters.get(0))
		func.type = Type.BOOL
		func.content = {
			if (finalStateImpactVector.isCompletelyCovered) {
				'''return «FOR i : 0 ..<finalStateImpactVector.size SEPARATOR ' && '»(«FOR fs : finalStateImpactVector.get(i) SEPARATOR ' || '»«scHandle»->stateConfVector[«i»] == «IF fs.stateVector.offset == i»«fs.shortName»«ELSE»«null_state»«ENDIF»«ENDFOR»)«ENDFOR»;
				'''
			} 
			else {
				'''return bool_false;'''
			} 
		}
		if(!finalStateImpactVector.isCompletelyCovered) {
			func.documentation = new Comment("Always returns 'false' since this state machine can never become final.")
		}
		func
	}
	
	
	
	/* ===================================================================================
	 * Implementation of interface element accessor functions
	 */
	
	def interfaceIncomingEventRaiser(ExecutionFlow it, EventDefinition event) {
		function(event.asRaiser, 
			'''
			«IF event.hasValue»
			«event.valueAccess» = value;
			«ENDIF»
			«event.access» = bool_true;
			''',
			#[{if(event.hasValue) {event.typeSpecifier.targetLanguageName + ' value'}}]
		)
	}
	
	def interfaceOutgoingEventGetter(ExecutionFlow it, EventDefinition event) {
		val f = function(event.asRaised, '''return «event.access»;''')
		(f.parameters.get(0) as Parameter).typeQualifier = TypeQualifier.CONST
		f.type = Type.BOOL
		f
	}
	
	def interfaceOutgoingEventValueGetter(ExecutionFlow it, EventDefinition event) '''
		«event.typeSpecifier.targetLanguageName» «event.asGetter»(const «scHandleDecl»)
		{
			return «event.valueAccess»;
		}
	'''
	
	def interfaceFunctions(ExecutionFlow it) '''
		«FOR scope : interfaceScopes»
			«FOR event : scope.incomingEvents»
				«interfaceIncomingEventRaiser(event)»
			«ENDFOR»
			
			«FOR event : scope.outgoingEvents»
				«interfaceOutgoingEventGetter(event)»
				«IF event.hasValue» 
					«interfaceOutgoingEventValueGetter(event)»
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
	 
	def functionPrototypes(ExecutionFlow it) '''
		«new Comment("prototypes of all internal functions")»
		«FOR key : internalFunctions.keySet»
		«new Comment(key)»
		«FOR func : internalFunctions.get(key)»
		«(func as Function).declare»
		«ENDFOR»
		
		«ENDFOR»
	'''
	
	def constantDefinitions(ExecutionFlow it) '''
		«FOR scope : scopes.filter(typeof(StatechartScope))»
			«FOR d : scope.declarations.filter(typeof(VariableDefinition)).filter[const]»
				«IF d.type.name != 'void'»const «d.typeSpecifier.targetLanguageName» «d.access» = «d.initialValue.resolveConstants»;«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''

	def internalFunction(Step it) {
		val func = function(shortName)
		switch (it) {
			Check: {
				(func.parameters.get(0) as Parameter).typeQualifier = TypeQualifier.CONST
				func.content = '''return «code»;'''
				func.type = Type.BOOL
			}
			Step: {
				func.content = code
			}
		}
		func.modifiers += Modifier.STATIC
		func
	}
	
	
	/* ===================================================================================
	 * Handling implementation of internal functions
	 */
	 
	/** */
	def functionImplementations(ExecutionFlow it) '''
		«new Comment("implementations of all internal functions")»
		«FOR key : internalFunctions.keySet»
		«new Comment(key)»
		«FOR func : internalFunctions.get(key)»
		«func»
		«ENDFOR»
		
		«ENDFOR»
	'''	
}