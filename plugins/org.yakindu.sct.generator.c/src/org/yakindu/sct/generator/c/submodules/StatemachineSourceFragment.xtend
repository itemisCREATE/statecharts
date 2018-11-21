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
package org.yakindu.sct.generator.c.submodules

import com.google.inject.Inject
import org.yakindu.sct.generator.c.ConstantInitializationResolver
import org.yakindu.sct.generator.c.FlowCode
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.generator.c.ISourceFragment

/**
 * @author rbeckmann
 *
 */
class StatemachineSourceFragment implements ISourceFragment {
	@Inject protected extension Naming
	@Inject protected extension GenmodelEntries
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension FlowCode
	@Inject protected extension ConstantInitializationResolver
	@Inject protected extension StateVectorExtensions
	@Inject protected extension ExpressionsChecker
	
	@Inject protected extension APIGenerator
	
	@Inject protected extension InternalFunctionsGenerator
	@Inject protected extension InterfaceFunctionsGenerator

	override CharSequence fileComment(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) {
		'''«entry.licenseText»'''
	}
	
	override CharSequence includes(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		#include "«(module.h).relativeTo(module.c)»"
		#include "«(typesModule.h).relativeTo(module.c)»"
		«IF timed || !it.operations.empty»
			#include "«(module.client.h).relativeTo(module.c)»"
		«ENDIF»
		
		«IF hasStringComparison»
		#include <string.h>
		«ENDIF»
		«IF modOnReal»#include <math.h>«ENDIF»
		/*! \file Implementation of the state machine '«name»'
		*/
		'''
	}
	
	override CharSequence declarations(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«functionPrototypes»
		
		«constantDefinitions»
		'''
	}
	
	override CharSequence implementations(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«functions»
		'''
	}
	
	def constantDefinitions(ExecutionFlow it) '''
		«FOR scope : scopes.filter(typeof(StatechartScope))»
			«FOR d : scope.declarations.filter(typeof(VariableDefinition)).filter[const]»
				«IF d.type.name != 'void'»const «d.typeSpecifier.targetLanguageName» «d.access» = «d.initialValue.resolveConstants»;«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''
	
	def functions(ExecutionFlow it) '''
		«init»
		
		«enter»
		
		«runCycle»

		«exit»
		
		«active»
		
		«final»
		
		«IF timed»
		«raiseTimeEvent»

		«ENDIF»
		«isStateActive»
		
		«clearInEventsFunction»
		
		«clearOutEventsFunction»
		
		«interfaceFunctions»
		
		«functionImplementations»
	'''
}