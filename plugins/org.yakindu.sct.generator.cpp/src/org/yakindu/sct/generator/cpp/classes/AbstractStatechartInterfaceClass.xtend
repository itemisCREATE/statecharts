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

import java.util.List
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.core.language.IFunction
import org.yakindu.sct.generator.core.language.IModule
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

/**
 * @author rbeckmann
 *
 */
abstract class AbstractStatechartInterfaceClass extends AbstractStatechartClass {
	def void build(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs, IModule parent,
		StatechartScope scope) {
		super.build(flow, entry, artifactConfigs)
		this.parent = parent
		this.scope = scope
	}
	
	override List<IFunction> createDeclarationFunctions(StatechartScope scope, Declaration declaration) {
		switch (declaration) {
			EventDefinition: createEventFunctions(scope, declaration)
			VariableDefinition: createVariableFunctions(scope, declaration)
		}
	}

	override List<IFunction> createEventFunctions(StatechartScope scope, EventDefinition declaration) {
		val funcs = newArrayList
		switch (declaration.direction) {
			case Direction.LOCAL: {
				funcs += createInEventFunctions(scope, declaration)
				funcs += createOutEventFunctions(scope, declaration)
			}
			case Direction.IN: {
				funcs += createInEventFunctions(scope, declaration)
			}
			case Direction.OUT: {
				funcs += createOutEventFunctions(scope, declaration)
			}
		}
		funcs
	}

	override List<IFunction> createInEventFunctions(StatechartScope scope, EventDefinition declaration) {
		val funcs = newArrayList
		funcs += raiseInterfaceEvent(scope, declaration)
		funcs
	}

	override List<IFunction> createOutEventFunctions(StatechartScope scope, EventDefinition declaration) {
		val funcs = newArrayList
		funcs += isInterfaceEventRaised(scope, declaration)
		if (declaration.hasValue) {
			funcs += getInterfaceEventValue(scope, declaration)
		}
		funcs
	}

	override List<IFunction> createVariableFunctions(StatechartScope scope, VariableDefinition definition) {
		val funcs = newArrayList
		funcs += getInterfaceVariable(definition)
		if (!(definition.readonly || definition.const)) {
			funcs += setInterfaceVariable(definition)
		}
		funcs
	}
}
