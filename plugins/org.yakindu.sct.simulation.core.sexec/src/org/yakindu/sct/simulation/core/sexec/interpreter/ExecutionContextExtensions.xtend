/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import org.yakindu.base.types.typesystem.ITypeValueProvider
import org.yakindu.sct.simulation.core.sruntime.EventDirection
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext

class ExecutionContextExtensions {

	@Inject
	extension ITypeValueProvider

	def clearLocalAndInEvents(ExecutionContext executionContext) {
		executionContext.allEvents.filter[direction == EventDirection.IN || direction == EventDirection.LOCAL].forEach [
			if (raised) {
				raised = false;
				value = if(type !== null) type.defaultValue else null
			}
		]
	}

	def clearOutEvents(ExecutionContext executionContext) {
		executionContext.allEvents.filter[direction == EventDirection.OUT].forEach[if(raised) raised = false]
	}

}
