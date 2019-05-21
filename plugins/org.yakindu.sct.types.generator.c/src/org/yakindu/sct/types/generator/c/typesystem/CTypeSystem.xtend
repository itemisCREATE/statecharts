/**
 * Copyright (c) 2016 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Andreas Muelder - itemis AG
 * 
 */
package org.yakindu.sct.types.generator.c.typesystem;

import com.google.inject.Singleton
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.TypedElement
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.GenericTypeSystem

import static org.yakindu.base.types.TypesFactory.*

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
 class CTypeSystem extends GenericTypeSystem {

	static val CTypeSystem INSTANCE = new CTypeSystem()

	public static val String DOUBLE = "double"
	public static val String UINT8_T = "uint8_t"
	public static val String INT8_T = "int8_t"
	public static val String INT16_T = "int16_t"
	public static val String UINT16_T = "uint16_t"
	public static val String INT32_T = "int32_t"
	public static val String INT64_T = "int64_t"
	public static val String UINT32_T = "uint32_t"
	public static val String UINT64_T = "uint64_t"
	public static val String FLOAT = "float"
	public static val String BOOL = "bool"
	public static val String UNSUPPORTED_TYPE = "UnsupportedType"

	public static val String POINTER = "pointer"
	public static val String POINTER_PROPERTY = "pointer"
	public static val String VALUE_PROPERTY = "value"

	protected new() {
	}

	static def CTypeSystem getInstance() {
		return INSTANCE
	}

	override initRegistries() {
		super.initRegistries()

		getType(BOOLEAN).abstract = true
		getType(INTEGER).abstract = true
		getType(REAL).abstract = true

		declareRangedInteger(INT8_T, -128L, 127L);
		declareRangedInteger(INT16_T, -32768L, 32767L);
		declareRangedInteger(INT32_T, -2147483648L, 2147483647L)
		declareRangedInteger(INT64_T, 0, 0); // TODO: Size of int64
		declareRangedInteger(UINT8_T, 0L, 255L)
		declareRangedInteger(UINT16_T, 0L, 65535L)
		declareRangedInteger(UINT32_T, 0L, 4294967295L)
		declareRangedInteger(UINT64_T, 0, 0); // TODO: Size of int64
		declareSuperType(getType(INT64_T), getType(INTEGER))
		declareSuperType(getType(INT32_T), getType(INT64_T))
		declareSuperType(getType(INT16_T), getType(INT32_T))
		declareSuperType(getType(INT8_T), getType(INT16_T))

		declareSuperType(getType(UINT64_T), getType(INTEGER))
		declareSuperType(getType(UINT32_T), getType(UINT64_T))
		declareSuperType(getType(UINT16_T), getType(UINT32_T))
		declareSuperType(getType(UINT8_T), getType(UINT16_T))

		declarePrimitive(FLOAT)
		declarePrimitive(DOUBLE)
		declarePrimitive(BOOL)
		declarePrimitive(UNSUPPORTED_TYPE)
		getType(UNSUPPORTED_TYPE).abstract = true

		declareSuperType(getType(DOUBLE), getType(REAL))
		declareSuperType(getType(FLOAT), getType(DOUBLE))
		declareSuperType(getType(BOOL), getType(BOOLEAN))

		// make integers assignable to floats and doubles
		declareSuperType(getType(INTEGER), getType(FLOAT))

		// 'ANY' type is used to transform '#defines' into constants. As we
		// cannot always derive a proper type for them and they should be
		// assignable in expressions, 'ANY' type is used as leaf in the type
		// hierarchy tree
		declareSuperType(getType(ANY), getType(UINT8_T))
		declareSuperType(getType(ANY), getType(INT8_T))
		declareSuperType(getType(ANY), getType(BOOL))
		declareSuperType(getType(ANY), getType(STRING))

		declarePointerType()
		declareSuperType(getType(ARRAY), getType(POINTER))
	}

	protected def declarePointerType() {
		val pointer = createPointerType()
		declareType(pointer, pointer.getName())
		getResource().contents += pointer

		// Declare extension method to get a pointer for any type
		var pointerExtension = eINSTANCE.createProperty => [
			name = POINTER_PROPERTY
			typeSpecifier = eINSTANCE.createTypeSpecifier => [
				type = pointer
			]
		]
		getResource.contents += pointerExtension
		extensionPropertyRegistry.put(getType(ANY), pointerExtension)
	}

	protected def createPointerType() {
		eINSTANCE.createComplexType => [ type |
			type.name = POINTER
			type.annotations += TypesFactory.eINSTANCE.createAnnotation => [
				type = typeAnnotations.createBuiltInTypeAnnotationType()
			]
			type.typeParameters += eINSTANCE.createTypeParameter => [
				name = "baseType"
			]
			type.features += eINSTANCE.createProperty => [
				name = VALUE_PROPERTY
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = type.typeParameters.head
				]
			]
		]
	}

	override getOperationExtensions(Type type) {
		val result = super.getOperationExtensions(type)
		result += super.getOperationExtensions(getType(ANY))
		result
	}

	override getPropertyExtensions(Type type) {
		val result = super.getPropertyExtensions(type)
		result += super.getPropertyExtensions(getType(ANY))
		result
	}

	/**
	 * lower and upper bounds are currently not used
	 */
	def declareRangedInteger(String name, long lowerBound, long upperBound) {
		val type = declarePrimitive(name)
		type
	}
	
	def boolean isPointer(TypedElement it) {
		return isSame(type, getType(POINTER))
	}
	
	def TypeSpecifier pointsTo(TypedElement it) {
		if(isPointer) {
			return typeSpecifier.typeArguments.head
		}
	}
}
