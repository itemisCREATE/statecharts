package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Singleton
import javax.inject.Inject
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sexec.transformation.TypeBuilder

@Singleton
class StatemachineMethods {

	extension TypesFactory typesFactory = TypesFactory.eINSTANCE
	extension ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE
	@Inject extension ITypeSystem ts
	@Inject extension SexecElementMapping  
	@Inject extension SExecExtensions  
	@Inject extension Sequence2Method
	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension StatemachineProperties
	@Inject extension Statechart2StatemachineTypeDeclaration

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
//				expressions += createCallToSequenceMethod(sc.create.initSequence)
			]
		]
	}
	
	def stateVectorInitialization(Statechart sc) {
		val ef = sc.create
		val i = _variable("i", ITypeSystem.INTEGER, 0._int)
		_for(i, i._smaller(ef.stateVector.size._int), i._inc) => [
			it.body = _block(
				stateVector(sc)._ref._get(0._int)._assign(stateVector(sc)._ref._fc(noState(sc)))
			)
		]
	}
	
	
	protected def createCallToSequenceMethod(Sequence seq) {
		createElementReferenceExpression => [
			operationCall = true
			reference = createMethodForSequence(seq)
		]
	}
	
	def createInitMethod() {
		createMethod("init", ts.getType(ITypeSystem.VOID))
	}

	def createEnterMethod() {
		createMethod("enter", ts.getType(ITypeSystem.VOID))
	}
	
	def createExitMethod() {
		createMethod("exit", ts.getType(ITypeSystem.VOID))
	}
	
	def createIsActiveMethod() {
		createMethod("isActive", ts.getType(ITypeSystem.BOOLEAN))
	}
	
	def createIsFinalMethod() {
		createMethod("isFinal", ts.getType(ITypeSystem.BOOLEAN))
	}
	
	def createRunCycleMethod() {
		createMethod("runCycle", ts.getType(ITypeSystem.BOOLEAN))
	}
	
	protected def createMethod(String name, Type returnType) {
		createOperation => [op |
			op.name = name
			op.typeSpecifier = createTypeSpecifier => [
				type = returnType
			]
		]
	}
	
	
}
