package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

import static org.yakindu.base.types.typesystem.ITypeSystem.VOID
import com.google.inject.Singleton

@Singleton class Sequence2Method {

	@Inject extension SExecExtensions
	@Inject ITypeSystem ts
	extension SexecFactory sexecFactory = SexecFactory.eINSTANCE
	extension TypesFactory typesFactory = TypesFactory.eINSTANCE

	def declareEnterSequenceMethod(ComplexType it, ExecutionFlow flow) {
		val body = EcoreUtil.copy(flow.enterSequences.defaultSequence)
		val method = createDefaultEnterSequenceMethod() => [
			bodySequence = body
		]
		it.features += method
	}

	def create createMethod createDefaultEnterSequenceMethod() {
		name = "defaultEnterSequence"
		typeSpecifier = createTypeSpecifier => [
			type = ts.getType(VOID)
		]
	}

}
