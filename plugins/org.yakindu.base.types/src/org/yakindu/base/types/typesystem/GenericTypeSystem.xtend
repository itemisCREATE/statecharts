/** 
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.base.types.typesystem

import com.google.inject.Singleton
import static org.yakindu.base.types.TypesFactory.*

/** 
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton 

class GenericTypeSystem extends AbstractTypeSystem {

	static final GenericTypeSystem INSTANCE = new GenericTypeSystem()

	protected new() {
	}

	def static GenericTypeSystem getInstance() {
		return INSTANCE
	}

	override protected void initRegistries() {
		declarePrimitive(STRING)
		declarePrimitive(REAL)
		declarePrimitive(INTEGER)
		declarePrimitive(BOOLEAN)
		declarePrimitive(VOID)
		declarePrimitive(NULL)
		getType(NULL).setAbstract(true)
		declarePrimitive(ANY)
		getType(ANY).setAbstract(true)
		declareSuperType(getType(ANY), getType(STRING))
		declareSuperType(getType(ANY), getType(BOOLEAN))
		declareSuperType(getType(ANY), getType(INTEGER))
		declareSuperType(getType(INTEGER), getType(REAL))
		declareArrayType
	}

	protected def declareArrayType() {
		val array = createArrayType()
		array.abstract = true
		declareType(array, array.getName())
		getResource().contents += array
	}

	protected def createArrayType() {
		eINSTANCE.createComplexType => [ ar |
			ar.name = ARRAY
			ar.annotations += eINSTANCE.createAnnotation => [
				type = typeAnnotations.createBuiltInTypeAnnotationType()
			]
			ar.typeParameters += eINSTANCE.createTypeParameter => [
				name = "baseType"
			]
		]
	}
}
