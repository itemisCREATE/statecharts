/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sequencer.operations

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.Expression
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.Visibility
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sequencer.types.RegionType
import org.yakindu.sct.model.sequencer.types.StateType
import org.yakindu.sct.model.sequencer.types.StatemachineProperties
import org.yakindu.sct.model.sequencer.types.StatemachinePublic
import org.yakindu.sct.model.sequencer.util.SgraphExtensions
import org.yakindu.sct.model.sequencer.vectors.HistoryVector
import org.yakindu.sct.model.sequencer.vectors.StateVector
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
	@Inject extension EntryActionOperation

	def declareEnterDeepOperations(Statechart sc) {
		sc.eAllContents.filter(Region).filter[requireDeepHistory].forEach[enterDeep]
	}

	def defineEnterDeepOperations(Statechart sc) {
		sc.eAllContents.filter(Region).filter[requireDeepHistory].forEach[defineEnterDeep]
	}

	def create op : _op enterDeep(Region r) {
		op.name = "enter_deep"
		op._type(ITypeSystem.VOID)
		op.visibility = Visibility.PROTECTED
		r.type.features += op
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
					if(child.entryActionOperation !== null) actions += child.entryActionOperation._call
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
