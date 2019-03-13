package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sgraph.Statechart

class StatemachineProperties {
	
	@Inject ITypeSystem ts
	
	@Inject extension Statechart2StatemachineTypeDeclaration
	@Inject extension SexecElementMapping
	@Inject extension SExecExtensions  
	
	extension TypesFactory typesFactory = TypesFactory.eINSTANCE
	
	def defineProperties(ComplexType it, Statechart sc) {
		it.features += stateVector(sc)
		if (sc.create.hasHistory) {
			it.features += historyStateVector(sc)
		}
	}
	
	def create createProperty stateVector(Statechart sc) {
		name = "stateVector"
		typeSpecifier = createArrayOfStateType(sc)
	}
	
	def create createProperty historyStateVector(Statechart sc) {
		name = "historyStateVector"
		typeSpecifier = createArrayOfStateType(sc)
	}
	
	protected def createArrayOfStateType(Statechart sc) {
		createTypeSpecifier => [
			type = ts.getType(ITypeSystem.ARRAY)
			typeArguments += createTypeSpecifier => [
				type = createStatesEnumerationType(sc)
			]
		]
	}
	
}