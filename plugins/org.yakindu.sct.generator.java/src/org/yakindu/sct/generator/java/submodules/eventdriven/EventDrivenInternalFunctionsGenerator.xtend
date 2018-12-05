/**
  Copyright (c) 2018 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	René Beckmann - refactored from Statemachine
*/
package org.yakindu.sct.generator.java.submodules.eventdriven

import org.yakindu.sct.generator.java.submodules.InternalFunctionsGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow

class EventDrivenInternalFunctionsGenerator extends InternalFunctionsGenerator {
	override internalEventFields(ExecutionFlow it) '''
		«IF hasLocalEvents»
			private Queue<Runnable> internalEventQueue = new LinkedList<Runnable>();
		«ENDIF»
		«super.internalEventFields(it)»
	'''
}