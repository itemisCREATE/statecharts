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
package org.yakindu.sct.generator.core.extensions

/**
 * Derive model sequencer configuration from core generator entries.
 * 
 * @author axel terfloth
 */
import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.model.sexec.transformation.config.DefaultFlowConfiguration
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper

@Singleton
class CoreFlowConfiguration extends DefaultFlowConfiguration {
	
	@Inject protected GeneratorEntry entry
	@Inject extension ICoreLibraryHelper 
	
	override defineConfigurationForStatechart(Statechart sc) {
		super.defineConfigurationForStatechart(sc)
		_applyOutgoingEventBuffer = entry.outEventGettersUsed
	}
}