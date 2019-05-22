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
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.util.ContainmentExtensions
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.sct.types.modification.IModification
import org.yakindu.sct.types.generator.c.annotation.CoreCGeneratorAnnotationLibrary

class FlattenComplexTypesModification implements IModification {

	@Inject protected extension ContainmentExtensions
	@Inject protected extension CoreCGeneratorAnnotationLibrary

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.eAllContents.filter(ComplexType).forEach [ ct |
			ct.rootType = EcoreUtil2.getAllContainers(ct).filter(ComplexType).last
		]
		p.eAllContents.filter(ComplexType).toList.forEach [ ct |
			val outerType = ct.eContainer
			if(outerType instanceof ComplexType) {
				// when moving 
			}
			
			ct.name = ct.getContainmentHierarchy.join("_")
			ct.rootType = EcoreUtil2.getAllContainers(ct).filter(ComplexType).last
			p.member += ct
		]

		return p
	}
}
