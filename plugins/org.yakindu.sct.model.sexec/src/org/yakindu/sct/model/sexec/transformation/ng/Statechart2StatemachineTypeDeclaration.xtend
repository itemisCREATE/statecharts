/**
 * Copyright (c) 2018-2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	andreas muelder - itemis AG
 * 
 */
package org.yakindu.sct.model.sexec.transformation.ng

import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InterfaceScope

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class Statechart2StatemachineTypeDeclaration {

	extension TypesFactory factory = TypesFactory.eINSTANCE
	extension ITypeSystem ts = GenericTypeSystem.instance

	def Package toTypeDeclaration(Statechart sc) {
		createPackage => [ package |
			package.name = sc.namespace

			package.member += createStatemachineBaseType()

			val statemachineType = declareStatemachineType(sc)
			package.member += statemachineType

			statemachineType.features += createStatesEnumerationType(sc)
			
			statemachineType.features += sc.scopes.filter(InterfaceScope).filter[!name.nullOrEmpty].map [
				createInterfaceType
			]

			statemachineType.declareMembers(sc)

		]
	}

	protected def declareStatemachineType(Statechart sc) {
		createComplexType => [ scType |
			scType.name = sc.name
			scType.superTypes += createTypeSpecifier => [
				type = createStatemachineBaseType()
			]
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
					type = createStatesEnumerationType(sc)

				]
			]
			typeSpecifier = createTypeSpecifier => [
				type = ts.getType(ITypeSystem.BOOLEAN)
			]
		]

	}

	protected def create createEnumerationType createStatesEnumerationType(Statechart sc) {
		it => [
			name = '''«sc.name»States'''
			annotationInfo = createAnnotatableElement
			sc.eAllContents.filter(RegularState).forEach [ state |
				enumerator += createEnumerator => [
					name = state.name
				]
			]
		]
	}

	protected def create createComplexType createInterfaceType(InterfaceScope iface) {
		it => [
			name = iface.name
			iface.declarations.forEach[decl|features += EcoreUtil.copy(decl)]
		]
	}

	protected def create createComplexType createStatemachineBaseType() {
		it => [
			name = "Statemachine"
			// Implicit operations
			features += createOperation => [
				name = "init"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.VOID)
				]
			]
			features += createOperation => [
				name = "enter"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.VOID)
				]
			]
			features += createOperation => [
				name = "exit"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.VOID)
				]
			]
			features += createOperation => [
				name = "isActive"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.BOOLEAN)
				]
			]
			features += createOperation => [
				name = "isFinal"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.BOOLEAN)
				]
			]

			features += createOperation => [
				name = "runCycle"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.BOOLEAN)
				]
			]
		]
	}
}
