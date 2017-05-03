/**
* Copyright (c) 2016 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	Thomas Kutz - itemis AG
*
*/
package org.yakindu.base.types.util

import com.google.inject.Inject
import java.util.List
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Package
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeParameter
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem

class TypesTestFactory {
	
	public static final TypesTestFactory INSTANCE = new TypesTestFactory();
	
	@Inject 
	public ITypeSystem ts;
	
	protected TypesFactory factory = TypesFactory.eINSTANCE
	
	def Package createRootPackage(String filename) {
		factory.createPackage => [
			it.name = filename
		]
	}
	
	def createComplexType(String name) {
		factory.createComplexType => [
			it.name = name
		]
	}
	
	def createParameter(String name, String typeName) {
		createParameter(name, toTypeSpecifier(ts.getType(typeName)));
	}
	
	def createParameter(String name, Type type) {
		createParameter(name, type.toTypeSpecifier);
	}
	
	def createParameter(String name, TypeSpecifier typeSpec) {
		factory.createParameter => [
			it.name = name
			it.typeSpecifier = typeSpec
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
		createOperation(name, ts.getType(returnType))
	}
	
	def createOperation(String name, Type returnType) {
		factory.createOperation => [
			it.name = name
			it.typeSpecifier = returnType.toTypeSpecifier
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
	
}