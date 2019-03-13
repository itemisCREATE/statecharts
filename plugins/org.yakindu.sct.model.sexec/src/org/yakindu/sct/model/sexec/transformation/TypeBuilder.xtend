package org.yakindu.sct.model.sexec.transformation

import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.TypedElement
import com.google.inject.Inject
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.Expression

class TypeBuilder {

	@Inject extension ITypeSystem typeSystem
	extension TypesFactory tFactory = TypesFactory.eINSTANCE
	
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