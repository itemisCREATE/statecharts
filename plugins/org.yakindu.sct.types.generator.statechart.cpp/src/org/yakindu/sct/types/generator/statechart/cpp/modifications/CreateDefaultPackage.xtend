package org.yakindu.sct.types.generator.statechart.cpp.modifications

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.types.modification.IModification

class CreateDefaultPackage implements IModification {
	@Inject protected extension SequencerAnnotationLibrary
	protected TypesFactory typesFactory = TypesFactory.eINSTANCE
	
	override modify(Collection<Package> packages) {
		// All ComplexType members of all packages that are statemachines
		val statemachines = packages.map[member].flatten.filter(ComplexType).filter[isStatemachineType].toList
		// All supertype typeSpecifier's types
		statemachines.map[superTypes].flatten.map[type].forEach[
			packages.getDefaultPackage.member.add(it)
		]
		packages
	}
	
	def protected Package getDefaultPackage(Collection<Package> packages) {
		return packages.findFirst[name == "default"]?:createDefaultPackage(packages)
	}
	
	def protected Package create typesFactory.createPackage createDefaultPackage(Collection<Package> packages) {
		name = "default"
		packages.add(it)
	}
}