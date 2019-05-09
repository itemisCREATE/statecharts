package org.yakindu.sct.model.sexec.transformation

import com.google.inject.Inject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.Property

class ArrayType {
	
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