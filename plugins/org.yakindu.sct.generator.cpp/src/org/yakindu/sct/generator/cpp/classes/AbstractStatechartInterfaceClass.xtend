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
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.language.CFunctionFactory
import org.yakindu.sct.generator.core.language.IModule
import org.yakindu.sct.generator.core.language.factory.IStandardFunctionProvider
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.EventCode
import org.yakindu.sct.generator.cpp.ExpressionCode
import org.yakindu.sct.generator.cpp.FlowCode
import org.yakindu.sct.generator.cpp.Naming
import org.yakindu.sct.generator.cpp.Navigation
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.language.CppClass
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.InterfaceScope

/**
 * @author rbeckmann
 *
 */
abstract class AbstractStatechartInterfaceClass extends CppClass {
	@Inject protected extension Naming
	@Inject protected extension Navigation
	@Inject protected extension FlowCode
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension ExpressionCode
	@Inject protected extension StateVectorExtensions
	@Inject protected extension EventCode

	@Inject protected extension IStandardFunctionProvider
	@Inject protected extension CFunctionFactory
	
	protected ExecutionFlow flow
	protected GeneratorEntry entry
	protected IGenArtifactConfigurations config
	protected InterfaceScope scope
	
	new(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs, IModule parent,
		InterfaceScope scope) {
		this.flow = flow
		this.entry = entry
		this.config = artifactConfigs
		this.parent = parent
		this.scope = scope
	}
}
