/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.CExpressionsGenerator
import org.yakindu.sct.model.stext.stext.EventRaisingExpression

/**
 * @author René Beckmann
 */
class EventDrivenExpressionCode extends CExpressionsGenerator {
	@Inject extension EventNaming
	
	protected static int valueVarIndex = 0
	
	override dispatch CharSequence code(EventRaisingExpression it) {
		val valueVarName = '''value_«valueVarIndex++»'''
		'''
		«IF event.definition.event.direction != Direction::LOCAL»
			«IF value !== null»
				«event.definition.event.valueAccess» = «value.code»;
			«ENDIF»
			«event.definition.event.access» = bool_true«ELSE»
			«IF value !== null»
			«event.definition.event.typeSpecifier.targetLanguageName» «valueVarName» = «value.code»;
			«functionPrefix(flow)»add_value_event_to_queue(«scHandle», «event.definition.event.eventEnumMemberName», «valueVarName»)
			«ELSE»
			«functionPrefix(flow)»add_event_to_queue(«scHandle», «event.definition.event.eventEnumMemberName»)«ENDIF»«ENDIF»'''
	}
}
