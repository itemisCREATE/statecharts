/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp.classes.members

import com.google.inject.Inject
import org.yakindu.sct.generator.c.language.CFunctionFactory
import org.yakindu.sct.generator.c.language.CustomType
import org.yakindu.sct.generator.c.language.Type
import org.yakindu.sct.generator.c.language.TypeQualifier
import org.yakindu.sct.generator.core.language.Comment
import org.yakindu.sct.generator.core.language.IFunction
import org.yakindu.sct.generator.core.language.IType
import org.yakindu.sct.generator.core.language.Parameter
import org.yakindu.sct.generator.core.language.factory.IStandardFunctionProvider
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.CppExpressionsGenerator
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.EventCode
import org.yakindu.sct.generator.cpp.FlowCode
import org.yakindu.sct.generator.cpp.Navigation
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.language.CodePartExtensions
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

/**
 * @author rbeckmann
 *
 */
class StandardFunctionProvider implements IStandardFunctionProvider {
	@Inject extension CFunctionFactory
	
	@Inject protected extension CppNaming
	@Inject protected extension Navigation
	@Inject protected extension FlowCode
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension CppExpressionsGenerator
	@Inject protected extension StateVectorExtensions
	@Inject protected extension EventCode
	
	@Inject protected extension CodePartExtensions
	
	override public IFunction init(ExecutionFlow it) {
		function("init", '''
			for (int i = 0; i < «orthogonalStatesConst»; ++i)
				stateConfVector[i] = «flow.null_state»;
			
			«IF flow.hasHistory»
			for (int i = 0; i < «historyStatesConst»; ++i)
				historyVector[i] = «flow.null_state»;
			
			«ENDIF»
			stateConfVectorPosition = 0;
			
			clearInEvents();
			clearOutEvents();
			
			«flow.initSequence.code»
		''')
	}
	
	override public IFunction enter(ExecutionFlow it) {
		function("enter", flow.enterSequences.defaultSequence.code)
	}
	
	override public IFunction exit(ExecutionFlow it) {
		function("exit", flow.exitSequence.code)
	}
	
	override public IFunction runCycle(ExecutionFlow it) {
		function("runCycle", '''
			clearOutEvents();
			for (stateConfVectorPosition = 0;
				stateConfVectorPosition < «orthogonalStatesConst»;
				stateConfVectorPosition++)
				{
					
				switch (stateConfVector[stateConfVectorPosition])
				{
				«FOR state : flow.states»
					«IF state.reactSequence !== null»
					case «state.shortName.asEscapedIdentifier» :
					{
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
		''')
	}
	
	override public IFunction isActive(ExecutionFlow it) {
		val isActive = function("isActive", '''return «FOR i : 0 ..< stateVector.size SEPARATOR '||'»stateConfVector[«i»] != «null_state»«ENDFOR»;''')
		isActive.type = Type.BOOL
		isActive.setFunctionConst
		isActive		
	}
	
