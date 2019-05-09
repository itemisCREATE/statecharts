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
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.sct.types.modification.IModification

class RenameInterfacesModification implements IModification {

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.eAllContents.filter(ComplexType).filter[getAnnotationOfType("InterfaceGroup") !== null].forEach [ ct |
			var suffix = getSuffix(ct)
			switch (suffix) {
				case "_SCInterface":
					ct.name = ct.name.replace(suffix, "Iface")
				case "_SCInternal": {
				}
				default: {
					ct.name = ct.name.replace(suffix, "Iface" + suffix.replaceFirst("_", ""))
				}
			}
		]

		return p

	}

	def getSuffix(ComplexType type) {
		return type.name.substring(type.name.indexOf("_"))
	}

}
