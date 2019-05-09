/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.c.modifications

import java.util.Collection
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.sct.types.modification.IModification

class RenameOperationsModification implements IModification{
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.eAllContents.filter(Operation).filter[static == false].forEach[ op |
			op.name = op.name.toFirstLower
		]
		return p
	}
}
