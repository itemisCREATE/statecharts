package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.base.types.Visibility

@Singleton class StatemachineProperties {
	
	@Inject ITypeSystem ts
	
	@Inject extension StatemachinePublic
	@Inject extension SgraphExtensions  
	
	@Inject extension TypeBuilder
	
	extension TypesFactory typesFactory = TypesFactory.eINSTANCE
	
	def defineProperties(ComplexType it, Statechart sc) {
		it.features += stateVector(sc)
		if (sc.requireHistory) {
			it.features += historyStateVector(sc)
		}
		it.features += nextStateIndex(sc)
	}
	
	def create createProperty nextStateIndex(Statechart sc) {
		name = "nextStateIndex"
		_type(ITypeSystem.INTEGER)
		visibility = Visibility.PROTECTED
	}
	
	def create createProperty stateVector(Statechart sc) {
		name = "stateVector"
		typeSpecifier = createArrayOfStateType(sc)
		visibility = Visibility.PROTECTED
	}
	
	def create createProperty historyStateVector(Statechart sc) {
		name = "historyStateVector"
		typeSpecifier = createArrayOfStateType(sc)
		visibility = Visibility.PROTECTED
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