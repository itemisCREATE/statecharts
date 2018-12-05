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

import com.google.inject.Singleton
import org.yakindu.sct.generator.java.submodules.InterfaceFunctionsGenerator
import org.yakindu.sct.model.stext.stext.EventDefinition

@Singleton
class EventDrivenInterfaceFunctionsGenerator extends InterfaceFunctionsGenerator {
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
}