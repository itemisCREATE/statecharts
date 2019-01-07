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
package org.yakindu.sct.generator.cpp.files

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.core.submodules.lifecycle.Enter
import org.yakindu.sct.generator.core.submodules.lifecycle.Exit
import org.yakindu.sct.generator.core.submodules.lifecycle.Init
import org.yakindu.sct.generator.core.submodules.lifecycle.IsActive
import org.yakindu.sct.generator.core.submodules.lifecycle.IsFinal
import org.yakindu.sct.generator.core.submodules.lifecycle.IsStateActive
import org.yakindu.sct.generator.core.submodules.lifecycle.RunCycle
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.CppExpressionsGenerator
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.EventCode
import org.yakindu.sct.generator.cpp.FlowCode
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.submodules.InterfaceFunctions
import org.yakindu.sct.generator.cpp.submodules.InternalFunctions
import org.yakindu.sct.generator.cpp.submodules.TimingFunctions
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static org.eclipse.xtext.util.Strings.*
import static org.yakindu.sct.generator.c.CGeneratorConstants.*

class StatemachineImplementation implements IContentTemplate {
	
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension SgraphExtensions
	@Inject protected extension FlowCode
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension CppExpressionsGenerator
	@Inject protected extension StateVectorExtensions
	@Inject protected extension EventCode
	@Inject protected extension ExpressionsChecker
	
	@Inject protected extension Init
	@Inject protected extension Enter
	@Inject protected extension RunCycle
	@Inject protected extension IsActive
	@Inject protected extension IsFinal
	@Inject protected extension Exit
	@Inject protected extension IsStateActive
	
	@Inject protected extension InternalFunctions
	@Inject protected extension InterfaceFunctions
	@Inject protected extension TimingFunctions
	
	protected GeneratorEntry entry
	
	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		this.entry = entry
		val namespace = statechartNamespace
	'''	
		«entry.licenseText»
		
		#include "«module.h»"
		«IF hasStringComparison»
		#include <string.h>
		«ENDIF»
		«IF modOnReal»#include <math.h>«ENDIF»
		
		/*! \file Implementation of the state machine '«name»'
		*/
		
		«IF !namespace.nullOrEmpty»
		«FOR ns : namespace»
		namespace «ns» {
		«ENDFOR»
		«ENDIF»
		
		«usingNamespaces»
		
		«constructorDefinition»
		
		«destructorDefinition»
		
		«constantDefinitions»
		
		«init»
		
		«enter»
		
		«exit»
		
		«isActive»
		
		«isFinal»
		
		«runCycle»
		
		«clearInEventsFunction»
		
		«clearOutEventsFunction»

		«timedStatemachineFunctions»

		«isStateActive»
		
		«interfaceFunctions»
		
		«functionImplementations»
		
		«additionalFunctions»
		
		«IF !namespace.nullOrEmpty»
		«FOR ns : namespace»
		}
		«ENDFOR»
		«ENDIF»
	'''
	}
	

		
	
	def protected usingNamespaces(ExecutionFlow it) {
		''''''
	}
	
	def additionalFunctions(ExecutionFlow it) {
		/* Hook for child classes */
		''''''
	}
	

	def constructorDefinition(ExecutionFlow it){
	'''
		«module»::«module»():
			«initialisationList»
		{
			«constructorBody(it)»
		}
	'''
	}
	
	def protected initialisationList(ExecutionFlow it) {
		'''
			«IF timed»«timerInstance»(«NULL_STRING»),«ENDIF»
			«STATEVECTOR_POS»(0)«FOR s : getInterfaces»,
			«s.instance»()«IF s.hasOperations && !entry.useStaticOPC»,
			«s.OCB_Instance»(«NULL_STRING»)«ENDIF»«ENDFOR»«IF entry.tracingUsed»,
			«tracingInstance»(0)«ENDIF»
		'''
	}
	
	def protected initialisationListCopy(ExecutionFlow it) {
		'''
			«IF timed»«timerInstance»(rhs.«timerInstance»),«ENDIF»
			«STATEVECTOR_POS»(rhs.«STATEVECTOR_POS»)«FOR s : getInterfaces»,
			«s.instance»(rhs.«s.instance»)«IF s.hasOperations && !entry.useStaticOPC»,
			«s.OCB_Instance»(rhs.«s.OCB_Instance»)«ENDIF»«ENDFOR»
		'''	
	}
	
	protected def CharSequence constructorBody(ExecutionFlow it)
		'''
		«IF hasHistory»
			for («USHORT_TYPE» i = 0; i < «historyStatesConst»; ++i)
				«HISTORYVECTOR»[i] = «null_state»;
				
		«ENDIF»
		'''
	
	
	def destructorDefinition(ExecutionFlow it) '''
		«module»::~«module»()
		{
		}
	'''
	
	
	
	def constantDefinitions(ExecutionFlow it) '''
		«FOR scope : statechartScopes»
			«FOR d : scope.declarations.filter(typeof(VariableDefinition)).filter[const] AFTER newLine»
				«IF d.type.name != 'void'»const «d.typeSpecifier.targetLanguageName» «d.access» = «d.initialValue.code»;«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''
}