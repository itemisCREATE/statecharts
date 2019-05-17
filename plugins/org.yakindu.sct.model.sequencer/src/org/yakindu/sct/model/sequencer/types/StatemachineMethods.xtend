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
package org.yakindu.sct.model.sequencer.types

import com.google.inject.Singleton
import java.util.List
import java.util.function.Function
import javax.inject.Inject
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.Visibility
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.typesystem.ITypeValueProvider
import org.yakindu.sct.model.sequencer.operations.EnterOperation
import org.yakindu.sct.model.sequencer.operations.ExitOperation
import org.yakindu.sct.model.sequencer.operations.ReactOperation
import org.yakindu.sct.model.sequencer.util.ArrayTypeExtensions
import org.yakindu.sct.model.sequencer.util.SgraphExtensions
import org.yakindu.sct.model.sequencer.util.StatechartExtensions
import org.yakindu.sct.model.sequencer.vectors.FinalStateImpactVector
import org.yakindu.sct.model.sequencer.vectors.HistoryVector
import org.yakindu.sct.model.sequencer.vectors.StateVector
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*

@Singleton
class StatemachineMethods {

	extension ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE
	
	@Inject extension ReactOperation
	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension StatemachineProperties
	@Inject extension StatemachinePublic
	@Inject extension IStatemachine
	@Inject extension SgraphExtensions
	@Inject extension ArrayTypeExtensions
	@Inject extension ITypeSystem ts
	@Inject extension StatechartExtensions
	@Inject extension StateVector
	@Inject extension HistoryVector
	@Inject extension FinalStateImpactVector
	@Inject extension EnterOperation
	@Inject extension ExitOperation
	@Inject extension StatemachineInterfaceMethods
	@Inject extension ITypeValueProvider
	
	def defineEnterMethod(ComplexType it, Statechart sc) {
		it.features += createEnterMethod => [
			body = _block(
				sc.statemachineType.defaultEnterSequence._call
			)
		]
	}
	
