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
package org.yakindu.sct.simulation.core.util

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.yakindu.base.types.Direction
import org.yakindu.base.types.typesystem.ITypeValueProvider
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sruntime.ExecutionContext

class ExecutionContextExtensions {
	@Inject protected extension ITypeValueProvider

	def clearOutEvents(ExecutionContext executionContext) {
		executionContext.allEvents.filter[direction == Direction.OUT].forEach[if(raised) raised = false]
	}

	def clearLocalAndInEvents(ExecutionContext executionContext) {
		executionContext.allEvents.filter[direction == Direction.IN || direction == Direction.LOCAL].forEach [
			if (raised) {
				raised = false;
				value = if(type !== null) type.defaultValue else null
			}
		]
	}

	def List<RegularState> getAllActiveStates(ExecutionContext context) {
		context.activeStates.filter(RegularState).map[stateHierachy].flatten.toList
	}
	
	def protected getStateHierachy(RegularState state) {
		var result = new ArrayList<RegularState>()
		result.add(state);
		var container = state.eContainer();
		while (container !== null) {
			if (container instanceof RegularState) {
				result.add(container);
			}
			container = container.eContainer();
		}
		return result
	}
}
