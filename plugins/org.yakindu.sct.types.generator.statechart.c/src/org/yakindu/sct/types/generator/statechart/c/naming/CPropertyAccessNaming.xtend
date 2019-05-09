/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.statechart.c.naming

import org.eclipse.emf.ecore.EObject
import org.yakindu.base.base.NamedElement
import org.yakindu.base.types.Property
import org.yakindu.sct.types.generator.statechart.core.naming.IPropertyAccessNaming

class CPropertyAccessNaming implements IPropertyAccessNaming {
	
	override nameReadAccess(Property prop) {
		return  "get_" + prop.name
	}
	
	override nameWriteAccess(Property prop) {
		return "set_" + prop.name
	}
	
	override nameAssign(Property prop) {
		return "assign_" + prop.name
	}
	
	def dispatch getName(EObject it) {
		""
	}
	
	def dispatch getName(NamedElement it) {
		name + "_"
	}
}
