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
package org.yakindu.sct.generator.c.extensions

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition

/**
 * @author rbeckmann
 *
 */
class EventDrivenInterfaceFunctionsGenerator extends InterfaceFunctionsGenerator {
	override interfaceIncomingEventRaiser(ExecutionFlow it, EventDefinition event) '''
		void «event.asRaiser»(«scHandleDecl»«event.valueParams»)
		{
			«IF event.hasValue»
			«event.valueAccess» = value;
			«ENDIF»
			«event.access» = bool_true;
			
			«functionPrefix»runCycle(«scHandle»);
		}
	'''
}