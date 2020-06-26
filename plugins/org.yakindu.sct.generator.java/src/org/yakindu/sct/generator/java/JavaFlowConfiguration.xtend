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
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.generator.core.extensions.CoreFlowConfiguration
import org.yakindu.sct.model.sgraph.Statechart

/**
 * Derives a flow configuration required by the model sequencer from the 
 * Java code generator model.
 * 
 * @author Thomas Kutz
 */
@Singleton
class JavaFlowConfiguration extends CoreFlowConfiguration {
	
	@Inject extension GeneratorPredicate
	
	override defineConfigurationForStatechart(Statechart sc) {
		super.defineConfigurationForStatechart(sc)
		
		_applyIncomingEventQueue = useInEventQueue
	}
}