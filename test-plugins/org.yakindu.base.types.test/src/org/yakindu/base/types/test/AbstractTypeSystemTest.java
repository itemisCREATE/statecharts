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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.yakindu.base.types.PrimitiveType;
import org.yakindu.base.types.Type;
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
	private static final String SIMPLE_TYPE = "SimpleType";
	private static final String CONVERSION_SUB_TYPE = "ConversionSubType";
	private static final String CONVERSION_TYPE = "ConversionType";

	private Type superType;
	private Type subType;
	private Type subType2;
	private Type simpleType;
	private Type conversionType;
	private Type conversionSubType;

	@Override
	protected void initBuiltInTypes() {
		// SubType extends SuperType
		superType = createPrimitive(SUPER_TYPE);
		declareType(superType, SUPER_TYPE);
		subType = createPrimitive(SUB_TYPE);
		declareType(subType, SUB_TYPE);
		declareSuperType(superType, subType);
		// SubType2 extends Supertype
		subType2 = createPrimitive(SUB_TYPE2);
		declareType(subType2, SUB_TYPE2);
		declareSuperType(superType, subType2);
		// SimpleType
		simpleType = createPrimitive(SIMPLE_TYPE);
		declareType(simpleType, SIMPLE_TYPE);
		//simpleType can be converted into Conversiontype
		conversionType = createPrimitive(CONVERSION_TYPE);
		declareConversion(simpleType, conversionType);
		conversionSubType = createPrimitive(CONVERSION_SUB_TYPE);
		declareSuperType(conversionType, conversionSubType);
		
	}

	protected Type createPrimitive(String name) {
		PrimitiveType result = TypesFactory.eINSTANCE.createPrimitiveType();
		result.setName(name);
		return result;
	}

	@Test
	public void testGetSuperType() throws Exception {
		assertTrue(isSame(superType, getSuperType(subType)));

	}

	@Test
	public void testIsSuperType() throws Exception {
		assertTrue(isSuperType(subType, superType));
		assertFalse(isSuperType(superType, subType));
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
		assertTrue(isSame(conversionType, getCommonType(conversionType, simpleType)));
		assertTrue(isSame(conversionType, getCommonType(conversionType, conversionSubType)));
	}

	@Override
	public Object defaultValue(Type type) {
		return null;
	}

}
