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

import com.google.inject.Inject
import org.yakindu.sct.generator.java.GeneratorPredicate
import org.yakindu.sct.generator.java.submodules.FieldDeclarationGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow

class EventDrivenFieldDeclarationGenerator extends FieldDeclarationGenerator {
	@Inject protected extension GeneratorPredicate
	
	override internalEventFields(ExecutionFlow it) '''
		«IF needsInternalEventQueue»
			private Queue<Runnable> internalEventQueue = new LinkedList<Runnable>();
		«ENDIF»
		«IF needsInEventQueue && !needsSynchronized»
			private Queue<Runnable> inEventQueue = new LinkedList<Runnable>();
		«ENDIF»
		«IF needsInEventQueue && needsSynchronized»
			private BlockingQueue<Runnable> inEventQueue = new LinkedBlockingQueue<Runnable>();
		«ENDIF»
		«super.internalEventFields(it)»
	'''
}