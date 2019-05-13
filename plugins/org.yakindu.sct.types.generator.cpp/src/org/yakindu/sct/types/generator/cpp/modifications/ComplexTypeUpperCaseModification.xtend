/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.cpp.modifications

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.Package
import org.yakindu.sct.types.modification.IModification

/**
 * Changes the first character of all ComplexType names in the packages to upper case. 
 */
class ComplexTypeUpperCaseModification implements IModification {
	@Inject protected extension PackageNavigationExtensions

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.allTopLevelComplexTypes.forEach [ cT |
			cT.name = cT.name.toFirstUpper
		]
		p
	}

}
