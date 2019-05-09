/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.base.expressions.util

import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.types.Visibility
import org.yakindu.base.expressions.expressions.FeatureCall

class PackageNavigationExtensions {
	
	def allTopLevelComplexTypes(Package p) {
		p.member.filter(ComplexType).toList
	}
	
	def allTopLevelPublicProperties(Package p) {
		p.member.filter(Property).filter[visibility == Visibility.PUBLIC].toList
	}
	
	def allComplexTypes(Package p) {
		p.eAllContents.filter(ComplexType).toList
	}
	
	def allOperations(Package p) {
		p.eAllContents.filter(Operation).toList
	}
	
	def allFeatureCalls(Package p) {
		p.eAllContents.filter(FeatureCall).toList
	}
	
	def getContainingPackage(EObject e) {
		EcoreUtil2.getContainerOfType(e, Package)
	}
}
