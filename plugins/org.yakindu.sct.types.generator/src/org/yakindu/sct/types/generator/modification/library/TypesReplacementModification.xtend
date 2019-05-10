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
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.sct.types.generator.ITargetPlatform
import org.yakindu.sct.types.modification.IModification

class TypesReplacementModification implements IModification {
	@Inject protected ITargetPlatform platform

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		val contents = p.eAllContents.toList

		contents.filter(TypeSpecifier).forEach [
			replaceType
		]
		contents.filter(TypeCastExpression).forEach [
			replaceType
		]

		p.member.filter(ComplexType).map[superTypes].flatten.map[type].forEach [ t |
			t.eAllContents.filter(TypeSpecifier).forEach[replaceType]
		]

		p
	}

	def protected replaceType(TypeSpecifier it) {
		if (isDeclaredInPackage(type)) {
			return
		}
		val replacementType = platform.getReplacementType(type)
		if (replacementType !== null) {
			it.type = replacementType
		}
	}

	def protected replaceType(TypeCastExpression it) {
		if (isDeclaredInPackage(type)) {
			return
		}
		val replacementType = platform.getReplacementType(type)
		if (replacementType !== null) {
			it.type = replacementType
		}
	}

	def protected isDeclaredInPackage(Type type) {
		EcoreUtil2.getRootContainer(type) instanceof Package
	}
}
