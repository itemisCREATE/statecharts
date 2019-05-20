package org.yakindu.sct.model.sequencer.modification

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sequencer.types.StatemachineMethods
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.types.common.library.TypesLibrary
import org.yakindu.sct.types.modification.IModification

class EventDrivenModification implements IModification {
	@Inject protected extension SequencerAnnotationLibrary
	@Inject protected extension TypeBuilder
	@Inject protected extension ExpressionBuilder
	@Inject protected TypesLibrary typesLibrary
	@Inject protected extension StatemachineMethods
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}
	
	def modify(Package p) {
		val trigger = triggerAnnotation
		val queued = queuedAnnotation
		p.member.addAll(trigger, queued)
		
		val annotated = getAnnotatedComplexTypes(p)

		annotated.forEach[cT |
			// Go over eAllContents because events are in subtypes (interfaces)!
			
			cT.eAllContents.filter(Event).filter[direction == Direction.IN].forEach[
				_annotateWith(trigger)
			]
			cT.eAllContents.filter(Event).filter[direction == Direction.LOCAL].forEach[
				_annotateWith(queued)
			]
			
			if(cT.needsQueue) {
				cT.features.add(typesLibrary.queue)
				cT.features.add(typesLibrary.eventWrapper)
				val queueInstance = cT.internalQueueInstance
				queueInstance.typeSpecifier.typeArguments += _typeSpecifier(typesLibrary.eventWrapper)
				cT.features.add(queueInstance)
			}
			
			cT.defineRTCMethod		
		]
	}
	
	def Property create _variable("internalEventQueue", typesLibrary.queue) internalQueueInstance(ComplexType cT) {
	}
	
	def internalQueueSize(ComplexType cT) {
		internalQueueInstance(cT)._ref._fc(typesLibrary.queue.features.filter[name == "size"].head)
	}
	
	def internalQueuePop(ComplexType cT) {
		internalQueueInstance(cT)._ref._fc(typesLibrary.queue.features.filter[name == "pop"].head)
	}
	
	def defineRTCMethod(ComplexType cT) {
		cT.createRTCMethod => [
			body = _block(
				if(needsQueue(cT)) { 
					#[
						cT.createClearOutEventsMethod._call,
						cT.createSingleStepMethod._call,
						cT.createClearEventsMethod._call,
						_while(cT.internalQueueSize._greater(0._int)) => [
							body = _block(
								_variable("event", typesLibrary.eventWrapper, cT.internalQueuePop),
								cT.createSingleStepMethod._call,
								
								cT.createClearEventsMethod._call
							)
						]
					]
				}
				else {
					#[
						cT.createClearOutEventsMethod._call,
						cT.createSingleStepMethod._call,
						cT.createClearEventsMethod._call
					]
					
				}
			)
		]
	}
	
	def popEvent(ComplexType cT) {
		_block(
			_variable("event", typesLibrary.eventWrapper, cT.internalQueuePop)
			// TODO GOD HELP ME
		)
	}
	
	def needsQueue(ComplexType cT) {
		cT.eAllContents.filter(Event).exists[direction == Direction.LOCAL]
	}
	
	def getAnnotatedComplexTypes(Package p) {
		p.eAllContents.filter(ComplexType).filter[isEventDriven].toList
	}
	
}