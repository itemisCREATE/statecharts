/**
 * Copyright (c) 2016 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Thomas Kutz - itemis AG
 * 
 */
package org.yakindu.sct.model.stext.test.util

import com.google.inject.Inject
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Package
import org.yakindu.base.types.PrimitiveType

class TypesTestFactory {

	public static final TypesTestFactory INSTANCE = new TypesTestFactory();

	@Inject
	protected ITypeSystem ts;

	protected TypesFactory factory = TypesFactory.eINSTANCE

	def Package createRootPackage(String filename) {
		factory.createPackage => [
			it.name = filename
		]
	}

	def createParameter(String name, String typeName) {
		createParameter(name, typeName, false);
	}
	
	def createParameter(String name, String typeName, boolean isOptional) {
		createParameter(name, toTypeSpecifier(ts.getType(typeName)), isOptional);
	}

	def createParameter(String name, Type type) {
		createParameter(name, type.toTypeSpecifier, false);
	}
	
	def createParameter(String name, Type type, boolean isOptional) {
		createParameter(name, type.toTypeSpecifier, isOptional);
	}

	def createParameter(String name, TypeSpecifier typeSpec) {
		createParameter(name, typeSpec, false)
	}
	
	def createParameter(String name, TypeSpecifier typeSpec, boolean isOptional) {
		factory.createParameter => [
			it.name = name
			it.typeSpecifier = typeSpec
			it.optional = isOptional
		]
	}

	def createProperty(String name, String typeName) {
		createProperty(name, typeName, false);
	}

	def createProperty(String name, String typeName, boolean isConst) {
		createProperty(name, ts.getType(typeName)) => [const = isConst];
	}

	def createProperty(String name, Type type) {
		createProperty(name, type.toTypeSpecifier);
	}

	def createProperty(String name, TypeSpecifier typeSpec) {
		factory.createProperty => [
			it.name = name
			it.typeSpecifier = typeSpec
		]
	}

	def createOperation(String name, String returnType) {
		createOperation(name, ts.getType(returnType), false)
	}
	
	def createOperation(String name, String returnType, boolean isStatic) {
		createOperation(name, ts.getType(returnType), isStatic)
	}

	def createOperation(String name, Type returnType) {
		createOperation(name, returnType, false)
	}

	def createOperation(String name, Type returnType, boolean isStatic) {
		factory.createOperation => [
			it.name = name
			it.typeSpecifier = returnType.toTypeSpecifier
			it.static = isStatic
		]
	}

	def toTypeSpecifier(String typeName) {
		toTypeSpecifier(ts.getType(typeName));
	}

	def toTypeSpecifier(Type type) {
		factory.createTypeSpecifier => [
			it.type = type
		]
	}

	def createTypeParameter(String name) {
		factory.createTypeParameter => [
			it.name = name
		]
	}

	def Enumerator createEnumerator(String name) {
		factory.createEnumerator => [
			it.name = name
		]
	}

	def PrimitiveType createPrimitiveType(String name, String baseTypeName) {
		factory.createPrimitiveType => [
			it.name = name
			it.superTypes += (ts.getType(baseTypeName) as PrimitiveType).toTypeSpecifier
		]
	}

}
