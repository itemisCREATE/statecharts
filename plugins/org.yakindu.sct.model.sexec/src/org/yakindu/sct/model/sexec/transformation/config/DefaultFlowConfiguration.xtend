/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.transformation.config

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.lib.StatechartAnnotations

/**
 * Provides the default configuration for the model sequencer.
 * 
 * @author axel terfloth
 */
@Singleton
class DefaultFlowConfiguration implements IFlowConfiguration {

	@Inject protected extension StatechartAnnotations
	 
	protected boolean _isEventDriven = false
	protected boolean _isSuperStep = false
	
	protected boolean _applyIncomingEventBuffer = true
	protected boolean _applyInternalEventBuffer = true
	protected boolean _applyOutgoingEventBuffer = false
	
	protected boolean _applyIncomingEventQueue = true
		
	override defineConfigurationForStatechart(Statechart sc) {
		_isEventDriven = sc.isEventDriven
		_isSuperStep = sc.isSuperStep()
		_applyIncomingEventBuffer = sc.isInEventBuffer
		_applyInternalEventBuffer = sc.isInternalEventBuffer
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
	
	@Singleton
	static class AllFeaturesDisabled extends DefaultFlowConfiguration {
		
		override void defineConfigurationForStatechart(Statechart sc) {
			
			super.defineConfigurationForStatechart(sc)
			
			_applyIncomingEventBuffer = false
			_applyInternalEventBuffer = false
			_applyOutgoingEventBuffer = false
			_applyIncomingEventQueue = false
		}

	}
	
}