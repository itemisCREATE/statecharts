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
import com.google.inject.Singleton
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.c.CGeneratorConstants
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.c.extensions.GenmodelEntries

/**
 * @author rbeckmann
 *
 */
@Singleton // Guice
class InterfaceFunctionsGenerator {
	@Inject protected extension SExecExtensions
	@Inject protected extension Naming
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension EventCode
	@Inject protected extension ExpressionsChecker
	
	@Inject protected extension GeneratorEntry entry
	@Inject protected extension GenmodelEntries
	
	def interfaceFunctions(ExecutionFlow it) '''
		«FOR scope : interfaceScopes»
			«FOR event : scope.incomingEvents»
				«interfaceIncomingEventRaiser(event)»
			«ENDFOR»
			
			«FOR event : scope.outgoingEvents»
				«interfaceOutgoingEventGetter(event)»
				«IF event.hasValue» 
					«interfaceOutgoingEventValueGetter(event)»
				«ENDIF»
			«ENDFOR»
			
			«FOR variable : scope.variableDefinitions»
				«IF variable.isConstString»const «ENDIF»«variable.typeSpecifier.targetLanguageName» «variable.asGetter»(const «scHandleDecl»)
				{
					return «variable.access»;
				}
				«IF !variable.readonly && !variable.const»
				void «variable.asSetter»(«scHandleDecl», «variable.typeSpecifier.targetLanguageName» value)
				{
					«IF entry.tracingGeneric»
					«tracingPrefix»FEATURE(«scHandle», «CGeneratorConstants::TRACE_MACHINE_VARIABLE_SET», «featureNamingPrefix»«variable.name», &value);
					«ENDIF»
					«variable.access» = value;
				}
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''
}