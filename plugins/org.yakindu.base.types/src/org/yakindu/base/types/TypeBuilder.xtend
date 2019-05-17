/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 *  thomas kutz - itemis AG
 *  axel terfloth - itemis AG
 */
package org.yakindu.base.types

import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.TypedElement
import com.google.inject.Inject
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Type
import org.yakindu.base.types.Operation
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.base.types.AnnotationType
import org.yakindu.base.types.TypeSpecifier
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 * Builder extension for building types.
 * 
 * @author axel terfloth
 * @author thomas kutz
 */
class TypeBuilder {

	@Inject extension ITypeSystem typeSystem
	
	extension TypesFactory tFactory = TypesFactory.eINSTANCE

	def _op(String name, String returnType) {
		_op(name, typeSystem.getType(returnType))
	}
	
	def _op(String name) {
		_op(name, typeSystem.getType(ITypeSystem.VOID))
	}

	def _op(String name, Type returnType) {
		_op => [ op |
			op.name = name
			op.typeSpecifier = createTypeSpecifier => [
				type = returnType
			]
		]
	}

	def _op() {
		createOperation
	}

	def _param(Operation it, String pName, String typeName) {
		_param(pName, typeSystem.getType(typeName))
	}

	def _param(Operation it, String pName, Type type) {
		parameters.add(createParameter => [
			name = pName
			_type(type)
		])
		return it
	}

	def _param(Operation it, String pName, TypeSpecifier typeSpec) {
		parameters.add(createParameter => [
			name = pName
			_type(typeSpec)
		])
		return it
	}

	def _type(TypedElement it, String typeName) {
		_type(typeSystem.getType(typeName))
	}

	def _type(TypedElement it, Type type) {
		typeSpecifier = createTypeSpecifier => [ ts |
			ts.type = type
		]
	}

	def _type(TypedElement it, TypeSpecifier typeSpec) {
		typeSpecifier = EcoreUtil.copy(typeSpec)
	}
	
	def _typeSpecifier(Type type) {
		createTypeSpecifier => [ ts |
			ts.type = type
		]
	}

	def _variable(String name, Type type) {
		createProperty => [ prop |
			prop.name = name
			prop._type(type)
		]
	}

	def _variable(String name, String typeName) {
		createProperty => [ prop |
			prop.name = name
			prop._type(typeName)
		]
	}

	def _variable(String name, String typeName, Expression init) {
		createProperty => [ prop |
			prop.name = name
			prop._type(typeName)
			prop.initialValue = init
		]
	}
	
	def _variable(String name, Type type, Expression init) {
		createProperty => [ prop |
			prop.name = name
			prop.typeSpecifier = type._typeSpecifier 
			prop.initialValue = init
		]
	}

	def _annotateWith(AnnotatableElement elem, AnnotationType annotationType) {
		elem.annotationInfo.annotations += createAnnotation => [type = annotationType]
	}

}
