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
package org.yakindu.sct.types.generator.modification.library

import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.AnnotationType
import org.yakindu.base.types.Package
import org.yakindu.sct.types.modification.IModification

class RemoveAnnotationTypeModification implements IModification{
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package it) {
		eAllContents.filter(AnnotationType).toList.forEach[ at |
			EcoreUtil.remove(at)
		]
		it
	}
	
}
