/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.PrimitiveType;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeParameter;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.typesystem.AbstractTypeSystem;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class AbstractTypeSystemTest extends AbstractTypeSystem {

	private static final String SUB_TYPE = "SubType";
	private static final String SUB_TYPE2 = "SubType2";
	private static final String SUPER_TYPE = "SuperType";
	private static final String SUPER_SUPER_TYPE = "SuperSuperType";
	private static final String SIMPLE_TYPE = "SimpleType";
	private static final String CONVERSION_SUB_TYPE = "ConversionSubType";
	private static final String CONVERSION_TYPE = "ConversionType";
	private static final String TYPE_PARAMETER = "T";
	private static final String COMPLEX_TYPE = "ComplexType";
	private static final String SUPER_COMPLEX_TYPE = "SuperComplexType";
	private static final String SUPER_SUPER_COMPLEX_TYPE = "SuperSuperComplexType";
	
	private static final String PRIMITIVE_TYPE = "PrimitiveType";
	private static final String PRIMITIVE_BASE_TYPE = "PrimitiveBaseType";
	
	private static final String EXTENSION_OPERATION = "extensionOperation";
	private static final String EXTENSION_OPERATION2 = "extensionOperation2";
	private static final String EXTENSION_OPERATION3 = "extensionOperation3";
	
	private static final String EXTENSION_PROPERTY = "extensionProperty";
	private static final String EXTENSION_PROPERTY2 = "extensionProperty2";
	private static final String EXTENSION_PROPERTY3 = "extensionProperty3";

	private Type superType;
	private Type superSuperType;
	private Type subType;
	private Type subType2;
	private Type simpleType;
	private Type conversionType;
	private Type conversionSubType;
	
	private TypeParameter typeParameter;
	
	private ComplexType complexType;
	private ComplexType superComplexType;
	private ComplexType superSuperComplexType;
	
	private PrimitiveType primitiveType;
	private PrimitiveType primitiveBaseType;
	
	private Operation extensionOperation;
	private Operation extensionOperation2;
	private Operation extensionOperation3;
	
	private Property extensionProperty;
	private Property extensionProperty2;
	private Property extensionProperty3;
	

	@Override
	protected void initRegistries() {
		// SubType extends SuperType
		superType = createPrimitive(SUPER_TYPE);
		declareType(superType, SUPER_TYPE);
		subType = createPrimitive(SUB_TYPE);
		declareType(subType, SUB_TYPE);
		declareSuperType(subType, superType);
		
		// SubType2 extends Supertype
		subType2 = createPrimitive(SUB_TYPE2);
		declareType(subType2, SUB_TYPE2);
		declareSuperType(subType2,superType);
		
		// SuperSuperType extends SuperType
		superSuperType = createPrimitive(SUPER_SUPER_TYPE);
		declareType(superSuperType, SUPER_SUPER_TYPE);
		declareSuperType(superType, superSuperType);
		
		// SimpleType
		simpleType = createPrimitive(SIMPLE_TYPE);
		declareType(simpleType, SIMPLE_TYPE);
		
		// simpleType can be converted into Conversiontype
		conversionType = createPrimitive(CONVERSION_TYPE);
		declareConversion(simpleType, conversionType);
		conversionSubType = createPrimitive(CONVERSION_SUB_TYPE);
		declareSuperType(conversionSubType, conversionType);
		
		// T with SuperType as bound (<T extends SuperType>)
		typeParameter = createTypeParameter(TYPE_PARAMETER);
		declareType(typeParameter, TYPE_PARAMETER);
		typeParameter.setBound(superType);
		
		// Primitive type with baseType
		primitiveBaseType = createPrimitive(PRIMITIVE_BASE_TYPE);
		primitiveType = createPrimitive(PRIMITIVE_TYPE);
		declareType(primitiveType, PRIMITIVE_TYPE);
		primitiveType.setBaseType(primitiveBaseType);
		
		// ComplexType extends SuperComplexType extends SuperSuperComplexType
		superSuperComplexType = createComplexType(SUPER_SUPER_COMPLEX_TYPE);
		superComplexType = createComplexType(SUPER_COMPLEX_TYPE);
		superComplexType.getSuperTypes().add(superSuperComplexType);
		complexType = createComplexType(COMPLEX_TYPE);
		complexType.getSuperTypes().add(superComplexType);
		
		// extension operation
		extensionOperation = createOperation(EXTENSION_OPERATION);
		extensionOperation2 = createOperation(EXTENSION_OPERATION2);
		extensionOperation3 = createOperation(EXTENSION_OPERATION3);
		extensionOperationRegistry.put(subType,extensionOperation);
		extensionOperationRegistry.put(superType,extensionOperation2);
		extensionOperationRegistry.put(superSuperType,extensionOperation3);
		
		// extension properties
		extensionProperty = createProperty(EXTENSION_PROPERTY);
		extensionProperty2 = createProperty(EXTENSION_PROPERTY2);
		extensionProperty3 = createProperty(EXTENSION_PROPERTY3);
		extensionPropertyRegistry.put(subType, extensionProperty);
		extensionPropertyRegistry.put(superType, extensionProperty2);
		extensionPropertyRegistry.put(superSuperType, extensionProperty3);
	}

	protected Property createProperty(String name) {
		Property property = TypesFactory.eINSTANCE.createProperty();
		property.setName(name);
		return property;
	}

	protected Operation createOperation(String name) {
		Operation op = TypesFactory.eINSTANCE.createOperation();
		op.setName(name);
		return op;
	}

	protected ComplexType createComplexType(String name) {
		ComplexType complexType = TypesFactory.eINSTANCE.createComplexType();
		complexType.setName(name);
		return complexType;
	}

	protected TypeParameter createTypeParameter(String name) {
		TypeParameter typeParameter = TypesFactory.eINSTANCE.createTypeParameter();
		typeParameter.setName(TYPE_PARAMETER);
		return typeParameter;
	}

	protected PrimitiveType createPrimitive(String name) {
		PrimitiveType result = TypesFactory.eINSTANCE.createPrimitiveType();
		result.setName(name);
		return result;
	}

	@Test
	public void testGetSuperTypes() throws Exception {
		// super type from registry
		assertEquals("Type system's extends registry not reflected in getSuperTypes() method", 2, getSuperTypes(subType).size());
		assertTrue(isSame(superType, getSuperTypes(subType).get(0)));
		
		// super type as base type of primitive type
		assertEquals("Primitive type's base type not reflected in getSuperTypes() method", 1, getSuperTypes(primitiveType).size());
		assertTrue(isSame(primitiveBaseType, getSuperTypes(primitiveType).get(0)));
		
		// super type as complex type super type
		assertEquals("Complex type's super types not reflected in getSuperTypes() method", 2, getSuperTypes(complexType).size());
		assertTrue(isSame(superComplexType, getSuperTypes(complexType).get(0)));
		
		// super type as type parameter bound
		assertEquals("Type parameter's bound type not reflected in getSuperTypes() method", 2, getSuperTypes(typeParameter).size());
		assertTrue(isSame(superType, getSuperTypes(typeParameter).get(0)));
	}

	@Test
	public void testIsSuperType() throws Exception {
		// super type from registry
		assertTrue("Direct super types from type system's extends registry not reflected in isSuperType() method", isSuperType(subType, superType));
		assertTrue("Indirect super types from type system's extends registry not reflected in isSuperType() method", isSuperType(superType, superSuperType));
		assertFalse(isSuperType(superType, subType));
		
		// super type as base type of primitive type
		assertTrue("Primitive type's base type not reflected in isSuperType() method", isSuperType(primitiveType, primitiveBaseType));
		assertFalse(isSuperType(primitiveBaseType, primitiveType));
		
		// super type as complex type super type
		assertTrue("Complex type's direct super types not reflected in isSuperType() method", isSuperType(complexType, superComplexType));
		assertTrue("Complex type's indirect super types not reflected in isSuperType() method", isSuperType(complexType, superSuperComplexType));
		assertFalse(isSuperType(superComplexType, complexType));
		
		// super type as type parameter bound
		assertTrue("Type parameter's bound type not reflected in isSuperType() method", isSuperType(typeParameter, superType));
		assertTrue("Indirect super types from type system's extends registry not reflected in isSuperType() method", isSuperType(typeParameter, superSuperType));
		assertFalse(isSuperType(typeParameter, simpleType));
	}
	
	@Test
	public void testHaveCommonType() throws Exception {
		assertTrue(haveCommonType(subType, subType2));
		assertTrue(haveCommonType(subType, superType));
		assertTrue(haveCommonType(superType, subType));
		assertFalse(haveCommonType(superType, simpleType));
	}

	@Test
	public void testGetCommonType() throws Exception {
		assertTrue(isSame(superType, getCommonType(subType, subType2)));
		assertTrue(isSame(superType, getCommonType(subType, superType)));
		assertTrue(isSame(superType, getCommonType(superType, subType)));

		assertNull(getCommonType(superType, simpleType));
	}

	@Test
	public void testGetCommonTypeWithConversion() throws Exception {
		assertTrue(isSame(conversionType, getCommonTypeWithConversion(conversionType, simpleType)));
		assertTrue(isSame(conversionType, getCommonTypeWithConversion(conversionType, conversionSubType)));
	}
	
	@Test
	public void testGetOperationExtensions() {
		assertEquals(3, getOperationExtensions(subType).size());
		assertTrue(getOperationExtensions(subType).contains(extensionOperation));
		assertTrue(getOperationExtensions(subType).contains(extensionOperation2));
		assertTrue(getOperationExtensions(subType).contains(extensionOperation3));
	}
	
	@Test
	public void testIsOperationExtension() {
		assertTrue(isExtensionOperation(extensionOperation));
		assertTrue(isExtensionOperation(extensionOperation2));
		assertTrue(isExtensionOperation(extensionOperation3));
	}
	
}
