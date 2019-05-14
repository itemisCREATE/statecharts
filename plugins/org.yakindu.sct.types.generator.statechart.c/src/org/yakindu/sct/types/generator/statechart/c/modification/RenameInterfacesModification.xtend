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

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.sct.types.generator.statechart.c.naming.CInterfaceNaming
import org.yakindu.sct.types.modification.IModification

class RenameInterfacesModification implements IModification {
	
	@Inject protected extension CInterfaceNaming

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.eAllContents.filter(ComplexType).filter[getAnnotationOfType("InterfaceGroup") !== null].forEach [ ct |
			switch (ct.name) {
				case SCInterface:
					ct.name = iface
				case SCInternal: {
					ct.name = internal
				}
				default: {
					ct.name = iface + ct.name.toFirstUpper // TODO: This renames a lower case getter from interface (named) to IfaceNamed. Could be removed with 4.0
				}
			}
		]

		return p

	}

}
