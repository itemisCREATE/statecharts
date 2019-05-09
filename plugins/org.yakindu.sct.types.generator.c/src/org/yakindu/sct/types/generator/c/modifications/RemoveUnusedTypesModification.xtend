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
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Package
import org.yakindu.sct.types.modification.IModification

class RemoveUnusedTypesModification implements IModification{
	@Inject protected extension PackageNavigationExtensions
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package it) {
		allComplexTypes.forEach[ct |
			if(ct.features.nullOrEmpty){
				if(!(ct instanceof EnumerationType)) {
					EcoreUtil.remove(ct)
				}
			}
		]
		it
	}
	
}
