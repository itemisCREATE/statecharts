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
package org.yakindu.sct.generator.cpp

/**
 * Provides the configuration for the model sequencer derived from C++ generator model
 * 
 * @author axel terfloth
 */
import com.google.inject.Inject
import org.yakindu.sct.generator.core.extensions.CoreFlowConfiguration
import org.yakindu.sct.model.sgraph.Statechart
import com.google.inject.Singleton
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension

@Singleton
class CppFlowConfiguration extends CoreFlowConfiguration {
	
	@Inject protected extension GenmodelEntriesExtension gp
	

	override takeConfigurationfromStatechart(Statechart sc) {
		super.takeConfigurationfromStatechart(sc)
		
		_applyIncomingEventBuffer = false // deactivate confugartion for now TODO: remove
		_applyInternalEventBuffer = false // deactivate configuration for now TODO: remove
		_applyIncomingEventQueue = false // deactivate configuration for now TODO: entry.inEventQueue
	}
	
}