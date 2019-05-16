package org.yakindu.sct.types.common.library

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Event
import org.yakindu.base.types.Package
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.expressions.util.ExpressionsHelper

@Singleton
class TypesLibrary {
	public static final String PACKAGE_NAME = "org.yakindu.sct.types.common"
	
	protected extension TypesFactory = TypesFactory.eINSTANCE
	@Inject protected extension TypeBuilder
	@Inject protected extension ExpressionsHelper
	@Inject protected ITypeSystem ts
	
	
	Package _typesPackage
	ComplexType _queue
	ComplexType _eventWrapper
	
	def getTypesPackage() {
		_typesPackage?:createTypesPackage
	}
	
	def getQueue() {
		_queue?:createQueue
	}
	
	def getEventWrapper() {
		_eventWrapper?:createEventWrapper()
	}
	
	def protected ComplexType createQueue() {
		_queue = createComplexType => [ ct |
			ct.name = "Queue"
			ct.typeParameters += createTypeParameter => [
				name = "T"
			]
			ct.features += _op("add", ITypeSystem.VOID)._param("e", ct.typeParameters.head)
			ct.features += _op("pop", ct.typeParameters.head)
			ct.features += _op("size", ITypeSystem.INTEGER)
		]
		typesPackage.member.add(_queue)
		_queue
	}
	
	def protected Package createTypesPackage() {
		_typesPackage = createPackage => [
			name = PACKAGE_NAME
		]
	}
	
	def protected ComplexType createEventWrapper() {
		_eventWrapper = createComplexType => [
			ct |
			ct.name = "EventType"
			ct.typeParameters += createTypeParameter => [
				name = "T"
			]
			ct.features += createProperty => [
				name = "name"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.STRING)
				]
			]
			ct.features += createProperty => [
				name = "isRaised"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.BOOLEAN)
				]
			]
			ct.features += createProperty => [
				name = "value"
				typeSpecifier = createTypeSpecifier => [
					type = ct.typeParameters.head
				]
			]
		]
		typesPackage.member.add(_eventWrapper)
		_eventWrapper
	}
}