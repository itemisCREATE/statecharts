/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sequencer.util

import com.google.inject.Inject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.Property

class ArrayTypeExtensions {
	
	@Inject ITypeSystem ts
	
	extension TypesFactory typesFactory = TypesFactory.eINSTANCE
	
	def _array() {
		ts.getType(ITypeSystem.ARRAY) as ComplexType
	}
	
	def _new(ComplexType type) {
		type.allFeatures.filter(Operation).findFirst[name == "new"]
	}
	
	def _length(ComplexType type) {
		type.allFeatures.filter(Property).findFirst[name == "length"]
	}
	
	def _of(ComplexType arrayType, Type elementType) {
		createTypeSpecifier => [
			type = arrayType
			typeArguments += createTypeSpecifier => [
				type = elementType
			]
		]
	}
}
