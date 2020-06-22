package org.yakindu.sct.model.sexec.transformation.config

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.lib.StatechartAnnotations

@Singleton
class DefaultFlowConfiguration implements IFlowConfiguration {

	@Inject protected extension StatechartAnnotations annotations
	 
	protected boolean _isEventDriven = false
	protected boolean _isSuperStep = false
	
	protected boolean _applyIncomingEventBuffer = true
	protected boolean _applyInternalEventBuffer = true
	protected boolean _applyOutgoingEventBuffer = false
	
	protected boolean _applyIncomingEventQueue = true
		
	override takeConfigurationfromStatechart(Statechart sc) {
		_isEventDriven = annotations.isEventDriven(sc)
		_isSuperStep = annotations.isSuperStep(sc)
	}
	
	override applyIncomingEventBuffer() {
		isCycleBased && _applyIncomingEventBuffer
	}
	
	override applyInternalEventBuffer() {
		isCycleBased && _applyInternalEventBuffer
	}
	
	override applyOutgoingEventBuffer() {
		_applyOutgoingEventBuffer
	}
	
	override isCycleBased() { ! _isEventDriven }
	
	override isEventDriven() { _isEventDriven }
	
	override isSuperStep() { _isSuperStep }
	
	override applyIncomingEventQueue() {
		isEventDriven && _applyIncomingEventQueue
	}
	
	
}