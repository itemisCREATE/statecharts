/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 *  thomas kutz - itemis AG
 *  axel terfloth - itemis AG
 */
package org.yakindu.base.types

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.base.BasePackage
import org.yakindu.base.types.annotations.VisibilityAnnotations
import org.yakindu.base.types.typesystem.ITypeSystem

/**
 * Builder extension for building types.
 * 
 * @author axel terfloth
 * @author thomas kutz
 */
class TypeBuilder {
	
	public static final TypeBuilder BUILDER = new TypeBuilder


	@Inject extension ITypeSystem typeSystem
	
	extension BasePackage = BasePackage.eINSTANCE
	extension TypesPackage = TypesPackage.eINSTANCE
	extension TypesFactory tFactory = TypesFactory.eINSTANCE

	def _op(String name, String returnType) {
		_op(name, typeSystem.getType(returnType))
	}

	def _op(String name) {
		_op(name, _void)
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

//	def _ctor() {
//		createConstructor => [name = "new"]
//	}

	def _param(Operation it, String pName, String typeName) {
		it._param(pName, typeSystem.getType(typeName))
	}

	def _param(Operation it, String pName, Type type) {
		checkNotNull(operation, it)
		checkNotNull(namedElement_Name, pName)
		parameters.add(createParameter => [
			name = pName
			_type(type)
		])
		return it
	}

	def _param(Operation it, String pName, TypeSpecifier typeSpec) {
		checkNotNull(namedElement_Name, pName)
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
		checkNotNull(typedElement_Type, type)
		typeSpecifier = createTypeSpecifier => [ ts |
			ts.type = type
		]
	}

	def _type(TypedElement it, TypeSpecifier typeSpec) {
		checkNotNull(typedElement_TypeSpecifier, typeSpec)
		typeSpecifier = EcoreUtil.copy(typeSpec)
	}

	def _typeSpecifier(Type type) {
		checkNotNull(typeSpecifier_Type, type)
		createTypeSpecifier => [ ts |
			ts.type = type
		]
	}
	
	def _typeSpecifier(Type type, TypeSpecifier ... typeArgs) {
		checkNotNull(typeSpecifier_Type, type)
		createTypeSpecifier => [ ts |
			ts.type = type
			ts.typeArguments += typeArgs
		]
	}

	def _variable(String name, Type type) {
		checkNotNull(namedElement_Name, name)
		createProperty => [ prop |
			prop.name = name
			prop._type(type)
		]
	}
	
	def _variable(String name, TypeSpecifier type) {
		checkNotNull(namedElement_Name, name)
		checkNotNull(typedElement_TypeSpecifier, type)
		createProperty => [ prop |
			prop.name = name
			prop.typeSpecifier = type
		]
	}

	def _variable(String name, String typeName) {
		checkNotNull(namedElement_Name, name)
		createProperty => [ prop |
			prop.name = name
			prop._type(typeName)
		]
	}

	def _variable(String name, String typeName, Expression init) {
		checkNotNull(namedElement_Name, name)
		checkNotNull(property_InitialValue, init)
		createProperty => [ prop |
			prop.name = name
			prop._type(typeName)
			prop.initialValue = init
		]
	}

	def _variable(String name, Type type, Expression init) {
		checkNotNull(namedElement_Name, name)
		checkNotNull(property_InitialValue, init)
		createProperty => [ prop |
			prop.name = name
			prop.typeSpecifier = type._typeSpecifier
			prop.initialValue = init
		]
	}
	
	def _variable(String name, TypeSpecifier type, Expression init) {
		checkNotNull(namedElement_Name, name)
		checkNotNull(typedElement_TypeSpecifier, type)
		checkNotNull(property_InitialValue, init)
		createProperty => [ prop |
			prop.name = name
			prop.typeSpecifier = type
			prop.initialValue = init
		]
	}
	
	
	def _event(String name) {
		checkNotNull(namedElement_Name, name)
		createEvent => [
			it.name = name
			it.direction = Direction.LOCAL
		]
	}
	
	def _in(Event e) {
		checkNotNull(event, e)
		e.direction = Direction.IN
		e
	}
	
	def _out(Event e) {
		checkNotNull(event, e)
		e.direction = Direction.OUT
		e
	}
	
	
	def _enumType(String name, String... enumeratorNames) {
		checkNotNull(namedElement_Name, name)
		createEnumerationType => [
			it.name = name
			enumeratorNames.forEach[en |
				it.enumerator += createEnumerator => [it.name = en]
			]
		]
	}
	
	def _complexType(String name) {
		checkNotNull(namedElement_Name, name)
		createComplexType => [
			it.name = name
		]
	}

	def _complexType() {
		createComplexType
	}

	def <T extends AnnotatableElement> T _annotate(T elem, AnnotationType annotationType, Expression... args) {
		checkNotNull(annotatableElement, elem)
		checkNotNull(annotation_Type, annotationType)
		elem.annotations += createAnnotation => [
			type = annotationType
			if (!args.nullOrEmpty) {
				arguments += args.toList
			}
		]
		elem
	}
	
	def <T extends AnnotatableElement> T _annotate(T elem, String annotationName, Expression... args) {
		checkNotNull(annotatableElement, elem)
		checkNotNull(annotation_Type, annotationType)
		elem.annotations += createAnnotation => [
			type = _annotationType(annotationName)
			if (!args.nullOrEmpty) {
				arguments += args.toList
			}
		]
		elem
	}
	
	def AnnotationType create t : createAnnotationType _annotationType(String name) {
		t.name = name
	} 
	
	
	def _boolean() {
		typeSystem.getType(ITypeSystem.BOOLEAN)
	}
	
	def _void() {
		typeSystem.getType(ITypeSystem.VOID)
	}
	
	def _integer() {
		typeSystem.getType(ITypeSystem.INTEGER)
	}
	
	def _real() {
		typeSystem.getType(ITypeSystem.REAL)
	}
	
	def _string() {
		typeSystem.getType(ITypeSystem.STRING)
	}
	

	def <T extends AnnotatableElement> T _public(T e) {
		e._annotate(VisibilityAnnotations.PUBLIC_ANNOTATION)
	}
	
//	def <T extends Declaration> T _protected(T it) {
//		checkNotNull(declaration, it)
//		visibility = Visibility.PROTECTED
//		it
//	}
//
//	def <T extends Declaration> T _public(T it) {
//		checkNotNull(declaration, it)
//		visibility = Visibility.PUBLIC
//		it
//	}
	
	def protected void checkNotNull(EStructuralFeature ref, Object o) {
		if(o === null) {
			throw new IllegalArgumentException('''Feature «ref.name» of «ref.EContainingClass.name» must not be null!''')
		}
	}
	
	def protected void checkNotNull(EClass eCls, Object o) {
		if(o === null) {
			throw new IllegalArgumentException('''Object of type «eCls.name» must not be null!''')
		}
	}
	
	def <T extends Declaration> T _meta(Declaration owner, T feature) {
		owner.metaFeatures += feature
		feature
	}
	
	

}
