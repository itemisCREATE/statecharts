/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.sct.generator.core.extensions.CoreFlowConfiguration
import org.yakindu.sct.model.sgraph.Statechart
import com.google.inject.Singleton

/**
 * Derives a flow configuration required by the model sequencer from the 
 * C code generator gmodel.
 * 
 * @author axel terfloth
 */
@Singleton
class CFlowConfiguration extends CoreFlowConfiguration {
	
	@Inject protected GeneratorPredicate gp

	override takeConfigurationfromStatechart(Statechart sc) {
		super.takeConfigurationfromStatechart(sc)
		
		_applyIncomingEventQueue = gp.useInEventQueue		
	}
	
}