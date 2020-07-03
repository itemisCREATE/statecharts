/**
  Copyright (c) 2019 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	René Beckmann - refactored from Statemachine
*/
package org.yakindu.sct.generator.java

import com.google.inject.Inject

class GeneratorPredicate extends org.yakindu.sct.generator.core.extensions.GeneratorPredicate {
	@Inject protected extension GenmodelEntries
	
	override useInEventQueue() {
		super.useInEventQueue || needsRunnable
	}

	override useInEventQueueDeprecated() {
		entry.inEventQueue
	}
	
	def needsSynchronized() {
		entry.synchronized || needsRunnable
	}
	
	def needsRunnable() {
		entry.runnable && isEventDriven
	}

}