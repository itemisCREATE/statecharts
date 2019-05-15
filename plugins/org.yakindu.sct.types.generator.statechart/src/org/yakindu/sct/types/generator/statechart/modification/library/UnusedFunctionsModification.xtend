package org.yakindu.sct.types.generator.statechart.modification.library

import com.google.inject.Inject
import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.types.modification.IModification

class UnusedFunctionsModification implements IModification {
	
	@Inject protected extension SequencerAnnotationLibrary

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		val featureCalls = p.eAllContents.filter(FeatureCall).map[feature].filter(Operation).toList
		val refs = p.eAllContents.filter(ElementReferenceExpression).map[reference].filter(Operation).toList
		refs.addAll(featureCalls)
		p.removeUnusedFunctions(refs)
		return p
	}
	
	def protected void removeUnusedFunctions(Package p, List<Operation> refs) {
		val opsToRemove = newArrayList
		 p.eAllContents.filter(Operation).filter[!isAPI].toList.forEach[ op | 
			if(!refs.contains(op)) {
				opsToRemove.add(EcoreUtil.copy(op))
				EcoreUtil.remove(op)
			}
		]
		if(!opsToRemove.nullOrEmpty){
			p.removeUnusedFunctions(refs)
		}
		return
	}

}
