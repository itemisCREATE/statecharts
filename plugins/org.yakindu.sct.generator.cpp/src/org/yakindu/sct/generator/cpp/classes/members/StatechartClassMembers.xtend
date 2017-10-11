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
import org.yakindu.sct.generator.c.language.ArrayVariable
import org.yakindu.sct.generator.c.language.CustomType
import org.yakindu.sct.generator.c.language.Type
import org.yakindu.sct.generator.c.language.Variable
import org.yakindu.sct.generator.core.language.Comment
import org.yakindu.sct.generator.core.language.IFunction
import org.yakindu.sct.generator.core.language.IType
import org.yakindu.sct.generator.core.language.factory.FunctionFactory
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.EventCode
import org.yakindu.sct.generator.cpp.ExpressionCode
import org.yakindu.sct.generator.cpp.FlowCode
import org.yakindu.sct.generator.cpp.Naming
import org.yakindu.sct.generator.cpp.Navigation
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.language.CodePartExtensions
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.StatechartScope

/**
 * @author rbeckmann
 *
 */
class StatechartClassMembers {
	@Inject protected extension Naming
	@Inject protected extension Navigation
	@Inject protected extension FlowCode
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension ExpressionCode
	@Inject protected extension StateVectorExtensions
	@Inject protected extension EventCode
	@Inject protected extension StatechartExtensions
	
	@Inject extension FunctionFactory
	@Inject extension CodePartExtensions
	
	def public IFunction setTimer(ExecutionFlow flow) {
		function("setTimer", '''this->«timerInstance» = timerInterface;''', #['''«timerInterface»* timerInterface'''])
	}
	
	def public IFunction getTimer() {
		val getTimer = function("getTimer", '''return «timerInstance»;''')
		getTimer.type = new CustomType(timerInterface + "*")
		getTimer
	}
	
	def public IFunction raiseTimeEvent(ExecutionFlow it) {
		function(raiseTimeEventFctID, '''
			if ((evid >= (sc_eventid)«timeEventsInstance») && (evid < (sc_eventid)(&«timeEventsInstance»[«timeEventsCountConst»])))
			{
				*(sc_boolean*)evid = true;
			}
			''',
			#["sc_eventid evid"]
		)
	}
	
	def public IFunction clearInEvents(ExecutionFlow it) {
		function("clearInEvents", '''
			«FOR scope : scopes»
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
		''')
	}
	
	def public IFunction clearOutEvents(ExecutionFlow it) {
		function("clearOutEvents", '''
		«FOR scope : it.scopes»
			«FOR event : scope.outgoingEvents»
			«event.access» = false;
			«ENDFOR»
		«ENDFOR»
		''')
	}

	def orthogonalStatesConstVar(ExecutionFlow it) {
		val orthogonalStatesConstVar = new Variable(Type.INT, orthogonalStatesConst)
		orthogonalStatesConstVar.setStatic
		orthogonalStatesConstVar.setConst
		orthogonalStatesConstVar.initialValue = flow.stateVector.size.toString
		orthogonalStatesConstVar.documentation = new Comment("The maximum number of orthogonal states defines the dimension of the state configuration vector.")
		orthogonalStatesConstVar
	}
	
	def historyStatesConstVar(ExecutionFlow it) {
		val historyStatesConstVar = new Variable(Type.INT, historyStatesConst)
		historyStatesConstVar.setStatic
		historyStatesConstVar.setConst
		historyStatesConstVar.initialValue = flow.historyVector.size.toString
		historyStatesConstVar.documentation = new Comment("Dimension of the state configuration vector for history states")
		historyStatesConstVar
	}
	
	def timerInterfaceInstance() {
		new Variable(timerInterface.pointer, timerInstance)
	}
	
	def timeEventsArray() {
		new ArrayVariable(Type.BOOL, timeEventsInstance, timeEventsCountConst)
	}
	
	def stateConfVectorArray(ExecutionFlow it, IType statesEnumType) {
		new ArrayVariable(statesEnumType, "stateConfVector", orthogonalStatesConstVar)
	}
	
	def historyVectorArray(ExecutionFlow it, IType statesEnumType) {
		new ArrayVariable(statesEnumType, "historyVector", historyStatesConst)
	}
	
	def stateConfVectorPosition() {
		new Variable(Type.SHORT, "stateConfVectorPosition")
	}
	
	def interfacePointerInstance(StatechartScope it) {
		new Variable(interfaceName.pointer, instance)
	}
	
	def interfaceInstance(StatechartScope it) {
		new Variable(interfaceName, instance)
	}
	
	def ocbInterfaceInstance(StatechartScope it) {
		new Variable(interfaceOCBName.pointer, OCB_Instance)
	}
	
	def internalFunction(Step it) {
		val func = function(shortName)
		switch (it) {
			Check: {
				func.content = '''return «code»;'''
				func.type = Type.BOOL
			}
			Step: {
				func.content = code
			}
		}
		func
	}
	
	def timeEventsCountConstVar(ExecutionFlow it) {
		val timeEventsCountConstVar = new Variable(Type.INT, timeEventsCountConst)
		timeEventsCountConstVar.initialValue = timeEvents.size.toString
		timeEventsCountConstVar.setStatic
		timeEventsCountConstVar.setConst
		timeEventsCountConstVar
	}
	
	def timeEventsCountparallelConstVar(ExecutionFlow it) {
		val timeEventsCountparallelConstVar = new Variable(Type.INT, timeEventsCountparallelConst)
		timeEventsCountparallelConstVar.initialValue = (it.sourceElement as Statechart).maxNumberOfParallelTimeEvents.toString
		timeEventsCountparallelConstVar.setStatic
		timeEventsCountparallelConstVar.setConst
		timeEventsCountparallelConstVar
	}
}