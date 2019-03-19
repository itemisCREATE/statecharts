/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 *  axel terfloth - itemis AG
 */
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Singleton
import java.util.List
import java.util.function.Function
import javax.inject.Inject
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Expression
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.transformation.ArrayType
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.ImportDeclaration
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

@Singleton
class StatemachineMethods {

	extension ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE
	
	@Inject extension ReactOperation rm
	@Inject extension SexecElementMapping  
	@Inject extension SExecExtensions  
	@Inject extension Sequence2Method
	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder exp
	@Inject extension StatemachineProperties
	@Inject extension StatemachinePublic
	@Inject extension StateVectorExtensions
	@Inject extension IStatemachine
	@Inject extension SgraphExtensions
	@Inject extension ArrayType
	@Inject extension StateType
	@Inject extension SequenceBuilder
	@Inject extension ITypeSystem ts
	
	def defineEnterMethod(ComplexType it, Statechart sc) {
		it.features += createEnterMethod => [
			body = createBlockExpression => [
				expressions += createCallToSequenceMethod(sc.create.enterSequences.defaultSequence)
			]
		]
	}
	
	def defineExitMethod(ComplexType it, Statechart sc) {
		it.features += createExitMethod => [
			body = createBlockExpression => [
				expressions += createCallToSequenceMethod(sc.create.exitSequence)
			]
		]
	}
	
	def defineInitMethod(ComplexType it, Statechart sc) {
		it.features += createInitMethod => [
			body = createBlockExpression => [
				expressions += stateVectorInitialization(sc)
				if (sc.requireHistory) {
					expressions += historyStateVectorInitialization(sc)
				}
				expressions += sc.variableInits.filterNull.toList
			]
		]
	}
	
	protected def variableInits(Statechart sc) {
		var List<Expression> inits = newArrayList
		for (VariableDefinition vd : sc.variablesForInitSequence) {
			inits += vd.initialization
		}
		inits
	}
	
	protected def variablesForInitSequence(Statechart sc) {
		val flow = sc.create
		val statechartVariables = flow.scopes.map(s|s.variables).flatten.filter(typeof(VariableDefinition)).filter[!const]
		val importedVariables = flow.scopes.map(s|s.declarations).flatten.filter(typeof(ImportDeclaration)).map(
			d|d.declaration).filter(typeof(VariableDefinition))
		return statechartVariables + importedVariables
	}
	
	protected def initialization(VariableDefinition vd) {
		if (vd.effectiveInitialValue !== null) {
			val owner = vd.eContainer
			if (owner instanceof InterfaceScope) {
				return owner.property._ref._fc(vd.feature)._assign(vd.effectiveInitialValue)
			} else {
				return vd.feature._ref._assign(vd.effectiveInitialValue)
			}
		}
		null
	}
	
	def stateVectorInitialization(Statechart sc) {
		val ef = sc.create
		val i = _variable("i", ITypeSystem.INTEGER, 0._int)
		_for(i, i._ref._smaller(ef.stateVector.size._int), i._ref._inc) => [
			it.body = _block(
				stateVector(sc)._ref._get(0._int)._assign(statesEnumeration(sc)._ref._fc(noState(sc)))
			)
		]
	}
	
	def historyStateVectorInitialization(Statechart sc) {
		val ef = sc.create
		val i = _variable("i", ITypeSystem.INTEGER, 0._int)
		_for(i, i._ref._smaller(ef.historyVector.size._int), i._ref._inc) => [
			it.body = _block(
				historyVector(sc)._ref._get(0._int)._assign(statesEnumeration(sc)._ref._fc(noState(sc)))
			)
		]
	}
	
	
	
	def defineIsActiveMethod(ComplexType it, Statechart sc) {
		it.features += createIsActiveMethod => [
			body = createBlockExpression => [
				expressions += exp._return(isActiveCheck(sc))
			]
		]
	}
	
