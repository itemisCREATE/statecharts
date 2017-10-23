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

import com.google.inject.Inject
import java.util.List
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.language.CFunctionFactory
import org.yakindu.sct.generator.core.language.IFunction
import org.yakindu.sct.generator.core.language.factory.IStandardFunctionProvider
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.CppExpressionsGenerator
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.EventCode
import org.yakindu.sct.generator.cpp.FlowCode
import org.yakindu.sct.generator.cpp.Navigation
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.language.CodePartExtensions
import org.yakindu.sct.generator.cpp.language.CppClass
import org.yakindu.sct.generator.cpp.language.Visibility
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

/**
 * @author rbeckmann
 *
 */
abstract class AbstractStatechartClass extends CppClass {
	@Inject protected extension CppNaming
	@Inject protected extension Navigation
	@Inject protected extension FlowCode
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension CppExpressionsGenerator
	@Inject protected extension StateVectorExtensions
	@Inject protected extension EventCode

	@Inject protected extension CodePartExtensions
	@Inject protected extension IStandardFunctionProvider
	@Inject protected extension CFunctionFactory
	
	protected ExecutionFlow flow
	protected GeneratorEntry entry
	protected IGenArtifactConfigurations config
	protected StatechartScope scope
	
	def void build(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		this.flow = flow
		this.entry = entry
		this.config = artifactConfigs
	}
	def getInnerClassVisibility() {
		switch (entry.innerClassVisibility) {
			case "public": Visibility.PUBLIC
			case "protected": Visibility.PROTECTED
			case "private": Visibility.PRIVATE
		}
	}
	
	def List<IFunction> createDeclarationFunctions(StatechartScope scope, Declaration declaration) {
		switch (declaration) {
			EventDefinition: createEventFunctions(scope, declaration)
			VariableDefinition: createVariableFunctions(scope, declaration)
			default: #[]
		}
	}
	
	def createScopeDeclarationFunctions(StatechartScope it) {
		declarations.map[decl | createDeclarationFunctions(it, decl)].filter[!nullOrEmpty].flatten.forEach[func | addMember(func, Visibility.PUBLIC)]
	}

	def List<IFunction> createEventFunctions(StatechartScope scope, EventDefinition declaration) {
		val funcs = newArrayList
		switch (declaration.direction) {
			case Direction.LOCAL: {
				funcs += createLocalEventFunctions(scope, declaration)
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
	
	def List<IFunction> createLocalEventFunctions(StatechartScope scope, EventDefinition declaration) {
		val funcs = newArrayList
		funcs += createInEventFunctions(scope, declaration)
		funcs += createOutEventFunctions(scope, declaration)
		funcs
	}

	def List<IFunction> createInEventFunctions(StatechartScope scope, EventDefinition declaration) {
		val funcs = newArrayList
		funcs += raiseDefaultInterfaceEvent(scope, declaration)
		funcs
	}

	def List<IFunction> createOutEventFunctions(StatechartScope scope, EventDefinition declaration) {
		val funcs = newArrayList
		funcs += isDefaultInterfaceEventRaised(scope, declaration)
		if (declaration.hasValue) {
			funcs += getDefaultInterfaceEventValue(scope, declaration)
		}
		funcs
	}

	def List<IFunction> createVariableFunctions(StatechartScope scope, VariableDefinition definition) {
		val funcs = newArrayList
		funcs += getDefaultInterfaceVariable(definition)
		if (!(definition.readonly || definition.const)) {
			funcs += setDefaultInterfaceVariable(definition)
		}
		funcs
	}
}