package org.yakindu.sct.model.sequencer.modification

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sequencer.types.StatemachineMethods
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.types.modification.IModification
import org.yakindu.sct.model.sequencer.types.ICycleBasedMachine
import org.yakindu.base.types.Visibility

class CycleBasedModification implements IModification {
	
	@Inject protected extension SequencerAnnotationLibrary
	@Inject protected extension TypeBuilder
	@Inject protected extension ExpressionBuilder
	@Inject protected extension StatemachineMethods
	@Inject protected extension ICycleBasedMachine
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}
	
	def protected modify(Package p) {
		getAnnotatedComplexTypes(p).forEach[ cT |
			cT.defineRunCycleMethod			
		]
	}
	
	def defineRunCycleMethod(ComplexType cT) {
		cT.features += createRunCycleMethod => [
			body = _block(
				
				cT.createClearOutEventsMethod._call,
				
				cT.createSingleStepMethod._call,
				
				cT.createClearEventsMethod._call
			)
			visibility = Visibility.PUBLIC
		]
		cT.superTypes += _typeSpecifier(cycleBasedMachineType)
	}
	
	def getAnnotatedComplexTypes(Package p) {
		p.eAllContents.filter(ComplexType).filter[isCycleBased].toList
	}
	
	
}