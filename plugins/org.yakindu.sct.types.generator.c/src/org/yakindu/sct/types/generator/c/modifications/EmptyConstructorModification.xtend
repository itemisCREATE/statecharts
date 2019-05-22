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

import org.yakindu.sct.types.modification.IModification
import java.util.Collection
import org.yakindu.base.types.Package
import org.yakindu.base.types.Constructor
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 * Removes all unused constructors, which got no body
 */
class EmptyConstructorModification implements IModification{
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}
	
	def modify(Package p){
		p.eAllContents.filter(Constructor).filter[body === null].toList.forEach[
			EcoreUtil.remove(it)
		]
		return p
	}
	
}