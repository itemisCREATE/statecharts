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
package org.yakindu.sct.generator.c.extensions

import com.google.inject.Inject
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition

/**
 * @author rbeckmann
 *
 */
class InterfaceFunctionsGenerator {
	@Inject protected extension Navigation
	@Inject protected extension Naming
	@Inject protected extension ICodegenTypeSystemAccess
	
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
				«IF variable.const»const «ENDIF»«variable.typeSpecifier.targetLanguageName» «variable.asGetter»(const «scHandleDecl»)
				{
					return «variable.access»;
				}
				«IF !variable.readonly && !variable.const»
				void «variable.asSetter»(«scHandleDecl», «variable.typeSpecifier.targetLanguageName» value)
				{
					«variable.access» = value;
				}
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''
	
	def interfaceIncomingEventRaiser(ExecutionFlow it, EventDefinition event) '''
		void «event.asRaiser»(«scHandleDecl»«event.valueParams»)
		{
			«IF event.hasValue»
			«event.valueAccess» = value;
			«ENDIF»
			«event.access» = bool_true;
		}
	'''
	
	def interfaceOutgoingEventGetter(ExecutionFlow it, EventDefinition event) '''
		sc_boolean «event.asRaised»(const «scHandleDecl»)
		{
			return «event.access»;
		}
	'''
	
	def interfaceOutgoingEventValueGetter(ExecutionFlow it, EventDefinition event) '''
		«event.typeSpecifier.targetLanguageName» «event.asGetter»(const «scHandleDecl»)
		{
			return «event.valueAccess»;
		}
	'''
}