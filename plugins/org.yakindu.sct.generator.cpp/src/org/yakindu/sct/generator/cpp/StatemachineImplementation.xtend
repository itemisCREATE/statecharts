/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.c.language.Preprocessor.Header
import org.yakindu.sct.generator.c.language.Preprocessor.LocalHeader
import org.yakindu.sct.generator.c.language.Preprocessor.SystemHeader
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.classes.StatechartClass
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static org.eclipse.xtext.util.Strings.*

class StatemachineImplementation implements IContentTemplate {
	
	@Inject protected extension CppNaming
	@Inject protected extension Navigation
	@Inject protected extension FlowCode
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension CppExpressionsGenerator
	@Inject protected extension StateVectorExtensions
	@Inject protected extension EventCode
	@Inject protected extension ExpressionsChecker
	
	protected GeneratorEntry entry
	
	@Accessors protected StatechartClass statechartClass
	@Accessors protected boolean newMode = false
	
	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		this.entry = entry
		val List<Header> includes = newArrayList
		includes.add(new LocalHeader(module.h))
		includes.add(new SystemHeader("string.h"))
		if(modOnReal) includes.add(new SystemHeader("math.h"))
	'''	
		«entry.licenseText»
		
		«FOR include : includes»
		«include»
		«ENDFOR»
		
		/*! \file Implementation of the state machine '«name»'
		*/
		
		«constantDefinitions»
		
		«statechartClass»
	'''
	}
		
	def protected usingNamespaces(ExecutionFlow it) {
		''''''
	}
	
	def additionalFunctions(ExecutionFlow it) {
		/* Hook for child classes */
		''''''
	}
	
	def constantDefinitions(ExecutionFlow it) '''
		«FOR scope : statechartScopes»
			«FOR d : scope.declarations.filter(typeof(VariableDefinition)).filter[const] AFTER newLine»
				«IF d.type.name != 'void'»const «d.typeSpecifier.targetLanguageName» «d.access» = «d.initialValue.code»;«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''
	

}