	def defineExitMethod(ComplexType it, Statechart sc) {
		it.features += createExitMethod => [
			body = _block(
				sc.statemachineType.resolveExitOperation._call
			)
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
		for (Property vd : sc.variablesForInitSequence) {
			inits += vd.initialization
		}
		inits
	}
	
	protected def variablesForInitSequence(Statechart sc) {
		val statechartVariables = sc.scopes.map(s|s.variables).flatten.filter(Property).filter[!const]
//		val flow = sc.create
//		val importedVariables = flow.scopes.map(s|s.declarations).flatten.filter(typeof(ImportDeclaration)).map(
//			d|d.declaration).filter(typeof(VariableDefinition))
		return statechartVariables // + importedVariables
	}
	
	protected def initialization(Property vd) {
		if (vd.effectiveInitialValue !== null) {
			val owner = vd.eContainer
			if (owner instanceof InterfaceScope) {
				return owner.property._ref._fc(vd.feature)._assign(vd.effectiveInitialValue.copy)
			} else if (owner instanceof InternalScope) {
				return owner.property._ref._fc(vd.feature)._assign(vd.effectiveInitialValue.copy)
			} else {
				return vd.feature._ref._assign(vd.effectiveInitialValue.copy) 
			}
		}
		null
	}
	
	def effectiveInitialValue(Property vd) {
		if (vd.initialValue !== null) {
			return vd.initialValue
		} else {
			return vd.type?.defaultValue?.value
		}
	}
	
	def stateVectorInitialization(Statechart sc) {
		val i = _variable("stateVectorIndex", ITypeSystem.INTEGER, 0._int)
		_for(i, i._ref._smaller(sc.stateVector.size._int), i._ref._inc) => [
			it.body = _block(
				stateVectorProperty(sc)._ref._get(i._ref)._assign(statesEnumeration(sc)._ref._fc(noState(sc)))
			)
		]
	}
	
	def historyStateVectorInitialization(Statechart sc) {
		val i = _variable("historyVectorIndex", ITypeSystem.INTEGER, 0._int)
		_for(i, i._ref._smaller(sc.historyVector.size._int), i._ref._inc) => [
			it.body = _block(
				historyVectorProperty(sc)._ref._get(i._ref)._assign(statesEnumeration(sc)._ref._fc(noState(sc)))
			)
		]
	}
	
	def defineIsActiveMethod(ComplexType it, Statechart sc) {
		it.features += createIsActiveMethod => [
			body = createBlockExpression => [
				expressions += _return(isActiveCheck(sc))
			]
		]
	}
	
	protected def isActiveCheck(Statechart sc) {
		return (0..<sc.stateVector.size)
			.map[i | notEqualsNoState(sc, i) as Expression]
			.reduce[p1, p2 | p1._or(p2)]
	}
	
	protected def notEqualsNoState(Statechart sc, int index) {
		stateVectorProperty(sc)._ref._get(index._int)._notEquals(statesEnumeration(sc)._ref._fc(noState(sc)))
	}
	
	def defineIsFinalMethod(ComplexType it, Statechart sc) {
		it.features += createIsFinalMethod => [
			body = createBlockExpression => [
				expressions += _return(isFinalCheck(sc))
			]
		]
	}
	
	protected def isFinalCheck(Statechart sc) {
		val fsv = sc.finalStateImpactVector
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
	
	protected def equalsState(Statechart sc, RegularState fs, int index) {
		stateVectorProperty(sc)._ref._get(index._int)._equals(
			if (fs.stateVector.offset == index) {
				statesEnumeration(sc)._ref._fc(fs.enumerator)
			} else {
				statesEnumeration(sc)._ref._fc(noState(sc))
			}
		)
	}
	
	def defineSingleStepMethod(ComplexType it, Statechart sc) {
		it.features += createSingleStepMethod => [
			body = _block(
				
				_for(nextStateIndex(sc)._ref._assign(0._int), nextStateIndex(sc)._ref._smaller(stateVectorProperty(sc)._ref._fc(_array._length)), nextStateIndex(sc)._ref._inc) => [
					body = _block(
						stateSwitch(stateVectorProperty(sc)._ref._get(nextStateIndex(sc)._ref), sc.allRegularStates.filter[isLeaf].filter[es | es.reactMethod!==null].toList, [ s | 
							s.reactMethod._call(_true)
						], _block)
					)
				]
			)
		]
	}
	
	def Operation create _op("singleStep") createSingleStepMethod(ComplexType cT) {
	
	}
	
	def Operation create _op("runToCompletion") createRTCMethod(ComplexType cT) {
		cT.features += it
	}
	
	def defineIsStateActiveMethod(ComplexType it, Statechart sc) {
		it.features += createIsStateActiveMethod(sc) => [
			body = _block(
				stateSwitch(parameters.head._ref, sc.allRegularStates, [ s |
					_return(
						if(s.isLeaf) {
							stateVectorProperty(sc)._ref._get(s.stateVector.offset._int)._equals(statesEnumeration(sc)._ref._fc(s.enumerator))
						} else {
							stateVectorProperty(sc)._ref._get(s.stateVector.offset._int)._greaterEqual(statesEnumeration(sc)._ref._fc(s.enumerator))
							._and(
							stateVectorProperty(sc)._ref._get(s.stateVector.offset._int)._smallerEqual(statesEnumeration(sc)._ref._fc(s.subStates.last.enumerator)))
						}
					)
				], _return(_false))
			)
		]
	}
	
	def stateSwitch(Expression switchContext, List<RegularState> states, Function<RegularState, Expression> action, Expression defaultAction) {
		_switch(switchContext, states.map[s | stateCase(s, action.apply(s))]) => [^default = defaultAction]
	}
	
	def stateCase(RegularState state, Expression e) {
		_case(state.enumerator._ref, e)
	}
	
	def create _op createIsStateActiveMethod(Statechart sc) {
		name = "isStateActive"
		_type(ts.getType(ITypeSystem.BOOLEAN))
		_param("state", sc.statesEnumeration)
	}
	
	def create _op createClearOutEventsMethod(ComplexType cT) {
		name = "clearOutEvents"
		_type(ITypeSystem.VOID)
		visibility = Visibility.PROTECTED
	}
	
	def defineClearOutEventsMethod(ComplexType it, Statechart sc) {
		it.features += createClearOutEventsMethod(it) => [
			body = _block(
				sc.scopes.filter(InterfaceScope).map[iface | iface.property._ref._fc(iface.createInterfaceType.clearOutEvents)]
			)
		]
	}
	
	def create _op createClearEventsMethod(ComplexType cT) {
		name = "clearEvents"
		_type(ITypeSystem.VOID)
		visibility = Visibility.PROTECTED
	}
	
	def defineClearEventsMethod(ComplexType it, Statechart sc) {
		it.features += createClearEventsMethod(it) => [
			body = _block => [
				expressions += sc.scopes.filter(InterfaceScope).map[iface | iface.property._ref._fc(iface.createInterfaceType.clearEvents)]
				// clear internal events directly
				val internalEventClears = newArrayList
				sc.scopes.filter(InternalScope).forEach[iface | 
					internalEventClears += iface.members.filter(Event).map[event | _clearEvent(iface.property._ref._fc(event))]
				]
				expressions += internalEventClears
			]
		]
	}
}
