package org.yakindu.sct.types.generator.statechart.modification.library

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.Visibility
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.types.modification.IModification

class APIOperationsModification implements IModification {

	@Inject protected extension SequencerAnnotationLibrary

	val APIOperations = #[
		"init",
		"enter",
		"exit",
		"runCycle",
		"isActive",
		"isFinal",
		"isStateActive"
	]

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		val ops = p.eAllContents.filter(Operation).filter[!(it instanceof OperationDefinition)]
		ops.filter[APIOperations.contains(name)].forEach [
			visibility = Visibility.PUBLIC
			static = false
			annotateWith(APIAnnotation)
		]
		ops.filter[!APIOperations.contains(name) && !isAPI].forEach [
			static = true 
			visibility = Visibility.PROTECTED
		]
		return p
	}

}
