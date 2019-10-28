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
import org.yakindu.sct.generator.java.features.Synchronized
import org.yakindu.sct.generator.java.submodules.EventCode
import org.yakindu.sct.model.stext.stext.EventDefinition

class EventDrivenEventCode extends EventCode {
	@Inject protected extension GeneratorPredicate
	@Inject protected extension Synchronized
	
	override internalEventRaiser(EventDefinition it) '''
		private void raise«name.asEscapedName»(«IF hasValue»final «typeSpecifier.targetLanguageName» value«ENDIF») {

			internalEventQueue.add( new Runnable() {
				@Override public void run() {
					«IF hasValue»«valueIdentifier» = value;«ENDIF»
					«identifier» = true;					
					singleCycle();
				}
			});
		}
	'''
	
	override inEventRaiser(EventDefinition it) {
		if(needsInEventQueue(flow)) {
			'''
			public void raise«name.asEscapedName»(«IF hasValue»final «typeSpecifier.targetLanguageName» value«ENDIF») {
				«sync(flow.statemachineClassName + ".this", '''
				inEventQueue.add(
					new Runnable() {
						@Override
						public void run() {
							«IF hasValue»«valueIdentifier» = value;«ENDIF»
							«identifier» = true;
							«IF needsRunnable»
							runCycle();
							«ELSE»
							singleCycle();
							«ENDIF»
						}
					}
				);
				«IF !needsRunnable»
				runCycle();
				«ENDIF»
				''')»
			}
			'''
		} else {
			'''
			public void raise«name.asEscapedName»(«IF hasValue»final «typeSpecifier.targetLanguageName» value«ENDIF») {
				«sync(flow.statemachineClassName + ".this", '''
				«IF hasValue»«valueIdentifier» = value;«ENDIF»
				«identifier» = true;
				runCycle();
				''')»
			}
			'''
		}
	}
	
	
}