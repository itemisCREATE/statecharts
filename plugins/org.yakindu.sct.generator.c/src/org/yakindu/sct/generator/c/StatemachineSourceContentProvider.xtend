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
package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.sct.generator.c.extensions.APIGenerator
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.InterfaceFunctionsGenerator
import org.yakindu.sct.generator.c.extensions.InternalFunctionsGenerator
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.c.extensions.Navigation
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

/**
 * @author rbeckmann
 *
 */
class StatemachineSourceContentProvider {
	@Inject protected extension Naming
	@Inject protected extension GenmodelEntries
	@Inject protected extension Navigation
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension FlowCode
	@Inject protected extension ConstantInitializationResolver
	@Inject protected extension StateVectorExtensions
	@Inject protected extension ExpressionsChecker
	
	@Inject protected extension APIGenerator
	
	@Inject protected extension InternalFunctionsGenerator
	@Inject protected extension InterfaceFunctionsGenerator
	
	def public CharSequence content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«entry.licenseText»
		
		#include <stdlib.h>
		#include <string.h>
		«IF modOnReal»#include <math.h>«ENDIF»
		#include "«(typesModule.h).relativeTo(module.c)»"
		#include "«(module.h).relativeTo(module.c)»"
		«IF timed || !it.operations.empty»
			#include "«(module.client.h).relativeTo(module.c)»"
		«ENDIF»
		/*! \file Implementation of the state machine '«name»'
		*/
		
		«functionPrototypes»
		
		«constantDefinitions»
		
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