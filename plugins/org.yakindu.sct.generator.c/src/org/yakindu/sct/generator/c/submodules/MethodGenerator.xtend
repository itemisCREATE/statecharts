/** 
 * Copyright (c) 2020 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.submodules

import com.google.inject.Inject
import org.yakindu.base.types.annotations.VisibilityAnnotations
import org.yakindu.sct.generator.c.FlowCode
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.LocalVariableDefinition

/**
 * Generator module that cares about generically generating methods defined in the 
 * execution flow.
 * 
 * @author axel terfloth
 */
class MethodGenerator {

	@Inject protected extension VisibilityAnnotations
	@Inject protected extension INamingService
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension Naming
	@Inject protected extension SExecExtensions
	
	@Inject protected extension FlowCode


	def declarations(Iterable<Method> steps) '''
		«FOR s : steps»
			«s.declaration»
		«ENDFOR»
	'''
	
	
	def declaration(Method it) '''
		«IF ! body.comment.isNullOrEmpty»/*! «body.comment» */«ENDIF»
		«declarationModifier»«typeSpecifier.targetLanguageName» «prefix»«shortName»(«scHandleDecl»«FOR p : parameters BEFORE ', ' SEPARATOR ', '»«IF p.varArgs»...«ELSE»const «p.typeSpecifier.targetLanguageName» «p.name.asIdentifier»«ENDIF»«ENDFOR»);
		
	'''
	
	def declarationModifier(Method it) {
		if (it.isPublic)
			'''extern '''
		else 
			'''static '''
	}
	

	def implementation(Iterable<Method> methods) '''
	 	«FOR m : methods»
	 		«m.implementation»
	 		
	 	«ENDFOR»
	 '''
	
	def implementation(Method it) '''
		«implementationModifier»«typeSpecifier.targetLanguageName» «prefix»«shortName»(«scHandleDecl»«FOR p : parameters BEFORE ', ' SEPARATOR ', '»«IF p.varArgs»...«ELSE»const «p.typeSpecifier.targetLanguageName» «p.name.asIdentifier»«ENDIF»«ENDFOR»)
		{
			«IF !body.steps.nullOrEmpty»«body.stepComment»«ENDIF»
 			«body.steps.filter(LocalVariableDefinition).map[s | s.code].join»
			«IF !body.requiresHandles»
				«unusedParam(scHandle)»
			«ENDIF»
			«body.steps.filter[s | !(s instanceof LocalVariableDefinition)].map[s | s.code].join»
		}
	 '''
	
	def implementationModifier(Method it) {
		if (it.isPublic)
			''''''
		else 
			'''static '''
	}
	
	protected def prefix (Method it){
		if (isPublic) flow.functionPrefix
		else ""
	}
}