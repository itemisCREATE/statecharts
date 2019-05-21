package org.yakindu.sct.model.sequencer.modification

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.Visibility
import org.yakindu.sct.model.sequencer.types.ICycleBasedMachine
import org.yakindu.sct.model.sequencer.types.StatemachineMethods
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.types.modification.IModification

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
			cT.defineRunCycleMethod(p)			
		]
	}
	
	def defineRunCycleMethod(ComplexType cT, Package p) {
		cT.features += createRunCycleMethod => [
			body = _block(
				
				cT.createClearOutEventsMethod._call,
				
				cT.createSingleStepMethod._call,
				
				cT.createClearEventsMethod._call
			)
			visibility = Visibility.PUBLIC
		]
		val cycleType = cycleBasedMachineType 
		p.member += cycleType
		cT.superTypes += _typeSpecifier(cycleType)
	}
	
	def getAnnotatedComplexTypes(Package p) {
		p.eAllContents.filter(ComplexType).filter[isCycleBased].toList
	}
	
	
}