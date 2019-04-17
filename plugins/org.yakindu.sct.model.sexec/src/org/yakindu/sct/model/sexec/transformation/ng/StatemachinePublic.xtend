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
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.Visibility
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope

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
	
	@Inject protected extension ModelSequencerNaming
	@Inject protected extension StatemachineInterfaceMethods
	
	def create createPackage statemachinePackage(Statechart sc) {
 		it => [
 			name = sc.statemachinePackageName
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
			features += sc.scopes.filter(InternalScope).map [
				createInternalType
			]

			declareMembers(sc)
		]
	}
	
	protected def create createAnnotationType interfaceAnnotationType() {
		name = interfaceTypeAnnotationName
	}
	
	def create createEnumerationType statesEnumeration(Statechart sc) {
		it => [
			name = sc.statesEnumerationName
			annotationInfo = createAnnotatableElement
			enumerator += sc.noState
			sc.eAllContents.filter(RegularState).forEach [ state |
				enumerator += state.enumerator
			]
		]
	}
	
	def create createEnumerator enumerator(RegularState state) {
		name = state.enumeratorName
	}
	
	def create createEnumerator noState(Statechart sc) {
		it.name = noStateName
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
			scType.features += internal.property
		]
	}
	
	def create createProperty property(InterfaceScope iface) {
		it.typeSpecifier = createTypeSpecifier => [
			type = createInterfaceType(iface)
		]
		it.name = type.name.toFirstLower
		it.visibility = Visibility.PUBLIC
	}
	
	def create createProperty property(InternalScope internal) {
		it.typeSpecifier = createTypeSpecifier => [
			type = createInternalType(internal)
		]
		it.name = type.name.toFirstLower
		it.visibility = Visibility.PROTECTED
	}

	protected def create createComplexType createInterfaceType(InterfaceScope iface) {
		it.name = iface.interfaceTypeName
		
		iface.declarations.forEach[decl|features += decl.feature]
		features.filter(Property).filter[!const].forEach[prop|prop.initialValue = null]
		
		features += clearOutEvents
		features += clearEvents
		
		it._annotateWith(interfaceAnnotationType)
	}
	
	protected def create createComplexType createInternalType(InternalScope internal) {
		it.name = internalTypeName
		
		internal.declarations.forEach[decl|features += decl.feature => [visibility = Visibility.PROTECTED]]
		features.filter(Property).filter[!const].forEach[prop|prop.initialValue = null]
		
		it._annotateWith(interfaceAnnotationType)
		it.visibility = Visibility.PROTECTED
	}
	
	protected def create EcoreUtil.copy(decl) feature(Declaration decl) {}
}
