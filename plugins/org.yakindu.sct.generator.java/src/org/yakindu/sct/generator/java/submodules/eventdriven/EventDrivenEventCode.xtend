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
import org.yakindu.base.types.Event
import org.yakindu.sct.generator.java.GeneratorPredicate
import org.yakindu.sct.generator.java.features.Synchronized
import org.yakindu.sct.generator.java.submodules.EventCode
import org.yakindu.sct.model.sexec.ExecutionFlow

class EventDrivenEventCode extends EventCode {
	
	@Inject protected extension GeneratorPredicate
	@Inject protected extension Synchronized
	
	override internalEventRaiser(Event it) '''
		private void raise«name.asName»(«IF hasValue»final «typeSpecifier.targetLanguageName» value«ENDIF») {

			internalEventQueue.add(new Runnable() {
				@Override public void run() {
					«IF hasValue»«valueIdentifier» = value;«ENDIF»
					«identifier» = true;					
				}
			});
		}
	'''
	
	override inEventRaiser(Event it) {
		if(needsInEventQueue(flow)) {
			'''
			public void raise«name.asName»(«IF hasValue»final «typeSpecifier.targetLanguageName» value«ENDIF») {
				«sync(flow.statemachineClassName + ".this", '''
				inEventQueue.add(new Runnable() {
					@Override
					public void run() {
						«IF hasValue»«valueIdentifier» = value;«ENDIF»
						«identifier» = true;
						«IF needsRunnable»
						runCycle();
						«ENDIF»
					}
				});
				«IF !needsRunnable»
				runCycle();
				«ENDIF»
				''')»
			}
			'''
		} else {
			'''
			public void raise«name.asName»(«IF hasValue»final «typeSpecifier.targetLanguageName» value«ENDIF») {
				«sync(flow.statemachineClassName + ".this", '''
				«IF hasValue»«valueIdentifier» = value;«ENDIF»
				«identifier» = true;
				runCycle();
				''')»
			}
			'''
		}
	}
	
	override eventNextCode(ExecutionFlow flow) '''nextEvent();'''
	
	override nextEvent(ExecutionFlow it) '''
		protected void nextEvent() {
			«IF needsInternalEventQueue»
			if(!internalEventQueue.isEmpty()) {
				internalEventQueue.poll().run();
				return;
			}
			«ENDIF»
			«IF needsInEventQueue»
			if(!inEventQueue.isEmpty()) {
				inEventQueue.poll().run();
				return;
			}
			«ENDIF»
		}
	'''
	
	
}