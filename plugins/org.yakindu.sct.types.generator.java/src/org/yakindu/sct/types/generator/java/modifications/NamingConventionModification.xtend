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
package org.yakindu.sct.types.generator.java.modifications

import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.sct.types.modification.IModification

/**
 * This modification ensures everything is named as by Java naming conventions
 */
class NamingConventionModification implements IModification {
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.eAllContents.forEach[rename]
		p
	}
	
	def dispatch rename(EObject it) {}
	def dispatch rename(Operation it) { it.name = it.name.toFirstLower}
	def dispatch rename(Property it) { it.name = it.name.toFirstLower}
	def dispatch rename(ComplexType it) { it.name = it.name.toFirstUpper}
	
}