	override public IFunction isStateActive(ExecutionFlow it, IType statesEnumType) {
		val isStateActive = function(flow.stateActiveFctID, '''
			switch (state)
			{
				«FOR s : flow.states»
				case «s.shortName.asEscapedIdentifier» : 
					return (sc_boolean) («IF s.leaf»stateConfVector[«s.stateVectorDefine»] == «s.shortName.asEscapedIdentifier»
					«ELSE»stateConfVector[«s.stateVectorDefine»] >= «s.shortName.asEscapedIdentifier»
						&& stateConfVector[«s.stateVectorDefine»] <= «s.subStates.last.shortName.asEscapedIdentifier»«ENDIF»);
				«ENDFOR»
				default: return false;
			}
		''',
		#[new Parameter(statesEnumType, "state")])
		isStateActive.type = Type.BOOL
		isStateActive.setFunctionConst
		isStateActive
	}
	
	override public IFunction isFinal(ExecutionFlow it) {
		val isFinal = function("isFinal")
		if(!finalStateImpactVector.isCompletelyCovered) {
			isFinal.documentation = new Comment("Always returns 'false' since this state machine can never become final.")
		}
		isFinal.type = Type.BOOL
		isFinal.setFunctionConst
		isFinal.content = {
			if (finalStateImpactVector.isCompletelyCovered) {
			'''return «FOR i : 0 ..<finalStateImpactVector.size SEPARATOR ' && '»(«FOR fs : finalStateImpactVector.get(i) SEPARATOR ' || '»stateConfVector[«i»] == «IF fs.stateVector.offset == i»«fs.shortName»«ELSE»«null_state»«ENDIF»«ENDFOR»)«ENDFOR»;
			'''
			} else {
			'''return false;'''
			} 
		}
		isFinal
	}
	
	/* Timed functions */
	
	override public IFunction setTimer() {
		function("setTimer", '''this->«timerInstance» = timerInterface;''', #['''«timerInterface»* timerInterface'''])
	}
	
	override public IFunction getTimer() {
		val getTimer = function("getTimer", '''return «timerInstance»;''')
		getTimer.type = new CustomType(timerInterface + "*")
		getTimer
	}
	
	override public IFunction raiseTimeEvent(ExecutionFlow it) {
		function(raiseTimeEventFctID, '''
			if ((evid >= (sc_eventid)«timeEventsInstance») && (evid < (sc_eventid)(&«timeEventsInstance»[«timeEventsCountConst»])))
			{
				*(sc_boolean*)evid = true;
			}
			''',
			#["sc_eventid evid"]
		)
	}
	
	/*
	 * Event functions
	 */
	/* Value getters */
	def protected IFunction getEventValue(EventDefinition evd, StatechartScope scope) {
		val getValue = function(evd.asGetter)
		getValue.documentation = new Comment('''Get value of event «evd.name» in interface «scope.interfaceName»''')
		getValue.setFunctionConst
		getValue.type = new CustomType(evd.typeSpecifier.targetLanguageName)
		getValue
	}
	
	override IFunction getDefaultInterfaceEventValue(StatechartScope scope, EventDefinition evd) {
		val getValue = getEventValue(evd, scope)
		getValue.content = '''return «scope.instance».«evd.asGetter»();'''
		getValue
	}
	
	override IFunction getInterfaceEventValue(StatechartScope scope, EventDefinition evd) {
		val getValue = getEventValue(evd, scope)
		getValue.content = '''return «evd.localValueAccess»;'''
		getValue
	}
	
	override IFunction getInternalEventValue(StatechartScope scope, EventDefinition evd) {
		getInterfaceEventValue(scope, evd)
	}
	
	/* Raised checkers */
	def protected IFunction isEventRaised(EventDefinition evd, StatechartScope scope) {
		val isRaised = function(evd.asRaised)
		isRaised.documentation = new Comment('''Check if event «evd.name» in interface «scope.interfaceName» is raised.''')
		isRaised.setFunctionConst
		isRaised.type = Type.BOOL
		isRaised
	}
	
	override IFunction isDefaultInterfaceEventRaised(StatechartScope scope, EventDefinition evd) {
		val isRaised = isEventRaised(evd, scope)
		isRaised.content = '''return «scope.instance».«evd.asRaised»();'''
		isRaised
	}
	
	override IFunction isInterfaceEventRaised(StatechartScope scope, EventDefinition evd) {
		val isRaised = isEventRaised(evd, scope)
		isRaised.content = '''return «evd.localAccess»;'''
		isRaised
	}
	
	override IFunction isInternalEventRaised(StatechartScope scope, EventDefinition evd) {
		isInterfaceEventRaised(scope, evd)
	}
	
	/* Event raisers */
	def protected IFunction raiseEvent(EventDefinition evd, StatechartScope scope) {
		val raise = function(evd.asRaiser)
		raise.documentation = new Comment('''Raise event «evd.name» in interface «scope.interfaceName»''')
		if(evd.hasValue) {
			raise.parameters += new Parameter(new CustomType(evd.typeSpecifier.targetLanguageName), "value")
		}
		raise
	}
	
	override IFunction raiseDefaultInterfaceEvent(StatechartScope scope, EventDefinition evd) {
		val raise = raiseEvent(evd, scope)
		raise.content = '''«scope.instance».«evd.asRaiser»(«IF evd.hasValue»value«ENDIF»);'''
		raise
	}
	
	override IFunction raiseInterfaceEvent(StatechartScope scope, EventDefinition evd) {
		val raise = raiseEvent(evd, scope)
		raise.content = '''
			«IF evd.hasValue»
			«evd.localValueAccess» = value;
			«ENDIF»
			«evd.localAccess» = true;
			'''
		raise
	}
	
	override IFunction raiseInternalEvent(StatechartScope scope, EventDefinition evd) {
		raiseInterfaceEvent(scope, evd)
	}
	
	def protected IFunction getVariable(VariableDefinition vad) {
		val getVariable = function(vad.asGetter)
		getVariable.type = new CustomType(vad.typeSpecifier.targetLanguageName)
		if(vad.const) {
			getVariable.typeQualifier = TypeQualifier.CONST
		}
		getVariable.setFunctionConst
		getVariable
	}
	
	override getDefaultInterfaceVariable(VariableDefinition vad) {
		val getVariable = getVariable(vad)
		getVariable.content = '''return «vad.access»;'''
		getVariable
	}
	
	override getInterfaceVariable(VariableDefinition vad) {
		val getVariable = getVariable(vad)
		getVariable.content = '''return «vad.localAccess»;'''
		getVariable
	}
	
	def protected IFunction setVariable(VariableDefinition vad) {
		val setVariable = function(vad.asSetter)
		setVariable.parameters += new Parameter(new CustomType(vad.typeSpecifier.targetLanguageName), "value")
		setVariable
	}
	
	override setDefaultInterfaceVariable(VariableDefinition vad) {
		val setVariable = setVariable(vad)
		setVariable.content = '''«vad.access» = value;'''
		setVariable
	}
	
	override setInterfaceVariable(VariableDefinition vad) {
		val setVariable = setVariable(vad)
		setVariable.content = '''«vad.localAccess» = value;'''
		setVariable
	}
	
}