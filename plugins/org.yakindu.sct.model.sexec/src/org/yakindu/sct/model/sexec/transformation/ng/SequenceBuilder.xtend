/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.yakindu.base.expressions.expressions.SwitchExpression
import org.yakindu.base.types.Expression
import org.yakindu.base.types.typesystem.ITypeValueProvider
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sexec.transformation.TraceExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart

class SequenceBuilder extends org.yakindu.sct.model.sexec.transformation.SequenceBuilder {

	@Inject extension SgraphExtensions sgraph
	@Inject extension SexecElementMapping mapping
	@Inject extension TraceExtensions trace

	@Inject extension ITypeValueProvider tvp
	@Inject extension TypeBuilder tBuilder
	@Inject extension ExpressionBuilder eBuilder
	@Inject extension StatemachineExpressionBuilder smeBuilder
	@Inject extension StatemachineProperties smProperties
	@Inject extension StateOperations stateOperations
	@Inject extension EnterOperation scopeOperations
	@Inject extension StatemachinePublic smPublic
	@Inject extension StateType stateType
	@Inject extension RegionType regionType
	@Inject extension EntryReactOperation enMethods
	@Inject extension ExitSequence
	@Inject extension StateVector
	@Inject extension ImpactVector
	@Inject extension StatechartExtensions

//	@Inject(optional=true)
//	@Named(IModelSequencer.ADD_TRACES)
//	boolean _addTraceSteps = false


	override defineStatechartExitSequence(ExecutionFlow flow, Statechart sc) {
		val res =super.defineStatechartExitSequence(flow, sc)
		
		val exitOperation = sc.statemachineType.exitSequence()
		exitOperation._comment("Default exit sequence for statechart " + sc.name)
		exitOperation.body = _block(
			sc.regions.map[type.exitSequence].filterNull
			.map[regionExit | regionExit._call]
		)
//		if(flow.exitAction !== null) exitSequence.steps.add(flow.exitAction.newCall)
		return res
	}
	
	override dispatch void defineStateExitSequence(State s) {
		super._defineStateExitSequence(s)
		
		val exitOperation = s.type.exitSequence
		exitOperation._comment("Default exit sequence for state " + s.name)
		val List<Expression> exitExpressions = newArrayList
		if (s.leaf) {
			exitExpressions += s._exitState
		} else {
			for (r : s.regions) {
				// first enforce calculation of all child exit sequences
//				r.defineStateExitSequence
				if (r.type.resolveExitSequence !== null) {
					exitExpressions += r.type.resolveExitSequence._call
				}
			}
		}

		if(s.exitAction !== null) exitExpressions.add(s.exitAction._call)
//		if(_addTraceSteps) seq.steps += execState.newTraceStateExited
		exitOperation.body = _block(exitExpressions)
	}
	
	override dispatch void defineStateExitSequence(Region r) {
		super._defineStateExitSequence(r)
		
		val exitOperation = r.type.exitSequence
		exitOperation._comment("Default exit sequence for region " + r.name)
		val List<Expression> exitExpressions = newArrayList

		// process all states of a region
//		for (s : r.vertices)
//			defineStateExitSequence(s)

		// collect leaf states
		val Iterable<RegularState> leafStates = r.collectLeafStates(new ArrayList<RegularState>())
		val sVector = r.stateVector

		for (i : sVector.offset .. sVector.offset + sVector.size - 1) {
			// create a state switch for each state configuration vector position
			val SwitchExpression sSwitch = r.defineExitSwitch(leafStates, i)
			exitExpressions += sSwitch
		}

		exitOperation.body = _block(exitExpressions)

	}
	
	override dispatch void defineStateExitSequence(FinalState fs) {
		super._defineScopeEnterSequences(fs)
		
		val exitOperation = fs.type.exitSequence
		exitOperation._comment("Default exit sequence for final state")
		val List<Expression> exitExpressions = newArrayList
		exitExpressions += fs._exitState

//		if(_addTraceSteps) seq.steps += execState.newTraceStateExited

		exitOperation.body = _block(exitExpressions)
	}
	
	def SwitchExpression defineExitSwitch(Region region, Iterable<RegularState> leafStates, int pos) {
		// create a state switch
		var SwitchExpression sSwitch = _switch(region.statechart.stateVectorProperty._ref._get(pos._int))
		sSwitch._comment("Handle exit of all possible states (of " + region.name + ") at position " + pos + "...")

		val Iterable<RegularState> posStates = leafStates.filter(
			rs|rs.stateVector.size == 1 && rs.stateVector.offset == pos)

		// create a case for each leaf state
		for (s : posStates) {
			
			val List<Expression> caseExp = newArrayList

			//Save regions if necessary
			val exitScopes = s.parentScopes
			exitScopes.removeAll(region.parentScopes)
			exitScopes.remove(s)

			//Leave leaf
			if (s.type.exitSequence !== null) {
				caseExp += s.type.exitSequence._call
			}
			// include exitAction calls up to the direct child level.
			exitScopes.fold(caseExp,
				[cs, exitScope|
					{
						if (exitScope instanceof RegularState) {
							if (s.impactVector.last == exitScope.impactVector.last) {
								if (exitScope.exitAction !== null) cs += exitScope.exitAction._call
	//							if(_addTraceSteps) cs.steps.add(execState.newTraceStateExited)
							}
						}
						cs
					}])

			if (!caseExp.isEmpty) sSwitch.cases += _case(s.enumerator._ref, _block(caseExp))
			sSwitch.^default = _block
		}
		return sSwitch
	}
	
		

}
