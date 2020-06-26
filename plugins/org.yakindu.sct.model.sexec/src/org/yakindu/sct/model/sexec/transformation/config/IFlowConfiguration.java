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
package org.yakindu.sct.model.sexec.transformation.config;

import org.yakindu.sct.model.sgraph.Statechart;
import com.google.inject.ImplementedBy;

/**
 * This service provides the configuration for the model sequencer. These configuration entries 
 * are typically derived from the generator models and the concrete generators can contribute 
 * their configuration by implementing and binding this interface.
 * 
 * Implementations of this interface should typically be bound as singletons for dependency injection.
 * 
 *  @author axel terfloth
 */
@ImplementedBy(DefaultFlowConfiguration.class)
public interface IFlowConfiguration {

	void defineConfigurationForStatechart(Statechart sc);
	
	boolean isEventDriven();
	boolean isCycleBased();
	boolean isSuperStep();
	
	boolean applyIncomingEventBuffer();
	boolean applyInternalEventBuffer();
	boolean applyOutgoingEventBuffer();
	
	boolean applyIncomingEventQueue();
}
