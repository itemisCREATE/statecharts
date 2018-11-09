/** 
 * Copyright (c) 2018 committers of YAKINDU and others. 
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
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypedElement
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.LocalVariableDefinition
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Return
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.StateVector
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.SexecExtensions
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart

/**
 * React method is an artifact concepts that is created for each state machine state and the statechart
 * itself. It defines the react behavior for each reactive element of the state machine. 
 * 
 * @author Axel Terfloth - terfloth@itemis.de
 *  
 */
class ReactMethod {
	
	@Inject extension SexecElementMapping mapping
	@Inject extension SexecExtensions sexec
	@Inject extension SgraphExtensions sgraph
	@Inject extension ITypeSystem typeSystem
	
	
	/**
	 * Declares the react methods for all ExecutionNode objects. This are the ExecutionStates and the ExecutionFlow itself.
	 */	
	def declareReactMethods(ExecutionFlow it) {

		flow.declareReactMethod		
		states.forEach[s | s.declareReactMethod ]
	}
	
	/**
	 * Define the react methods for all ExecutionNode objects. This are the ExecutionStates and the ExecutionFlow itself.
	 */	
	def defineReactMethods(ExecutionFlow it) {

		flow.defineReactMethod
		states.forEach[s | s.defineReactMethod ]
		
	}
	
	def dispatch ExecutionNode declareReactMethod(RegularState state) {
		state.create.declareReactMethod
	}	
	

	def dispatch ExecutionNode declareReactMethod(Statechart statechart) {	
		statechart.flow.declareReactMethod 
	}	

	def dispatch ExecutionNode declareReactMethod(ExecutionNode node) {
		node => [
			features.add( sexecFactory.createMethod => [ m |
				m.name = "react"
				m._type(_bool)
				m._param("try_transition", _bool)
			])
		]
	}

	
	def defineReactMethod(ExecutionFlow it) {
		reactMethod => [ body = 
			_sequence(
				flow.createLocalReactionSequence,
				_return(_false)	
			) => [ comment = "State machine reactions."]	
		]		
	}
	
	
	
	def defineReactMethod(ExecutionState execState) {
		
		val state = execState.sourceElement as RegularState
		val reactMethod = execState.reactMethod
		val childFirst = state.statechart.isChildFirstExecution
				
		val parentNode = if (state.parentState !== null) state.parentState.create else execState.flow
		val processParent = 	   parentNode !== null 
							&& (	    ( childFirst && parentNode.impactVector.last == execState.impactVector.last)
							     || (!childFirst && parentNode.stateVector.offset == execState.stateVector.offset)
							   )
				 				
		if (state.statechart.interleaveLocalReactions) {
			
			val tryTransitionParam = reactMethod.param('try_transition')
			val didTransitionVariable = _variable("did_transition", _bool)
			
				
			val stateReactions = 
				_sequence(
					_declare(didTransitionVariable)._with(_ref(tryTransitionParam)),
					
					_if(tryTransitionParam._ref)
						._then (
							if (processParent && !childFirst) 
								_if(_call(parentNode.reactMethod)._with(tryTransitionParam._ref)._equals(_false))
									._then ( 
										execState.createReactionSequence(
											didTransitionVariable._assign(_false)) 
									)	
							else
								execState.createReactionSequence(
									didTransitionVariable._assign(_false))
						),
								
					_if(didTransitionVariable._ref._equals(_false))
						._then(
							_sequence(
								execState.createLocalReactionSequence => [
									if (processParent && childFirst) 
										_step(didTransitionVariable._assign(_call(parentNode.reactMethod)._with(_ref(tryTransitionParam))))	
								])		
						),
						
					_return(didTransitionVariable._ref)
				)
								
			reactMethod.body = stateReactions
			
		} else {
			
			throw new RuntimeException("Non interleaved local reactions not supported");
		}
				
		reactMethod.body.comment = 'The reactions of state ' + state.name + '.'
		
		return reactMethod
	} 
	

	def _step(Sequence it, Step step) {
		steps.add(step)
		return steps
	}	


	def _equals(Expression left, Expression right) {
		ExpressionsFactory.eINSTANCE.createLogicalRelationExpression => [ eq |
			eq.operator = RelationalOperator.EQUALS;
			eq.leftOperand = left
			eq.rightOperand = right
		]
	}	
	
