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
package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.cpp.files.StatemachineHeader
import org.yakindu.sct.model.sexec.ExecutionFlow

/**
 * @author René Beckmann - Initial contribution and API
 * @author Axel Terfloth - updates
 */
class EventDrivenStatemachineHeader extends StatemachineHeader {
	@Inject extension StatechartEvents events
	
	override preStatechartDeclarations(ExecutionFlow it) {
		'''
		«super.preStatechartDeclarations(it)»
		
		«events.content(it)»
		'''
	}
}