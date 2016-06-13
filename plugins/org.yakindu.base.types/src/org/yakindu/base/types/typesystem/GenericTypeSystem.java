/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types.typesystem;

import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.TypeParameter;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypesFactory;

import com.google.inject.Singleton;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class GenericTypeSystem extends AbstractTypeSystem {

	@Override
	protected void initBuiltInTypes() {
		declarePrimitive(STRING);
		declarePrimitive(REAL);
		declarePrimitive(INTEGER);
		declarePrimitive(BOOLEAN);
		declarePrimitive(VOID);
		declarePrimitive(NULL);

		declareSuperType(getType(INTEGER), getType(REAL));

		getType(NULL).setAbstract(true);
		
		declareArrayType();
	}

	protected void declareArrayType() {
		ComplexType array = TypesFactory.eINSTANCE.createComplexType();
		array.setName("array");
		declareType(array, array.getName());
		getResource().getContents().add(array);

		TypeParameter baseType = TypesFactory.eINSTANCE.createTypeParameter();
		baseType.setName("baseType");
		array.getParameter().add(baseType);
		
		// GET
		Operation get = TypesFactory.eINSTANCE.createOperation();
		get.setName("get");
		Parameter index = TypesFactory.eINSTANCE.createParameter();
		TypeSpecifier paramTypeSpec = TypesFactory.eINSTANCE.createTypeSpecifier();
		paramTypeSpec.setType(getType(INTEGER));
		index.setTypeSpecifier(paramTypeSpec);
		
		index.setName("index");
		get.getParameters().add(index);
		TypeSpecifier getTypeSpec = TypesFactory.eINSTANCE.createTypeSpecifier();
		getTypeSpec.setType(baseType);
		get.setTypeSpecifier(getTypeSpec);
		array.getFeatures().add(get);
		
		// ADD
		Operation add = TypesFactory.eINSTANCE.createOperation();
		add.setName("add");
		Parameter element = TypesFactory.eINSTANCE.createParameter();
		element.setName("element");
		TypeSpecifier addTypeSpec = TypesFactory.eINSTANCE.createTypeSpecifier();
		addTypeSpec.setType(baseType);
		element.setTypeSpecifier(addTypeSpec);
		add.getParameters().add(element);
		array.getFeatures().add(add);

		// SIZE
		Operation size = TypesFactory.eINSTANCE.createOperation();
		size.setName("size");
		TypeSpecifier sizeTypeSpec = TypesFactory.eINSTANCE.createTypeSpecifier();
		sizeTypeSpec.setType(getType(INTEGER));
		size.setTypeSpecifier(sizeTypeSpec);
		array.getFeatures().add(size);
	}
}
