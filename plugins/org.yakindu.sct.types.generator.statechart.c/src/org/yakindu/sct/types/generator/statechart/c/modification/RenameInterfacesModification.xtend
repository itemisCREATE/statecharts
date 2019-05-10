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
package org.yakindu.sct.types.generator.statechart.c.modification

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
