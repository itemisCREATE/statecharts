package org.yakindu.sct.types.generator.c.modifications

import java.util.Collection
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Constructor
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.sct.types.modification.IModification
import org.yakindu.base.expressions.expressions.BlockExpression

class RemoveInitialValueModification implements IModification {
	
	override modify(Collection<Package> packages) {
		packages.map[member].flatten.filter(ComplexType).forEach[modify]
		packages
	}
	
	def protected modify(ComplexType type) {
		type.features.filter(Property).filter[initialValue !== null].forEach[
			val iV = initialValue
			if(iV instanceof ElementReferenceExpression) {
				val ref = iV.reference
				if(ref instanceof Constructor) {
					var delete = false
					val body = ref.body
					delete = (body === null)
					if(body instanceof BlockExpression) {
						delete = body.expressions.nullOrEmpty
					}
					if(delete) {
						initialValue = null
					}
				}
			}
		]
	}
	
}