	def _assign(Property prop, Expression value) {
		sexecFactory.createStatement => [
			expression = ExpressionsFactory.eINSTANCE.createAssignmentExpression => [ ae |
				ae.varRef = _ref(prop)
				ae.expression = value
			]
		]	
	}
	
	
	def _statement(Expression value) {
		sexecFactory.createStatement => [
			expression = value
		]	
	}
	
	
	def _declare(Property prop) {
		sexec.factory.createLocalVariableDefinition => [ variable = prop ]
	}
	
	def Parameter param(Operation it, String name) {
		parameters.filter[ p | p.name == name].head
	}
	
	def Method reactMethod(ExecutionNode it) {
		features.filter( typeof(Method) ).filter( m | m.name == "react").head
	}
	

	def Sequence _sequence (Step... sequenceSteps) {
		sexec.factory.createSequence => [
			steps.addAll(sequenceSteps)
		]
	}		
	
	
	def If _if (Expression cond) {
		sexec.factory.createIf() => [
			check = sexec.factory.createCheck => [
				condition = cond
			]	
		]
	}
	
	def If _if (Check c) {
		sexec.factory.createIf() => [
			check = c	
		]
	}
	
	def If _then (If it, Step step) {
		thenStep = step	
		it
	}
	
	def If _else (If it, Step step) {
		elseStep = step
		it
	}
	
	
	def ElementReferenceExpression _call(Operation op) {
		ExpressionsFactory.eINSTANCE.createElementReferenceExpression => [ 
			reference = op 
			operationCall=true
		]
	}
	
	def ElementReferenceExpression _ref(EObject p) {
		ExpressionsFactory.eINSTANCE.createElementReferenceExpression => [ 
			reference = p
			operationCall=false
		]
	}
	
	def ElementReferenceExpression _with(ElementReferenceExpression it, Expression... params) {
		for (param : params) {
			it.arguments.add(ExpressionsFactory.eINSTANCE.createArgument => [arg | arg.value = param])
		}
		return it
	}
	
	def LocalVariableDefinition _with(LocalVariableDefinition it, Expression value) {
	
		initialValue = value;
		return it
	}
	
	def Return _return(Expression exp) {
		sexec.factory.createReturn => [ value = exp ]
	}
	
	
	def _type(TypedElement it, String typeName) {
		typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier => [
					type = typeSystem.getType(typeName);
				]
	}
	
	def _bool() {
		return ITypeSystem::BOOLEAN
	}
	
	def _param(Operation it, String pName, String typeName) {

		parameters.add(TypesFactory.eINSTANCE.createParameter => [
			name = pName
			_type(typeName)
		])

		return it
	}
	
	
	def _variable(String name, String typeName) {
		TypesFactory.eINSTANCE.createProperty => [ prop |
			prop.name = name
			prop._type(typeName)
		]	
	}
	
	
	def PrimitiveValueExpression _true() { 
		ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression => [
			value = ExpressionsFactory.eINSTANCE.createBoolLiteral => [ value = true]	
		]
	}
	 
	def PrimitiveValueExpression _false() { 
		ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression => [
			value = ExpressionsFactory.eINSTANCE.createBoolLiteral => [ value = false]	
		]
	}
	 
	 		
	def Sequence createLocalReactionSequence(ExecutionNode state) {	

		 _sequence(
			state.reactions.filter(r | ! r.transition ).map[ lr | 
				_if(lr.check.newRef)
					._then(lr.effect.newCall)
			]	
		)				
	}


	def Sequence createReactionSequence(ExecutionNode state, Step localStep) {	
		val cycle = sexec.factory.createSequence
		cycle.name = "react"
		
		var localSteps = sexec.factory.createSequence		
		if (localStep !== null) localSteps.steps += localStep
		if (localSteps.steps.empty) localSteps = null
				
		val transitionReactions = state.reactions.filter(r | r.transition && ! r.unchecked ).toList
		val transitionStep = transitionReactions.reverseView.fold(localSteps as Step, [s, reaction | {
				var ifStep = sexec.factory.createIf
				ifStep.check = reaction.check.newRef		
				ifStep.thenStep = reaction.effect.newCall
				ifStep.elseStep = s
				ifStep as Step
			}])

		if (transitionStep !== null) cycle.steps.add(transitionStep)		
		else if (localSteps!== null) cycle.steps.add(localSteps)
		
		return cycle
	}
	
	
}