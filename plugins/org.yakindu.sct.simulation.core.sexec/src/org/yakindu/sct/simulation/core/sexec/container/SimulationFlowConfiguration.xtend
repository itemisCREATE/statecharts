/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.sexec.container

import org.yakindu.sct.model.sexec.transformation.config.DefaultFlowConfiguration
import org.yakindu.sct.model.sgraph.Statechart
import com.google.inject.Singleton

/**
 * Model sequencer configuration for the simulator.
 * 
 * @author axel terfloth
 */
@Singleton
class SimulationFlowConfiguration extends DefaultFlowConfiguration {
	
	override defineConfigurationForStatechart(Statechart sc) {
		super.defineConfigurationForStatechart(sc)

		/** this option is set t true to make sure that out event slots are properly cleaned up. */
		_applyOutgoingEventBuffer = true
	}
	
}