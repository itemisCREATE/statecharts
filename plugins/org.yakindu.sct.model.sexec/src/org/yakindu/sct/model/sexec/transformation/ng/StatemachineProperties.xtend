package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.Statechart

@Singleton class StatemachineProperties {
	
	@Inject ITypeSystem ts
	
	@Inject extension StatemachinePublic
	@Inject extension SexecElementMapping
	@Inject extension SExecExtensions
	
	@Inject extension TypeBuilder
	
	extension TypesFactory typesFactory = TypesFactory.eINSTANCE
	
	def defineProperties(ComplexType it, Statechart sc) {
		it.features += stateVector(sc)
		if (sc.create.hasHistory) {
			it.features += historyStateVector(sc)
		}
		it.features += nextStateIndex(sc)
	}
	
	def create createProperty nextStateIndex(Statechart sc) {
		name = "nextStateIndex"
		_type(ITypeSystem.INTEGER)
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
				type = statesEnumeration(sc)
			]
		]
	}
	
}