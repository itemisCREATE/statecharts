/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.modification.library

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.sct.types.modification.IModification

class RemoveUnusedTypesModification implements IModification {
	@Inject protected extension PackageNavigationExtensions

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package it) {
		allComplexTypes.forEach [ ct |
			if (ct.features.nullOrEmpty) {
				if (!(ct instanceof EnumerationType)) {
					ct.removeType(it)
				}
			}
		]
		it
	}

	def protected removeType(Type it, Package p) {
		var properties = p.eAllContents.filter(Property).toList
		properties = properties.filter[prop|prop.typeSpecifier.type == it].toList
		properties.forEach[prop|EcoreUtil.remove(prop)]
		EcoreUtil.remove(it)
	}

}
