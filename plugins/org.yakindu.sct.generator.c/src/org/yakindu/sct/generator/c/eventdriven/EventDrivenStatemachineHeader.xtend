/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.StatemachineHeader
import org.yakindu.sct.model.sexec.ExecutionFlow

class EventDrivenStatemachineHeader extends StatemachineHeader {
	@Inject extension EventNaming
	@Inject extension StatechartEventsHeader events
	
	override additionalContents(ExecutionFlow it) {
		'''
		«super.additionalContents(it)»
		
		«events.content(it)»
		'''
	}
	
	override statemachineTypeStructContent(ExecutionFlow it) {
		'''
		«super.statemachineTypeStructContent(it)»
		«eventQueueTypeName» internal_event_queue;
		'''
	}
	
	override includes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«super.includes(it, artifactConfigs)»
		#include "«eventsModule.h»"
		'''
	}
	
	override protected functions(ExecutionFlow it) {
		super.functions(it).toString.replace('''const «scHandleDecl», sc_eventid evid''','''«scHandleDecl», sc_eventid evid''')
	}
	
}
