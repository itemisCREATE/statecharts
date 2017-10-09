/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp.classes

import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.core.language.IModule
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

/**
 * @author rbeckmann
 *
 */
class StatechartDefaultInterfaceClass extends StatechartInterfaceClass {
	
	new(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs, IModule parent, InterfaceScope scope) {
		super(flow, entry, artifactConfigs, parent, scope)
	}
	
	override createInEventFunctions(InterfaceScope scope, EventDefinition declaration) {
		val funcs = super.createInEventFunctions(scope, declaration)
		funcs += raiseDefaultInterfaceEvent(scope, declaration)
		funcs
	}
	
	override createOutEventFunctions(InterfaceScope scope, EventDefinition declaration) {
		val funcs = super.createOutEventFunctions(scope, declaration)
		funcs += isDefaultInterfaceEventRaised(scope, declaration)
		if (declaration.hasValue) {
			funcs += getDefaultInterfaceEventValue(scope, declaration)
		}
		funcs
	}
	
	override createVariableFunctions(InterfaceScope scope, VariableDefinition definition) {
		val funcs = super.createVariableFunctions(scope, definition)
		funcs += getDefaultInterfaceVariable(scope, definition)
		if (!(definition.readonly || definition.const)) {
			funcs += setDefaultInterfaceVariable(scope, definition)
		}
		funcs
	}
	
	
}