package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Singleton
import javax.inject.Inject
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sgraph.Statechart

@Singleton
class StatemachineMethods {

	extension TypesFactory typesFactory = TypesFactory.eINSTANCE
	extension ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE
	@Inject extension ITypeSystem ts
	@Inject extension SexecElementMapping  
	@Inject extension SExecExtensions  
	@Inject extension Sequence2Method

	def defineEnterMethod(ComplexType it, Statechart sc) {
		createEnterMethod => [
			body = createBlockExpression => [
				expressions += createCallToEnterSeqenceMethod(sc.create)
			]
		]
	}
	
//	def defineExitMethod(ComplexType it, Statechart sc) {
//		createExitMethod => [
//			
//		]
//	}
	
	protected def createCallToEnterSeqenceMethod(ExecutionFlow flow) {
		createElementReferenceExpression => [
			operationCall = true
			reference = createMethodForSequence(flow.enterSequences.defaultSequence)
		]
	}

	def create createOperation createEnterMethod(ComplexType smtype) {
		it => [
			name = "enter"
			typeSpecifier = createTypeSpecifier => [
				type = ts.getType(ITypeSystem.VOID)
			]
		]
		smtype.features += it		
	}
	
	
}
