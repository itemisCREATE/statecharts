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
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.base.types.Visibility

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
	
	@Inject extension IStatemachine 
	@Inject extension TypeBuilder 
	
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

			features += interfaceAnnotationType

			features += statesEnumeration(sc)
			
			features += sc.scopes.filter(InterfaceScope).map [
				createInterfaceType
			]

			declareMembers(sc)
		]
	}
	
	protected def create createAnnotationType interfaceAnnotationType() {
		name = "InterfaceGroup"
	}


	protected def declareMembers(ComplexType scType, Statechart sc) {

		// Named interfaces
		sc.scopes.filter(InterfaceScope).filter[name !== null].forEach [ iface |
			scType.features += iface.property
		]
		
		// Unnamed interface
		sc.scopes.filter(InterfaceScope).filter[name === null].forEach [ iface |
			scType.features += iface.property
		]
		
		// Internal variables
		sc.scopes.filter(InternalScope).forEach [ internal |
			internal.declarations.forEach[decl|scType.features += decl.feature]
		]
	}
	
	def create createProperty property(InterfaceScope iface) {
		it.typeSpecifier = createTypeSpecifier => [
			type = createInterfaceType(iface)
		]
		it.name = type.name.toFirstLower
		it.visibility = Visibility.PUBLIC
	}

	def create createEnumerationType statesEnumeration(Statechart sc) {
		it => [
			name = '''«sc.name»States'''
			annotationInfo = createAnnotatableElement
			enumerator += sc.noState
			sc.eAllContents.filter(RegularState).forEach [ state |
				enumerator += state.enumerator
			]
		]
	}
	
	def create createEnumerator enumerator(RegularState state) {
		name = state.name
	}
	
	
	protected def create createEnumerator noState(Statechart sc) {
		it.name = "__NoState__"
	}

	protected def create createComplexType createInterfaceType(InterfaceScope iface) {
		it.name = if (iface.name.nullOrEmpty) "SCInterface" else iface.name
		iface.declarations.forEach[decl|features += decl.feature]
		
		it._annotateWith(interfaceAnnotationType)
	}
	
	protected def create EcoreUtil.copy(decl) feature(Declaration decl) {}
}
