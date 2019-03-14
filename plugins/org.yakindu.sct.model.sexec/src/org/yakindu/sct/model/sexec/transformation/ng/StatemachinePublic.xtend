/**
 * Copyright (c) 2018-2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	andreas muelder - itemis AG
 *  thomas kutz - itemis AG
 *  axel terfloth - itemis AG
 */
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InterfaceScope

/**
 * This class implements a transformation that creates the state machine type
 * from a statechart. It covers only all publicly visible elements which are provided
 * to users. It creates no internal declarations and no implementations.
 *  
 * @author andreas muelder - Initial contribution and API
 * @author thomas kutz
 * @author axel terfloth
 * 
 */
@Singleton class StatemachinePublic {

	extension TypesFactory factory = TypesFactory.eINSTANCE
	extension ITypeSystem ts = GenericTypeSystem.instance
	
	@Inject extension IStatemachine 
	
	def statemachinePackage(Statechart sc) {
		statemachinePackage(sc.namespace)
 	}

	def create createPackage statemachinePackage(String namespace) {
 		it => [
 			name = if (namespace.nullOrEmpty) "default" else namespace
 		]	
 	}
	

	def create createComplexType statemachineType(Statechart sc) {

		it => [
			
			name = sc.name
			superTypes += createTypeSpecifier => [ type = statemachineInterfaceType ]
			sc.statemachinePackage.member += it

			features += statesEnumeration(sc)
			
			features += sc.scopes.filter(InterfaceScope).filter[!name.nullOrEmpty].map [
				createInterfaceType
			]

			declareMembers(sc)
		]
	}


	protected def declareMembers(ComplexType scType, Statechart sc) {

		// Named Interfaces
		sc.scopes.filter(InterfaceScope).filter[name !== null].forEach [ iface |
			scType.features += createProperty => [ prop |
				prop.name = iface.name
				prop.typeSpecifier = createTypeSpecifier => [
					type = createInterfaceType(iface)
				]
			]
		]
		// Unnamed interfaces
		sc.scopes.filter(InterfaceScope).filter[name === null].forEach [ iface |
			iface.declarations.forEach[decl|scType.features += EcoreUtil.copy(decl)]
		]
		// State enumerations
		// isStateActive Operation
		scType.features += createOperation => [
			name = "isStateActive"
			parameters += createParameter => [
				name = "state"
				typeSpecifier = createTypeSpecifier => [
					type = statesEnumeration(sc)

				]
			]
			typeSpecifier = createTypeSpecifier => [
				type = ts.getType(ITypeSystem.BOOLEAN)
			]
		]

	}

	protected def create createEnumerationType statesEnumeration(Statechart sc) {
		it => [
			name = '''«sc.name»States'''
			annotationInfo = createAnnotatableElement
			sc.eAllContents.filter(RegularState).forEach [ state |
				enumerator += state.enumerator
			]
			enumerator += sc.noState
			
		]
	}
	
	def create createEnumerator enumerator(RegularState state) {
		name = state.name
	}
	
	
	protected def create createEnumerator noState(Statechart sc) {
		it => [
			name = "__NoState__"
		]
	}

	protected def create createComplexType createInterfaceType(InterfaceScope iface) {
		it => [
			name = iface.name
			iface.declarations.forEach[decl|features += EcoreUtil.copy(decl)]
		]
	}
}
