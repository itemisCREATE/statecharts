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
import org.yakindu.sct.generator.cpp.StatemachineImplementation
import org.yakindu.sct.model.sexec.ExecutionFlow

/**
 * @author René Beckmann - Initial contribution and API
 */
class EventDrivenStatemachineImplementation extends StatemachineImplementation {
	@Inject extension EventNaming eventNaming
	
	override protected usingNamespaces(ExecutionFlow it) {
		'''using namespace «eventNamespaceName»;'''
	}
}