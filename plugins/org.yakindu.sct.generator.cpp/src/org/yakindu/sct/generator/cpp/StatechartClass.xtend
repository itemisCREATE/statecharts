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
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.core.language.CharSequenceList
import org.yakindu.sct.generator.core.language.factory.FunctionFactory
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.language.Constructor
import org.yakindu.sct.generator.cpp.language.CppClass
import org.yakindu.sct.generator.cpp.language.Visibility
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry

/**
 * @author rbeckmann
 *
 */
class StatechartClass extends CppClass {
	@Inject protected extension Naming
	@Inject protected extension Navigation
	@Inject protected extension FlowCode
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension ExpressionCode
	@Inject protected extension StateVectorExtensions
	@Inject protected extension EventCode
	
	@Inject extension FunctionFactory
	
	protected ExecutionFlow flow
	protected GeneratorEntry entry
	protected IGenArtifactConfigurations config
	
	new(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		this.flow = flow
		this.entry = entry
		this.config = artifactConfigs
		this.name = flow.module
	}
	
	def createConstructors() {
		val constructor = new Constructor()
		constructor.parent = this
		constructor.name = this.name
		constructor.initializerList = initializerList
		if(flow.hasHistory) {
			constructor.content = '''
			for (int i = 0; i < «historyStatesConst»; ++i)
				historyVector[i] = «flow.null_state»;
			'''
		}
							
		
		addMember(constructor, Visibility.PUBLIC)
	}
	
	def protected getInitializerList() {
		val initializerList = new CharSequenceList(", ")
		if(flow.timed) {
			initializerList.add(timerInstance + "(null)")
		}
		initializerList.add("stateConfVectorPosition(0)")
		for(interface : flow.getInterfaces) {
			initializerList.add(interface.instance)
			if(interface.hasOperations && !entry.useStaticOPC) {
				initializerList.add(interface.OCB_Instance + "(null)")
			}
		}
		initializerList
	}
	
	def createDestructors() {
		
	}
	
	def createStandardFunctions() {
		
	}
	
	def createInterfaces() {
		
	}
}