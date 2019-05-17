package org.yakindu.sct.types.generator.statechart.cpp.modifications

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.types.modification.IModification

class RenameSidePackage implements IModification {
	@Inject protected extension SequencerAnnotationLibrary
	
	override modify(Collection<Package> packages) {
		packages.filter[member.filter(ComplexType).exists[isStatemachineType]].forEach[
			modify
		]
		packages
	}
	
	def modify(Package p) {
		p.member.filter(ComplexType).map[superTypes].flatten.map[type].toSet.forEach[ sT |
			(EcoreUtil.getRootContainer(sT) as Package).name = "default"
		]
	}
	
}