/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 *  thomas kutz - itemis AG
 *  axel terfloth - itemis AG
 */
package org.yakindu.sct.model.sexec.transformation

import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.TypedElement
import com.google.inject.Inject
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Type

/**
 * Builder extension for building types.
 * 
 * TODO: move to types plugin
 * 
 * @author axel terfloth
 * @author thomas kutz
 */
class TypeBuilder {

	@Inject extension ITypeSystem typeSystem
	extension TypesFactory tFactory = TypesFactory.eINSTANCE
	
	def _op(String name, Type returnType) {
		_op => [op |
			op.name = name
			op.typeSpecifier = createTypeSpecifier => [
				type = returnType
			]
		]
	}
	
	def _op() {
		createOperation
	}

	def _type(TypedElement it, String typeName) {
		typeSpecifier = createTypeSpecifier => [
			type = typeSystem.getType(typeName);
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
	
}