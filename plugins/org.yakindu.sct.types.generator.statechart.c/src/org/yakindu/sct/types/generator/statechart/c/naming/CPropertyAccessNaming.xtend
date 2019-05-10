/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
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
