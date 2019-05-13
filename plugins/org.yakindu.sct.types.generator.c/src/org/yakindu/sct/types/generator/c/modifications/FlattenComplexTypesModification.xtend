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

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.expressions.util.ContainmentExtensions
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.sct.types.modification.IModification

class FlattenComplexTypesModification implements IModification {
	
	@Inject protected extension ContainmentExtensions

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.eAllContents.filter(ComplexType).toList.forEach [ct | 
			ct.name = ct.getContainmentHierarchy.join("_")
			p.member += ct
		]

		return p
	}
}
