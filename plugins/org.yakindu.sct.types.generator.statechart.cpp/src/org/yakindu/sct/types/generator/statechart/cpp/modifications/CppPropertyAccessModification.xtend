/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.statechart.cpp.modifications

import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.sct.types.modification.IModification

class CppPropertyAccessModification implements IModification {
	extension ExpressionsFactory factory = ExpressionsFactory.eINSTANCE

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		(p.member.findFirst[it instanceof ComplexType] as ComplexType).features.filter(ComplexType).filter [
			getAnnotationOfType("InterfaceGroup") !== null
		].toList.forEach [
			eAllContents.filter(FeatureCall).toList.forEach [
				EcoreUtil.replace(it, createElementReferenceExpression => [ ele |
					ele.reference = it.feature
					ele.operationCall = true
				])
			]
		]
		return p
	}

}