	protected def isActiveCheck(Statechart sc) {
		return (0..<sc.create.stateVector.size)
			.map[i | notEqualsNoState(sc, i) as Expression]
			.reduce[p1, p2 | p1._or(p2)]
	}
	
	protected def notEqualsNoState(Statechart sc, int index) {
		stateVector(sc)._ref._get(index._int)._notEquals(statesEnumeration(sc)._ref._fc(noState(sc)))
	}
	
	def defineIsFinalMethod(ComplexType it, Statechart sc) {
		it.features += createIsFinalMethod => [
			body = createBlockExpression => [
				expressions += exp._return(isFinalCheck(sc))
			]
		]
	}
	
	protected def isFinalCheck(Statechart sc) {
		val ef = sc.create
		val fsv = ef.finalStateImpactVector
		if (fsv.isCompletelyCovered) {
			(0..<fsv.size)
				.map[i | fsv.get(i)
					.map[fs | equalsState(sc, fs, i) as Expression]
					.reduce[p1, p2 | p1._or(p2)]
					._parenthesized as Expression]
				.reduce[p1, p2 | p1._and(p2)]
		} else {
			_false
		}
	}
	
	protected def equalsState(Statechart sc, ExecutionState fs, int index) {
		stateVector(sc)._ref._get(index._int)._equals(
			if (fs.stateVector.offset == index) {
				stateVector(sc)._ref._fc((fs.sourceElement as RegularState).enumerator)
			} else {
				stateVector(sc)._ref._fc(noState(sc))
			}
		)
	}
	
	def defineRunCycleMethod(ComplexType it, Statechart sc) {
		val ef = sc.create
		it.features += createRunCycleMethod => [
			body = _block(
				_for(nextStateIndex(sc)._ref._assign(0._int), nextStateIndex(sc)._ref._smaller(stateVector(sc)._ref._fc(_array._length)), nextStateIndex(sc)._ref._inc) => [
					body = _block(
						_switch(stateVector(sc)._ref._get(nextStateIndex(sc)._ref), ef.states.filter[isLeaf].filter[es | rm.reactMethod(es)!==null].map[state | 
							_case((state.sourceElement as RegularState).enumerator._ref, (state.sourceElement as RegularState).type._ref._fc(rm.reactMethod(state), _true))
						]
					))
					
				]
			)
		]
	}
	
	protected def createCallToSequenceMethod(Sequence seq) {
		createElementReferenceExpression => [
			operationCall = true
			reference = createMethodForSequence(seq)
		]
	}
	
	def defineIsStateActiveMethod(ComplexType it, Statechart sc) {
		it.features += createIsStateActiveMethod(sc) => [
			body = _block(
				stateSwitch(parameters.head._ref, sc.create.states, [ s |
					if(s.isLeaf) {
						_return(stateVector(sc)._ref._get(s.getStateVector().offset._int)._equals(statesEnumeration(sc)._ref._fc(s.stateEnumerator)))
					} else {
						_return(stateVector(sc)._ref._get(s.getStateVector().offset._int)._greaterEqual(statesEnumeration(sc)._ref._fc(s.stateEnumerator))._and(
							stateVector(sc)._ref._get(s.getStateVector().offset._int)._smallerEqual(statesEnumeration(sc)._ref._fc(s.subStates.last.stateEnumerator)
						)))
					}
				], _return(_false))
			)
		]
	}
	
	def stateSwitch(Expression switchContext, Iterable<ExecutionState> states, Function<ExecutionState, Expression> action, Expression defaultAction) {
		_switch(switchContext, states.map[s | stateCase(s, action.apply(s))]) => [^default = defaultAction]
	}
	
	def stateCase(ExecutionState state, Expression e) {
		_case(state.stateEnumerator._ref, e)
	}
	
	def stateEnumerator(ExecutionState s) {
		(s.sourceElement as RegularState).enumerator
	}
	
	protected def createIsStateActiveMethod(Statechart sc) {
		_op("isStateActive", ts.getType(ITypeSystem.BOOLEAN))._param("state", sc.statesEnumeration)
	}	
}
