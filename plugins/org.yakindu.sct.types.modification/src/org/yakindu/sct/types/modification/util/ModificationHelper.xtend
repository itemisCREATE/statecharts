package org.yakindu.sct.types.modification.util

import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Property

class ModificationHelper {

	def getOwnerInstance(EObject obj) {
		val ct = obj.eContainer
		if (ct instanceof ComplexType) {
			val outerClass = ct.eContainer
			if (outerClass instanceof ComplexType) {
				return outerClass.features.filter(Property).findFirst[type === ct]
			}
		}
	}

}
