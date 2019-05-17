package org.yakindu.sct.types.generator.cpp.modifications

import java.util.Collection
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.sct.types.modification.IModification

class ConstMemberModification implements IModification {
	
	override modify(Collection<Package> packages) {
		packages.map[eAllContents.filter(ComplexType).toList].flatten.map[features].flatten.filter(Property).forEach[
			if(isConst && initialValue !== null) {
				static = true
			}
		]
		packages
	}
	
}