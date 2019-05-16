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
import java.util.Set
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.types.generator.statechart.annotation.SCTGeneratorAnnotationLibrary
import org.yakindu.sct.types.modification.IModification

class UnusedFunctionsModification implements IModification {
	
	@Inject protected extension SequencerAnnotationLibrary
	@Inject protected extension SCTGeneratorAnnotationLibrary

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.removeUnusedFunctions(p.operationCalls)
		return p
	}
	
	def protected void removeUnusedFunctions(Package p, Set<Operation> refs) {
		val opsToRemove = newArrayList
		 p.eAllContents.filter(Operation).filter[!API].toList.forEach[ op | 
		 	if(!(refs.exists[EcoreUtil.equals(it, op)])) {
		 		opsToRemove.add(op)
				EcoreUtil.remove(op)
		 	}
		]
		if(!opsToRemove.nullOrEmpty){
			p.removeUnusedFunctions(p.operationCalls)
		}
		return
	}
	
	def protected getOperationCalls(Package p) {
		val featureCalls = p.eAllContents.filter(FeatureCall).map[feature].filter(Operation).toList
		val refs = p.eAllContents.filter(ElementReferenceExpression).map[reference].filter(Operation).toSet
		refs.addAll(featureCalls)
		return refs
	}

}
