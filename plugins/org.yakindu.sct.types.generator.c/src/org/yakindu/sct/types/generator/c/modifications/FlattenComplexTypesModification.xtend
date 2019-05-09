/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.types.generator.c.modifications

import java.util.Collection
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.sct.types.modification.IModification

class FlattenComplexTypesModification implements IModification {

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.eAllContents.filter(ComplexType).toList.forEach [ct | 
			ct.name = ct.getContainmentHierarchy
			p.member += ct
		]

		return p
	}

	def protected String getContainmentHierarchy(ComplexType it) {
		if (eContainer instanceof ComplexType) {
			return getContainmentHierarchy(eContainer as ComplexType) + "_" + name
		}
		return name
	}

}
