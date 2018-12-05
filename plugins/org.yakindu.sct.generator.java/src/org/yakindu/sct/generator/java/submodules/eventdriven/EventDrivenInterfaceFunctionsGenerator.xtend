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