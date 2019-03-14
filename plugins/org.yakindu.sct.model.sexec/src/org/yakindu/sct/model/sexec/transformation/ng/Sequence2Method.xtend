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
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.base.types.Visibility

@Singleton class Sequence2Method {

	@Inject extension SExecExtensions
	@Inject ITypeSystem ts
	extension SexecFactory sexecFactory = SexecFactory.eINSTANCE
	extension TypesFactory typesFactory = TypesFactory.eINSTANCE
	@Inject extension INamingService naming
	

	def declareSequenceMethods(ComplexType scType, ExecutionFlow flow) {
		flow.allFunctions.filter(Sequence).forEach [ fun |
			scType.features += createMethodForSequence(fun)
		]
	}

	def create createMethod createMethodForSequence(Sequence body) {
		name = body.getShortName
		typeSpecifier = createTypeSpecifier => [
			type = ts.getType(VOID)
		]
		visibility = Visibility.PROTECTED
		bodySequence = EcoreUtil.copy(body)
	}

}
