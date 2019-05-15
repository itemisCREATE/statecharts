package org.yakindu.sct.types.common.library

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem

@Singleton
class TypesLibrary {
	public static final String PACKAGE_NAME = "org.yakindu.sct.types.common"
	
	protected extension TypesFactory = TypesFactory.eINSTANCE
	@Inject protected ITypeSystem ts
	
	ComplexType _queue
	Package _typesPackage
	
	def getTypesPackage() {
		_typesPackage?:createTypesPackage
	}
	
	def getQueue() {
		_queue?:createQueue
	}
	
	def protected ComplexType createQueue() {
		_queue = createComplexType => [ ct |
			ct.name = "Queue"
			ct.typeParameters += createTypeParameter => [
				name = "T"
			]
			ct.features += createOperation => [
				name = "add"
				parameters += createParameter => [
					name = "e"
					typeSpecifier = createTypeSpecifier => [
						type = ct.typeParameters.head
					]
				]
			]
			ct.features += createOperation => [
				name = "pop"
				typeSpecifier = createTypeSpecifier => [
					type = ct.typeParameters.head
				]
			]
			ct.features += createOperation => [
				name = "size"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.INTEGER)
				]
			]
		]
		typesPackage.member.add(_queue)
		_queue
	}
	
	def protected Package createTypesPackage() {
		_typesPackage = createPackage => [
			name = PACKAGE_NAME
		]
	}
}