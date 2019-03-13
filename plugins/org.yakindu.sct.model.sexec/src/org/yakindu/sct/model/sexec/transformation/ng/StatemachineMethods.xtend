package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Singleton
import javax.inject.Inject
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.base.types.Type

@Singleton
class StatemachineMethods {

	extension TypesFactory typesFactory = TypesFactory.eINSTANCE
	extension ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE
	@Inject extension ITypeSystem ts
	@Inject extension SexecElementMapping  
	@Inject extension SExecExtensions  
	@Inject extension Sequence2Method

	def defineEnterMethod(ComplexType it, Statechart sc) {
		it.features += createEnterMethod => [
			body = createBlockExpression => [
				expressions += createCallToSeqenceMethod(sc.create.enterSequences.defaultSequence)
			]
		]
	}
	
	def defineExitMethod(ComplexType it, Statechart sc) {
		it.features += createExitMethod => [
			body = createBlockExpression => [
				expressions += createCallToSeqenceMethod(sc.create.exitSequence)
			]
		]
	}
	
	protected def createCallToSeqenceMethod(Sequence seq) {
		createElementReferenceExpression => [
			operationCall = true
			reference = createMethodForSequence(seq)
		]
	}

	def createEnterMethod() {
		createMethod("enter", ts.getType(ITypeSystem.VOID))
	}
	
	def createExitMethod() {
		createMethod("exit", ts.getType(ITypeSystem.VOID))
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
