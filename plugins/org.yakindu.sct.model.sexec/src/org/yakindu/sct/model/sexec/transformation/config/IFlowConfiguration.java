package org.yakindu.sct.model.sexec.transformation.config;

import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultFlowConfiguration.class)
public interface IFlowConfiguration {

	void takeConfigurationfromStatechart(Statechart sc);
	
	boolean isEventDriven();
	boolean isCycleBased();
	boolean isSuperStep();
	
	boolean applyIncomingEventBuffer();
	boolean applyInternalEventBuffer();
	boolean applyOutgoingEventBuffer();
	
	boolean applyIncomingEventQueue();
}
