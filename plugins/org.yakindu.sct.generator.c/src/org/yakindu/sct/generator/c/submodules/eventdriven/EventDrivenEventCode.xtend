/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.submodules.eventdriven

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.extensions.EventNaming
import org.yakindu.sct.generator.c.submodules.EventCode
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import static org.yakindu.sct.generator.c.CGeneratorConstants.TRUE

/**
 * @author rbeckmann
 *
 */
@Singleton // Guice
class EventDrivenEventCode extends EventCode {
	@Inject extension EventNaming
	
	protected static int valueVarIndex = 0
	
	override CharSequence eventRaisingCode(EventRaisingExpression it, ExpressionsGenerator exp) {
		val valueVarName = '''value_«valueVarIndex++»'''
		'''
		«IF event.definition.event.direction != Direction::LOCAL»
			«IF value !== null»
				«event.definition.event.valueAccess» = «exp.code(value)»;
			«ENDIF»
			«event.definition.event.access» = «TRUE»«ELSE»
			«IF value !== null»
			«event.definition.event.typeSpecifier.targetLanguageName» «valueVarName» = «exp.code(value)»;
			«flow.addToQueueValueFctID»(«scHandle», «event.definition.event.eventEnumMemberName», &«valueVarName»)
			«ELSE»
			«flow.addToQueueFctID»(«scHandle», «event.definition.event.eventEnumMemberName»)«ENDIF»«ENDIF»'''
	}
	
	override interfaceIncomingEventRaiserBody(ExecutionFlow it, EventDefinition event) '''
			«IF event.hasValue»
			«event.valueAccess» = value;
			«ENDIF»
			«event.access» = «TRUE»;
			
			«runCycleFctID»(«scHandle»);
	'''
	
	
}