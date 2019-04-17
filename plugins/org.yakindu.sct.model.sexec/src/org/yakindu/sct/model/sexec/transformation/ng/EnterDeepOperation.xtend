package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Visibility
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart

@Singleton
class EnterDeepOperation {

	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder

	@Inject extension RegionType
	@Inject extension StateType

	@Inject extension SgraphExtensions
	@Inject extension StateVector
	@Inject extension HistoryVector
	@Inject extension StatemachineProperties
	@Inject extension StatemachinePublic
	@Inject extension EnterOperation
	@Inject extension StateOperations

	def declareEnterDeepOperations(Statechart sc) {
		sc.eAllContents.filter(Region).filter[requireDeepHistory].forEach[enterDeep]
	}

	def defineEnterDeepOperations(Statechart sc) {
		sc.eAllContents.filter(Region).filter[requireDeepHistory].forEach[defineEnterDeep]
	}

	def create _op enterDeep(Region r) {
		name = "enter_deep"
		_type(ITypeSystem.VOID)
		visibility = Visibility.PROTECTED
		r.type.features += it
	}

	def protected defineEnterDeep(Region r) {
		r.enterDeep => [
			body = _block(r.deepHistorySwitch)
		]
	}

	def protected deepHistorySwitch(Region r) {
		val sc = r.statechart

		val historySwitch = _switch(sc.historyVectorProperty._ref._get(r.historyVector.offset._int))

		for (child : r.vertices.filter(State)) {
			for (childLeaf : child.collectLeafStates(newArrayList).
				filter(c|c.stateVector.offset == r.stateVector.offset)) {
				val List<Expression> actions = newArrayList

				if (child.leaf) {
					actions += child.type.defaultEnterSequence._call
				} else {
					if(child.entryAction !== null) actions += child.entryAction._call
//					if(trace.addTraceSteps) seq.steps += execChild.newTraceStateEntered
					for (childRegion : child.regions) {
						actions += childRegion.enterDeep._call
					}
				}

				historySwitch.cases += _case(childLeaf.enumerator._ref, _block(actions))
			}
		}
		historySwitch.^default = _block

		return historySwitch
	}

}
