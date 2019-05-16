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
package org.yakindu.sct.types.generator.statechart.modification.library

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.types.generator.statechart.annotation.SCTGeneratorAnnotationLibrary
import org.yakindu.sct.types.modification.IModification

/**
 *  Removes recursively all unused functions by searching for empty cross references
 * 
 */
class UnusedFunctionsModification implements IModification {
	
	@Inject protected extension SequencerAnnotationLibrary
	@Inject protected extension SCTGeneratorAnnotationLibrary

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.removeUnusedFunctions
		return p
	}
	
	def protected void removeUnusedFunctions(Package p) {
		val opsToRemove = newArrayList
		 p.eAllContents.filter(Operation).filter[!API].toList.forEach[ op | 
			if((EcoreUtil.UsageCrossReferencer.find(op, p).nullOrEmpty)){
				opsToRemove.add(op)
			}
		]
		EcoreUtil.removeAll(opsToRemove)
		if(!opsToRemove.nullOrEmpty){
			p.removeUnusedFunctions
		}
		return
	}
}
