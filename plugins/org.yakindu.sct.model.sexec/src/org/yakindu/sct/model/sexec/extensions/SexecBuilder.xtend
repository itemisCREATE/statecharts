package org.yakindu.sct.model.sexec.extensions

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.LocalVariableDefinition
import org.yakindu.sct.model.sexec.Return
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.sexec.Step
import org.yakindu.base.types.ComplexType
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.DoWhile

class SexecBuilder {
	
//	@Inject extension ITypeSystem typeSystem
	@Inject extension TypeBuilder typeBuilder
	extension SexecFactory sexecFactory = SexecFactory.eINSTANCE
//	extension TypesFactory typesFactory = TypesFactory.eINSTANCE
	
	
	def _method(ComplexType type, String name) {
		_method(name) => [ 
			type.features += it
		]
	}
	
	def _method(String name) {
		createMethod => [ m |
			m.name = name 
		]
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
		createStatement => [
			expression = ExpressionsFactory.eINSTANCE.createAssignmentExpression => [ ae |
				ae.varRef = _ref(prop)
				ae.expression = value
			]
		]	
	}
	
	
	def _statement(Expression value) {
		createStatement => [
			expression = value
		]	
	}
	
	
	def _declare(Property prop) {
		createLocalVariableDefinition => [ variable = prop ]
	}
	

	def Method _body (Method it, Step... sequenceSteps) {
		body = _sequence(sequenceSteps)
		it
	}		
	

	def Sequence _sequence (Step... sequenceSteps) {
		createSequence => [
			steps.addAll(sequenceSteps)
		]
	}		
	
	def Step _empty () {
		createSequence
	}		
	
	def Step _when(Step step, boolean cond) {
		if (cond) step
		else _empty
	}
	
	def Sequence _conceptSequence (String name) {
		createSequence => [
			it.name = name
		]
	}		
	
	def Sequence _conceptSequence (String name, EObject... objects) {
		createSequence => [
			it.name = name
			objects.forEach[ o | 
				it.steps += o.toStep
			]
		]
	}		
	
	def dispatch Step toStep(EObject o) {
		o._ref._statement
	}
	
	def dispatch Step toStep(Expression e) {
		e._statement
	}
	
	def dispatch Step toStep(Step s) {
		s
	}
	
	
	
	def If _if (Expression cond) {
		createIf() => [
			check = createCheck => [
				condition = cond
			]	
		]
	}
	
	def If _if (Check c) {
		createIf() => [
			check = c	
		]
	}


	def DoWhile _do (Step body) {
		createDoWhile() => [ l | l.body = body ]
	}

	def DoWhile _do () {
		createDoWhile()
	}

	def DoWhile _while (DoWhile it, Expression cond) {
		it => [
			check = createCheck => [
				condition = cond
			]	
		]
	}
	
	def DoWhile _while (DoWhile it, Check c) {
		it => [check = c]	
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
		createReturn => [ value = exp ]
	}
	
	
//	def _type(TypedElement it, String typeName) {
//		typeSpecifier = createTypeSpecifier => [
//					type = typeSystem.getType(typeName);
//				]
//	}
	
	
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
	
	
	def _traceBeginRunCycle() {
		createTraceBeginRunCycle
	}
	
	def _traceEndRunCycle() {
		createTraceEndRunCycle
	}
	
	
}