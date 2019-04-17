package org.yakindu.sct.model.sexec.transformation.ng.operations

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.ArrayList
import java.util.List
import org.yakindu.base.expressions.expressions.SwitchExpression
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sexec.transformation.ng.RegionType
import org.yakindu.sct.model.sexec.transformation.ng.StateType
import org.yakindu.sct.model.sexec.transformation.ng.StatemachineProperties
import org.yakindu.sct.model.sexec.transformation.ng.StatemachinePublic
import org.yakindu.sct.model.sexec.transformation.ng.expressions.StatemachineExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.ng.vectors.ImpactVector
import org.yakindu.sct.model.sexec.transformation.ng.vectors.StateVector
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart

@Singleton
class ExitOperation {

	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension StatemachineExpressionBuilder

	@Inject extension StateType
	@Inject extension RegionType

	@Inject extension StatemachinePublic
	@Inject extension StatemachineProperties
	@Inject extension ExitActionOperation

	@Inject extension SgraphExtensions
	@Inject extension StatechartExtensions

	@Inject extension StateVector
	@Inject extension ImpactVector

	def declareExitOperations(Statechart sc) {
		sc.eAllContents.filter(Region).forEach[exitOperation]
		sc.eAllContents.filter(State).forEach[exitOperation]
		sc.eAllContents.filter(FinalState).forEach[exitOperation]

		sc.exitOperation
	}

	def defineExitOperations(Statechart sc) {
		sc.eAllContents.filter(Region).forEach[defineExitOperation]
		sc.eAllContents.filter(State).forEach[defineExitOperation]
		sc.eAllContents.filter(FinalState).forEach[defineExitOperation]

		sc.defineExitOperation
	}

	def resolveExitOperation(ComplexType it) {
		features.filter(Operation).findFirst[name == exitOperationName]
	}

	def protected create op : _op exitOperation(FinalState s) {
		op.name = exitOperationName
		op._comment("Default exit sequence for final state " + s.name)
		s.type.features += op
	}

	def protected create op : _op exitOperation(State s) {
		op.name = exitOperationName
		op._comment("Default exit sequence for state " + s.name)
		s.type.features += op
	}

	def protected create op : _op exitOperation(Region r) {
		op.name = exitOperationName
		op._comment("Default exit sequence for region " + r.name)
		r.type.features += op
	}

	def protected create op : _op exitOperation(Statechart sc) {
		op.name = exitOperationName
		op._comment("Default exit sequence for statechart " + sc.name)
		sc.statemachineType.features += op
	}

	def protected defineExitOperation(FinalState fs) {
		fs.exitOperation.body = _block => [
			expressions += fs._exitState
		]
	}

	def protected defineExitOperation(State s) {
		s.exitOperation.body = _block => [
			if (s.leaf) {
				expressions += s._exitState
			} else {
				for (r : s.regions) {
					if (r.type.resolveExitOperation !== null) {
						expressions += r.type.resolveExitOperation._call
					}
				}
			}
			if(s.resolveExitActionOperation !== null) expressions += s.resolveExitActionOperation._call
		]
	}

	def protected defineExitOperation(Region r) {
		r.exitOperation.body = _block => [
			// collect leaf states
			val leafStates = r.collectLeafStates(new ArrayList<RegularState>())
			val sVector = r.stateVector

			for (i : sVector.offset .. sVector.offset + sVector.size - 1) {
				// create a state switch for each state configuration vector position
				expressions += r.defineExitSwitch(leafStates, i)
			}
		]
	}

	def protected defineExitOperation(Statechart sc) {
		sc.exitOperation.body = _block => [
			expressions += sc.regions.map[type.resolveExitOperation].filterNull.map[regionExit|regionExit._call]
		// TODO: statechart exit actions
		]

	}

	def protected exitOperationName() {
		"exitSequence"
	}

	def protected SwitchExpression defineExitSwitch(Region region, Iterable<RegularState> leafStates, int pos) {
		// create a state switch
		var SwitchExpression sSwitch = _switch(region.statechart.stateVectorProperty._ref._get(pos._int))
		sSwitch._comment("Handle exit of all possible states (of " + region.name + ") at position " + pos + "...")

		val Iterable<RegularState> posStates = leafStates.filter( rs |
			rs.stateVector.size == 1 && rs.stateVector.offset == pos
		)

		// create a case for each leaf state
		for (s : posStates) {

			val List<Expression> caseExp = newArrayList

			// Save regions if necessary
			val exitScopes = s.parentScopes
			exitScopes.removeAll(region.parentScopes)
			exitScopes.remove(s)

			// Leave leaf
			if (s.type.resolveExitOperation !== null) {
				caseExp += s.type.resolveExitOperation._call
			}
			// include exitAction calls up to the direct child level.
			exitScopes.fold(caseExp, [ cs, exitScope |
				{
					if (exitScope instanceof RegularState) {
						if (s.impactVector.last == exitScope.impactVector.last) {
							if(exitScope.resolveExitActionOperation !== null) cs += exitScope.resolveExitActionOperation._call
						// if(_addTraceSteps) cs.steps.add(execState.newTraceStateExited)
						}
					}
					cs
				}
			])

			if(!caseExp.isEmpty) sSwitch.cases += _case(s.enumerator._ref, _block(caseExp))
			sSwitch.^default = _block
		}
		return sSwitch
	}

}
